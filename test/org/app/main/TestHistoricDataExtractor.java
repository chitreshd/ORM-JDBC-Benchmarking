/**
 * 
 */
package org.app.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.app.data.HistoricData;
import org.junit.Test;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class TestHistoricDataExtractor {
	
	@Test
	public void testParseLine() throws ParseException{
		HistoricData expData = new HistoricData();
		HistoricData actData = new HistoricData();
		
		// Set expData
		// 2011-03-01,1.10,1.10,1.00,1.01,216600,1.01
		DateFormat format = new SimpleDateFormat("yyyy-dd-MM");
		Date date = null;
		date = format.parse("2011-03-01");
		expData.setDate(date);
		expData.setOpen((float) 1.10);
		expData.setHigh((float) 1.10);
		expData.setLow((float) 1.00);
		expData.setClose((float) 1.01);
		expData.setVolume(216600);
		expData.setAdjClose((float) 1.01);
		
		HistoricDataExtractor extractor = new HistoricDataExtractor();
		actData = extractor.parseLine("2011-03-01,1.10,1.10,1.00,1.01,216600,1.01");
		
		assertEquals(expData.getAdjClose(),actData.getAdjClose(),0);
		assertEquals(expData.getClose(),actData.getClose(),0);
		assertEquals(expData.getOpen(),actData.getOpen(),0);
		assertEquals(expData.getHigh(),actData.getHigh(),0);
		assertEquals(expData.getLow(),actData.getLow(),0);
		assertEquals(expData.getVolume(),actData.getVolume(),0);
		assertTrue(expData.getDate().equals(actData.getDate()));
		
		// Lets test the equals method from HistoricData
		assertTrue(expData.equals(actData));	
		
	}
	
	@Test
	public void testExtracTuples() throws IllegalStateException, IOException{
		HistoricDataExtractor extractor = new HistoricDataExtractor();
		List<String> extractedTupples = extractor.extractAllTuples("HistoricTest");
		assertEquals(extractedTupples.size(),7);
		assertEquals(extractedTupples.get(0),"2011-03-04,1.08,1.08,1.05,1.06,57400,1.06");
		assertEquals(extractedTupples.get(6),"2011-02-24,1.15,1.19,1.11,1.13,171400,1.13");
	}
	
	@Test
	public void testParseFile() throws IllegalStateException, IOException, ParseException {
		HistoricDataExtractor extractor = new HistoricDataExtractor();
		List<HistoricData> dataList = extractor.parseFile("HistoricTest");
		assertEquals(dataList.size(),7);
		
		HistoricData expData = new HistoricData();
		
		
		// Set expData. Not testing every object but just 1. which is at index 4
		// 2011-02-28,1.12,1.16,1.08,1.08,134300,1.08
		DateFormat format = new SimpleDateFormat("yyyy-dd-MM");
		Date date = null;
		date = format.parse("2011-02-28");
		expData.setDate(date);
		expData.setOpen((float) 1.12);
		expData.setHigh((float) 1.16);
		expData.setLow((float) 1.08);
		expData.setClose((float) 1.08);
		expData.setVolume(134300);
		expData.setAdjClose((float) 1.08);
		
		HistoricData actData = dataList.get(4);
		assertTrue(expData.equals(actData));	
	}
	
	@Test
	public void testParseFileForSymbol(){
		
	}

}
