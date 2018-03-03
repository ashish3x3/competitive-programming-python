package com.demoprograms.day3;
import java.io.*;
public class TestDataInput {
	public static void main(String args[]) throws IOException
	
	{
		FileInputStream fs=new FileInputStream("Text.txt");
		DataInputStream ds=new DataInputStream(fs);
		int i=ds.readInt();
		System.out.println(i);
		double d=ds.readDouble();
		System.out.println(d);
		double d1=ds.readDouble();
		System.out.println(d1);
		//double d2=ds.readDouble();
		//System.out.println(d2);
		ds.close();
	}

}
