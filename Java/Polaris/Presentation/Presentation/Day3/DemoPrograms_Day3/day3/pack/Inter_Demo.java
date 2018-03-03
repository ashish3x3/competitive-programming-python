package com.demoprograms.day3.pack;

import  com.demoprograms.day3.trial_pack.*;
import java.io.*;				 



 class Savings  implements Account 
	{
		 static int  Balance=5000;
		 int Bank_Code=152;
	
	
	void display_BankCode()
		{
			
			System.out.println("BankCode\t\t"+Bank_Code);
		}

	void display_BankName(String Name)
		{
			System.out.println("BankName\t\t"+Name);
		}

		public void Deposit(int Deposit_amount)
		{
			System.out.println("*******DEPOSIT*******\n");
			System.out.println("Balance\t\t\t\n"+Balance);
			Balance=Balance+Deposit_amount;
			
			System.out.println("Amount Deposited..\t\n"+
Deposit_amount);
			System.out.println("Balance\t\t\t\n"+Balance);
		}
		
		public void Withdraw(int Withdraw_amount)
		{	System.out.println("*******WITHDRAW*******\n");
			System.out.println("Balance\t\t\t"+Balance);
			Balance=Balance-Withdraw_amount;
			System.out.println("Withdraw Amount\t\t"+Withdraw_amount);
			System.out.println("Balance\t\t\t"+Balance);
		}
		
		

		public  void Amount_Transcation(int Transcation_amount) { }
		public void Available_Balance(int Account_Number, String Password) { }

               

	}


 public class Inter_Demo 
	{
	public static void main(String args[])throws IOException
		{	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ano=0;
		String Pass=" ";
		Login_Detail la=new Login_Detail();
		System.out.println("enter account number\t");
		ano=Integer.parseInt(br.readLine());
                System.out.println("enter password\t");
		Pass=br.readLine();
		la.Login(ano,Pass);
		
}
}

class Login_Detail implements Ebank{

    int ch,wit,Dep;
	Savings a=new Savings();
public void Login(int AccNo, String Password){
	try{
	
	if(AccNo==1448)
	{
		
		System.out.println("1.BANK DETAILS\n2.DEPOSIT AMOUNT\n3.WITHDRAW\n4.EXIT\n");
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		do
		{		
		System.out.println("ENTER YOUR CHOICE\t");
		ch=Integer.parseInt(bf.readLine());
		switch(ch)
		{
		case 1:
		a.display_BankCode();
		a.display_BankName("ICICI");
		break;
		
                case 2:
                System.out.println("ENTER the Amount to be deposited\t");
		Dep=Integer.parseInt(bf.readLine());
		a.Deposit(Dep);
		break;

		case 3:
                System.out.println("ENTER the Amount to be withdrawn\t");
		wit=Integer.parseInt(bf.readLine());
		a.Withdraw(wit);
		break;
		
				
		
		case 4:
		System.exit(0);

		}}while(ch<=4);}
		

}catch(Exception e){}}
public void Balance()
{
	
}
public void Transaction(int amount, String Password)
{

}

}