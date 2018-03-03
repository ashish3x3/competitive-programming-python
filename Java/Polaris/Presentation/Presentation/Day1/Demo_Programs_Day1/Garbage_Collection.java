
public class Garbage_Collection {
	
	int a;
	int b;
	
public	void setData(int c,int d)
	{
		a=c;
		b=d;
	}
	
	void showdata()
	{
		System.out.println( a+" "+b);
	}
	 
	protected void finalize() 


	{
		// Clean up code
		 
	}
   public static void main(String args[])
   {
	   Garbage_Collection obj=new Garbage_Collection();
	   obj.setData(3, 4);
	   obj.showdata();
	   obj=null;
	  Runtime.getRuntime().gc();
 
   }
}
