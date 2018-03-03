package com.demoprograms.day4;
import java.util.*;
public class SetDemo {

	public static void main(String[] args) {
		 
        HashSet<String>  s1 = new HashSet<String>();
      
		s1.add("Beginner");
		s1.add("Java"); 
		s1.add("Java");
		s1.add("tutorial");
 		
		System.out.println();
		
		System.out.print("Elements as a set" + s1);
System.out.println("\n s1.contains Java :" + s1.contains("Java"));

 
TreeSet<String>  t1=new TreeSet<String>(s1);

System.out.println("t1.equals s1 : "+t1.equals(s1));

Iterator<String>  itr=t1.iterator();

System.out.println("Iteration Type 1 :");
  while (itr.hasNext())
  {
   String e=(String)itr.next();
     System.out.println(e);
  }
  System.out.println("Iteration Type 2 :");
  for ( Object o: s1)
	  System.out.println(o);
  
  Object[] a=s1.toArray();
  System.out.println("After converting to Array :");
    for (int i=0;i<a.length;i++)
    	System.out.println(a[i]);
    
    System.out.println("checking for Identity");
    System.out.println(s1.equals(t1));
	}
	
	
}


