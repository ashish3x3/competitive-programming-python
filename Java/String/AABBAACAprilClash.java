import java.util.*;


public class AABBAACAprilClash{

		public static String [] s=null;
		public static StringBuffer [] t=null;

		public static void main(String [] args){
			int N;
			int M,T;
				Scanner scan=new Scanner(System.in);
				System.out.println("Enetr T");
				T=scan.nextInt();
				while(T-- > 0){
				System.out.println("Enetr N and M");
				 N=scan.nextInt();
				 M=scan.nextInt();

				 s=new String[N];
				 t=new StringBuffer[N];
				 System.out.println("Enetr N String");

				 for(int i=0;i<N;++i){
				 	s[i]=scan.next();


				 }

				 t[0]=new StringBuffer(s[0]);

		for(int i=1;i<N;++i){
		 t[i]=new StringBuffer().append(t[i-1]).append(t[i-1].reverse()).append(new StringBuffer(s[i]));
				 }

				 for(int i=0;i<N;++i){
				 	System.out.println(""+t[i]);
				 }

				 String str="";

				 System.out.println("Enetr M index");

				 for(int i=0;i<M;++i){

				 	//System.out.print(""+t[N-1].charAt(scan.nextInt()));
				 	str=str+t[N-1].charAt(scan.nextInt());

				 }

				 System.out.println(""+str);




				}//T

		}//main

}//class