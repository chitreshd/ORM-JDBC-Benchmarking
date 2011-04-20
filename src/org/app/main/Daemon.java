package org.app.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.data.RealtimeData;
import org.app.database.RealTimeDataManager;

public class Daemon {
	private static Log log = LogFactory.getLog(Daemon.class);
	public static void main(String args[]){
		log.info("Started the project");
		hibernateInvocation();
	}
	
	private static void jdbcInvocation(){
		DataMarshal marshal = new DataMarshal();
		try {
			marshal.marshalRealTimeData("realtime", "Stocks");
			//marshal.marshalHistoricData("historic");
			
			RealTimeDataManager dbm = new RealTimeDataManager();
			long before = System.currentTimeMillis();
			RealtimeData expData = (RealtimeData) dbm.get("ACCL");
			long after = System.currentTimeMillis();
			log.info(expData);
			log.info("Query reponse time: "+ (after - before));
			dbm.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Time taken to insert entire realtime data: " + marshal.getCounter());
	}
	
	private static void hibernateInvocation(){
		HibernateDataMarshal marshal = new HibernateDataMarshal();
		try {
			marshal.marshalRealTimeData("realtime");
			System.out.println("Time taken to insert entire realtime data: " + marshal.getCounter());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
