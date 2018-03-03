import java.util.*;

/*

Shashank loves to play with arrays a lot. Today, he has an array A consisting of N positive integers. At first, Shashank listed all the subarrays of his array A on a paper and later replaced all the subarrays on the paper with the maximum element present in the respective subarray.

For eg: Let us consider the following array A consisting of three elements.

A = {1,2,3}

List of Subarrays:

{1}

{2}

{3}

{1,2}

{2,3}

{1,2,3}

Final List:

{1}

{2}

{3}

{2}

{3}

{3}

Now, Shashank wondered how many numbers in the list are greater than K.

Input Format

The first line of input contains a single integer T denoting the number of test cases. The first line of each test case contains two space-separated integers, N and K, where N denotes the number of elements in the array A. The next line of each test case contains N space separated integers, each denoting an element of array A.

Constraints
1=T=105
1=N=2×105
1=Ai=109
0=K=109
Sum of N over all test cases does not exceed 106.

Output Format

For each test case, Print the required answer in a separate line.

Sample Input

2
3 2
1 2 3 
3 1 
1 2 3 

Sample Output

3
5

Explanation

In the first test case, there are 3 numbers in the list greater than 2.
In the second test case, there are 5 numbers in the list greater than 1.
Suggest Edits
920 hackers have submitted code

Share

Download PDF


*/


public class NumberListSubArray{
		
		public static int [] arr=null;

			public static void  main(String [] args){
			
					Scanner scan=new Scanner(System.in);
					int N,K,T;
					
					T=scan.nextInt();
					int j=0;
					
					while(T-- >0){
					
					N=scan.nextInt();
					K=scan.nextInt();
					
					arr=new int[N];
					
					//System.out.println("enter array");
					
					for(int i=0;i<N;++i){
						arr[i]=scan.nextInt();
					
					}
					
					//res[j++]=count(K);
					System.out.println("" + count(K));
					
					} //while
					
					//for(int i=0;i<)
					
			
			} //main
			
			public static int count(int K){
					
					int m1=Integer.MIN_VALUE;
					int k=0,count=0;
					
					for(int l=1;l<=arr.length;++l){
						
						k++;
						//System.out.println("k = " +k);
							for(int j=0;j<=arr.length-l;++j){
									//System.out.println("j = " +j);
									for(int m=0;m<k;++m){
										
										if(arr[m+j]>m1){
											
											m1=arr[m+j];
											//System.out.println("m1 inside if = " +m1);	
											
										} //if
									
									} //m
									
									if(m1>K)
										count++;
										
									m1=Integer.MIN_VALUE;
									//System.out.println("m1 = " +m1);									
									
							} //j
					
					} //l
					
					//System.out.println(" " +count);
					return count;
			
			
			
			}
			
			/*
			
H:\java>javac NumberListSubArray.java

H:\java>java NumberListSubArray
1
3 1
1 2 3
5

H:\java>java NumberListSubArray
2
3 2
1 2 3
3


3 1
1 2 3
5
			
			
			*/
			

} //class