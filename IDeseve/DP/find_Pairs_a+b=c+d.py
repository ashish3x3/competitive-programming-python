


http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/

Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) such that a+b = c+d, and a, b, c and d are distinct elements. If there are multiple answers, then print any of them.

Example:

Input:   {3, 4, 7, 1, 2, 9, 8}
Output:  (3, 8) and (4, 7)
Explanation: 3+8 = 4+7

Input:   {3, 4, 7, 1, 12, 9};
Output:  (4, 12) and (7, 9)
Explanation: 4+12 = 7+9

Input:  {65, 30, 7, 90, 1, 9, 8};
Output:  No pairs found
Expected Time Complexity: O(n2)


# Java Program to find four different elements a,b,c and d of
# array such that a+b = c+d
 
# function to find a, b, c, d such that
# (a + b) = (c + d)
def findPairs(arr, n):
 
# Create an empty hashmap to store mapping 
# from sum to pair indexes
Hash = {}
 
# Traverse through all possible pairs of arr[]
for i in range(n - 1):
    for j in range(i + 1, n):
    sum = arr[i] + arr[j]
    # Sum already present in hash
    if sum in Hash.keys():
        # print previous pair and current
        prev = Hash.get(sum)
        print (str(prev) + " and (%d, %d)"
        %(arr[i], arr[j]))   
        return True
    else:
        # sum is not in hash
        # store it and continue to next pair
        Hash[sum] = (arr[i], arr[j])
return False
 
# driver program
arr = [3, 4, 7, 1, 2, 9, 8]
n = len(arr)
findPairs(arr, n)





1) Extend the above solution with duplicates allowed in array.
2) Further extend the solution to print all quadruples in output instead of just one. And all quadruples should be printed printed in lexicographical order (smaller values before greater ones). Assume we have two solutions S1 and S2.

S1 : a1 b1 c1 d1 ( these are values of indices int the array )  
S2 : a2 b2 c2 d2

S1 is lexicographically smaller than S2 iff
  a1 < a2 OR
  a1 = a2 AND b1 < b2 OR
  a1 = a2 AND b1 = b2 AND c1 < c2 OR 
  a1 = a2 AND b1 = b2 AND c1 = c2 AND d1 < d2 