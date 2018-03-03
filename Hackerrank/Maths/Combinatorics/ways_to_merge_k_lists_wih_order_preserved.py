# https://www.hackerrank.com/challenges/merge-list



# https://math.stackexchange.com/questions/382174/ways-of-merging-two-incomparable-sorted-lists-of-elements-keeping-their-relative
#https://math.stackexchange.com/questions/1065374/in-how-many-ways-can-i-merge-m-and-n-items-without-disturbing-the-order-in-e


'''
answer is (n+m)! / n! /m! ... explanation is the following... first of all,total cases is (n+m)! .. considering that item comes from two group and the sequence is fixed, we have to divide the total cases by n! and m!..
this is equal to n+mCn .. it is hard to compute for large number for normal programming language .. some trick is needed to go through .. in the previous problem we already had experience on processing nCr for large number :)
hint)) use combination table

'''
import sys
from math import factorial
mod = 10**9 + 7

def getfactorialmod(b):
    val = 1
    for i in range(1,b+1):
        val = (val*i)%mod
    return val
    

T = int(raw_input())

for _ in xrange(T):
    a,b = map(int,raw_input().strip().split())
    '''
    here a%mod//b%mod not equal to a/b % mod.. so we have to calculate complete factorial and then at last find mod
    '''
    # both works
    #res = factorial(a+b)//factorial(a)//factorial(b)       
    res = factorial(a+b)//(factorial(a)*factorial(b))
    print res%mod




###############################################################

def c(n, k):
    res = 1
    for i in range(k):
        res = res * (n - i) // (i + 1)
    return res

n = int(raw_input())
for _ in range(n):
    a = list(map(int, raw_input().split()))
    print c(a[0] + a[1], a[0]) % 1000000007

#####################################################################


N = 201
MOD = 10**9+7

c = [[0] * N for _ in xrange(N)]
for i in xrange(N):
    c[i][0] = c[i][i] = 1
    for j in xrange(1, i):
        c[i][j] = (c[i-1][j-1] + c[i-1][j]) % MOD

t = int(raw_input())
for _ in xrange(t):
    n, m = map(int, raw_input().split())
    print c[n+m][n]



###############################################################


# Enter your code here. Read input from STDIN. Print output to STDOUT
from sys import stdin
fa = [1]
hi = 10**9+7
for i in xrange(1,300):
    fa.append((i*fa[i-1]))
x = int(stdin.readline())
a = stdin.readlines()
for i in a:
    x,y = i.split()
    x = int(x);y=int(y);
    print (fa[x+y]/(fa[x]*fa[y]))%(10**9+7)































