package com.demoprograms.day7;

public class StringMatcherTest {
	
	
	public static void main(String args[])
	{
		
		StringMatcher m=new StringMatcher();
		System.out.println(m.isTrue("true"));
		System.out.println(m.isNoNumberAtBeginning("w842324"));
		System.out.println(m.containsTrue("aatrue"));
		System.out.print(m.isIntersection("howarbyou"));
	}
}
