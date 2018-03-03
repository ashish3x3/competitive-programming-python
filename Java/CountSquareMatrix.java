import java.util.*;

public class CountSquareMatrix{
		
		//public static int max=Integer.MAX_VALUE;
		public static int I=0;
		public static int J=0;
		public static int [] arr=null;

		public static void main(String [] args){
				
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter T");
				int T=scan.nextInt();
				arr=new int[T];
				int t=0;
				int L=0,B=0;
				while(T>0){
				System.out.println("Enter L X B");
				L=scan.nextInt();
				B=scan.nextInt();
				arr[t++]=countSquare(L,B);
				T--;
				}
				
				for(int i=0;i<arr.length;++i){
					System.out.println(" "+ arr[i]);
				
				}
		
		} //main
		
		public static int countSquare(int l,int b){
				int c=0;
				int flag=0;
				int max=Integer.MAX_VALUE;
				//System.out.println("Math.min(a,b)"+min(l,b));
				for(int i=min(l,b);i>0;--i){
						//System.out.println("i =" +i);
						for(int j=i;j<=i;++j){
							c=count(i,j,l,b); 
							//System.out.println("reached above c<max");
							if(c<max && c!=0){
							//System.out.println("reached inside c<max");
								max=c;
								I=i;
								J=j;
								flag=1;
								break;
							
							} //if
							
						
						} //inner j
						
						if(flag!=0)
							break;
						
				} //outer for
				
			//System.out.println(" \n\nmax =" +max + "i = "+ I + "j = "+J);
			return max;
		
		} //count
		
		public static int min(int a,int b){
		
				return a<=b?a:b;
				
		}
		
		public static int count(int i,int j,int l,int b){
				
				int r=0,m=0;
				if((l%i !=0) || (b%j !=0))
					return 0;
				//System.out.println("Reached below return in count");					
				r+=(l/i);
				m=(b/j);
				//System.out.println("Reached below m=(b/j)");
				return m*r;
				
		
		
		}//count

}  //class