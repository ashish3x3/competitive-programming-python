package com.demoprograms.day7;

public class Demo1 {
	public static final String EXAMPLE_TEST = "This    is an Example";
		

	public static void main(String[] args) {
		System.out.println(EXAMPLE_TEST.matches(".*"));
		String[] splitString = (EXAMPLE_TEST.split("\\s+"));
		System.out.println(splitString.length); 
		for (String strin : splitString) {
			System.out.println(strin);
		}
		// Replace all whitespace with tabs
		System.out.println(EXAMPLE_TEST.replaceAll("\\s+"," "));
	}
}

