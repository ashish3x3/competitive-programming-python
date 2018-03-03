package com.demoprograms.day7;

import java.util.Scanner;
import java.io.IOException;

public class AssertionForm2 {
   public static void main(String argv[]) throws IOException {
      Scanner reader = new Scanner(System.in);      
      System.out.print("Enter your age: ");
      int age = reader.nextInt();
     
    assert age>=18:"You are too young to vote";
      
      System.out.println("You are eligible to vote");
   }
}
