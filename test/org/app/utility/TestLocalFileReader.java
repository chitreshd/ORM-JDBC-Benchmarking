/**
 * 
 */
package org.app.utility;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.utility.LocalFileReader;
import org.junit.Test;



/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class TestLocalFileReader {
	private static final Log log = LogFactory.getLog(TestLocalFileReader.class);
	
	@Test
	public void testGetLine(){
		try {
			String test = LocalFileReader.getLine("credentials");
			assertEquals("Shrikant@52",test);
			assertNotSame("",test);
			
		} catch (IOException e) {
			log.error("Test fails -> File opening error: " + e.getMessage());
		}
	}

}
