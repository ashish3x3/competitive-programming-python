# https://www.hackerrank.com/contests/infinitum18/challenges/tower-3-coloring

#!/bin/python

import sys

mod = 10**9 + 7

import sys

def pwrMod(base, pwr, mod):
    res = 1
    while pwr > 0:
        if pwr % 2 == 1:
            res = res*base % mod
        base = base*base % mod
        pwr /= 2
    return res

def towerColoring2(n):
    pwr = pwrMod(3, n, 1000000006)
    return pwrMod(3, pwr, 1000000007)


def expmod(a,b,c):
    x = 1
    while(b>0):
        if(b&1==1): 
            x = (x*a)%c
        a=(a*a)%c
        b >>= 1
    return x%c

def towerColoring(n):
    #midRes = expmod(3,n,mod)    # n^r   # r=3^a  a=input()  n =3 (colors)  ; 3^3^a
    #res = expmod(3,midRes,mod)
    #exponent = pow(3, n, prime - 1)
    #return pow(3, exponent, prime)
    # print pow( 3, pow(3,n,M-1), M )
    mid = pwrMod(3, n, mod-1)
    res = pwrMod(3, mid, mod)
    return res%mod

n = int(raw_input().strip())
result = towerColoring(n)
print(result)
