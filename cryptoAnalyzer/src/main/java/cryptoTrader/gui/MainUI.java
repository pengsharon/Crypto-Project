package cryptoTrader.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cryptoTrader.utils.DataVisualizationCreator;
import java.util.ArrayList;

public class MainUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MainUI instance;
	private JPanel stats, chartPanel, tablePanel;

	// Should be a reference to a separate object in actual implementation
	private List<String> selectedList;

	private JTextArea selectedTickerList;
//	private JTextArea tickerList;
	private JTextArea tickerText;
	private JTextArea BrokerText;
	private JComboBox<String> strategyList;
	private Map<String, List<String>> brokersTickers = new HashMap<>();
	private Map<String, String> brokersStrategies = new HashMap<>();
	private List<String> selectedTickers = new ArrayList<>();
	private String selectedStrategy = "";
	private DefaultTableModel dtm;
	private JTable table; //this is a table

	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	private MainUI() {

		// Set window title
		super("Crypto Trading Tool");
		
		// set new text file: clear contents
		try {
			new FileWriter("brokerNames.txt", false).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Set top bar


		JPanel north = new JPanel();

//		north.add(strategyList);

		// Set bottom bar
//		JLabel from = new JLabel("From");
//		UtilDateModel dateModel = new UtilDateModel();
//		Properties p = new Properties();
//		p.put("text.today", "Today");
//		p.put("text.month", "Month");
//		p.put("text.year", "Year");
//		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
//		@SuppressWarnings("serial")
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new AbstractFormatter() {
//			private String datePatern = "dd/MM/yyyy";
//
//			private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePatern);
//
//			@Override
//			public Object stringToValue(String text) throws ParseException {
//				return dateFormatter.parseObject(text);
//			}
//
//			@Override
//			public String valueToString(Object value) throws ParseException {
//				if (value != null) {
//					Calendar cal = (Calendar) value;
//					return dateFormatter.format(cal.getTime());
//				}
//
//				return "";
//			}
//		});

		JButton trade = new JButton("Perform Trade");
		trade.setActionCommand("refresh");
		trade.addActionListener(this);



		JPanel south = new JPanel();
		
		south.add(trade);

		dtm = new DefaultTableModel(new Object[] { "Trading Client", "Coin List", "Strategy Name" }, 1);
		table = new JTable(dtm);
		// table.setPreferredSize(new Dimension(600, 300));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Trading Client Actions",
				TitledBorder.CENTER, TitledBorder.TOP));
		Vector<String> strategyNames = new Vector<String>();
		strategyNames.add("None");
		strategyNames.add("Strategy-A");
		strategyNames.add("Strategy-B");
		strategyNames.add("Strategy-C");
		strategyNames.add("Strategy-D");
		TableColumn strategyColumn = table.getColumnModel().getColumn(2);
		JComboBox comboBox = new JComboBox(strategyNames);
		strategyColumn.setCellEditor(new DefaultCellEditor(comboBox));
		JButton addRow = new JButton("Add Row");
		JButton remRow = new JButton("Remove Row");
		addRow.setActionCommand("addTableRow");
		addRow.addActionListener(this);
		remRow.setActionCommand("remTableRow");
		remRow.addActionListener(this);

		scrollPane.setPreferredSize(new Dimension(800, 300));
		table.setFillsViewportHeight(true);
		

		JPanel east = new JPanel();
//		east.setLayout();
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
//		east.add(table);
		east.add(scrollPane);
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(addRow);
		buttons.add(remRow);
		east.add(buttons);
//		east.add(selectedTickerListLabel);
//		east.add(selectedTickersScrollPane);

		// Set charts region
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(1250, 650));
		stats = new JPanel();
		stats.setLayout(new GridLayout(2, 2));

		west.add(stats);

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(west, BorderLayout.CENTER);
		getContentPane().add(south, BorderLayout.SOUTH);
//		getContentPane().add(west, BorderLayout.WEST);
	}

	public void updateStats(JComponent component) {
		stats.add(component);
		stats.revalidate();
	}

	public static void main(String[] args) {
		JFrame frame = MainUI.getInstance();
		frame.setSize(900, 600);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// [["broker2"], ["eth", "btc"], ["stratA"]]
		
		String command = e.getActionCommand();
		if ("refresh".equals(command)) {
			brokerInfo[] combinedInfo = new brokerInfo[dtm.getRowCount()];
			ArrayList<String> coinsToFetch = new ArrayList<String>();
			for (int count = 0; count < dtm.getRowCount(); count++){
					String [] rowInfo = new String[3];
					Object traderObject = dtm.getValueAt(count, 0);
					if (traderObject == null) {
						JOptionPane.showMessageDialog(this, "please fill in Trader name on line " + (count + 1) );
						return;
					}
					String traderName = traderObject.toString();
//					rowInfo[0] = traderName;
					Object coinObject = dtm.getValueAt(count, 1);
					if (coinObject == null) {
						JOptionPane.showMessageDialog(this, "please fill in cryptocoin list on line " + (count + 1) );
						return;
					}
					String[] coinNames = coinObject.toString().split(",");
					for(int i = 0; i < coinNames.length; i++) {
						if(!coinsToFetch.contains(coinNames[i])) {
							coinsToFetch.add(coinNames[i]);
						}
					}
					Object strategyObject = dtm.getValueAt(count, 2);
					if (strategyObject == null) {
						JOptionPane.showMessageDialog(this, "please fill in strategy name on line " + (count + 1) );
						return;
					}
					String strategyName = strategyObject.toString();
					System.out.println(traderName + " " + Arrays.toString(coinNames) + " " + strategyName);
					
					brokerInfo thisBroker = new brokerInfo(traderName, coinNames, strategyName);
					combinedInfo[count] = thisBroker;
	        }
			
			System.out.println(combinedInfo[0].getBName());
			System.out.println(combinedInfo[0].getCoinList());
			System.out.println(combinedInfo[0].getStratName());
			for(int i = 0; i < coinsToFetch.size(); i++) {
				System.out.println(coinsToFetch.get(i));
			}	
			stats.removeAll();
			DataVisualizationCreator creator = new DataVisualizationCreator();
			creator.createCharts();
		} else if ("addTableRow".equals(command)) {
			
			// get broker name
			int rowNum = dtm.getRowCount() - 1;
			Object traderObject = dtm.getValueAt(rowNum, 0);
			
			String brokerName = traderObject.toString();
//			System.out.println("brokername: " + brokerName);
			// read through list in text file to make sure this name does not yet exist
			if (verifyUniqueBroker(brokerName)) {
				dtm.addRow(new String[3]);
				writeBroker(brokerName);
				
			} else {
				JOptionPane.showMessageDialog(this, "Broker name already exists, enter a new one!");
			}
			
		} else if ("remTableRow".equals(command)) {
			int selectedRow = table.getSelectedRow();
			
			// remove brokerName of row from txt file
			Object traderObject = dtm.getValueAt(selectedRow, 0);
			String brokerName = traderObject.toString();
			File f = new File("brokerNames.txt");
			
			removeBroker(brokerName, f);
			
			if (selectedRow != -1)
				dtm.removeRow(selectedRow);
		}
	}
	
	private boolean verifyUniqueBroker(String brokerName) {
//		System.out.println("verifying entered");
		boolean uniqueBroker = true;
		try {
			Scanner brokerNames = new Scanner(new File("brokerNames.txt"));
			while (brokerNames.hasNextLine()) {
				String broker = brokerNames.nextLine();
//				System.out.println(broker);
				
				if (broker.equals(brokerName)) {
					uniqueBroker = false;
//					System.out.println("broker already exists: " + broker);
					break;
				} 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return uniqueBroker;
	}
	
	private static void writeBroker(String brokerName) {
//		System.out.println("writeBroker entered");
		try {
		    FileWriter brokerList = new FileWriter("brokerNames.txt",true); 
		    brokerList.write( brokerName + "\n");//appends the string to the file
		    brokerList.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void removeBroker(String brokerName, File f) {

        try {
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(f));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String brokerLine;

            while ((brokerLine = reader.readLine()) != null) {

                // trim newline when comparing with lineToRemove
                String trimmedLine = brokerLine.trim();

                if (trimmedLine.equals(brokerName))
                    continue;

                writer.write(brokerLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            boolean successful = tempFile.renameTo(f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
//	private static void removeBroker(String brokerName) {
//		
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter("brokerNames.txt"));
//			
//		    String brokerLine;
//		    InputStream readingFile = new FileInputStream("brokerNames.txt");
//			BufferedReader br = new BufferedReader(new InputStreamReader(readingFile));
//			
//			// ISSUE: FOR SOME REASON, ALL ITEAMS OF BROKER NAMES GETS DELETED
//			while ((brokerLine = br.readLine()) != null) { // no empty lines
//				String broker = brokerLine;
//				if(broker.equals(brokerName)) {
//					brokerLine = ""; //replace with empty line	
//					break;
//			    } else {
//			    	brokerLine = broker;
//			    }
//				
//			    bw.close();
//			    br.close();
//			    
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
//	}
	
}
