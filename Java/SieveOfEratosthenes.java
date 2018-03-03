import java.lang.*;
import java.util.*;
import java.io.*;


public class SieveOfEratosthenes {

		public static boolean [] arr=null;
		
		public static void main(String [] args) throws IOException{
				
				String fileName="input_To_SieveofEratosthenes.txt" ;
				
				Scanner scan=new Scanner(new FileReader(fileName));
				int N=0;
				//if(scan.hasNextLine())                       //no need
					 N=Integer.parseInt(scan.nextLine());    //there must not be  new line in text file in between
					 
					int M=1;
					boolean res;
					String str=null;
					
				while(scan.hasNextLine()){
					 //str=scan.nextLine();
					 
					 M =Integer.parseInt(scan.nextLine());
					 
					 if(M==0)
						break;
					 
					 
				
					//res=checkPrime(N,M);
					//System.out.println("\n num = " +M  +" \nisPrime =" +res);
					
				}
		
		} //main
		
		public static boolean checkPrime(int n,int m){
		
				preprocess(n);
				printList();
				if(m<=n)
					return arr[m];
				
				for(int i=2;i<Math.sqrt(m);i++){
					
					if(m%i==0)
						return false;
					
				}
				return true;
				
		
		} // checkprime
		
		public static void printList(){
				
				for(int i=0;i<arr.length;++i){
						
						if(arr[i]==true)
							System.out.print(" "+i);
						
				}
				
		}  //printList
		
		public static void preprocess(int n){
		
				arr=new boolean[n+1];
				arr[0]=false;
				arr[1]=false;
				for(int i=2;i<arr.length;++i)
					arr[i]=true;
				
				for(int i=2;i<Math.sqrt(arr.length);++i){
					
					if(arr[i]==true){
					
						for(int j=2;i*j<=n;++j){
							arr[i*j]=false;
							
						} //if
						
					}//ineer for
				
				} //for outer
		
		} //preprocess

} //class