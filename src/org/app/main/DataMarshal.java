/**
 * 
 */
package org.app.main;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.data.HistoricData;
import org.app.data.RealtimeData;
import org.app.database.HistoricDataManager;
import org.app.database.RealTimeDataManager;
import org.app.utility.RealtimeFileReader;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 * This class provides the APIs to marshal or arrange the data 
 * that's in files into database.
 * 
 */
public class DataMarshal {
	private long counter;
	private static final Log log = LogFactory.getLog(DataMarshal.class);
	
	/**
	 * @param filePath - Realtime data filepath. Absolute path is expedted.
	 * @param dbName - the dbName with which you want the data to be put in.
	 * @throws Exception 
	 */
	public void marshalRealTimeData(String filePath, String dbName) throws Exception{
		
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		RealTimeDataManager dbm = new RealTimeDataManager();
		
		List<RealtimeData> dList = extractor.parseFile(filePath);
		
		if((dbName != null) && (!dbName.isEmpty()))
			dbm.setDatabase(dbName);
		
		long before = System.currentTimeMillis();
		for(RealtimeData object : dList){
			try{
				dbm.put(object);
			} catch(Exception e){
				log.error(e.getMessage());			 
			}
		}
			
		long after = System.currentTimeMillis();
		counter = after - before;
	}
	
	/**
	 * @param dirName: Provide the directory name where all the historic data is kept.
	 * 
	 * This API intends to recursively fetch the files from the directory and extract its
	 * data. Steps
	 * - fetch a file
	 * - extract its name
	 * - strip .dat
	 * - assign the remaning thing to the HistoricData object as a symbol
	 * - call the HistoricData extractor and retrieve the list of HistoricData.
	 * - call the HistoricData Manager and add the data to the database. 
	 * @throws Exception 
	 */
	public void marshalHistoricData(String dirName) throws Exception{
		
		HistoricDataManager dbm = new HistoricDataManager();
		RealtimeFileReader reader = RealtimeFileReader.getInstance();
		String [] fileList = reader.getFileNames(dirName);
		for(String fileName:fileList){
			String filePath = dirName + System.getProperty("file.separator") + fileName;
			HistoricDataExtractor extractor = new HistoricDataExtractor();
			extractor.setSymbol(reader.getFileName(fileName));
			List<HistoricData> dList = extractor.parseFile(filePath);
			System.out.println(dList);
			for(HistoricData object : dList){
				try{
					dbm.put(object);
				} catch(Exception e){
					log.error(e.getMessage());
				}
			}
				
		}
		
		
	}

	/**
	 * @param counter the counter to set
	 */
	/*public void setCounter(long counter) {
		this.counter = counter;
	}*/

	/**
	 * @return the counter
	 */
	public long getCounter() {
		return counter;
	}
}
