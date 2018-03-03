package com.demoprograms.day4;
import java.util.*;
public class TestEmp {

	public static void main(String args[])
	{
		Emp e1=new Emp(24);
		Emp e2=new Emp(25);
		Emp e3=new Emp(26);
		
		 HashSet<Emp> hs=new HashSet<Emp>();
		

			Emp e4=new Emp(24);
			Emp e5=new Emp(25);
		 
		 hs.add(e1);
		 hs.add(e2);
		 hs.add(e3);
		 
	 
		 System.out.println(hs.size());
	  	 System.out.println(hs.contains(e4));
		 System.out.println(hs.remove(e5));
		 System.out.println(hs.size()); 
		 
		 
	 
	}
	
}
