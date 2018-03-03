					
							
class Account
	{
		int Balance, Initial_Amount=5000;
		
       
		public int Calculate( int amount)
		{
		Balance=Initial_Amount-amount;
                System.out.println(Balance);
		return Balance;
		}

		
}

class Method_Override
{
public static void main(String args[])
{



	
	Deposit d1=new Deposit();
             
	System.out.println("\t\tPOLYMORPHISM\t\t\n");
        System.out.println(d1.Calculate(500));
	
	
	
}
}
							//OverRiding
class Deposit extends Account
{
	
		 public   int Calculate(int amount)
		{
                 super.Calculate(amount);
                 
		  return 0;
		}
}