import java.util.*;

public class PermFinal{


	//public static Set<List<String>> set=new  HashSet<List<String>>();
	public static Set<String> set=new  HashSet<String>();
	public static Integer [] index=null;
	public static int [] data={0,1,2,3,4,5,6,7,8,9};
	public static int MAX=100000;

	public static void main(String [] args){

		Scanner scan=new Scanner(System.in);

		int T=scan.nextInt();
		int min,max;
		boolean res=false;
		while(T-- > 0){
			//System.out.println("Enetr min max");
			min=scan.nextInt();
			max=scan.nextInt();

			for(int i=min;i<=max;++i){
                index=new Integer[i];
				printAllKLengthRec("",i);
				if(set.size()>MAX){
					System.out.println("YES");
                break;
            }

			}
            if(set.size()<=MAX)
			System.out.println("NO");
		}
	} //main

	// The method that prints all possible strings of length k.  It is
    //  mainly a wrapper over recursive function printAllKLengthRec()
   /* static void printAllKLength(char set[], int k) {
        int n = set.length;        
        printAllKLengthRec(set, "", n, k);
    }*/
 
    // The main recursive method to print all possible strings of length k
    static void printAllKLengthRec(String prefix, int k) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
            //System.out.println(prefix);
            set.add(prefix);
            return;
        }
 
        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + data[i]; 
             
            // k is decreased, because we have added a new character
            printAllKLengthRec( newPrefix,k - 1); 
        }
    }


}//class