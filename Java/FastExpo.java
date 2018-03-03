import java.util.*;


public class FastExpo{
		
		public static void main(String [] args){
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter a....A^b");
			long a=scan.nextInt();
			
			System.out.println("Enter b... A^b");
			long b=scan.nextInt();
			
			System.out.println("Enter m... %m");
			long m=scan.nextInt();
			
			long res= fastExpo(a,b,m);
			System.out.println(" Res = " +res);
		
		
		} //main
		
		public static long fastExpo(long a,long b,long m){
		
			long x=a;
			long y=(b%2!=0)?a:1;
			b=b/2;
			while(b>0){
				x=(((x%m)*(x%m))%m);
				if(b%2!=0)
					y=(y==1)?(x%m):(((y%m)*(x%m))%m);
					
			b=b/2;
			
			
			} //while
			
			return y;
		
		}  //fastExpo
	
	/*
		
H:\java>javac FastExpo.java

H:\java>java FastExpo
Enter a....A^b
2
Enter b... A^b
10
Enter m... %m
1000000007
 Res = 1024

H:\java>java FastExpo
Enter a....A^b
20
Enter b... A^b
100
Enter m... %m
1000000007
 Res = 864605215

H:\java>java FastExpo
Enter a....A^b
20
Enter b... A^b
10
Enter m... %m
1000000007
 Res = 999928327

H:\java>java FastExpo
Enter a....A^b
200
Enter b... A^b
10
Enter m... %m
1000000007
 Res = 5017600
	
	*/



} //class