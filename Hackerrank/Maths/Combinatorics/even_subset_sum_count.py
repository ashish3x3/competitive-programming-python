
'''
I think there's an error in the last testcase(rest all are correct for me) the I/P is: 10 2 2 2 2 2 2 2 2 2 2 hence the answer should be 2^(n-1) -1 =2^9 -1= 511, but is given as 1023 which is 2^10 -1?! Atleast my logic is working with all other cases so there's definitely some problem with this one!

Your logic works only when there is at least one odd number, if the numbers are all even then any non empty subset will make it, so you'll get 2^10-1

You can make it even simpler. Some quick algebra will reduce your solution to:
2^(even) * 2^(odd-1) - 1
This answer makes sense combinatorially, too.

Maths explained
https://github.com/jiadar/java/blob/master/ross/tex/ChocolateFiesta.pdf


'''


# https://www.hackerrank.com/challenges/a-chocolate-fiesta

from __future__ import division
import math,sys
from fractions import gcd
from collections import defaultdict
mod = 10**9 + 7


def subsets(nums):
    if nums is None: 
        return None
    subsets = [[]] 
    next = [] 
    for n in nums:
        for s in subsets:
            next.append(s + [n])
            #print 'next ',next
        subsets += next
        #print 'subsets ',subsets
        next = []
    cnt = 0
    for l in subsets:
        if (sum(l)%mod)%2 == 0:
            #print l
            cnt+=1;
            cnt = cnt%mod
    return cnt-1

T = int(raw_input())
A = list(map(int,raw_input().strip().split(' ')))
#print subsets(A)
even,odd = 0,0
for a in A:
    if a%2 == 0:
        even+=1
    else:
        odd+=1
        
if even!=0 and odd !=0:
    print (pow(2,len(A)-1,mod)-1)%mod
else:
    print (pow(2,len(A),mod)-1)%mod
#print pow(2,len(A)-1,mod) -1

