/**
 * 
 */
package org.app.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.app.data.RealtimeData;
import org.junit.Test;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class TestRealTimeDataManager {
	
	
	@Test
	public void testPut() throws Exception{
		RealtimeData expData = new RealtimeData();
		//Symbol     Company                      Date    Price  Change%    Yield      P/E      PEG    Short             Range   50Davg  50DChng  200Davg 200DChng 1Ytarget        Volume       AvgVol.
		//"AA     Alcoa Inc. Common        3/4/2011    16.57    -0.33     0.72    68.72     0.84     2.00   \"16.37 - 16.80\"    16.73    -0.93    13.94    18.91    19.55      18617484      28989900"
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		date = format.parse("3/4/2011");
		expData.setSymbol("AAR");
		expData.setCompanyInfo("Alcoa Inc. Common");
		expData.setDate(date);
		expData.setPrice((float) 16.57);
		expData.setPercentChange((float) -0.33);
		expData.setYield((float) 0.72);
		expData.setPe((float) 68.72);
		expData.setPeg((float) 0.84);
		expData.setShortD((float) 2.00);
		expData.setRange("16.37 - 16.80");
		expData.setAvg50D((float) 16.73);
		expData.setChng50D((float) -0.93);
		expData.setAvg200D((float) 13.94);
		expData.setChng200D((float) 18.91);
		expData.setTarget1Y((float) 19.55);
		expData.setVolume(18617484);
		expData.setAvgVolume(28989900);
		RealTimeDataManager dbm = new RealTimeDataManager();
		dbm.put(expData);		
		
	}
	
	@Test
	public void testGet() throws Exception {
		
		RealTimeDataManager dbm = new RealTimeDataManager();
		RealtimeData expData = (RealtimeData) dbm.get("AAR");
		System.out.println(expData);
		dbm.close();
	
	}

}
