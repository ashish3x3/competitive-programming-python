# https://www.hackerrank.com/challenges/chocolate-feast/problem
#from __future__ import division

'''

1
60217 144 24

436
'''

import sys
from math import ceil


t = int(raw_input().strip())
for a0 in xrange(t):
    n,c,m = raw_input().strip().split(' ')
    n,c,m = [int(n),int(c),int(m)]
    cnt = 0
    c1 = int((n/c))
    c2 = c1 
    cnt+= c1
    if c2 >= m:
        while c2 != 0 and c2 >= m:
            if c2 == m:
                cnt+= 1
                break
            elif c2 == 1:
                cnt+= 1
                break
            cnt+= int((c2/m))
            c2 = int((c2/m)) + (c2%m)
            
    print cnt

'''
#!/bin/python
#from __future__ import division

import sys
from math import ceil


t = int(raw_input().strip())
for a0 in xrange(t):
    n,c,m = raw_input().strip().split(' ')
    n,c,m = [int(n),int(c),int(m)]
    eaten = wraps = n/c
    while wraps >= m:
        newEat = wraps/m
        eaten = eaten+newEat
        wraps = wraps%m
        wraps+= newEat
            
    print eaten




int eatenChocolades(int availableCash, int price, int wrapperDiscount){
    int eaten = 0;
    int wraps = 0;
     
    wraps = eaten = availableCash/price;
     
    while (wraps >= wrapperDiscount){
        int newlyEaten = wraps/wrapperDiscount;
        eaten += newlyEaten;
        wraps %= wrapperDiscount;
        wraps += newlyEaten;
    }
     
     
    return eaten;
}

'''