import java.util.*;

/*

H:\Computer Science\Java\MyHackerRank\Modular>java BigNumber
1
Enter A--N--M
523 3 11
6


H:\Computer Science\Java\MyHackerRank\Modular>java BigNumber
Enter A--N--M
12 2 17
5


*/
public class BigNumber{


	public static  Long A,N,M;

	public static void main(String [] args){

		long tn,num,T;
		Scanner scan=new Scanner(System.in);
		T=scan.nextLong();
		/*System.out.println("Enter A--N--M");
		A=scan.nextInt();
		N=scan.nextInt();
		M=scan.nextInt();
*/
		/*int f=findFactor(A);   //will return size of A with 0 i.e for A=22,fact=100,A=6 fact=10 

		int a1=A;

		for(int i=0;i<N-1;++i){
			A=(A*f+a1)%M;
			

		}
		System.out.println(""+ A);*/


    /*long long int N,M,num;
    scanf("%d",&T);*/
    while(T-- >0)
        {
        tn=10;
        //scanf("%d%lld%lld",&A,&N,&M);
        System.out.println("Enter A--N--M");
		A=scan.nextLong();
		N=scan.nextLong();
		M=scan.nextLong();

        num=A/10;
        while(num>0)
        {
            tn=tn*10;
            num=num/10;
        }
        //printf("%d\n",tn);
        num = A%M;
        N=N-1;
        while(N-- !=0)
            {
            num = ((num*tn)%M + A)%M;
        }
       System.out.println(""+num);
    }


	}//main

	public static int findFactor(int A){

		int fact=1;
		while(A!=0){

			fact=fact*10;
			A=A/10;
		}
		return fact;
	}
} //class