//inheritance
class Account
	{

	int Account_Number=152;
       
	   int Balance=5000;
       

	void display_AccountNumber()
		{
			
			System.out.println("Account Number\t"
+Account_Number);
		}

	void display_Name(String Name)
		{
			System.out.println("Name\t"+Name);
		}

	}




class Deposit extends Account
	{
	 

		void calculate_deposit(int Amount)
		{
			Balance=Balance+Amount;
			System.out.println(Balance);
		}
		
		
		
		

	}
class withdraw extends Deposit
	{
		void withdraw(int Amount)
		{
			Balance=Balance-Amount;
			System.out.println(Balance);
		}
	}


class Inheritance
{
public static void main(String args[])
{


        //Deposit d=new Deposit();
	withdraw w=new withdraw();
       	w.display_AccountNumber();
	w.display_Name("Laser");	
	w.calculate_deposit(500);
	w.withdraw(500);
}
}