/**
 * 
 */
package org.app.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.data.AData;
import org.app.data.HistoricData;
import org.app.utility.RealtimeFileReader;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 * 
 * This class manages the interaction of the application 
 * with the database. It interacts with the historicdata
 * table to provide CRUD functionality over HistoricData. 
 *
 */
public class HistoricDataManager implements DBDataManager{
	
	private static final Log log = LogFactory.getLog(HistoricDataManager.class);
	
	private Connection conn;
	
	public HistoricDataManager(){
		init();
	}
	/* (non-Javadoc)
	 * @see org.app.database.DBDataManager#get()
	 */
	@Override
	public AData get(String symbol) throws Exception {
		HistoricData dbObject = new HistoricData();	
		Statement st = conn.createStatement();
		String query = "SELECT * FROM historicdata WHERE symbol = '" + symbol + "';";
		log.info(query);
		ResultSet rs = st.executeQuery(query);
		if(rs.next()){
			int j = rs.getRow();
			if(j != 1)
				throw new Exception("Incorrect number of rows returned. ");
			dbObject.setSymbol(rs.getString(1));
			dbObject.setDate(rs.getDate(2));
			dbObject.setOpen(rs.getFloat(3));
			dbObject.setHigh(rs.getFloat(4));
			dbObject.setLow(rs.getFloat(5));
			dbObject.setClose(rs.getFloat(6));
			dbObject.setVolume(rs.getDouble(7));
			dbObject.setAdjClose(rs.getFloat(8));
		}
		else
			throw new Exception("ResultSet was null");
		
		return dbObject;
	}

	/* (non-Javadoc)
	 * @see org.app.database.DBDataManager#put(org.app.data.AData)
	 */
	@Override
	public void put(AData dObject) throws Exception {
		HistoricData dbObject = (HistoricData) dObject;
		/*Statement st = conn.createStatement();*/
		String sqlQ = " INSERT INTO historicdata VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sqlQ);
		ps.setString(1, dbObject.getSymbol());
		Date sqlDate = new Date(dbObject.getDate().getTime());
		ps.setDate(2, sqlDate);
		ps.setDouble(3, dbObject.getOpen());
		ps.setDouble(4, dbObject.getHigh());
		ps.setDouble(5, dbObject.getLow());
		ps.setDouble(6, dbObject.getClose());
		ps.setDouble(7, dbObject.getVolume());
		ps.setDouble(8, dbObject.getAdjClose());
		int count = ps.executeUpdate();
		log.info(count + " row(s) were affected");		
	}

	/* (non-Javadoc)
	 * @see org.app.database.DBDataManager#update(org.app.data.AData)
	 */
	@Override
	public void update(AData dObject) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.app.database.DBDataManager#delete(org.app.data.AData)
	 */
	@Override
	public void delete(String symbol) {
		// TODO Auto-generated method stub
		
	}
	
	public void init(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "Stocks",getUserName(),getPassWord());			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getUserName() throws IOException{
		RealtimeFileReader reader = RealtimeFileReader.getInstance();
		reader.setPathName("credentials");
		reader.open();
		reader.getLine(); // skip this as 1st line is password
		return reader.getLine();		 
	}
	
	private String getPassWord() throws IOException{
		RealtimeFileReader reader = RealtimeFileReader.getInstance();
		reader.setPathName("credentials");
		reader.open();
		return reader.getLine(); 				 
	}
	
	public void close() throws SQLException{
		conn.close();
	}
	

}
