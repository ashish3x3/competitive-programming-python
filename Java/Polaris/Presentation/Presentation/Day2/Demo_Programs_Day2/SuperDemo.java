
  class Super1 {
  
	  int a,b;
  
  Super1(int a,int b)
  
  {
	this.a=a;
	this.b=b;
  }
}

class sub extends Super1
{
	int c,d;
	 
	
	sub(int x,int y,int c,int d)
	{
		
		super( x, y);
		 
		 this.c=c;
		 this.d=d;
		
		
		
	}
	
	int add()
	{
		
		return a+b+c+d;
	}
   
}

class SuperDemo
{
	public static void main(String args[])
	{
		
		sub obj=new sub(2,3,4,5);
		System.out.println(obj.add());
		
	}
}
