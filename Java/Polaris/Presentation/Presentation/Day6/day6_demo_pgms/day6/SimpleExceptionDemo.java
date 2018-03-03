package com.demoprograms.day6;
 
class SimpleExceptionDemo
{
public static void main(String args[]) 
{
int d,a;
try
{
d=0;
a=42/d;
}
catch(ArithmeticException e)
{
//System.out.println("division by zero");
System.out.println(e.toString());
//e.printStackTrace();
	 
}
}
}
