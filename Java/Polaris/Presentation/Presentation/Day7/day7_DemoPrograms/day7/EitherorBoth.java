package com.demoprograms.day7;

import java.util.*;
import java.util.regex.*;
//import java.util.regex.Pattern;


public class EitherorBoth {

	//if this text line contains either the word "Joe" or the word "Jim" or both. 

	
	public static void main(String args[])
	{
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter a String");
		String s=scan.nextLine();
		 
		Pattern mypattern=Pattern.compile(".*(jim|joe).*", Pattern.CASE_INSENSITIVE);
		Matcher matcher =mypattern.matcher(s);
		System.out.println(matcher.matches());
	}
}
