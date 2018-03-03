
# https://www.hackerrank.com/challenges/summing-the-n-series

'''
This is basically a sum of odd number series
n^2 - (n-1)^2 ==> 2n-1 which is odd number series
direct formula for sum of odd number upto N is N^2
ref  http://www.9math.com/book/sum-first-n-odd-natural-numbers
'''

def sumOfOdd(n):
    res = 0
    for i in xrange(1, n+1, 2):
        res+=i
    return res
    
    
    
    
T = int(raw_input())

for _ in xrange(T):
    N = int(raw_input())
    #N = 2*N-1
    # print sumOfOdd(N) # timeout
    print (N*N)%1000000007