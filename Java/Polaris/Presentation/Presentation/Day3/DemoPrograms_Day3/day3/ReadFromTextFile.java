package com.demoprograms.day3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class ReadFromTextFile {

    public static void main(String args[]){

        try {
        
           
        	BufferedReader in = new BufferedReader(new FileReader("wor.txt"));
            PrintWriter out    = new PrintWriter("ReadWriteTextFi.txt");

            out.println("+---------- Testing output to a file ----------+");
            out.println();
             
            String inLine = null;
          
           while ((inLine =in.readLine())!= null) {
                out.println(inLine);
            }

            out.println();
            out.println("+---------- Testing output to a file ----------+");

            out.close();
            in.close();
            System.out.println("Completed");
            

        } catch (IOException e) {

            System.out.println("IOException:");
            e.printStackTrace();

        }

    }
}

 

