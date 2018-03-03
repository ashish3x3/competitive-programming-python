package com.demoprograms.day4;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {

  public static void main(String[] args) {
	  
	  // Returns a fixed-size list backed by the specified array.
    List<Integer> list = Arrays.asList(3,8,10,6,2,4);
    
   NavigableSet<Integer> ns = new TreeSet<Integer>(list);
    System.out.println("Ascending order (default): " + ns);

    Iterator<Integer> descendingIterator = ns.descendingIterator();
   
    System.out.print("Descending order ");
    while (descendingIterator.hasNext()) {
      int m = descendingIterator.next();
      System.out.print(m+" ");
    }
 //     Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
    int greatest = ns.lower(3);
    System.out.println("\n Greater of the set = " + greatest);
//Returns the least element in this set strictly greater than the given element, or null if there is no such element.
    int smallest = ns.higher(6);
    System.out.println("Smallest of the set = " + smallest);
    NavigableSet<Integer> s=ns.headSet(3,true);
    System.out.println(s);
  }
}
