# https://www.hackerrank.com/challenges/sherlock-and-permutations

'''

We fix a 1 at the first position. Now we are left with M-1 1s and N 0s. Now we can just count unique permutations of (M-1) 1s and N 0s, which is choose((M+N-1), N), which is (M+N-1)!/(N! * (M-1)!). We calculate all factorials upto 2000 since M+N can go upto 2000 at max. We also compute inverse of all factorials modulo MOD. We can answer all queries in O(1) now. Modulo inverse as a concept can be read from here: 

2nd way:
Once we put a 1 at the first position, we next need to build a sequence of length M+N−1. Now each unique sequence can be described by which of its N locations contain a zero. Right? If I tell you the positions of all the zeroes, then you also know the positions of all the ones. OK, so of the M−N−1 positions in our sequence, let us select N of them to contain a zero. How many ways can we do that? (M+N−1  C N).

You might have noticed we can also specify a sequence by saying where the M−1 remaining ones go. What answer does that give you and why is it the same answer?

https://math.stackexchange.com/questions/1185176/counting-the-number-of-unique-permutations

'''
from math import factorial

def nCr(n, r):
    return factorial(n) // factorial(r) // factorial(n-r)


testcase = int(raw_input())

for x in range(testcase):
    n,m = map(int,raw_input().strip().split(' '))
    total = nCr(n+m-1, n)
    print(int(total%1000000007))












