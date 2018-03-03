import java.util.*;

public class GraphPath{
		
		public static int [][] mat;
		
		public GraphPath(int m){
			
			mat=new int[m+1][m+1];
		}
		
		public static void main(String [] args){
			
			Scanner scan=new Scanner(System.in);
			int m=scan.nextInt();
			GraphPath g=new GraphPath(m);
			
			System.out.println("Enter the graph elements");
				
				for(int i=1;i<mat.length;++i){
				
					for(int j=1;j<mat.length;++j){
						
						mat[i][j]=scan.nextInt();
					}
					
				
				}//for outer
				
				int a,b;
				boolean c;
				System.out.println("enetr siurce");
				a=scan.nextInt();
				System.out.println("enetr Dest");
				b=scan.nextInt();
				c=check(mat,a,b);
				
				System.out.println("" +c);
		
		
		}//main
		
		public static boolean check(int [][] mat,int s,int d){
			
			int no_of_nodes=mat.length-1;
			boolean [] vis=new boolean[no_of_nodes+1];	

			int ele=s;
			int i=1;
			Stack<Integer> st=new Stack<Integer>();
			st.push((Integer)s);
			
			while(!st.isEmpty()){
				
				int m=st.peek();
				while(i<=no_of_nodes){
					
					if(mat[ele][i]==1 && vis[i]==false){
						System.out.println("" +ele +"  " + i);
						st.push((Integer)i);
						vis[i]=true;
						ele=i;
						i=1;
						continue;
					
					
					}//if
					i++;
				
				}//while < no_of_nodes
			  st.pop();
			
			}//while

			
			if(vis[d]==true)
				return true;
			else
				return false;
			
		}//check
		
		/*
		H:\java>java GraphPath
4
Enter the graph elements
1 1 0 0
0 1 1 1
0 0 1 0
1 0 0 0
enetr siurce
4
enetr Dest
1
4  1
1  2
2  3
true
		*/

}//class