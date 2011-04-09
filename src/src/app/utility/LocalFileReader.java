/**
 * 
 */
package src.app.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class LocalFileReader {
	
	public static String getLine(String pathName) throws IOException{
		String text = null;
		BufferedReader reader = new BufferedReader(new FileReader(new File(pathName)));
		text = reader.readLine();
		reader.close();
		return text;
	}
}
