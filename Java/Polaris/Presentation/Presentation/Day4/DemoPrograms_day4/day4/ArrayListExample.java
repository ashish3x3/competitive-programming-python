package com.demoprograms.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ArrayListExample {
	 
	public static void main(String[] args) {
		
		List<Integer> arraylistA = new ArrayList<Integer>();
		ArrayList<String> arraylistB = new ArrayList<String>();
		 		 
		
		for (int i = 0; i < 5; i++) {
			arraylistA.add(new Integer(i));
			
		}
		  
		arraylistB.add("beginner");
		arraylistB.add("java");
		arraylistB.add("tutorial");
		
		arraylistB.add(".");
		arraylistB.add(3,"com");
		arraylistB.add("java");
		arraylistB.add("site");
		
		System.out.println("BB"+arraylistB);
		
		Iterator<Integer>  i1 = arraylistA.iterator();
		System.out.print("ArrayList arraylistA --> ");
		while (i1.hasNext()) {
			System.out.print(i1.next() + "  ");
		}
		System.out.println();
		System.out.print("ArrayList arraylistA --> ");
		for (int j = 0; j < arraylistA.size(); j++) {
			System.out.print(arraylistA.get(j) + "  ");
		}
		System.out.println();
		ListIterator<String> i2 = arraylistB.listIterator();
		System.out.print("ArrayList arraylistB--> ");
		while (i2.hasNext()) {
			System.out.print(i2.next() + "  ");
		}
		System.out.println();
		System.out.print("Reverse List ");
		 
		while (i2.hasPrevious())
			System.out.print(i2.previous()+" ");
		
		//        Searching for an element in the ArrayList
		int index = arraylistB.indexOf("java");
		System.out.println("'java' was found at : " + index);
		int lastIndex = arraylistB.lastIndexOf("java");
		System.out.println("'java' was found at : " + lastIndex
				+ " from the last");
		System.out.println();
			System.out.println();
		//        Sort an ArrayList
		System.out.print("Sorted ArrayList arraylistA --> ");
		Collections.sort(arraylistA);
		System.out.print(arraylistA);
		System.out.println();
		  //  Reversing an ArrayList
		System.out.print("Reversed ArrayList arraylistA --> ");
		Collections.reverse(arraylistA);
		System.out.println(arraylistA);
		System.out.println();
		//		Checking emptyness of an ArrayList
		System.out.println("Is arraylistA empty?   "
				+ arraylistA.isEmpty());
		System.out.println();
		//        Checking for Equality of ArrayLists
		ArrayList<Integer> arraylistC = new ArrayList<Integer>(arraylistA);
		System.out.println("arraylistA.equals(arraylistC)? "
				+ arraylistA.equals(arraylistC));
		System.out.println();
		//      Shuffling the elements of an ArrayList in Random Order
		Collections.shuffle(arraylistA);
		System.out.print("ArrayList arraylistA after shuffling its elements--> ");
		i1 = arraylistA.iterator();
		while (i1.hasNext()) {
			System.out.print(i1.next() + " , ");
		}
		System.out.println();
		
		
		
		//        Clearing ArrayList Elements
		arraylistA.clear();
		System.out.println("arraylistA after clearing  : " + arraylistA);
		System.out.println();
		Collections.fill(arraylistB,"no");
       System.out.println(arraylistB);	
       List<String> sublist=arraylistB.subList(4, 6);
       System.out.println(sublist);
       
       int a[]={11,12,13,14,15};
       // converting Arrays into ArrayList
       List<int[]> arrlist= Arrays.asList(a);
        
	}
}

 