import java.util.*;
import java.*;

public  class FindMissingBitInteger{
	
	public static void main(String [] args){

			in arr[]={000,001,010,011,100,110,111};
			ArrayList<BitInteger> a =new ArrayList<BitInteger>(Arrays.asList(arr));

			int c=find(a);
			System.out.println(" "+c);


	} //main

	public static int find(ArrayList<BitInteger> a){

		return	find( a,BitInteger.INTEGER_SIZE-1);



	}

	public static int find(ArrayList<BitInteger> input, int column){

		if (column < 0) { // Base case and error condition
 return 0;
 }
 ArrayList<BitInteger> oddIndices = new ArrayList<BitInteger>();
 ArrayList<BitInteger> evenIndices = new ArrayList<BitInteger>();
 for (BitInteger t : input) {
 if (t.fetch(column) == 0) {
 evenIndices.add(t);
 } else {
 oddIndices.add(t);
 }
 }
 if (oddIndices.size() >= evenIndices.size()) {
 return (findMissing(evenIndices, column - 1)) << 1 | 0;
 } else {
 return (findMissing(oddIndices, column - 1)) << 1 | 1;
 }
 }


	


} //class