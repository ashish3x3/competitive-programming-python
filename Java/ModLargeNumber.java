import java.util.*;


public class ModLargeNumber{
		
		public static void main(String [] args){
			
			Scanner scan=new Scanner(System.in);
			String str=null;
			System.out.println("Enter a....A%b");
				str=scan.next();
			
			System.out.println("Enter b... A%b");
			long b=scan.nextInt();
			
			
			
			long res= largeMod(str,b);
			System.out.println(" Res = " +res);
		
		
		} //main
		
		public static long largeMod( String str,long b){
			
			int [] a=new int[str.length()];
			//System.out.println(" "+str.length());
			
			for(int i=0;i<a.length;++i){
				a[i]=(str.charAt(i)-'0');
			}
			
			for(int i=0;i<a.length;++i){
				System.out.print(" "+a[i]);
			}
			long res=0;
			for(int i=0;i<a.length;++i){
				
				  res=(( ( ( (  (res%b)*(10%b)  ) %b ) %b  )+ ( a[i] %b ) ) %b );   //both give right result
				  //res=(res*10+a[i])%b;           //give right result
			
			} //for
			 return res;
		
		}  //largeMod
		
		/*
			E.g. 12345 % 100:
ans = 0
ans = (o*10 + 1)%100
ans = (1*10 + 2)%100
ans = (12*10 + 3)%100
ans = (23*10 + 4)%100
ans = (34*10 + 5)%100
ans = 45.

H:\java>java ModLargeNumber
Enter a....A%b
12345
Enter b... A%b
100
 1 2 3 4 5 Res = 45


		*/
		
 }  //class		