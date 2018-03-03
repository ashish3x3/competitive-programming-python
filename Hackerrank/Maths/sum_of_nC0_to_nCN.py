# https://www.hackerrank.com/challenges/diwali-lights

'''
For n >= 1, derive the identity
nC0 + nC1 + nC2 + ... + nCn = 2^n
[Hint: Let a = b = 1 in the binomial theorem]

nCn = 1 and nC0 = 1.
nCr = nC(n - r)

'''

T = int(raw_input())

for _ in xrange(T):
    N = int(raw_input())
    print (2**N -1)%100000

