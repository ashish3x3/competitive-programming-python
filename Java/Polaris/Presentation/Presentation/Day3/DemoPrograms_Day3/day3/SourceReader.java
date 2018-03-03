package com.demoprograms.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SourceReader {
  public static void main(String[] arguments) {
    try {
      FileReader file = new FileReader("wor.txt");
      BufferedReader buff = new BufferedReader(file);
      boolean eof = false;
      while (eof!=true) {
        String line = buff.readLine();
        if (line == null)
          eof = true;
        else
          System.out.println(line);
      }
      buff.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
