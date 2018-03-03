import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DayaTree {

    public static void main(String[] args) {
    	Scanner scan=new Scanner(System.in);
        
        
         int T,N,c=0;
        
         T=scan.nextInt();
        while(T-- >0){
            N=scan.nextInt();

            for(int i=1;i<=N;++i){
            	if(binRep(i))
            		c++;
            }
            System.out.println(""+c);
        
    }
}//main

public static boolean binRep(int n){

	int c=BitCount(n);
	if(c%3==0)
		return true;

	return false;
	/*String bin=Integer.toBinaryString(n);
	int c=0;

	for(int i=0;i<bin.length();++i){
		if(bin.charAt(i)=='1')
			c++;
	}
	if(c%3==0)
		return true;

	return false;*/
}


			public static int  BitCount( int u)
		{
     		 int uCount;

     		uCount = u - ((u >> 1) & 033333333333) - ((u >> 2) & 011111111111);
     		return ((uCount + (uCount >> 3)) & 030707070707) % 63;
		}
}