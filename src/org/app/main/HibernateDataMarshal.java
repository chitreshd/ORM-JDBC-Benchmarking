/**
 * 
 */
package org.app.main;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.data.RealtimeData;
import org.app.database.RealTimeDataManager;
import org.app.hibernate.HibernateDataManager;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class HibernateDataMarshal {
	private long counter;
	private static final Log log = LogFactory.getLog(HibernateDataMarshal.class);
	
	/**
	 * @param filePath - Realtime data filepath. Absolute path is expedted.
	 * 
	 * @throws Exception 
	 */
	public void marshalRealTimeData(String filePath) throws Exception{
		
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		HibernateDataManager hdbm = new HibernateDataManager();
		hdbm.setupSession();
		List<RealtimeData> dList = extractor.parseFile(filePath);	
		
		
		long before = System.currentTimeMillis();
		for(RealtimeData object : dList){
			try{
				hdbm.insertRealTimeData(object);
			} catch(Exception e){
				log.error(e.getMessage());			 
			}
		}
		hdbm.destroySession();	
		long after = System.currentTimeMillis();
		setCounter(after - before);
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(long counter) {
		this.counter = counter;
	}

	/**
	 * @return the counter
	 */
	public long getCounter() {
		return counter;
	}
}
