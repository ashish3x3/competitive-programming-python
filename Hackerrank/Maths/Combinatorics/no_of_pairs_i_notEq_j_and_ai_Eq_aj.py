# https://www.hackerrank.com/challenges/sherlock-and-pairs/problem


from collections import defaultdict
import math,sys
from math import factorial


def solve(arr):
    mp = defaultdict(list)
    
    for idx,elem in enumerate(arr):
        if elem in mp:
            mp[elem].append(idx)
        else:
            mp[elem] = [idx]

    #print mp      
    cnt = 0
    for key, value in mp.iteritems():
        if len(value) > 1:
            l = len(value)
            #cnt+= (factorial(long(len(value)))//factorial(long(len(value))-2))
            # this works because in nP2, only first 2 values wil get multiplied ,others will get cancled
            cnt+= (l*(l-1))
    return cnt
        
            
T = int(raw_input())

for _ in xrange(T):
    N = int(raw_input())
    ar = list(map(int, raw_input().strip().split(' ')))
    print solve(ar)













########################################################


T = input()
for t in xrange(T):
    N = input()
    A = map(int, raw_input().split())
    c = {}
    res = 0
    for x in A:
        if x not in c:
            c[x] = 0
        res += c[x]
        c[x] += 1
    print 2*res