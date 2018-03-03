package com.demoprograms.day6;

class NegativeAgeException1 extends    RuntimeException{


	public String toString(){
		return "Age cannot be negative";
	}


}


public class CustomException1{
	static int getAge(){
		return -10;
	}
	public static  void main(String[] args) 
	{
		int age = getAge();
		// try
		//  {
		if (age < 0)

			throw new NegativeAgeException1();
		else
			System.out.println("Age entered is " + age);

	}
	/*  catch(NegativeAgeException1 e)
   {
  	 System.out.println(e);
   }
	 */
}  

//}





