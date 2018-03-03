package com.demoprograms.day6;

public class MultipleExceptions{  
	public static void main(String Args[]) {  

		int[] array = new int[3];  

		try{              

			for(int i=0;i<3;++i){  
				array[i] = i;  
			} 
			System.out.println(array[8]);
			array[0] = 2/0;  
		}
		catch(ArithmeticException e){  
			System.out.println("Cannot Divide by Zero!");  
		}
		catch(ArrayIndexOutOfBoundsException e){  
			System.out.println("Oops, we went to far, better go back to 0!");  
		}
		 catch(Exception e)
		 {
			 
			 System.out.println(e);
		 }

	finally{  
			System.out.println("Will be called always");  

		  }  

	}  

} 

