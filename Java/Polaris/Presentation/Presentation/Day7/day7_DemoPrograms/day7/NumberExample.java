package com.demoprograms.day7;

import java.lang.*;
import java.text.*;
import java.util.*;

public class NumberExample {

    public static void main(String args[]) throws NumberFormatException {

      // The number to format
      double number = 12345.678;

      // Get formatters for default, Spanish, and Japanese locales
      NumberFormat defaultFormat = NumberFormat.getInstance();
      NumberFormat spanishFormat = NumberFormat.getInstance(new Locale("fr_CA"));
      NumberFormat germanFormat = NumberFormat.getInstance(Locale.GERMANY);

     
      System.out.println("The number formatted for the default locale; " +
                         defaultFormat.format(number));
      System.out.println("The number formatted for the French locale; " +
                         spanishFormat.format(number));
      System.out.println("The number formatted for the German locale; " +
                         germanFormat.format(number));
    }
}