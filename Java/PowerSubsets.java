import java.util.*;



public class PowerSubsets{

public static int [] set=null;
		
		public static void main(String [] args){
		
				PowerSubsets st=new PowerSubsets();
				Scanner scan=new Scanner(System.in);
				System.out.println("enetr number of elsents N");
				int N=scan.nextInt();
				System.out.println("enetr elemnts");
				set=new int[N];
				
				for(int i=0;i<N;++i)
					set[i]=scan.nextInt();	     //set dosen't contain duplicates..
				
				
				st.subSets();
		
		} //main
		
		public static void subSets(){
		
				int size=(int)Math.pow(2,set.length);
		
				for(int i=0;i<size;++i){
					
					for(int j=0;j<set.length;++j){
						
						if(((i>>j)&1)==1)
							System.out.print(" "+ set[j]);
						//i>>=j;
					}
					System.out.println();
					
				
				} //for
		
		
		} //subsets
		
		/*

H:\java>java PowerSubsets
enetr number of elsents N
3
enetr elemnts
1 2 3

 1
 2
 1 2
 3
 1 3
 2 3
 1 2 3
 
 */

}  //class