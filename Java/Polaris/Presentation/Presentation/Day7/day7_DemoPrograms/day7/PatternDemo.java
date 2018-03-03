package com.demoprograms.day7;

import java.util.regex.Pattern;

public class PatternDemo {

	 	public static void main(String[] args) {
		String text    =  "This is the text to be searched " +
	        "for occurrences of is the pattern.";

	String pattern = ".*is.*";

	boolean matches = Pattern.matches(pattern, text);

	System.out.println("matches = " + matches);

	}

}
