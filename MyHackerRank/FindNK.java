import java.util.*;

/*H:\Computer Science\Java\MyHackerRank>javac FindNK.java

H:\Computer Science\Java\MyHackerRank>java FindNK
Enter T
1
Enter N and K
3 1
2

H:\Computer Science\Java\MyHackerRank>java FindNK
Enter T
2
Enter N and K
6 4
2
Enter N and K
3 1
2*/

H:\Computer Science\Java\MyHackerRank>


class FindNK{


	public static int [] arr=null;
	public static int K=0;
	public static int N=0;
	

	public static void main(String [] args){

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter T");
		int T=scan.nextInt();
		// int N;
		while(T-->0){

			System.out.println("Enter N and K");

		//Random r=new Random();
		//N=r.nextInt(100); //0-99   int randomNum = r.nextInt((max - min) + 1) + min;
			N=scan.nextInt();
			K=scan.nextInt();

			if(N>(int)Math.pow((double)10,5)  || K>N  ){
				System.out.println("N=" + N + " K= "+K + "pow=" +(int)Math.pow((double)10,5) );
				System.out.println("Wrong Input");
				System.exit(1);
			}

		/* // 1st method O(n^2)
		arr=new int[N];

		for(int i=0;i<N;++i){

			arr[i]=i;

		} //for

		int res=ReverseAndFind(K);
		System.out.println(" K is at " + res);*/

		// 2nd method O(n)
		for(int i=0;i<N;++i){

			if(K<i)
				break;
			reverse(i);

		}
		System.out.println("" + K);

		 // 3rd method

		/*
		O(1) Solution

			If you visualise the array before transformation as

			5     5  
			4     0
			3  => 4
			2     1
			1     3
			0     2

			You'll notice that the transformation is something like top element, bottom element, then next from top and then next from bottom till we reach middle. So we can split the array and apply the formula

		*/

		/*	
		 while(T--)
        {
        scanf("%ld%ld",&N,&K);
        if(K < (N/2))
            printf("%ld\n",(2*K + 1));
        else
            printf("%ld\n",2*((N-1)-K));
        }*/



	} //while T


	} //main

	public static void reverse(int i){
		/*
		First let us think What will be index of K(≥i) when we rotate the segment [i,N]. This can be seen very easily that the index of K(≥i) after rotating the segment [i,N] will be in such a way, Distance between i and K before rotation will be same as distance between NewindexofK and N after then rotation. 
		*/

		K=K-i;
		K=N-1-i-K;
		K=K+i;
		// return;


	}

	/*public static int ReverseAndFind(int K){

		for(int i=0;i<arr.length;++i){

			reverse(i);
			//System.out.println(" " + Arrays.toString(arr));
			if(arr[i]==K)
				return i;

			
		}
		return -1;

	} //RevandFind

	public static void reverse(int i){

		int j=arr.length-1;
		while(i<j){

			swap(i,j);
			i++;
			j--;
		}

	} //rev

	public static void swap(int i ,int j){

		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}*/


} //class