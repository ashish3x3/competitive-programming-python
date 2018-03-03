 


  class C {
	
 	private  int p=90;
 	
 	B b=new B();
	
	void meth2()
	{
		
		System.out.println(b.x);
		 
	}
	
	  class B
	
	{
		 int x=25;
		
	 	void meth1()
		{
			System.out.println(p);
		}
	} 
  }
	 class InnerClassDemo extends C
	 {
    public static void main(String[] args){
	{
	
 
		
		
		C obj=new C();
		//B obj1=new C().new B();
		 B obj1=obj.new B();
	 
		obj1.meth1();
		obj.meth2();
	 
	}

}
  } 
