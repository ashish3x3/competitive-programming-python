

# https://www.hackerrank.com/challenges/coinage

from __future__ import division
import math,sys
from fractions import gcd
from collections import defaultdict


ways = []
ans = 0

def solve(N, A, B, C, D):
    ans = 0
    for b in xrange(B+1):
        if b*2 >N:
            break
        for a in xrange(A+1):
            if a+b*2 >N:
                break
            ways[a + b * 2]+=1
            
    for c in xrange(C+1):
        if c*5 >N:
            break
        for d in xrange(D+1):
            if c * 5 + d*10 >N:
                break
            ans +=ways[N - c * 5 - d * 10]
        
    return ans
    
T = input()
for t in range(T):
    N = input()
    ways = [0]*(N+1)
    ans = 0
    A, B, C, D = map(int, raw_input().split(' '))
    res = solve(N, A, B, C, D)
    print res
    

'''
# pass all
cache = dict()

def solve(n, one, two, five, ten):
    key = (n, one, two, five, ten)
    if key in cache: return cache[key]
    
    ans = 0
    # take 1 or more tens
    for t in range(1, ten + 1):
        if n - t * 10 >= 0:
            ans = ans + solve(n - t * 10, one, two, five, 0)
        else:
            break
            
    # take 1 or more fives and no tens
    for f in range(1, five + 1):
        if n - f * 5 >= 0:
            ans = ans + solve(n - f * 5, one, two, 0, 0)
        else:
            break
    
    # take 1 or more twos and no fives or tens
    for t in range(1, two + 1):
        if n - t * 2 >= 0:
            ans = ans + solve(n - t * 2, one, 0, 0, 0)
        else:
            break
    
    # pay all in ones
    if n <= one:
        ans = ans + 1
        
    cache[key] = ans
    # print key, ans
    return ans

T = int(raw_input())

for _ in range(0, T):
    n = int(raw_input())
    one, two, five, ten = map(int, raw_input().split())
    print solve(n, one, two, five, ten)

 '''   
    
'''
# will give TLE
m = {}

def ways(N, A, B, C, D):
    #print '*****************'
    #print 'N, A, B, C, D ',N, A, B, C, D
    #print m
    if (N, A, B, C, D) in m:
        #print '(N, A, B, C, D in m ',N, A, B, C, D
        return m[(N, A, B, C, D)]
    
    if N < 0 or A < 0 or B < 0 or C < 0 or D < 0:
        #print 'N, A, B, C, D < 0 ',N, A, B, C, D
        return 0
    elif N == 0:
        #print 'N == 0 ',N, A, B, C, D
        if (N, A, B, C, D) not in m:
            m[(N, A, B, C, D)] = 1
        else:
            return 0
    else:
        #print 'N != 0 ',N, A, B, C, D
        m[(N, A, B, C, D)] = (ways(N-1,A-1,B,C,D) + 
                                ways(N-2,A,B-1,C,D) +
                                ways(N-5,A,B,C-1,D) + 
                                ways(N-10,A,B,C,D-1))
    return m[(N, A, B, C, D)]

T = input()
for t in range(T):
    N = input()
    A, B, C, D = map(int, raw_input().split(' '))
    m = {}
    ways(N, A, B, C, D)
    s = 0
    for (N, A, B, C, D) in m.keys():
        if N == 0:
            s += 1
    print s
    
'''




'''
def getSol(N,a,b,c,d,count):
    print 'N,a,b,c,d,count ',N,a,b,c,d,count
    if N == 0:
        return 1
    if N < 0:
        return 0
    if d < 0 or c < 0 or b < 0 or a < 0:
        return 0
    #if d > 0:
    count[0]+= getSol(N-1,a-1,b,c,d,count)
    count[0]+= getSol(N-2,a,b-1,c,d,count)
    count[0]+= getSol(N-5,a,b,c-1,d,count)
    count[0]+= getSol(N-10,a,b,c,d-1,count)
    #if c > 0:
    
    #if b > 0:
    
    #if a > 0:
    
    return count[0]

T = int(raw_input())

for _ in xrange(T):
    N = int(raw_input())
    count = [0]
    a,b,c,d = map(int,raw_input().strip().split())
    res = getSol(N,a,b,c,d,count)
    print res
'''
'''
noms=[1,2,5,10]

def solve(N,coins):
    L=len(coins)
    if (N,L) in D:
        return D[(N,L)]
    if L==1:
        D[(N,1)]=coins[0]*noms[0]>=N and N%noms[0]==0
        return D[(N,1)]
    else:
        res=0
        for i in xrange(int(min(N/noms[L-1],coins[L-1]))+1):
            res+=solve(N-noms[L-1]*i,coins[:L-1])
        D[(N,L)]=res
        return res
        
T=input()
for case in xrange(T):
    N=input()
    D={}
    coins=map(int,raw_input().split())
    print solve(N,coins)
'''



