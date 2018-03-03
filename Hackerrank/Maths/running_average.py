
# https://www.hackerrank.com/challenges/filling-jars


# running average firmula :  https://www.hackerrank.com/challenges/filling-jars/topics

from __future__ import division
import math

N, M  = map(int, raw_input().strip().split(' '))

sum = 0
for _ in xrange(M):
    a, b, k  = map(int, raw_input().strip().split(' '))
    sum+= ((b-a)+1)*k
    
print int(math.floor(sum/N))
    
