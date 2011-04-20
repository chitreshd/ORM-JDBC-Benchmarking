/**
 * 
 */
package org.app.main;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.app.data.RealtimeData;
import org.app.main.RealTimeDataExtractor;
import org.junit.Test;


/**
 * @author Chitresh Deshpande
 * 
 *         Copyright 2011, San Jose State University
 * 
 */
public class TestRealTimeExtractor {

	//@Test
	public void test() throws IllegalArgumentException, ParseException,
			IllegalStateException, IOException {
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		List<RealtimeData> list = extractor.parseFile(5);
		assertEquals(list.size(),5);
	}

	@Test
	public void testParse() {
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		try {
			RealtimeData expectedObject = extractor
					.parseLine("AAR     AMR Corporation          3/4/2011    23.61    -0.04     8.33     0.00     0.00     0.00 \"23.61 - 23.8636\"    23.55     0.25    23.49     0.50     0.00          6214         10240");

			// Compare some of the data objects.
			assertEquals("AA", expectedObject.getSymbol());
			assertEquals("Alcoa Inc. Common", expectedObject.getCompanyInfo());
			assertEquals(16.57, expectedObject.getPrice(), 0.01);
			assertEquals(18617484, expectedObject.getVolume(), 0.01);
			System.out.println(expectedObject);
			// assertTrue(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testParseWithStringParam() throws IllegalStateException, IllegalArgumentException, IOException, ParseException{
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		List<RealtimeData> dList = extractor.parseFile("RealTimetest");
		System.out.println(dList);
		
	}

}
