package cryptoTrader.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import cryptoTrader.gui.MainUI;

public class DataVisualizationCreator {
	
	public void createCharts() {
//		createTextualOutput();
		createTableOutput();
//		createTimeSeries();
//		createScatter();
		createBar();
	}

	private void createTextualOutput() {
//		DefaultTableModel dtm = new  DefaultTableModel(new Object[] {"Broker Name", "Ticker List", "Strategy Name"}, 1);
//		JTable table = new JTable(dtm);
//		//table.setPreferredSize(new Dimension(600, 300));
//		dtm.e
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
//                "Broker Actions",
//                TitledBorder.CENTER,
//                TitledBorder.TOP));
//		
//	
//		
//		scrollPane.setPreferredSize(new Dimension(800, 300));
//		table.setFillsViewportHeight(true);;
		
//		MainUI.getInstance().updateStats(scrollPane);
	}
	
	private void createTableOutput() {
		// Dummy dates for demo purposes. These should come from selection menu
		Object[] columnNames = {"Trader","Strategy","CryptoCoin","Action","Quantity","Price","Date"};
		
		// Dummy data for demo purposes. These should come from actual fetcher
		Object[][] data = summaryToTable();
		
		for (int i = 0; i <  data.length; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.println(data[i][j]);
			}
		}
		
//		{
//				{"Trader-1", "Strategy-A", "ETH", "Buy", "500", "150.3","13-January-2022"},
//				{"Trader-2", "Strategy-B", "BTC", "Sell", "200", "50.2","13-January-2022"},
//				{"Trader-3", "Strategy-C", "USDT", "Buy", "1000", "2.59","15-January-2022"},
//				{"Trader-1", "Strategy-A", "USDC", "Buy", "500", "150.3","16-January-2022"},
//				{"Trader-2", "Strategy-B", "ADA", "Sell", "200", "50.2","16-January-2022"},
//				{"Trader-3", "Strategy-C", "SOL", "Buy", "1000", "2.59","17-January-2022"},
//				{"Trader-1", "Strategy-A", "ONE", "Buy", "500", "150.3","17-January-2022"},
//				{"Trader-2", "Strategy-B", "MANA", "Sell", "200", "50.2","17-January-2022"},
//				{"Trader-3", "Strategy-C", "AVAX", "Buy", "1000", "2.59","19-January-2022"},
//				{"Trader-1", "Strategy-A", "LUNA", "Buy", "500", "150.3","19-January-2022"},
//				{"Trader-2", "Strategy-B", "FTM", "Sell", "200", "50.2","19-January-2022"},
//				{"Trader-3", "Strategy-C", "HNT", "Buy", "1000", "2.59","20-January-2022"}
//		};
//		

		JTable table = new JTable(data, columnNames);
		//table.setPreferredSize(new Dimension(600, 300));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Trader Actions",
                TitledBorder.CENTER,
                TitledBorder.TOP));
		
	
		
		scrollPane.setPreferredSize(new Dimension(800, 300));
		table.setFillsViewportHeight(true);;
		
		MainUI.getInstance().updateStats(scrollPane);
	}

	private void createTimeSeries() {
		TimeSeries series1 = new TimeSeries("Bitcoin - Daily");
		series1.add(new Day(13, 9, 2021), 50368.67);
		series1.add(new Day(14, 9, 2021), 51552.05);
		series1.add(new Day(15, 9, 2021), 47228.30);
		series1.add(new Day(16, 9, 2021), 45263.90);
		series1.add(new Day(17, 9, 2021), 46955.41);
		
		TimeSeries series2 = new TimeSeries("Ethereum - Daily");
		series2.add(new Day(13, 9, 2021), 3912.28);
		series2.add(new Day(14, 9, 2021), 3927.27);
		series2.add(new Day(15, 9, 2021), 3460.48);
		series2.add(new Day(16, 9, 2021), 3486.09);
		series2.add(new Day(17, 9, 2021), 3550.29);

		TimeSeries series3 = new TimeSeries("Cardano - Daily");
		series3.add(new Day(13, 9, 2021), 2.87);
		series3.add(new Day(14, 9, 2021), 2.84);
		series3.add(new Day(15, 9, 2021), 2.41);
		series3.add(new Day(16, 9, 2021), 2.43);
		series3.add(new Day(17, 9, 2021), 2.59);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		XYPlot plot = new XYPlot();
		XYSplineRenderer splinerenderer1 = new XYSplineRenderer();
		
		plot.setDataset(0, dataset);
		plot.setRenderer(0, splinerenderer1);
		DateAxis domainAxis = new DateAxis("");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new LogAxis("Price(USD)"));

		//plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		//plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis
		//plot.mapDatasetToRangeAxis(2, 2);// 3rd dataset to 3rd y-axis
		
		JFreeChart chart = new JFreeChart("Daily Price Line Chart", new Font("Serif", java.awt.Font.BOLD, 18), plot,
				true);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(800, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		chartPanel.setBackground(Color.white);
		
		MainUI.getInstance().updateStats(chartPanel);
	}
	
	private void createScatter() {
		TimeSeries series1 = new TimeSeries("Bitcoin - Daily");
		series1.add(new Day(13, 9, 2021), 50368.67);
		series1.add(new Day(14, 9, 2021), 51552.05);
		series1.add(new Day(15, 9, 2021), 47228.30);
		series1.add(new Day(16, 9, 2021), 45263.90);
		series1.add(new Day(17, 9, 2021), 46955.41);
		
		TimeSeries series2 = new TimeSeries("Ethereum - Daily");
		series2.add(new Day(13, 9, 2021), 3912.28);
		series2.add(new Day(14, 9, 2021), 3927.27);
		series2.add(new Day(15, 9, 2021), 3460.48);
		series2.add(new Day(16, 9, 2021), 3486.09);
		series2.add(new Day(17, 9, 2021), 3550.29);

		TimeSeries series3 = new TimeSeries("Cardano - Daily");
		series3.add(new Day(13, 9, 2021), 2.87);
		series3.add(new Day(14, 9, 2021), 2.84);
		series3.add(new Day(15, 9, 2021), 2.41);
		series3.add(new Day(16, 9, 2021), 2.43);
		series3.add(new Day(17, 9, 2021), 2.59);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new LogAxis("Price(USD)"));

		//plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		//plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis
		
		JFreeChart scatterChart = new JFreeChart("Daily Price Scatter Chart",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(600, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		chartPanel.setBackground(Color.white);
		MainUI.getInstance().updateStats(chartPanel);
	}
	
	private void createBar() {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		Those are hard-coded values!!!! 
//		You will have to come up with a proper datastructure to populate the BarChart with live data!
//		dataset.setValue(6, "Trader-1", "Strategy-A");
//		dataset.setValue(5, "Trader-2", "Strategy-B");
//		dataset.setValue(0, "Trader-3", "Strategy-E");
//		dataset.setValue(1, "Trader-3", "Strategy-C");
//		dataset.setValue(10, "Trader-4", "Strategy-D");
		
		HashMap<String, Integer> hashA = new HashMap<String, Integer>();
		HashMap<String, Integer> hashB = new HashMap<String, Integer>();
		HashMap<String, Integer> hashC = new HashMap<String, Integer>();
		HashMap<String, Integer> hashD = new HashMap<String, Integer>();
		
		
		ArrayList<String> brokerList = new ArrayList<String>(); // create arrayList containing all unique brokers
		Object[][] summaryTable = summaryToTable(); // call table information
		for(int i = 0; i < summaryTable.length; i++) { // iterate through table to grab uniques
			if(!brokerList.contains(summaryTable[i][0])) {
				brokerList.add((String) summaryTable[i][0]);
			}
		}
		
		// for item in brokerList,
			// for item in summaryTable
				// if summarytable[i][0].equals(item)
					// hashA.put(summaryTable[i][1], hashA.get(summaryTable[i][1]) + 1)
		
		// initialize all brokers for all strats to 0
		for(String broker : brokerList) {
		
			hashA.put(broker, 0);
			hashB.put(broker, 0);
			hashC.put(broker, 0);
			hashD.put(broker, 0);
			
		}
		
		// loop through summaryTable to updates hashtables
		for(String broker : brokerList) {
			for (int i = 0; i < summaryTable.length; i++) {
				if (summaryTable[i][0] == null) {
					break;
				}
				if (summaryTable[i][0].equals(broker)) {
					String stratName = (String) summaryTable[i][1];
					switch (stratName) {
					case "Strategy-A":
						hashA.put(broker, hashA.get(broker) + 1);
						break;
					case "Strategy-B":
						hashB.put(broker, hashB.get(broker) + 1);
						break;
					case "Strategy-C":
						hashC.put(broker, hashC.get(broker) + 1);
						break;
					case "Strategy-D":
						hashD.put(broker, hashD.get(broker) + 1);
						break;
					default:
						break;
					}
				} 
			}
		}
		
		
		// for stratA
		for (Map.Entry item: hashA.entrySet()) {
			String broker = (String)item.getKey();
			int timesPerformed = (int)item.getValue();
			dataset.setValue(timesPerformed, broker, "Strategy-A");
		}
		
		// for stratB
		for (Map.Entry item: hashB.entrySet()) {
			String broker = (String)item.getKey();
			int timesPerformed = (int)item.getValue();
			dataset.setValue(timesPerformed, broker, "Strategy-B");
		}
		
		// for stratC
		for (Map.Entry item: hashC.entrySet()) {
			String broker = (String)item.getKey();
			int timesPerformed = (int)item.getValue();
			dataset.setValue(timesPerformed, broker, "Strategy-C");
		}
		
		// for stratD
		for (Map.Entry item: hashD.entrySet()) {
			String broker = (String)item.getKey();
			int timesPerformed = (int)item.getValue();
			dataset.setValue(timesPerformed, broker, "Strategy-D");
		}
		

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Strategy");
		plot.setDomainAxis(domainAxis);
		LogAxis rangeAxis = new LogAxis("Actions(Buys or Sells)");
		rangeAxis.setRange(new Range(0.1, 20.0));
		plot.setRangeAxis(rangeAxis);

		//plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		//plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart barChart = new JFreeChart("Actions Performed By Traders So Far", new Font("Serif", java.awt.Font.BOLD, 18), plot,
				true);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(600, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		chartPanel.setBackground(Color.white);
		MainUI.getInstance().updateStats(chartPanel);
	}
	
	private Object[][] summaryToTable() {
		int numLines = 0;
		try {
			Scanner countLines = new Scanner(new File("summaries.txt"));
			while(countLines.hasNextLine()) {
				countLines.nextLine();
				numLines++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("NUMLINES IN FILE: " + numLines);
		String[][] summaryForTable = new String[numLines][7];
		try {
			Scanner summary = new Scanner(new File("summaries.txt"));
			int counter = 0;
			while(summary.hasNextLine()) {
				String currLine = summary.nextLine();
				String[] splitLine = currLine.split(",");
				for(int i = 0; i < 7; i++) {
					summaryForTable[counter][i] = splitLine[i];
				}
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return summaryForTable;
	}

}
