import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
https://www.hackerrank.com/challenges/picking-cards

There are N cards on the table and each has a number between 0 and N. Let us denote the number on the ith card by ci. You want to pick up all the cards. The ith card can be picked up only if at least ci cards have been picked up before it. (As an example, if a card has a value of 3 on it, you can't pick that card up unless you've already picked up 3 cards previously) In how many ways can all the cards be picked up?

Input Format
The first line contains the number of test cases T. T test cases follow. Each case contains an integer N on the first line, followed by integers c1,..ci,...,cN on the second line.

Output Format
Output T lines one corresponding to each test case containing the required answer for the corresponding test case. As the answers can be very big, output them modulo 1000000007.

Constraints:
1 <= T <= 10
1 <= N <= 50000
0 <= ci <= N

Sample Input:

3  
3  
0 0 0  
3  
0 0 1  
3  
0 3 3

Sample Output:

6  
4  
0

Sample Explanations:

For the first case, the cards can be picked in any order, so there are 3! = 6 ways.
For the second case, the cards can be picked in 4 ways: {1,2,3}, {2,1,3}, {1,3,2}, {2,3,1}. 
For the third case, no cards can be picked up after the first one, so there are 0 ways to pick up all cards.*/

/*
H:\Computer Science\Java\MyHackerRank\combina
1
3
0 0 0
000
min =1min =22for val 02for val 12for val 26
*/


import java.io.*;
import java.util.*;

public class PickCards {
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){
            int N = Integer.parseInt(br.readLine());
            int[] ar = strToInt(br.readLine().split(" "));
            printArray(ar);
            Arrays.sort(ar);
            long ways = 1L;
            int cardCount = 0;
            for(int min = 0; cardCount < N; cardCount++){
                int max = binarySearch(ar, cardCount, min, N);
                System.out.print(""+max + "for val "+cardCount);
                System.out.print("");

                if (cardCount > max){
                    ways = 0;
                    break;
                }
                ways = (ways * ((long)(max - cardCount + 1)))%MOD;
                min = max;
            }
            sb.append(ways + "\n");                
        }
        System.out.print(sb);
    }
    
    private static void printArray(int[] ar){

        for(int i=0;i<ar.length;++i){
            System.out.print(""+ar[i]);
        }
        System.out.println("");
        /*StringBuffer sb = new StringBuffer();
        for(int v : ar){
            sb.append(v + " ");
        }
        System.out.println(sb);*/
    }
    
    private static int binarySearch(int[] ar, int val, int min, int max){
        /*Every time this will return the last index of matchedor if ot matched index, since the array is sorted*/

        for(int length = max - min; length > 1; length = max - min){
            int mid = min + length/2;
            if (val < ar[mid]){
                max = mid;
                System.out.print("max ="+max);
            } else {
                min = mid;
                System.out.print("min ="+min);
            }
        }
        return min;
    }
    private static int[] strToInt(String[] temp){
        int N = temp.length;
        int[] ar = new int[N];
        while (N-- > 0){
            ar[N] = Integer.parseInt(temp[N]);
        }
        return ar;
    }
}




/*
public class Solution {
    public static int M= 1000000007;

    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        int N,res;
        int [] arr=null;
        boolean [] vis=null;
        while(T-- >0){
            N=scan.nextInt();
            arr=new int[N];
            vis=new boolean[N];
            
            for(int i=0;i<N;++i){
                arr[i]=scan.nextInt();
            }
            
            Arrays.sort(arr);
            //int N=arr.length;
            int result=1;
            if (arr[N - 1] >= N || arr[0] != 0)
            {
                result = 0;
            }
            else
            {
                for (int j = N - 1; j >= 0; j--)
                {
                    if (arr[j] > j)
                    {
                        result = 0;
                        break;
                    }
                    else
                    {
                        result = ((result) * ((j - arr[j]) + 1)) % 1000000007;
                    }
                }
 
            }
           System.out.println(""+result);
            
            
            /*
            // method 2 but timeout for large number
             res=1;
            // int way=0;
            for(int i=0;i<arr.length;++i){
                int way=Math.max(0,findLessOrEqual(arr,i)-i);
                
                if(way==0){
                    System.out.println(""+0);
                    System.exit(1);
                }
                
                res=(res*way)%M;
                
            }
            System.out.println(""+res);
            */
            
            
            /*
            // Brute force recursion
            res=find(arr,-1,vis,0,N); 
            System.out.println(""+res);
            */
            
            
      //  }
     
    //} //main
    
    /*public static int findLessOrEqual(int [] arr, int max){

       // if way=3 at i=3 so we substract 3 because for picking that a[i] //we have to pick atleast i number of cards from total ways i.e //number lessor wqual to a[i]..
      //  so we do find(arr,max)-i;



        int count=0;
        
        for(int num: arr){
            if(num<=max)
                count++;
        }
        return count;
    }
    
    public static int find(int [] arr,int j,boolean [] vis,int c,int N){
        
        
        // Brute force recursion
        if(c==arr.length)
            return 1;
        int res=0;
        
        for(int i=0;i<arr.length;++i){
            if(i != j && vis[i]==false && c>=arr[i] ){
                vis[i]=true;
                res+= find(arr,i,vis,c+1);
                vis[i]=false;
            }
        }
        return res;
        
         return 0;  //dummy return
    } //find*/
    
    
    
//}

