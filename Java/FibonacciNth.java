import java.util.*;

public class FibonacciNth{

	public static void main(String [] args){
		
		int n;
		Scanner scan=new Scanner(System.in);
		System.out.println(" Enetr N");
		n=scan.nextInt();
		fibnocci(n);
	}//main
	
	public static void fibnocci(int n){
		
		int a=0;
		int b=1;
		int c=0;
		
		if(n==1){
		  System.out.println(" "+a);
		  System.exit(1);
		  }
		 
		 if(n==2){
		  System.out.println(" "+b);
		  System.exit(1);
		  }
			
			for(int i=3;i<=n;++i){
				
				//System.out.println("i= "+i);
				c=a+b;
				a=b;
				b=c;
				//System.out.println("c=\t "+c);
			
			}//for
			
			System.out.println("  " +c);
	} //fib


}//class