/**
 * 
 */
package org.app.main;

import org.junit.Test;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class TestDataMarshal {

	@Test
	public void testmarshalRealTimeData() throws Exception{
		DataMarshal marshal = new DataMarshal();
		marshal.marshalRealTimeData("RealTimetest", "Stocks");
	}
	
	//@Test
	public void testmarshalHistoricData() throws Exception{
		DataMarshal marshal = new DataMarshal();
		String dirName = "historicTest";
		marshal.marshalHistoricData(dirName);
	}
}
