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


    int T,L,R;
    T=scan.nextInt();
    while(T-- >0){

        L=scan.nextInt();
        R=scan.nextInt();
        Set<Integer> set = new HashSet<Integer>();

        for(int i=L;i<=R;++i){
            set.add(i);
        }
        int res=1;

        for(int ele : powerSet()){
            res=res&ele;
        }
        System.out.perintln(""+res);
        

    }//T--

   
    
    
    /*for (Set<Integer> s : ps.powerSet(set)) {
        System.out.println(s);
    }*/
} //main

public Set<Integer> powerSet(Set<Integer> originalSet) {
    int res;
    // Original set size e.g. 3
    int size = originalSet.size();
    // Number of subsets 2^n, e.g 2^3 = 8
    int numberOfSubSets = (int) Math.pow(2, size);
    Set<Integer> sets = new HashSet<Integer>();
    ArrayList<Integer> originalList = new ArrayList<Integer>(originalSet);
    for (int i = 0; i < numberOfSubSets; i++) {
        // Get binary representation of this index e.g. 010 = 2 for n = 3
        String bin = getPaddedBinString(i, size);
        //Get sub-set
        Set<Integer> set = getSet(bin, originalList);
         res=1;

        for(Integer ele : set){
            res=res&ele;

        }
        sets.add(res);
    }
    return sets;
}

//Gets a sub-set based on the binary representation. E.g. for 010 where n = 3 it will bring a new Set with value 2
private Set<Integer> getSet(String bin, List<Integer> origValues){
    Set<Integer> result = new HashSet<Integer>();
    for(int i = bin.length()-1; i >= 0; i--){
        //Only get sub-sets where bool flag is on
        if(bin.charAt(i) == '1'){
            int val = origValues.get(i);
            result.add(val);
        }
    }
    return result;
}

//Converts an int to Bin and adds left padding to zero's based on size
private String getPaddedBinString(int i, int size) {
    String bin = Integer.toBinaryString(i);
    //bin = String.format("%0" + size + "d", Integer.parseInt(bin));
    return bin;
}

}