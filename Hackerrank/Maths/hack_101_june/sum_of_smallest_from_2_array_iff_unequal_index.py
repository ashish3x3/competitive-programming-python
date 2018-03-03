# https://www.hackerrank.com/contests/w33/challenges/twin-arrays/problem

import sys

def two_smallest(numbers):
    m1, m2 = float('inf'), float('inf')
    for x in numbers:
        if x <= m1:
            m1, m2 = x, m1
        elif x < m2:
            m2 = x
    return m1,m2

def twinArrays(ar1, ar2):
    a1,a2 = two_smallest(ar1)
    b1,b2 = two_smallest(ar2) 
    i1 = ar1.index(a1)
    i2 = ar2.index(b1)
    if i1 == i2:
        r = min(a1+b2,b1+a2)
        return r
    return a1+b1
        
    

n = int(raw_input().strip())
ar1 = map(int, raw_input().strip().split(' '))
ar2 = map(int, raw_input().strip().split(' '))
result = twinArrays(ar1, ar2)
print(result)
