/**
 * 
 */
package org.app.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.app.data.HistoricData;
import org.junit.Test;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class TestHistoricDataManager {
	
	//@Test
	public void testPut() throws Exception{
		HistoricData expData = new HistoricData();
		// Set expData
		// 2011-03-01,1.10,1.10,1.00,1.01,216600,1.01
		DateFormat format = new SimpleDateFormat("yyyy-dd-MM");
		Date date = null;
		date = format.parse("2011-03-01");
		expData.setSymbol("AAR");
		expData.setDate(date);
		expData.setOpen((float) 1.10);
		expData.setHigh((float) 1.10);
		expData.setLow((float) 1.00);
		expData.setClose((float) 1.01);
		expData.setVolume(216600);
		expData.setAdjClose((float) 1.01);
		HistoricDataManager dbm = new HistoricDataManager();
		dbm.put(expData);
	}
	
	@Test
	public void testGet() throws Exception {
		
		HistoricDataManager dbm = new HistoricDataManager();
		HistoricData expData = (HistoricData) dbm.get("AAR");
		System.out.println(expData);
		dbm.close();
	
	}
}
