/**
 * 
 */
package org.app.main;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.data.HistoricData;
import org.app.utility.RealtimeFileReader;

/**
 * @author Chitresh Deshpande
 * 
 *         Copyright 2011, San Jose State University
 * 
 */
public class HistoricDataExtractor {

	private static final Log log = LogFactory
			.getLog(RealTimeDataExtractor.class);

	RealtimeFileReader fileReader;
	private String symbol;
	
	public HistoricDataExtractor() {
		fileReader = RealtimeFileReader.getInstance();
	}
	
	

	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public List<HistoricData> parseFile(String filePath)
			throws IllegalStateException, IOException {
		List<HistoricData> dataList = new ArrayList<HistoricData>();
		
		List<String> tuppleList = extractAllTuples(filePath);
		
		for(String tupple:tuppleList)
			dataList.add(parseLine(tupple));
		
		return dataList;
	}

	public List<String> extractAllTuples(String filePath)
			throws IllegalStateException, IOException {
		List<String> tuppleList = new ArrayList<String>();
		
		/*
		 * We assume that the file provided will have same format and hence we
		 * leverage its properties. The company specific file with the historic
		 * data has relevant data starting from line no 13. Hence we skip first
		 * 12 lines and start extracting the data from the 13th line.
		 */
		//symbol = RealtimeFileReader.getInstance().stripExtension(filePath);
		fileReader.setPathName(filePath);
		fileReader.open();

		for (int i = 0; i < 12; i++) {
			fileReader.getLine();
		}

		String tupple = fileReader.getLine();
		while (tupple != null ) {
			if(tupple.isEmpty())
				break;
			tuppleList.add(tupple);
			tupple = fileReader.getLine();
		}
		fileReader.close();
		return tuppleList;
	}

	public HistoricData parseLine(final String line) {
		if (line == null || line.isEmpty())
			throw new IllegalArgumentException(
					"Null line or empty line encountered.");

		HistoricData data = new HistoricData();
		String[] splits = line.split(",");

		DateFormat format = new SimpleDateFormat("yyyy-dd-MM");
		Date date = null;
		try {
			date = format.parse(splits[0]);
		} catch (ParseException e) {

			log.error("Date was null and hence setting up the date as null.");
		}
		data.setDate(date);
		data.setSymbol(symbol);
		data.setOpen(Float.parseFloat(splits[1]));
		data.setHigh(Float.parseFloat(splits[2]));
		data.setLow(Float.parseFloat(splits[3]));
		data.setClose(Float.parseFloat(splits[4]));
		data.setVolume(Double.parseDouble(splits[5]));
		data.setAdjClose(Float.parseFloat(splits[6]));

		return data;
	}

}
