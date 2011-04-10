/**
 * 
 */
package org.app.main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.ParseException;

import org.app.main.DataManager;
import org.app.utility.LocalFileReader;
import org.junit.Test;


/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class TestDataManager {
	
	//@Test
	public void testopenDBConnection() throws SecurityException, NoSuchMethodException, 
											IllegalArgumentException, IllegalAccessException, 
											InvocationTargetException, InstantiationException, 
											ClassNotFoundException, IOException{
		DataManager manager = new DataManager();
		manager.setPassWord(LocalFileReader.getLine("credentials"));
		manager.setUserName("root");
		Class<DataManager> tClass = DataManager.class;
		String className = tClass.getName();
		System.out.println("Class Name: " + className);
		Method method = tClass.getDeclaredMethod("openDBConnection");
		method.setAccessible(true);
		method.invoke(manager);
	}
	
	@Test
	public void testExecute() throws IOException, InstantiationException, 
									IllegalAccessException, ClassNotFoundException, 
									SQLException, ParseException{
		String username = "root";
		String password = LocalFileReader.getLine("credentials");
		DataManager manager = new DataManager();
		manager.execute(username, password);
	}
}
