package com.demoprograms.day7;

public class Phone_Check {
//A phone number in this example consists  of 7 numbers in a row or  3 numbers a 
	//(white)space or a dash and then 4 numbers. 


	
	
	
	
	public static void main(String args[])
	{
		
		String s="977-5678";
				
		System.out.println(s.matches("[0-9]{7}|[0-9]{3}[\\s,-][0-9]{4}"));
	}
}
