# Enter your code here. Read input from STDIN. Print output to STDOUT


 '''
Given an array  consisting of  elements and an integer . Count the number of subarrays of array  which has maximum element greater than K.

Count the total number of subarrays which has maximum element ≤ K. Lets call this count X.
Subtract the above count  X from the total number of subarrays i.e ((N*(N+1))/2)      .

Chase in this question is to calculate the value of  which can be easily calculated by removing 
all the elements > K  from the array A  and counting the total number of subarrays form from the elements left in the array A.

Author's solution makes use of the approach described above.


A[1,2,3]
It has 6 subarrays :

{1}, {2}, {3}, {1,2}, {2,3}, {1,2,3}
I think that for a vector of N elements the total number of subarrays is N*(N+1)/2.
https://math.stackexchange.com/questions/1194584/the-total-number-of-subarrays


'''





t = int(raw_input())
for _ in range(t):
    n,k = map(int,raw_input().split())
    vs = map(int,raw_input().split())
    c = n*(n+1)/2
    cx = 0
    for x in vs:
        if x <= k:
            cx += 1
        else:
            c -= cx*(cx+1)/2
            cx = 0
    c -= cx*(cx+1)/2
    print c





T = input() 

for _ in range(T): 
    n, K = map(int, raw_input().split()) 
    nums = map(int, raw_input().split()) 

    dp = [(i if nums[i] > K else -1) for i in range(n)] 

    for i in range(1, n): 
        if dp[i] == -1: 
            dp[i] = dp[i-1]

    cnt = 0
    for i in range(n): 
        if dp[i] != -1: 
            cnt += dp[i] + 1

    print cnt



Complexity:
time complexity is O(N)

space complexity is O(1)

Execution:
You do not actually need to construct all the sub-arrays, as they reduce to only one element. You also can ignore all sub-arrays, that do not contain elements E > K. I also observed that there are x*y sub-arrays that match the above specified criteria for each element E > K. X is the distance from E to any previous e > K. Y is the distance from E to the end of the array. This way you crate all the sub-arrays that contain E and are not part of another e.

Solution:

#!/usr/bin/py
def numberList(a ,k):
    result = 0
 
    last_biggest = -1
    a_len = len(a)
 
    for idx in xrange(a_len):
        if a[idx] > k:
            result += (idx-last_biggest)*(a_len-idx)
            last_biggest = idx
 
    return result
 
if __name__ == '__main__':
    t = int(raw_input())
    for _ in xrange(t):
        n,k = map(int, raw_input().split())
        a = map(int, raw_input().split())
        print numberList(a ,k)