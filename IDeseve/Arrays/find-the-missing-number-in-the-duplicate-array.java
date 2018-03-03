


Find the missing number in the duplicate array
http://www.ideserve.co.in/learn/find-the-missing-number-in-the-duplicate-array


Given two integer arrays where second array is duplicate of first array with just 1 element missing. Find the element.
Example: 

Input:
Array1 - 9 7 8 5 4 6 2 3 1
Array2 - 2 4 3 9 1 8 5 6

Output:
7


Algorithm 1:
1. Iterate over array1, find sum of all numbers of array1, say result.
2. Iterate over array2 and subtract every element of array2 from result.
3. Print result.
Typically in an interview, there can be a follow-up question to solve this problem without using arithmetic operators. Following is the algorithm for the same.

Algorithm 2:
1. Initialize result = 0.
2. Iterate over both the input arrays and XOR 'result' with each element of the input arrays.
3. Print result.







             
package com.ideserve.questions.saurabh;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Given two integer arrays where second array is duplicate of first array
 * with just 1 element missing. Find the element.
 * 
 * @author Saurabh
 */
public class MissingNumberInDuplicateArray {
 
    /*
     * Find missing number using xor operation.
     * Handled for the generic case where any of the input array could be
     * duplicate of the other one.
     */
    public static void missingNumberInDuplicateArray(int[] array1, int[] array2) {  
        if(array1 == null && array2 == null) {
            System.out.println("Input arrays are empty!");
        } else if(array1 == null) {
            if(array2.length == 1) {
                System.out.println("Missing element = " + array2[0]);
            } else {
                System.out.println("Input is not valid!");
            }
        } else if(array2 == null) {
            if(array1.length == 1) {
                System.out.println("Missing element = " + array1[0]);
            } else {
                System.out.println("Input is not valid!");
            }
        } else {
            int len1 = array1.length;
            int len2 = array2.length;
            if(Math.abs(len1 - len2) != 1) {
                System.out.println("Input is not valid!");
                return;
            }
            if(len1 > len2){
                findMissingNumber(array1, array2);
            } else {
                findMissingNumber(array2, array1);
            }
        }
    }
 
    private static void findMissingNumber(int[] array1, int[] array2) {
        int result = array1[0];
        for (int i = 1; i < array1.length ; i++) {
            result = result ^ array1[i];
        }
        for (int i = 0; i < array2.length ; i++) {
            result = result ^ array2[i];
        }
        System.out.println("Missing element = " + result);
    }
 
    /*
     * Find missing number using sum of array elements.
     * Handled for the generic case where any of the input array could be
     * duplicate of the other one.
     */
    public static void missingNumberInDuplicateArrayUsingSum(int[] array1, int[] array2) {      
        if(array1 == null && array2 == null) {
            System.out.println("Input arrays are empty!");
        } else if(array1 == null) {
            if(array2.length == 1) {
                System.out.println("Missing element = " + array2[0]);
            } else {
                System.out.println("Input is not valid!");
            }
        } else if(array2 == null) {
            if(array1.length == 1) {
                System.out.println("Missing element = " + array1[0]);
            } else {
                System.out.println("Input is not valid!");
            }
        } else {
            int len1 = array1.length;
            int len2 = array2.length;
            if(Math.abs(len1 - len2) != 1) {
                System.out.println("Input is not valid!");
                return;
            }
            if(len1 > len2){
                findMissingNumberUsingSum(array1, array2);
            } else {
                findMissingNumberUsingSum(array2, array1);
            }
        }
    }
 
    private static void findMissingNumberUsingSum(int[] array1, int[] array2) {
        int result = 0;
        for(int i = 0; i < array1.length; i++) {
            result += array1[i];
        }
        for(int i = 0; i < array2.length; i++) {
            result -= array2[i];
        }
        System.out.println("Missing element = " + result);
    }
 
    public static void main(String[] args) {
        int[] array1 = {9, 7, 8, 5, 4, 6, 2, 3, 1};
        int[] array2 = {2, 3, 4, 9, 1, 8, 5, 6};
        missingNumberInDuplicateArray(array1, array2);
    }
}
        


Time Complexity is O(n)
Space Complexity is O(1)













