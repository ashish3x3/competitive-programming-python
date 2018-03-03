package com.demoprograms.day4;

import java.util.*;

public class Comparator_ArrayList  {
	 
	 public static void main(String args[])
	 {
		 
		 List<String> a=new ArrayList<String>();
		 a.add("Apple");
		 a.add("bat");
		 a.add("antelope");
		 a.add("grapes");
		 a.add("Yellow");
		 System.out.println("Before sorting");
		 System.out.println(a);
		 System.out.println("Collections.sort() sorting");
		 Collections.sort(a);
		 System.out.println(a);
		 System.out.println("After sorting with comparator");
		 Collections.sort(a,new Caseinsensitivecomparator());
		 
		 System.out.println(a);
	 }
	 
	 
	 }

class Caseinsensitivecomparator implements  Comparator<String>
{
	 
	 public int compare(String o1, String o2){ 
	  
		String s1= o1;
		String s2= o2;
 		return s1.compareToIgnoreCase(s2);
		 
	 }

}
	 
		 
	 
	
	  
	

	 

