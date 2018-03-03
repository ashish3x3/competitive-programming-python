package com.demoprograms.day7;

	class parent
	{

	int disp()
	{

	System.out.println("inside parent");
	return 0;
	}
	}
	@Deprecated
	class chil extends parent
	{

		
		@Override
	int disp()
	{

	System.out.println("inside child");
	return 0;

	}



	@Deprecated

	void add()
	{

	}

	}

	class PredefinedAnnotationDemo
	{
	public static void main(String args[])
	{

 	chil c=new chil();
	c.add();
	c.disp();
	}
	} 


