
# https://www.hackerrank.com/challenges/leonardo-and-prime


'''
Leonardo loves primes and created  queries where each query takes the form of an integer, . For each , he wants you to count the maximum number of unique prime factors of any number in the inclusive range  and then print this value on a new line.

Note: Recall that a prime number is only divisible by  and itself, and  is not a prime number.

Input Format

The first line contains an integer, , denoting the number of queries. 
Each line  of the  subsequent lines contains a single integer, .

Constraints

Output Format

For each query, print the maximum number of unique prime factors for any number in the inclusive range  on a new line.

Sample Input

6
1
2
3
500
5000
10000000000
Sample Output

0
1
1
4
5
10
Explanation

The maximum number of unique prime factors of any number in the inclusive range  is , because  is not prime and its only factor is itself.
The maximum number of unique prime factors of any number in the inclusive range  is . We already know that the number  has  prime factors, but  has  prime factor (itself).
The maximum number of unique prime factors of any number in the inclusive range  is . The number  has  prime factor (itself), and we already know that the number  has  prime factor and the number  has  prime factors.
The maximum number of unique prime factors in the inclusive range  is . The product of our first four unique primes is , and there are no additional unique primes we can multiply that number by that results in a value .

'''








from __future__ import division
import math

def sieve(N):   # N will be sqrt(Real_N) i.e N = 10, then sqrt(N) will be 3
    yield 2
    D, q = {}, 3
    while q <= N:
        p = D.pop(q, 0)
        if p:
            x = q + p
            while x in D: x += p
            D[x] = p
        else:
            yield q
            D[q*q] = 2*q
        q += 2
    raise StopIteration


def prime_num_between_gen(end):
    
    if end == 2:
        return 1
    
    res=1
    count = 0
    limit = int(math.floor(math.sqrt(end))) + 1
    #print limit
    prime = sieve(int(math.sqrt(end)))
    
    for p in prime:
        if res*p<=end:
            count+=1
            res*=p
        else:
            return count
    
    low = limit
    high = 2*limit
    
    while low < end:
        mark = [True] * (limit+1)
        for p in prime:
            lo_lim = int(math.floor((low/p)))*p

            for j in xrange(lo_lim, high, p):
                mark[j - low] = False

        for k in xrange(low, high):
            #print k
            if mark[k - low] == True:
                if res*k<=end:
                    count+=1
                    res*=k
                else:
                    return count
                    
        low = low+limit
        high = high+limit
        if high >= end:
            high = end
            
    return count
            

test_cases = int(input())

while test_cases > 0:
    test_cases = test_cases-1
    n = int(raw_input())
    print prime_num_between_gen(n)



