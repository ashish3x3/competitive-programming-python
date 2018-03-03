

Count frequencies of array elements in range 1 to n
http://www.ideserve.co.in/learn/count-frequencies-of-array-elements

Algorithm 1: O(n^2) time and O(1) space
Use 2 loops.
1. Outer loop runs from i = 1 to n.
2. Inner loop calculates the count of i in the input array.
3. Print the count of i when inner loop ends.

Algorithm 2: O(n) time and O(n) space
1. Create a count array of size n with all elements from index i = 0 to n-1 initialized to 0.
Here, count[i] is count of i+1.
2. Traverse the array once. For i = 0 to n-1, increment count[input[i]-1] by 1.
3. Traverse count array and print count array.


Algorithm 3: O(n) time and O(1) space
1. Reduce all elements by 1 so that the elements are converted in the range 0 to n-1.
2. Traverse the input array and for i = 0 to n-1, add n to element at index (input[i]%n). After all the elements are completed, element at index i will be increment by n*k where k is the number of times i occurs in the array.
3. Finally, print counts of elements. Count of i+1 will be input[i]/n. 
Reason: 
Element at index i will be equal to input[i] + n*k where k is the number of times i occurs in the array.
On dividing by n, we get: (input[i] + n*k)/n = input[i]/n + (n*k)/n = 0 + k = k = the number of times i occurs in the array
As initially, all elements were reduced by 1, so this is count of i+1. 
4. Traverse input array once and set input[i] = input[i]%n+1 to get original array.





Example:
Input Array: [2, 3, 3, 2, 5]
n: 5
After step #1, array will be:
[1, 2, 2, 1, 4]
Step #2:
i = 0: Set input[input[0]%5] = input[input[0]%5] + 5
                             = input[1%5] + 5
                             = input[1] + 5  
                             = 2 + 5 
                             = 7
Array: [1, 7, 2, 1, 4]

i = 1: Set input[input[1]%5] = input[input[1]%5] + 5
                             = input[7%5] + 5
                             = input[2] + 5
                             = 2 + 5
                             = 7
Array: [1, 7, 7, 1, 4]

i = 2: Set input[input[2]%5] = input[input[2]%5] + 5
                             = input[7%5] + 5
                             = input[2] + 5
                             = 7 + 5
                             = 12
Array: [1, 7, 12, 1, 4]

i = 3: Set input[input[3]%5] = input[input[3]%5] + 5
                             = input[1%5] + 5
                             = input[1] + 5
                             = 7 + 5
                             = 12
Array: [1, 12, 12, 1, 4]

i = 4: Set input[input[4]%5] = input[input[4]%5] + 5
                             = input[4%5] + 5
                             = input[4] + 5
                             = 4 + 5
                             = 9
Array: [1, 12, 12, 1, 9]

After step #2: Input Array = [1, 12, 12, 1, 9]

Step #3: Print all elements:
(i+1)   input[i]/n
1        0
2        2
3        2
4        0
5        1

Step #4: Get back original array by setting input[i] = input[i]%n+1
i = 0: Set input[0] = input[0]%5+1
                    = 1%5+1
                    = 1 + 1
                    = 2 
i = 1: Set input[1] = input[1]%5+1
                    = 12%5+1
                    = 2 + 1
                    = 3 
i = 2: Set input[2] = input[2]%5+1
                    = 12%5+1
                    = 2 + 1
                    = 3 
i = 3: Set input[3] = input[3]%5+1
                    = 1%5+1
                    = 1 + 1
                    = 2 
i = 4: Set input[4] = input[4]%5+1
                    = 4%5+1
                    = 4 + 1
                    = 5 
Hence original array is obtained as [2, 3, 3, 2, 5]




             
package com.ideserve.questions.saurabh;
 
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Given an array of length n having integers 1 to n with some elements being repeated.
 * Count frequencies of all elements from 1 to n. 
 *
 * @author Saurabh
 */
public class CountFrequencies {
 
    // O(n^2) time and O(1) space
    public static void countFrequenciesNaive(int[] input) {
        int n = input.length;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (input[j] == i) {
                    count++;
                }
            }
            System.out.println(i + " " + count);
        }
    }
 
    // O(n) time and O(n) space
    public static void countFrequencies(int[] input) {
        int n = input.length;
        int[] count = new int[n];
 
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
 
        for (int i = 0; i < n; i++) {
            count[input[i] - 1]++;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + count[i]);
        }
    }
 
    // O(n) time and O(1) space
    public static void countfrequenciesEfficient(int input[]) {
 
        int n = input.length;
        for (int i = 0; i < n; i++) {
            input[i]--;
        }
 
        for (int i = 0; i < n; i++) {
            input[input[i] % n] += n;
        }
 
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + input[i] / n);
            // Change the element back to original value
            input[i] = input[i] % n + 1;
        }
    }
 
    public static void main(String[] args) {
        int[] input = { 2, 3, 3, 2, 5 };
        countfrequenciesEfficient(input);
    }
}
        


















































