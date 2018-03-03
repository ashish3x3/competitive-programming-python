package com.demoprograms.day7;

public class StringMatcher {
	// Returns true if the string matches exactly "true"
	public boolean isTrue(String s){
		return s.matches("true");
	}
	// Returns true if the string matches exactly "true" or "True"
	public boolean isTrueVersion2(String s){
		return s.matches("[tT]rue");
	}
	
	// Returns true if the string matches exactly "true" or "True"
	// or "yes" or "Yes"
	public boolean isTrueOrYes(String s){
		return s.matches("[tT]rue|[yY]es");
	}
	
	// Returns true if the string contains exactly "true"
	public boolean containsTrue(String s){
		return s.matches(".*true.*");
	}
	

	// Returns true if the string contains of three letters
	public boolean isThreeLetters(String s){
		return s.matches("[a-zA-Z]{3}");
		// Simpler from for
//		return s.matches("[a-Z][a-Z][a-Z]");
	}
	


	// Must match at the beg of line , and if the character is not a digit return true
	public boolean isNoNumberAtBeginning(String s){
		return s.matches("^[^\\d].*");
	}
	// Returns true if the string contains a arbitrary number of characters except b
	public boolean isIntersection(String s){
		return s.matches("([\\w&&[^b]])*");
	}
	
	
}

