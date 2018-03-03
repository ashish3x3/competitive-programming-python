package com.demoprograms.day7;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Number_in_Check {
	
	public static void main(String args[])
	{
		Pattern pattern=Pattern.compile("[0-9]{3}");
		 

		Matcher matcher=pattern.matcher("56");
		System.out.println(matcher.matches());
	}

}
