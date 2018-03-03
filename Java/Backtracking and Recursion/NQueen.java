import java.util.*;

/*

Have to place N queen is such a place taht htey don'y cut each other..

H:\Computer Science\Java\Backtracking and Recursion>java NQueen
 Enter N 4
 0 0 0 0
 reached k==n
* Q * *
* * * Q
Q * * *
* * Q *

 reached k==n
* * Q *
Q * * *
* * * Q
* Q * *
*/


public class NQueen{
  //Have to place N queen is such a place taht htey don'y cut each other..
	public static int [] arr=null;

	public static void main(String [] args){

		Scanner scan=new Scanner(System.in);
		System.out.print(" Enter N " );
		int N=scan.nextInt();
		//System.out.print(" reached start " );
		arr=new int[N];           //store kth row ith columen
		Arrays.fill(arr,0);
		printArr();
		//NQueen nq=new NQueen();
		find(0,arr.length);
 


	}

	public static  void printArr(){

		//System.out.print(" reached print " );

		for(int i=0;i<arr.length;++i){

			System.out.print(" " + arr[i]);
		}
		System.out.println(" ");
		//System.out.print(" reached below print " );

	}

	public static void find(int k,int n){

		//System.out.print(" reached find" );

		for(int i=0;i<n;++i){

			if(place(k,i)){
			//	System.out.println(" k and I ==  " +k +" " +i );
				arr[k]=i;    //store kth row ith columen

				if(k == n-1){   //if all 8 roes(i.e k) filled ..pirnt config..
					System.out.println(" reached k==n " );

					printQueens();

					/*for(int m=0;m<arr.length;++m){
						System.out.print(" "+ arr[m]);
					}*/
				} //if

				else{

						//System.out.println(" k+1 == " + (k+1) );
					 find(k+1,n);       //if not all fined check next row and fill it..
					}
					

			}

		} //for


	}  //find

	public static void printQueens() {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

	public static boolean place(int k,int i){

			for(int j=0;j<k;++j){
				//if any row before this kth row has that same colume filled with queen
				// check is config.  diagonally cutting each other...(3,5) and (5,7) diagonal..so distance between them is same ...i-k ==j-l
				if(arr[j]==i || (Math.abs(arr[j]-i)== Math.abs(j-k)))  //jth row-kth row and ith row and a[j] col
					return false;

			}

		return true;

	} //place


}//class