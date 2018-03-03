package com.demoprograms.day6;


import java.io.*;

class CustomException3{
	static int flag=0;
	public static void main(String args[])throws IOException {
	      
		do
		{
        String Pass="";
	System.out.print("Enter Password");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Pass=br.readLine();
	Check_Password ch =new Check_Password();
	flag=ch.isCorrectPassword(Pass);
		} while (flag!=1);
	}
}


class Password_Exception extends Exception{
	
	
		public String toString(){
			return "Enter Correct Password";
		}	 
	
}

 

class Check_Password {
	public int isCorrectPassword(String Password) 
	{
		int i=0;
		try
             {
			if(Password.equals("polad"))
			{
			   i=1;
				System.out.println("Welcome\t");
				}
		else
		{
		 throw new Password_Exception();
			}
		}
	
		catch(Password_Exception e)
		{
			System.out.println(e);
			 
			}
		return i;
		}	
		
		
  
		
}		


