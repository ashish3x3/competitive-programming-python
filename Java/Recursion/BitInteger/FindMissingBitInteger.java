package BitInteger;

import java.util.*;
import java.*;

public  class FindMissingBitInteger{
	
	public static void main(String [] args){

			int arr[]={000,001,010,011,100,110,111};
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

class BitInteger {
        public static int INTEGER_SIZE;
        private boolean[] bits;
        public BitInteger() {
                bits = new boolean[INTEGER_SIZE];
        }
        /* Creates a number equal to given value. Takes time proportional
         * to INTEGER_SIZE. */
        public BitInteger(int value){
                bits = new boolean[INTEGER_SIZE];
                for (int j = 0; j < INTEGER_SIZE; j++){
                        if (((value >> j) & 1) == 1) bits[INTEGER_SIZE - 1 - j] = true;
                        else bits[INTEGER_SIZE - 1 - j] = false;
                }
        }
       
        /** Returns k-th least-significant bit. */
        public int fetch(int k){
                if (bits[k]) return 1;
                else return 0;
        }
       
        /** Sets k-th least-significant bit. */
        public void set(int k, int bitValue){
                if (bitValue == 0 ) bits[k] = false;
                else bits[k] = true;
        }
       
        /** Sets k-th least-significant bit. */
        public void set(int k, char bitValue){
                if (bitValue == '0' ) bits[k] = false;
                else bits[k] = true;
        }
       
        /** Sets k-th least-significant bit. */
        public void set(int k, boolean bitValue){
                bits[k] = bitValue;
        }      
       
        public void swapValues(BitInteger number) {
                for (int i = 0; i < INTEGER_SIZE; i++) {
                        int temp = number.fetch(i);
                        number.set(i, this.fetch(i));
                        this.set(i, temp);
                }
        }
               
        public int toInt() {
                int number = 0;
                for (int j = INTEGER_SIZE - 1; j >= 0; j--){
                        number = number | fetch(j);
                        if (j > 0) {
                                number = number << 1;
                        }
                }
                return number;
        }
}