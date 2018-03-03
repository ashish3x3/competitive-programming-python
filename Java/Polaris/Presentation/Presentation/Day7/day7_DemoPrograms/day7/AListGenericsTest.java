package com.demoprograms.day7;
class AListGenericsTest
{

public static void main(String args[])
{

AListGenerics<Integer> intList=new AListGenerics<Integer>();
intList.add(1);
intList.add(2);

AListGenerics<String> stringList=new AListGenerics<String>();

stringList.add("Hello");

System.out.println(intList.getElement(0));
System.out.println(stringList.getElement(0));
}

}
