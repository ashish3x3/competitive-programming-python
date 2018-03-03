# https://www.hackerrank.com/contests/infinitum18/challenges/count-solutions/copy-from/1302022563
'''
Alright, to solve this problem, we can simply iterate over the value of . Say we are iterating with a variable . Now we can solve a quadratic in :
We can simply used the quadratic formula here, to check if the roots meet our conditions and are distinct.

'''


#!/bin/python

import sys

def bruto(a, b, c, d):
    res = 0
    for x in range(1, c + 1):
        for y in range(1, d + 1):
            if x * x + y * y == x * a + y * b:
                res += 1
    return res

sq = {}
for i in range(10 ** 6):
    sq[i * i] = i

def countSolutions2(a, b, c, d):
    sols = set()
    for x in range(1, c + 1):
        u = b * b - 4 * x * (x - a)
        if u in sq:
            v = sq[u]
            if b % 2 == v % 2:
                y = (b + v) / 2
                if y >= 1 and y <= d:
                    sols.add((x, y))
                y = (b - v) / 2
                if y >= 1 and y <= d:
                    sols.add((x, y))
    return len(sols)

#ax^2+bx+c=0 
def solve_quadratic(a,b,c):
    d = b**2 - 4*a*c

    if d > 0:
        sd = d**(0.5)
        return [-(b+sd)/(2*a), -(b-sd)/(2*a)]
    elif d == 0:
        return [-b/(2*a)]
    return []

def countSolutions(a, b, c, d):
    count = 0
    for x in xrange(1,c+1):  # a <= c 
        #solve the quadratic equation and verify the solutions O(c) computations
        
        # b^2 -b.k + i^2 -i.n = 0 ; change n to x and i to a fir iteratng for 'a' as 'i'
        # 1y^2 - ky + x^2 - xa ; a= 1, b = -1
        sols = solve_quadratic(1, -b, x*x-a*x)  
        print sols
        sols = map(round, sols)
        if len(sols)==2 and sols[1]==sols[0]:
            sols=sols[:-1]
            
        for s in sols:
            if s > 0 and s<=d:
                count += int((x**2 + s**2) == (x*a + s*b))
    return count
        

q = int(raw_input().strip())
for a0 in xrange(q):
    a, b, c, d = raw_input().strip().split(' ')
    a, b, c, d = [int(a), int(b), int(c), int(d)]
    result = countSolutions(a, b, c, d)
    print(result)
