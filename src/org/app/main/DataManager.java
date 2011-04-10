/**
 * 
 */
package org.app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.data.RealtimeData;


/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */

public class DataManager {
	private static final Log log = LogFactory.getLog(DataManager.class);
	
	DBConnector connector;
	String userName; 
	String passWord;
	
	public DataManager() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		connector = MySqlConnector.getInstance();
	}
	
	public void execute() throws Exception{
		openDBConnection();		
	}
	
	private void putData(){
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	private void openDBConnection() throws Exception{
		connector.connect(userName, passWord);
		System.out.println("Testing private testing");
	}
	
	public void execute(String _userName, String _passWord) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException, IllegalArgumentException, IOException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "Stocks",_userName,_passWord);
		log.info("Connection established with the mysql server");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM livestock;");
		log.info("SELECT query executed with success");
		int i = rs.getMetaData().getColumnCount();
		int j = rs.getRow();
		rs.last();
		int k = rs.getRow();
		log.info("Column count " + i);
		log.info("Row " + j);
		log.info("Row after last call " + k);
		log.info("Now lets do some insertions");
		String sqlQ = " INSERT INTO livestock VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sqlQ);
		ps.setString(1, "AADR");
		RealtimeData data = new RealtimeData();
		data.setDate("3/4/2011");
		Date sqlDate = new Date(data.getDate().getTime());
		ps.setDate(2,sqlDate);
		ps.setDouble(3, 16.57);
		ps.setDouble(4, -0.33);
		ps.setDouble(5, 0.72);
		ps.setDouble(6, 68.72);
		ps.setDouble(7, 0.84);
		ps.setDouble(8, 2.00);
		ps.setString(9, "16.37 - 16.80");
		ps.setDouble(10, 16.73);
		ps.setDouble(11, -0.93);
		ps.setDouble(12, 13.94);
		ps.setDouble(13, 18.91);
		ps.setDouble(14, 19.55);
		ps.setDouble(15, 18617484);
		ps.setDouble(16, 28989900);
		int count = ps.executeUpdate();
		log.info(count + "row(s) were affected");
		rs.last();
		k = rs.getRow();
		log.info("Row after last call " + k);
		log.info("Now we will be retrieving the data from file and inserting into DB");
		
		RealTimeDataExtractor extractor = new RealTimeDataExtractor();
		List<RealtimeData> list = extractor.extractTuples(5);
		for(int a = 0; a < 5; a++){
			data = list.get(a);
			ps.setString(1, data.getSymbol());
			sqlDate = new Date(data.getDate().getTime());
			ps.setDate(2,sqlDate);
			ps.setDouble(3, data.getPrice());
			ps.setDouble(4, data.getPercentChange());
			ps.setDouble(5, data.getYield());
			ps.setDouble(6, data.getPe());
			ps.setDouble(7, data.getPeg());
			ps.setDouble(8, data.getShortD());
			ps.setString(9, data.getRange());
			ps.setDouble(10, data.getAvg50D());
			ps.setDouble(11, data.getChng50D());
			ps.setDouble(12, data.getAvg200D());
			ps.setDouble(13, data.getChng200D());
			ps.setDouble(14, data.getTarget1Y());
			ps.setDouble(15, data.getVolume());
			ps.setDouble(16, data.getAvgVolume());
			ps.executeUpdate();
		}		
		conn.close();
		log.info("Connection closeed with the mysql server");		
	}
	
	

}
