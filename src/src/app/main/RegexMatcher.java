/**
 * 
 */
package src.app.main;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexMatcher {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter input string to search: ");
		String input = in.nextLine();
		in.close();
		Pattern pattern = Pattern.compile("[\\s]{2,}");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()){
			/*System.out.println("I found the text " + matcher.group()
					+ " starting at index " + matcher.start()
					+ " and ending at index " + matcher.end());
			System.out.println("Token: ");*/
			
		}
		System.out.println("Modified String: " + matcher.replaceAll(":"));	
		

	}
}