import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

			//public static int M=1000000007;
			public static long [] arr=null;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
		arr=new long[T];
        long n=0;
		int k=0;
        int low=0,high=1000000;
		//System.out.println(""+high);
		
        while(T>0){
            n=scan.nextLong();
			//System.out.println(""+n);
             
            int mid=0;
          // BigInteger l=new BigInteger("0");
		  // BigInteger h=new BigInteger("0");
		  long l=0,h=1000;
            while(low<=high){
				//System.out.println(""+low +"  " + high +  "  " +mid);
                
                mid=((high+low)/2);
				//System.out.println(""+mid);
                l=((long)mid*(mid+1)*(mid+mid+1))/6; 
				//System.out.println(" l= "+l + " n= "+n);
                h=((long)(mid+1)*(mid+2)*((2*(mid+1))+1))/6;
				//System.out.println(" h = "+h);
                
                if(l<=n && h>n){
                   //System.out.println("mid"+mid);
					arr[(int)k++]=mid;				   
                    break;
                    
                } //if
                
                if(n>l)
                    low=mid+1;
                
                if(n<=l)
                    high=mid-1;
                
                
                
            } //while
            
            T--;
            
            
        }//while
		
		for(int i=0;i<arr.length;++i){
					System.out.println(""+ arr[i]);
				
				}
    }
}