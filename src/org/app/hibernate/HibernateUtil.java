/**
 * 
 */
package org.app.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * @return
	 */
	private static SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		return new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
}
