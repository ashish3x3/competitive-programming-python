

http://www.geekviewpoint.com/java/dynamic_programming/subset_sum_multiple_supplies

All we are doing here is running a loop for each single element in array, and then crossing to true its multiple using j value as 0...sum..what is does if at end sumarr[sum] = true for any single elemt, it means that elmt can be used multiple times to go tot the number..hence found a sequence with multi select.. 

and thats y we have aded check with loop sumarr[sum] == false, sice once it is set to true by any individeal value fro array, we are done..

/*********************************************************************
 * Author: Isai Damier
 * Title: Subset Sum with Endless Supplies
 * Project: geekviewpoint
 * Package: algorithms
 *
 * Statement:
 *   Given a sequence S, with n positive numbers totaling to T, check
 *   whether there exists a subsequence totaling to x, where x is less
 *   than or equal to T. You may use any of the elements in S more than
 *   once.
 *
 * Time-complexity: pseudo-polynomial: O(n*x)
 * Space-complexity: O(x)
 * 
 * Dynamic Programming Strategy:
 * 
 *   We are not going to say too much here since this is essentially the
 *   "Positive Subset Sum" problem. So we will wait right here as you
 *   go read the "Positive Subset Sum" implementation.
 * 
 *   Okay. So there is one distinction between the two problems: here you
 *   may use each elements as many times as you need. So given the sequence
 *   S={2,8,24}, we can reach 6 as 2+2+2 or 20 as 8+8+2+2.
 * 
 *   To achieve this multiplicity, all we have to change is the direction
 *   of the nested for-loop so that we end up with:
 * 
 *     for(int e : S)
 *       for(int i=0; i<=x; i++)
 *         if(sum[i])
 *           sum[i+e]=true;
 * 
 *   The reason it's that simple is because the line "if(sum[i])" is
 *   most of the time looking at multiples. For instance, during the first
 *   pass of the outer for-loop (i.e. e=2), the second for-loop sets all
 *   multiples of 2 to true. Manually run the example where S={2,8,24}
 *   and x=18 if you still don't see it.
 **********************************************************************/
 package algorithm.programming.dynamic;
 
public class SubsetSumWithMultipleSupplies {
 
  public boolean subsetSumEndlessReuse(int[] S, int x) {
    //preliminary
    int T = 0;
    for (int e : S) {
      T += e;
    }
    if (x < 0 || x > T) {
      return false;
    }
    //algorithm
    boolean sum[] = new boolean[x + 1];
    sum[0] = true;
    for (int p = 0; !sum[x] && p < S.length; p++) {
      int e = S[p];
      for (int q = 0; !sum[x] && q <= x; q++) {
        if (q + e <= x && sum[q]) {
          sum[q + e] = true;
        }
      }
    }
    return sum[x];
  }
}