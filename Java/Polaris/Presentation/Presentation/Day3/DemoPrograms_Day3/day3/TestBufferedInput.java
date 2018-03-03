 
package com.demoprograms.day3;

import java.io.*;
public class TestBufferedInput
{
public static void main(String args[])
{
byte buffer[]=new byte[500];

try
{
BufferedInputStream bis=new BufferedInputStream(new FileInputStream("wor.txt"));
 
bis.read(buffer);


}
catch(Exception e)
{
e.printStackTrace();
}
String s=new String(buffer);
System.out.println(s);
}
}

