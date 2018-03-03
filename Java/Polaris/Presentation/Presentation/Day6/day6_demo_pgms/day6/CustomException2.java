package com.demoprograms.day6;

class NegativeAgeException extends  Exception {

	NegativeAgeException(String Message)
	{
		super(Message);

	}

}


class CustomException2 {
	static int getAge(){
		return -10;
	}
	public static void main(String[] args) 
	{
		int age = getAge();
		try
		{
			if (age < 0)

				throw new NegativeAgeException("Age cannot be negative");

			else
				System.out.println("Age entered is " + age);

		}
		catch(NegativeAgeException e)
		{
			System.out.println(e.getMessage());
		}

	} 
}



