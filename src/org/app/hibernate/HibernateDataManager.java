/**
 * 
 */
package org.app.hibernate;

import org.app.data.HistoricData;
import org.app.data.RealtimeData;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class HibernateDataManager {
	
	private Session session;
	
	public void insertRealTimeData(RealtimeData data){
		/*Session session = HibernateUtil.getSessionfactory().openSession();	*/	
		
		Transaction t = session.beginTransaction();
		session.save(data);
		t.commit();
		/*session.flush();
	    session.close();	*/    
	}
	
	public RealtimeData getRealTimeData(String symbol){
		/*Session session = HibernateUtil.getSessionfactory().openSession();	*/
		Transaction t = session.beginTransaction();
		RealtimeData data = (RealtimeData) session.get(RealtimeData.class, new String(symbol));
		t.commit();
		/*session.flush();
		session.close();*/
		return data;
		
	}
	
	public void insertHistoricData(HistoricData data){
		/*Session session = HibernateUtil.getSessionfactory().openSession();		*/
		Transaction t = session.beginTransaction();
		session.save(data);
		t.commit();
		session.flush();
	    session.close();	    
	}
	
	public HistoricData getHistoricData(String symbol){
		/*Session session = HibernateUtil.getSessionfactory().openSession();	*/
		Transaction t = session.beginTransaction();
		HistoricData data = (HistoricData) session.get(HistoricData.class, new String(symbol));
		t.commit();
		session.flush();
		session.close();
		return data;		
	}

	public void setupSession(){
		session = HibernateUtil.getSessionfactory().openSession();
	}
	
	public void destroySession(){
		session.flush();
		session.close();
	}
}
