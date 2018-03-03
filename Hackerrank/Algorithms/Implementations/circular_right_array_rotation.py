# https://www.hackerrank.com/challenges/circular-array-rotation/problem

'''
Here is the trick. We will consider 2 cases, 1st is  when k<m and 2nd is when k>m, you will get to know why we are considering these two cases as we go on.
Let the input parameters be n, k=4 and m=5, so the numbers would be (1,2,3,4,5,6,7,8,9...n-1,n) keep note of the number at index m-k (i.e. at index 1). Now after  k=4  rotations  the resulting numbers will be (n-3,n-2,n-1,n,1,2,3,4 ...n-5,n-4). Note that the current number at index m=5(which in this case is 2) was at an index  1 (i.e. at m-k). So we can directly find the element at index m=5 without actually rotating the array by outputting the element at index (m-k).
Now let k=4 and m=3. In this case the number that is at index m=3 was actually at an index (n-k+m). Here also we can find the element at m=3 without rotating the array by outputting the element at index (n-k+m).
In case you are wondering what about the case when k>n well we can tackle that by using the mod(%) operator.For those of you who do not know how mod(%) operator works. Basically it returns the remainder, let k=r%n, so if rotation(i.e. r) is greater than n, due to the mod(%) operator the value of k will be remainder of r/n. e.x. if r=9, n=6 than k=3 and if r is multiple of n i.e. if r=5,10,15,20..... and n=5 than k=0 after the operation.
Here is my code.

The element at the i th position moves right k times: (i+k)
When we reach the last index of the array we need to go back to first index and that is what we are doing with %n.
'''

import math,sys

def roatedArray(arr,k):
    newArr = []
    for _ in xrange(k):
        arr = [arr[-1]] + arr[:-1]
    #print arr
    
    return arr
    

n,k,q = map(int,raw_input().strip().split(' '))
arr = list(map(int,raw_input().strip().split(' ')))
#arr = roatedArray(arr,k)
k = k%n

for _ in xrange(q):
    m = int(raw_input())
    j = m-k
    print arr[j]
    #if j<0:
     #   print arr[n+j]
    #else:
     #   print arr[j]
    #print arr[]


