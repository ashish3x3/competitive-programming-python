




https://www.youtube.com/watch?v=MUjOEJLtm6Y&index=11&list=PLyEvk8ZeQDMVbsg7CEfT0NV3s3GkMx1vN
http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

# Python program to find maximum contiguous subarray

The implementation handles the case when all numbers in array are negative.
Drawback of kadane is it looks for positive sum in the array..in case of all negative array,it may fail without any additional modification.. see below this algo for kadane impl..
 
def maxSubArraySum(a,size):
     
    max_so_far =a[0]
    curr_max = a[0]
     
    for i in range(1,size):
        curr_max = max(a[i], curr_max + a[i])
        max_so_far = max(max_so_far,curr_max)
         
    return max_so_far
 
# Driver function to check the above function 
a = [-2, -3, 4, -1, -2, 1, 5, -3]
print"Maximum contiguous sum is" , maxSubArraySum(a,len(a))




By Kadane Algo:
Explanation:
Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far


# Python program to find maximum contiguous subarray
  
# Function to find the maximum contiguous subarray
from sys import maxint
def maxSubArraySum(a,size):
      
    max_so_far = -maxint - 1
    max_ending_here = 0
      
    for i in range(0, size):
        max_ending_here = max_ending_here + a[i]
        if (max_so_far < max_ending_here):
            max_so_far = max_ending_here
 
        if max_ending_here < 0:
            max_ending_here = 0  
    return max_so_far
  
# Driver function to check the above function 
a = [-13, -3, -25, -20, -3, -16, -23, -12, -5, -22, -15, -4, -7]
print "Maximum contiguous sum is", maxSubArraySum(a,len(a))