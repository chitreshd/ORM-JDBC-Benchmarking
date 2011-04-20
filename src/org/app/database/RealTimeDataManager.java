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
import org.app.data.RealtimeData;
import org.app.utility.RealtimeFileReader;

/**
 * @author Chitresh Deshpande
 * 
 *         Copyright 2011, San Jose State University
 * 
 */
public class RealTimeDataManager implements DBDataManager {

	private static final Log log = LogFactory.getLog(RealTimeDataManager.class);

	private Connection conn;
	protected String database;
	
	public RealTimeDataManager() {
		database = "Stocks";
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.app.database.DBDataManager#get(java.lang.String)
	 */
	@Override
	public AData get(String symbol) throws Exception {
		RealtimeData data = new RealtimeData();	
		Statement st = conn.createStatement();
		String query = "SELECT * FROM livestock WHERE symbol = '" + symbol + "'";
		log.info(query);
		ResultSet rs = st.executeQuery(query);
		if(rs.next()){
			int j = rs.getRow();
			if(j != 1)
				throw new Exception("Incorrect number of rows returned. ");
			data.setSymbol(rs.getString(1));
			data.setDate(rs.getDate(2));
			data.setPrice(rs.getFloat(3));
			data.setPercentChange(rs.getFloat(4));
			data.setYield(rs.getFloat(5));
			data.setPe(rs.getFloat(6));
			data.setPeg(rs.getFloat(7));
			data.setShortD(rs.getFloat(8));
			data.setRange(rs.getString(9));
			data.setAvg50D(rs.getFloat(10));
			data.setChng50D(rs.getFloat(11));
			data.setAvg200D(rs.getFloat(12));
			data.setChng200D(rs.getFloat(13));
			data.setTarget1Y(rs.getFloat(14));
			data.setVolume(rs.getDouble(15));
			data.setAvgVolume(rs.getDouble(16));		
			
		}
		
		query = "SELECT * FROM CompanyInfo WHERE symbol = '" + symbol + "'";
		log.info(query);
		rs = st.executeQuery(query);
		if(rs.next()){
			int j = rs.getRow();
			if(j != 1)
				throw new Exception("Incorrect number of rows returned. ");
			//data.setSymbol(rs.getString(1));
			data.setCompanyInfo(rs.getString(2));
		}
		
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.app.database.DBDataManager#put(org.app.data.AData)
	 */
	@Override
	public void put(AData dObject) throws Exception {
		RealtimeData data = new RealtimeData();
		data = (RealtimeData) dObject;
		/*Statement st = conn.createStatement();*/
		String sqlQ = " INSERT INTO livestock VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sqlQ);		
		ps.setString(1, data.getSymbol());
		Date sqlDate = new Date(data.getDate().getTime());
		ps.setDate(2,sqlDate);
		ps.setFloat(3, data.getPrice());
		ps.setFloat(4, data.getPercentChange());
		ps.setFloat(5, data.getYield());
		ps.setFloat(6, data.getPe());
		ps.setFloat(7, data.getPeg());
		ps.setFloat(8, data.getShortD());
		ps.setString(9, data.getRange());
		ps.setFloat(10, data.getAvg50D());
		ps.setFloat(11, data.getChng50D());
		ps.setFloat(12, data.getAvg200D());
		ps.setFloat(13, data.getChng200D());
		ps.setFloat(14, data.getTarget1Y());
		ps.setDouble(15, data.getVolume());
		ps.setDouble(16, data.getAvgVolume());
		ps.executeUpdate();
		sqlQ = " INSERT INTO CompanyInfo VALUES (?,?)";
		PreparedStatement ps1 = conn.prepareStatement(sqlQ);
		ps1.setString(1, data.getSymbol());
		ps1.setString(2, data.getCompanyInfo());
		ps1.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.app.database.DBDataManager#update(org.app.data.AData)
	 */
	@Override
	public void update(AData dObject) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.app.database.DBDataManager#delete(java.lang.String)
	 */
	@Override
	public void delete(String symbol) {
		// TODO Auto-generated method stub

	}

	public void init() {

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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ database, getUserName(), getPassWord());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getUserName() throws IOException {
		RealtimeFileReader reader = RealtimeFileReader.getInstance();
		reader.setPathName("credentials");
		reader.open();
		reader.getLine(); // skip this as 1st line is password
		return reader.getLine();
	}

	private String getPassWord() throws IOException {
		RealtimeFileReader reader = RealtimeFileReader.getInstance();
		reader.setPathName("credentials");
		reader.open();
		return reader.getLine();
	}

	
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void close() throws SQLException {
		conn.close();
	}

}
