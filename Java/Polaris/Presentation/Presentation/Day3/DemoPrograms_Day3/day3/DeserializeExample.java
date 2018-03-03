package com.demoprograms.day3;

import java.io.*; 

public class DeserializeExample { 
public static void main(String[] args) { 
Student e = null; 
try { 
FileInputStream fileIn = new FileInputStream("Student.dat"); 
ObjectInputStream in = new ObjectInputStream(fileIn); 
e = (Student) in.readObject(); 
in.close(); 
fileIn.close(); 
} catch (IOException i) { 
i.printStackTrace(); 
  
} catch (ClassNotFoundException c) { 
System.out.println("Student class not found"); 
c.printStackTrace(); 
 
} 
System.out.println("Deserialized Student..."); 
System.out.println("Name: " + e.name); 
System.out.println("Address: " + e.address); 
System.out.println("Roll no: " + e.rollno); 
System.out.println("Room No: " + e.roomNo); 
} 
}