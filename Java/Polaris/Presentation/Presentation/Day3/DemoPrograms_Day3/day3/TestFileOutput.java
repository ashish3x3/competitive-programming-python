package com.demoprograms.day3;
import java.io.*;

public class TestFileOutput
{
public static void main(String args[])
{
byte b[]=new byte[100];
 

try
{
System.in.read(b);
FileOutputStream fout=new FileOutputStream("text.txt");
fout.write(b);
}
catch(IOException e)
{
e.printStackTrace();

}
  
}
}
