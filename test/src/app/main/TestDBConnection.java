package src.app.main;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import src.app.utility.LocalFileReader;

public class TestDBConnection {
	private static final Log log = LogFactory.getLog(TestDBConnection.class);
	
	/**
	 * Use this variable and hence the DB for this test suite. 
	 * This will prevent these test-cases from tinkering with 
	 * other databases.
	 */
	private final String dbName = "jUnitTestDB";
	
	@Test
	public void testMySqlConnection(){
		DBConnector connector = null;
		try{
			connector = MySqlConnector.getInstance();
		} catch(Exception e){
			log.error("Error: " + e.getMessage());
			log.error("Stack Trace: " + e.getStackTrace());
		}
		
		try {
			String passWord = LocalFileReader.getLine("credentials");
			connector.connect("root",passWord);
		} catch (Exception e) {
			log.error("Error: " + e.getMessage());
			log.error("Stack Trace: " + e.getStackTrace());
			
		}
	}
	
	@Test(expected = SQLException.class)
	public void testMySqlConnectionFailure() throws Exception{
		DBConnector connector = MySqlConnector.getInstance();
		connector.connect("root","");		
	}
	
	@Test
	public void testCreateDB() throws Exception{
		DBConnector connector = MySqlConnector.getInstance();
		connector.setUserName("root");
		connector.setPassWord(LocalFileReader.getLine("credentials"));
		connector.createDataBase(dbName);
		deleteDB(connector);
	}
	
	@Test
	public void testDropDB() throws Exception{
		DBConnector connector = MySqlConnector.getInstance();
		connector.setUserName("root");
		connector.setPassWord(LocalFileReader.getLine("credentials"));
		createDB(connector);
		connector.dropDataBase(dbName);
	}
	
	private void createDB(DBConnector connector) throws Exception{
		connector.createDataBase(dbName);
	}
	
	private void deleteDB(DBConnector connector) throws Exception {
		connector.dropDataBase(dbName);
	}
	
	
}
