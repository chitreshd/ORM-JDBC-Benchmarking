package src.app.main;


/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */

public abstract class DBConnector {
	protected String userName;
	protected String passWord;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public abstract void connect(String userName, String passWord) throws Exception;	
	
	/**
	 * @param dbName
	 * @throws Exception
	 */
	public abstract void createDataBase(String dbName) throws Exception;
	
	public abstract void dropDataBase(String dbName) throws Exception;
}
