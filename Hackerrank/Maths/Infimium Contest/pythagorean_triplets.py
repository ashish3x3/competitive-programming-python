# https://www.hackerrank.com/contests/infinitum18/challenges/pythagorean-triple

#!/bin/python

# http://www.friesian.com/pythag.htm
#from __future__ import division

#import sys, math

def solveTriplets(a):
    
    if a % 2 == 0:
        print a**2/4 - 1, a, a**2/4 + 1
    else:
        print a, (a**2 - 1)/2, (a**2 + 1)/2



def factors(n):
    results = set()
    for i in xrange(1, int(math.sqrt(n)) + 1):
        if n % i == 0:
            results.add(i)
            results.add(int(n/i))
    return results

def getTriplet(a):
    res = factors(int(a))
    #print 'res ',res
    if len(res) == 2:
        m,n = max(list(res)[0],list(res)[1]), min(list(res)[0],list(res)[1])
    else:
        m,n = max(list(res)[0],list(res)[1]), min(list(res)[0],list(res)[1])
        
    return [a, int(abs(m**2 - n**2)/2),int(abs(m**2 + n**2)/2)]

def pythagoreanTriple(n):
    if n%2 ==0:
        a = n
        b = (long(((n/2)**2)-1)) # (a/2)2 - 1
        c = b+2
        return [a,b,c]  
        #return [n, (long(n**2/4)-1), (long(n**2/4)+1)]
    else:
        a = n
        b = (long((n**2-1)/2)) #(a2 - 1) / 2
        c = b+1
        return [a,b,c]
        #return [n, long(math.floor(n**2/2)), long(n**2/2)+1]

a = int(raw_input().strip())
solveTriplets(a)
#triple = pythagoreanTriple(a)
#triple = getTriplet(a)
#sorted(triple)
#print " ".join(map(str, triple))

