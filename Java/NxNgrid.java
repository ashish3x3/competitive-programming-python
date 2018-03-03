import java.util.*;

public class NxNgrid{
	
	public static String [][] mat;
	public static int count;
	public static String [] path; 
	
	
	
	public static void main(String [] args){
		Scanner scan=new Scanner(System.in);
		int n;
		System.out.println("enetr N");
		n=scan.nextInt();
		  
		mat=new String[n][n];
		path=new String[n*n ];
		path[0]="0";
		int k=1;;
		
		
		
		for(int i=0;i<n;++i){
			for(int j=0;j<n;++j){
				mat[i][j]=scan.next();
				
			}
		}
		
		findNumberOfPath(0,0,k);
		
		System.out.println( "   " + count);
		
	
	
	} //main
	
	public static void findNumberOfPath(int i,int j,int k){
		if(isSafeMoveRight(i,j)){
			
			path[k]=(j+1)+"";
			findNumberOfPath(i,j+1,k+1);
			
			}
			
		if(isSafeMoveDown(i,j)){
			
			path[k]=(i+1)+"";
			findNumberOfPath(i+1,j,k+1);
			}
			
		if(isEnd(i,j)){
			count++;
			printPath(k);
			}
			
			
	}//find
	
	
	public static void printPath(int k){
			
			for(int i=0;i<k;++i){
					
					System.out.print("-"+path[i]);
			}
			System.out.println();
	
	} //path
	
	
	public static boolean isSafeMoveDown(int i,int j){
			
			
			if((i+1) < mat.length && j < mat.length && !(mat[i+1][j].equals("X")) )			
					 return true;    //if((i+1) < mat.length && (j) < mat.length ) without obstacle
				else
					return false;
			
			
			
	}//down
	
	public static boolean isSafeMoveRight(int i,int j){
			
			
			if((i) < mat.length && (j+1) < mat.length && !(mat[i][j+1].equals("X")) )			
					 return true;	// if((i) < mat.length && (j+1) < mat.length )   without obstacle
				else
					return false;
			
			
			
	}//down
	
	public static boolean isEnd(int i,int j){
			
			
			if(i == mat.length-1 && j == mat.length-1  )
					 return true;
				else
					return false;
			
			
			
	}//down
	
	/*
		H:\java>java NxNgrid
-----with obstacle X..
enetr N
3
0 0 0
0 X 0
X 0 0
-0-1-2-1-2
   1

----without obstacle X..  
 
 H:\java>java NxNgrid
enetr N
3
0 0 0
0 X 0
X 0 0
-0-1-2-1-2
-0-1-1-2-2
-0-1-1-2-2
-0-1-1-2-2
-0-1-1-2-2
-0-1-2-1-2
   6
   
	*/
	
	
} //class