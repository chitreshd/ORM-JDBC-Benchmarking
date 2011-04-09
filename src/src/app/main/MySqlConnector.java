package src.app.main;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class MySqlConnector extends DBConnector{
	private static final Log log = LogFactory.getLog(MySqlConnector.class);
	
	private String url;
	private String dbName;
    private String driver;
	private Connection conn;
	
	private static MySqlConnector instance;
    
	
	private MySqlConnector() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		url = "jdbc:mysql://localhost:3306/";
		dbName = "phpmyadmin"; // by default the application will connect to phpmyadmin.
		driver = "com.mysql.jdbc.Driver";
		Class.forName(driver).newInstance();
	}
	
	
	public static MySqlConnector getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if(instance == null)
			instance = new MySqlConnector();		 
		return instance;		
	}
	
	// This is a sample method to test the connection. This will be removed once everything is working.
	@Override
	public void connect(String userName, String passWord) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {		
		log.info("Trying to connect MySQL database");
		Connection conn = null;	    
	    conn = DriverManager.getConnection(url+dbName,userName,passWord);
	    log.info("Connection established successfully");
	    conn.close();
	    log.info("Connection closed successfull");
	}
	
	private void open() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.conn = DriverManager.getConnection(url + dbName, userName, passWord);
		log.info("Connection established successfully");
	}
	
	private void close() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		this.conn.close();
		log.info("Connection closed successfull");
	}
	
	/* (non-Javadoc)
	 * @see src.app.main.DBConnector#createDB(java.lang.String)
	 */
	@Override
	public void createDataBase(String dbName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.open();
		Statement st = conn.createStatement();
		st.executeUpdate("CREATE DATABASE " + dbName);
		log.info("1 row(s) affected");
		this.close();
	}


	/* (non-Javadoc)
	 * @see src.app.main.DBConnector#deleteDataBase(java.lang.String)
	 */
	@Override
	public void dropDataBase(String dbName) throws Exception {
		this.open();
		Statement st = conn.createStatement();
		st.executeUpdate("DROP DATABASE " + dbName);
		log.info("1 row(s) affected");
		this.close();		
	}	

}
