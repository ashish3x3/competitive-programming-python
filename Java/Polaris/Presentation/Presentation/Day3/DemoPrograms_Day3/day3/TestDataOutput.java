package com.demoprograms.day3;
import java.io.*;
public class TestDataOutput
{
public static void main(String arggs[])
{
try
{
DataOutputStream dos=new DataOutputStream(new FileOutputStream("text.txt"));
dos.writeInt(25);
dos.writeDouble(45.80);
dos.writeDouble(34.43);
dos.close();
}
catch(IOException ioe)
{
System.out.println("Exception;"+ioe);
}
}
}

