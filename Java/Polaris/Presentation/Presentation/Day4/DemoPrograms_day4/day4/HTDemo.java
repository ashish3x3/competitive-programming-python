package com.demoprograms.day4;

import java.util.*;

class HTDemo { 
public static void main(String args[]) { 
Hashtable<String,Double> balance = new Hashtable<String,Double>(); 
Enumeration<String> names; 
String str; 
 
balance.put("John Doe", new Double(3434.34)); 
balance.put("Tom Smith", new Double(123.22)); 
balance.put("Jane Baker", new Double(1378.00)); 
balance.put("Todsd Hall", new Double(99.22)); 
balance.put("Ralph Smith", new Double(-19.08)); 
  
// Show all balances in hash table. 
names = balance.keys();
while(names.hasMoreElements()) { 
str = (String) names.nextElement(); 
System.out.println(str + ": " + balance.get(str)); 
} 
 
} 
} 
