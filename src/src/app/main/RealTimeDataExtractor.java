/**
 * 
 */
package src.app.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import src.app.data.RealtimeData;
import src.app.utility.RealtimeFileReader;

/**
 * @author Chitresh Deshpande
 * 
 *         Copyright 2011, San Jose State University
 * 
 */
public class RealTimeDataExtractor {
	private static final Log log = LogFactory
			.getLog(RealTimeDataExtractor.class);

	RealtimeFileReader fileReader;

	public RealTimeDataExtractor() {
		fileReader = RealtimeFileReader.getInstance();
	}

	public List<RealtimeData> extractTuples(int limit)
			throws IllegalStateException, IOException,
			IllegalArgumentException, ParseException {
		
		List<RealtimeData> list = new ArrayList<RealtimeData>();

		fileReader.setPathName("realtime");
		fileReader.open();

		String tupple = fileReader.getLine();
		fileReader.getLine();
		
		for (int i = 0; i < limit; i++) {
			tupple = fileReader.getLine();
			log.info("Line " + i + tupple);
			RealtimeData temp = parseLine(tupple);
			list.add(temp);
		}

		fileReader.close();
		return list;
	}

	public RealtimeData parseLine(String line) throws IllegalArgumentException,
			ParseException {
		if (line.isEmpty() || (line == null))
			throw new IllegalArgumentException();

		/*
		 * The input line has lot of white spaces and hence we remove it by
		 * using regex, Pattern and Matcher.
		 */
		String regex = "[\\s]{2,}";
		String delim = ":";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			// We need this loop to track all the instances of the pattern.
		}

		String modifiedString = matcher.replaceAll(delim);
		RealtimeData object = new RealtimeData();
		StringTokenizer tokenizer = new StringTokenizer(modifiedString, delim);
		List<String> token = new ArrayList<String>();
		/* int i = 0; */// Use this for debugging.
		while (tokenizer.hasMoreElements()) {
			token.add((String) tokenizer.nextElement());
			/*
			 * System.out.println("Token: " + token.get(i)); i++;
			 */// Use this for debugging.
		}

		// 17
		System.out.println("Entire token list: " + token);
		if (token.size() == 17) {
			System.out.println("Parsing successfull ");
			// Lame code. Finding a way to make it smarter.
			object.setSymbol(token.get(0));
			object.setCompanyInfo(token.get(1));
			object.setDate(token.get(2));
			object.setPrice(Float.parseFloat(token.get(3)));
			object.setPercentChange(Float.parseFloat(token.get(4)));
			object.setYield(Float.parseFloat(token.get(5)));
			object.setPe(Float.parseFloat(token.get(6)));
			object.setPeg(Float.parseFloat(token.get(7)));
			object.setShortD(Float.parseFloat(token.get(8)));
			object.setRange(token.get(9));
			object.setAvg50D(Float.parseFloat(token.get(10)));
			object.setChng50D(Float.parseFloat(token.get(11)));
			object.setAvg200D(Float.parseFloat(token.get(12)));
			object.setChng200D(Float.parseFloat(token.get(13)));
			object.setTarget1Y(Float.parseFloat(token.get(14)));
			object.setVolume(Double.parseDouble(token.get(15)));
			object.setAvgVolume(Double.parseDouble(token.get(16)));
		}
		return object;

	}
}
