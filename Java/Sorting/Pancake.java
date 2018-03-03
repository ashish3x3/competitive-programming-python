/*Following are the detailed steps. Let given array be arr[] and size of array be n.
1) Start from current size equal to n and reduce current size by one while it’s greater than 1. Let the current size be curr_size. Do following for every curr_size
……a) Find index of the maximum element in arr[0..curr_szie-1]. Let the index be ‘mi’
……b) Call flip(arr, mi)
……c) Call flip(arr, curr_size-1)*/

void countSort(char *str)
{
    // The output character array that will have sorted str
    char output[strlen(str)];
 
    // Create a count array to store count of inidividul characters and
    // initialize count array as 0
    int count[RANGE + 1], i;
    memset(count, 0, sizeof(count));
 
    // Store count of each character
    for(i = 0; str[i]; ++i)
        ++count[str[i]];
 
    // Change count[i] so that count[i] now contains actual position of
    // this character in output array
    for (i = 1; i <= RANGE; ++i)
        count[i] += count[i-1];
 
    // Build the output character array
    for (i = 0; str[i]; ++i)
    {
        output[count[str[i]]-1] = str[i];
        --count[str[i]];
    }
 
    // Copy the output array to str, so that str now
    // contains sorted characters
    for (i = 0; str[i]; ++i)
        str[i] = output[i];
}

/*
import java.util.*;
import java.lang.*;
import java.io.*;
 
class PancakeSort {
 
  public static void main(String[] args) {
 
    int[] arr = {10,9,8,7,6,15,14,13,12,11,5,4,3,2,1};
 
    System.out.println("Unsorted: " + Arrays.toString(arr));
    pancakeSort(arr);
    System.out.println("Sorted: " + Arrays.toString(arr));
  }
 
  public static void pancakeSort(int[] A){
    int max = 0;
    int j, index = 0;
 
    for (int i = 0; i < A.length; i++) {
      max = A[0];
      index = 0;
      for (j = 0; j < A.length - i; j++) {
        if (A[j] > max) {
          max = A[j];
          index = j;
        }
      }
      flip(A, index, A.length - 1 - i);
    }
  }
 
  public static void flip(int[] A, int l, int r) {
    while (l <= r) {
      int temp = A[l];
      A[l] = A[r];
      A[r] = temp;
      l++;
      r--;
    }
  }
}
 */
 
 /*

Output:

$ java PancakeSort
Unsorted: [10, 9, 8, 7, 6, 15, 14, 13, 12, 11, 5, 4, 3, 2, 1]
Sorted: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
*/


