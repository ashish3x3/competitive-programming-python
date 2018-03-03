//Abstract class
package com.demoprograms.day3;
import java.io.*;

abstract class Account
{
	int Account_Number=111;
	int Bank_Code=152;
	double  savBal=5000;
	double  curBal=3000;
	int amount;


	void display_BankCode()
	{

		System.out.println("BankCode\t\t"+Bank_Code);
	}

	void display_BankName(String Name)
	{
		System.out.println("BankName\t\t"+Name);
	}
	abstract  void withdraw(int amount);
	abstract void printReport();

}

class Savings extends Account
{



	void withdraw(int amt)


	{       
		if (savBal>1000)
		{		
			savBal=savBal-amt;
			System.out.println("balance after withdrawal\t\t\t"+savBal); 
		}
		else
			System.out.println("Insufficient Balance");



	}

	void printReport() { }           
}

class Current extends Account
{




	void withdraw(int amt)


	{       

		curBal=curBal-amt;
		System.out.println("balance after withdrawal\t\t\t"+curBal); 


	}


	void printReport() { }        
}



class AbstractDemo
{
	public static void main(String args[])throws IOException	
	{
		int ch;
	//	Savings s=new Savings();
		Current c=new Current();

     Account s=new Savings();;
    


		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		do
		{		
			System.out.println("1.Bank Details\n2.Withdraw-Savings\n3.Withdraw-Current\n4.Account Number\n5.Exit\n");
			ch=Integer.parseInt(bf.readLine());
			switch(ch)
			{
			case 1:
				s.display_BankCode();
				s.display_BankName("ICICI");
				break;
			case 2:
				s.withdraw(500);
				break;
			case 3:
				c.withdraw(300);
				break;
			case 4:
				System.out.println(s.Account_Number);
				break;
			case 5:
				System.exit(0);

			}}while(ch<=5);
	}
}

