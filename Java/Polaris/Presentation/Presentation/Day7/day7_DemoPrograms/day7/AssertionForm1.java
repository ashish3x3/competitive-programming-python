package com.demoprograms.day7;

import java.util.Scanner;
import java.io.IOException;

public class AssertionForm1 {
   public static void main(String argv[]) throws IOException {
      Scanner reader = new Scanner(System.in);      
      System.out.print("Enter your age: ");
      int age = reader.nextInt();
     
    assert age>=18;
      
      System.out.println("You are eligible to vote");
   }
}
