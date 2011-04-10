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

	@Test
	public void test() throws IllegalArgumentException, ParseException,
			IllegalStateException, IOException {
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		List<RealtimeData> list = extractor.extractTuples(5);
		assertEquals(list.size(),5);
	}

	@Test
	public void testParse() {
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		try {
			RealtimeData expectedObject = extractor
					.parseLine("AA     Alcoa Inc. Common        3/4/2011    16.57    -0.33     0.72    68.72     0.84     2.00   \"16.37 - 16.80\"    16.73    -0.93    13.94    18.91    19.55      18617484      28989900");

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

}
