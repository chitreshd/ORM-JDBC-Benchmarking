/**
 * 
 */
package org.app.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class TestRealTimeFileReader {

	@Test
	public void testGetFileNames(){
		
		RealtimeFileReader reader = RealtimeFileReader.getInstance();
		String [] fileList = reader.getFileNames("historicTest");
		for(String fileName : fileList){
			String strip = reader.stripExtension(fileName);
			
		}		
	}
	
	@Test
	public void testGetFileName(){
		RealtimeFileReader reader = RealtimeFileReader.getInstance();
		String lTest = "/ORM-JDBC-Benchmarking/historicTest/ACCL.dat";
		String lExpected = "ACCL";
		reader.setPathName(lTest);
		String lActual = reader.getFileName(lTest);
		assertEquals(lExpected,lActual);
	}
	
}
