

run the loop U will understand..
all we are doing is setting each value in array to true in sumnarr[] to true by running loop from sum .. >=currarrayelem... what this does is if no condition match in the end it will make sumarr[currelem] = true, later for other elem fro array, thy check if sumarr[j = sum...>=cureelem] = false and sumarr[j-currelem] = true, then amke sumarr[j] = true.. this way we will findthe match for sumarr[sum] when sumarr[sum-currelem] will be == true... check for array = [2,4,7,9] sum = 13,  ans = 9+4 

#=======================================================================
# Author: Isai Damier
# Title: Positive Subset Sum
# Project: geekviewpoint
# Package: algorithms
#
# Statement:
#   Given a sequence of n positive numbers totaling to T, check
#   whether there exists a subsequence totaling to x, where x is less
#   than or equal to T.
#
# Time-complexity: pseudo-polynomial: O(n*x)
# Space-complexity: O(x)
#
# Dynamic Programming Strategy:
#
#   Let's call the given Sequence S for convenience. Solving this
#   problem, there are two approaches we could take. On the one hand,
#   we could look through all the possible sub-sequences of S to see if
#   any of them sum up to x. This approach, however, would take an
#   exponential amount of work since there are 2^n possible
#   sub-sequences in S. On the other hand, we could list all the sums
#   between 0 and x and then try to find a sub-sequence for each one
#   of them until we find one for x. This second approach turns out to
#   be quite a lot faster: O(n*T). Here are the steps:
#
#   0] Create a boolean array called sum of size x+1:
#     As you might guess, when we are done filling the array, all the
#     sub-sums between 0 and x that can be calculated from S will be
#     set to true and those that cannot be reached will be set to false.
#     For example if S={2,4,7,9} then sum[5]=false while sum[13]=true
#     since 4+9=13.
#
#   1] Initialize sum{} to false:
#      Before any computation is performed, assume/pretend that each
#      sub-sum is unreachable. We know that's not true, but for now
#      let's be outrageous.
#
#   2] Set sum at index 0 to true:
#     This truth is self-evident. By taking no elements from S, we end
#     up with an empty sub-sequence. Therefore we can mark sum[0]=true,
#     since the sum of nothing is zero.
#
#   3] To fill the rest of the table, we are going to use the following
#     trick. Let S={2,4,7,9}. Then starting with 0, each time we find
#     a positive sum, we will add an element from S to that sum to get
#     a greater sum. For example, since sum[0]=true and 2 is in S, then
#     sum[0+2] must also be true. Therefore, we set sum[0+2]=sum[2]=true.
#     Then from sum[2]=true and element 4, we can say
#     sum[2+4]=sum[6]=true, and so on.
#
#  Step 3 is known as the relaxation step. First we started with an
#  absurd assumption that no sub-sequence of S can sum up to any
#  number. Then as we find evidence to the contrary, we relax our
#  assumption.
#
# Alternative implementation:
#   This alternative is easier to read, but it does not halt for small x.
#   In the actual code, each for-loop checks for "not sum[x]" since that's
#   really all we care about and should stop once we find it. Also
#   this time complexity is O(n*T) and space complexity is O(T)
#
#   sub_sum = [False] * ( x + 1 )
#   sum[0] = True
#   for a in A:
#     for i in range(sum(A), a-1,-1): # T = sum(A)
#       if not sum[i] and sum[i - a]:
#         sum[i] = True
#=======================================================================
  
 def positiveSubsetSum( A, x ):
    # preliminary
    if x < 0 or x > sum( A ): # T = sum(A)
      return False
 
    # algorithm
    sub_sum = [False] * ( x + 1 )
    sub_sum[0] = True
    p = 0
    while not sub_sum[x] and p < len( A ):
      a = A[p]
      q = x
      while not sub_sum[x] and q >= a:
        if not sub_sum[q] and sub_sum[q - a]:
          sub_sum[q] = True
        q -= 1
      p += 1
    return sub_sum[x]