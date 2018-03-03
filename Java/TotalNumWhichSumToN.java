import java.util.*;



public class TotalNumWhichSumToN{

public static int [] arr=null;
		
		public static void main(String [] args){
		
				
				Scanner scan=new Scanner(System.in);
				System.out.println("enetr number of elsents N");
				int N=scan.nextInt();
				System.out.println("enetr elemnts");
				arr=new int[N];
				
				for(int i=0;i<N;++i)
					arr[i]=scan.nextInt();	

				
				System.out.println("enetr Sum");
				int sum=scan.nextInt();
				
				int M=findTotalNum(sum);
				System.out.println("Output is " + M);
		
		} //main
		
		public static int findTotalNum(int n){
				
				int total=0;
				if(n==0) return 1;
				
				if(n<0) return 0;
				
				for(int i=0;i<arr.length;++i){
				
					total+=findTotalNum(n-arr[i]);
					
				}
				return total;
		
		
		} //func
		
		/*
		
H:\java>java TotalNumWhichSumToN
enetr number of elsents N
3
enetr elemnts
2 3 5
enetr Sum
6
Output is 2

H:\java>java TotalNumWhichSumToN
enetr number of elsents N
3
enetr elemnts
2 3 5
enetr Sum
8
Output is 6

H:\java>java TotalNumWhichSumToN
enetr number of elsents N
3
enetr elemnts
1 3 4
enetr Sum
5
Output is 6

		*/
		
		/*
		Using DP
D[0] = D[1] = D[2] = 1; D[3] = 2;
for(i = 4; i <= n; i++)
D[i] = D[i-1] + D[i-3] + D[i-4];
		
		*/
	} //class	