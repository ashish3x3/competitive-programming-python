import java.util.*;


/*

									
									Worst Permutation

 Your submission will run against only preliminary test cases. Full test cases will run at the end of the day.

Problem Statement

You are given an array of N integers which is a permuation of the first N natural numbers. You can swap any two elements of the array. You can make at most K swaps. What is the lexicographically worst permutation you can make?

Note: Lexicographically worst means the last ranked permutation in lexicographical ordering. Check sample for understanding.

Input Format
The first line of the input contains two integers, N and K, the size of the input array and the maximum swaps you can make, respectively. The second line of the input contains a permutation of the first N natural numbers.

Output Format
Print the lexicographically worst permutation you can make with at most K swaps.

Constraints
1=N=105
1=K=109

Sample Input#00

5 1
4 2 3 5 1

Sample Output#00

5 2 3 4 1

Explanation#00
You can swap any two numbers in [4,2,3,5,1] and see the worst permutation is [5,2,3,4,1]

Sample Input#01

3 1
2 1 3

Sample Output#01

3 1 2

Explanation#01
With 1 swap we can get [1,2,3], [3,1,2] and [2,3,1] out of these [3,1,2] is the worst permutation.

Sample Input#02

2 1
2 1

Sample Output#02

2 1

Explanation#02
We can see that [2,1] is already the worst permutation. So we don't need any swaps.
Suggest Edits
1037 hackers have submitted code

Share

Download PDF



*/

 class LastLexoInKSwap{
		
		public static int [] arr=null;
		
		public static void main(String [] args){
			
			Scanner scan=new Scanner(System.in);
			long K;
            int N;
			N=scan.nextInt();
			K=scan.nextLong();
			
			arr=new int[N];
			
			for(int i=0;i<N;++i){
					
					arr[i]=scan.nextInt();
			}
			
			findLexo(K);
			
			//System.out.println("Result");
				for(int i=0;i<arr.length;++i){
                        if(i>0)
						System.out.print(" "+arr[i]);
                    else
                        System.out.print(""+arr[i]);
						
				}
			
			}//main
			
			public static void findLexo(long K){
			
					int front=0;
					int max_index=0;
					
					while(K>0){
						
						max_index=findMax(front+1);
						
						if(max_index !=-1 &&  arr[front]<arr[max_index]){
							swap(front,max_index);
							front++;
						
						}
						else{
                             if(front<=arr.length){
						        front++;
                              continue;
                             }
                            else
                                break;
					
                        
                        }
                        K--;
					}
					
					
			
			} //findLexo
			
			public static int findMax(int j){
					
					int I=0;
					int max=Integer.MIN_VALUE;
					for(int i=j;i<arr.length;++i){
					
						
						if(arr[i] > max) {
						max = arr[i];
						I=i;
					}
	
					}
					if(I>=j)
					return I;
                else
                    return -1;
					
					//Arrays.sort(myArray);
						//int max = myArray[myArray.length - 1];
			
			} //findMAx
			
			public static void swap(int i,int j){
			
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				
			
			} //swap
			
			/*
			
H:\java>javac LastLexoInKSwap.java

H:\java>java LastLexoInKSwap
5 1
4 2 3 5 1
5 2 3 4 1
H:\java>java LastLexoInKSwap
5 2
1 4 2 3 5
5 4 3 2 1
H:\java>java LastLexoInKSwap
2 1
2 1
2 1
H:\java>java LastLexoInKSwap
3 1
2 1 3
3 1 2
			
			*/
			


} //class
