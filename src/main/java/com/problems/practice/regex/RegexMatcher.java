package com.problems.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.problems.Logger;

/**
 * Practice class to try out {@link java.util.regex.*} 
 * @author bbolla
 *
 */
public class RegexMatcher {
	
	private static final String codeRegex = "co.e";
	private static final Pattern codePattern = Pattern.compile(codeRegex);
	
	public static int countCode(String someString) {
		if(someString == null || someString.length() < 4) return 0; //edgeCases.
		
		Matcher matcher = codePattern.matcher(someString);
		
		
		int matches = 0;
		//Use the matcher. 
		while(matcher.find()) {
			Logger.debug(matcher.group());
			matches++;
		}
		
		return matches;
	}
	
	
	public static void main(String[] args) {
		Logger.debug(countCode("asdsadsabdkbsakDcodeasdakjsdnco$e"), " Should be 2");
	}

}
