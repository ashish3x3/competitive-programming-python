/*You will be given two number L, R. You need to calculate AND-AND of all the non-empty subset in range [L,R] both inclusive, and print result.

AND(&) operation on [L,R] is defined as (&) of all element in it. AND([L,R])=L&(L+1)&(L+2)&....&R.

AND-AND operation on [L,R] is defined as AND(&) of all non-empty subsets.

AND−AND([L,R])=AND([L,L])&AND([L,L+1])&AND(L,L+2)&...&AND([L,R])&AND([L+1,L+1])&AND([L+1,L+2])&...&AND([L+1,R])&....&AND([R,R])

For simplicity lets take L=2 and R=4.

All possible non-empty subsets [2,4]={2},{3},{4},{2,3},{2,4},{3,4},{2,3,4}

AND−AND([2,4])={2}&{3}&{4}&{2,3}&{2,4}&{3,4}&{2,3,4}

Input Format

First line of the input contains T, the number of testcases to follow.

Each testcase in a newline contains L and R separated by a single space.

Constraint

1≤T≤200

0≤L≤R≤232

Output Format

Output one line per test case with the required AND−AND.

Sample Input

2
2 3
2 4

Sample Output

2
0

Explanation

For Test:

Case1: AND−AND([2,4])={2}&{3}&{4}&{2,3}&{2,4}&{3,4}&{2,3,4}

Result for

{2}=2

{3}=3

{4}=4

{2,3}=2

{2,4}=0

{3,4}=0

{2,3,4}=0

AND−AND([2,4])=2&3&4&2&0&0&0=0

Similarly for Case2:AND−AND([2,3])=2&3&2=2*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class And_And {

/**
 * @param args
 */
public static void main(String[] args) {

    Scanner scan=new Scanner(System.in);


    int T,L,R,len;
    int res;
    T=scan.nextInt();
    while(T-- >0){

        L=scan.nextInt();
        R=scan.nextInt();
        Set<Integer> set = new HashSet<Integer>();

        for(int i=L;i<=R;++i){
            set.add(i);
        }
       // int res=1;
        len=R-L+1;
        int size = set.size();
    	// Number of subsets 2^n, e.g 2^3 = 8
    	int numberOfSubSets = (int) Math.pow(2, size);
        //res=getPaddedBinString(numberOfSubSets-1,size);

        Set<Integer> ht=powerSet(set,len);
        res=first(ht);


        for(int ele : powerSet(set,len)){
        	//System.out.print(" "+ele);
            res=ele & res;
        }
        System.out.println(""+res);
        

    }//T--

   
    
    
    /*for (Set<Integer> s : ps.powerSet(set)) {
        System.out.println(s);
    }*/
} //main
public static Integer first(Set<Integer> set) {

	for(Integer ele : set){
		return ele;
	}
	return 0;
}

public static Set<Integer> powerSet(Set<Integer> originalSet,int len) {

	/*for(Integer ele : originalSet){
        	System.out.print(" "+ele);
           // res=res&ele;
        }*/
    int res;
    // Original set size e.g. 3
    int size = originalSet.size();
    // Number of subsets 2^n, e.g 2^3 = 8
    int numberOfSubSets = (int) Math.pow(2, size);
    Set<Integer> sets = new HashSet<Integer>();
    ArrayList<Integer> originalList = new ArrayList<Integer>(originalSet);
    for (int i = 1; i < numberOfSubSets; i++) {
        // Get binary representation of this index e.g. 010 = 2 for n = 3
        String bin = getPaddedBinString(i, size);
        //Get sub-set
        Set<Integer> set = getSet(bin, originalList);
         res=Integer.parseInt(getPaddedBinString(numberOfSubSets-1,size));
         //System.out.println(" res for calc" + res);
         //System.out.println("");

			//System.out.println("set before ans");
         /*for(Integer ele : set){
        	System.out.print(" "+ele);
           // res=res&ele;
        }*/
       // System.out.println("");

        for(Integer ele : set){
            res=ele & res;

        }
        //System.out.println("ans of and of set = "+ res);
        sets.add(res);
    }
    return sets;
}

//Gets a sub-set based on the binary representation. E.g. for 010 where n = 3 it will bring a new Set with value 2
private static Set<Integer> getSet(String bin, List<Integer> origValues){
    Set<Integer> result = new HashSet<Integer>();
    for(int i = bin.length()-1; i >= 0; i--){
        //Only get sub-sets where bool flag is on
        if(bin.charAt(i) == '1'){
            int val = origValues.get(i);
            result.add(val);
        }
    }
    //System.out.println("result set");
    /*for(Integer ele : result){
    	
        	System.out.print(" "+ele);
           // res=res&ele;
        }
         System.out.println("");*/
    return result;
}

//Converts an int to Bin and adds left padding to zero's based on size
private static String getPaddedBinString(int i, int size) {
    String bin = Integer.toBinaryString(i);
    bin = String.format("%0" + size + "d", Integer.parseInt(bin));
    //System.out.println("Binary num");
    //System.out.println("Binary = "+bin + " for i = "+i);
    //System.out.println("");
    return bin;
}

}