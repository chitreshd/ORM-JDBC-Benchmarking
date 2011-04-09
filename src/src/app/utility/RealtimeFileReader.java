/**
 * 
 */
package src.app.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 * 
 * The correct way to use this utility is to open the file connection. Read the file contents
 * and then close the connection. The Singleton instance will ensure thread safety.
 *
 */
public class RealtimeFileReader {
	private static final Log log = LogFactory.getLog(RealtimeFileReader.class);
	private static RealtimeFileReader instance;
	private BufferedReader reader;
	private String pathName;
	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	private RealtimeFileReader(){		
	}
	
	public static RealtimeFileReader getInstance(){
		if(instance == null)
			instance = new RealtimeFileReader();		 
		return instance;		
	}
	
	public void open() throws IllegalStateException, FileNotFoundException{
		if(pathName.isEmpty() || (pathName == null))
			throw new IllegalStateException("Illegal file path.");
		reader = new BufferedReader(new FileReader(new File(pathName)));
		log.info("File connection established succesfully.");
	}
	
	public void close() throws IOException{
		reader.close();
	}
	
	public String getLine() throws IOException{
		return reader.readLine();
	}
	
}
