package com.demoprograms.day3;
 
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;


public class FileWriterDemo {
  public static void main(String[] args) throws IOException {
    try {
          FileWriter fw = new FileWriter("out.txt",true);  
    BufferedWriter bw = new BufferedWriter(fw);  
    bw.write(" much code");  
    bw.close();  
    } catch(EOFException e) {
      System.err.println(e);
    }

  }
}

