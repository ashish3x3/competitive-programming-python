
							//POlymorphism
							//Overloading
class Account
	{
		 
               int Initial_Amount=5000;
		
		
             int Calculate(int amount)
		{
                 
		int Balance=Initial_Amount-amount;
		return Balance;
		}


	    int Calculate(float amount)
		{
                       
	       int   int_Balance=Initial_Amount-(int)amount;
               return  int_Balance;
		}	

	  double Calculate(double amount)
		{
		double Double_Balance=Initial_Amount-amount;
		return Double_Balance;
                
		}
}


class Method_Overloading
{
public static void main(String args[])
{



	Account d=new Account();
	
	System.out.println("\t\tPOLYMORPHISM\t\t\n");
	System.out.println("Balance\t"+d.Calculate(500.90f));

	/*System.out.println("Balance\t"+d.Calculate(0));
	System.out.println("Balance\t"+d.Calculate(500.90f));
	System.out.println("Balance\t"+d.Calculate(1500.0009d));*/
}
}
							
