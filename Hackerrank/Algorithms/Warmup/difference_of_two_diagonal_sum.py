#https://www.hackerrank.com/challenges/diagonal-difference

import sys

def solve(a):
    sum_d1 = 0
    sum_d2 = 0
    
    for i in xrange(len(a)):
        sum_d1+= a[i][i]
        sum_d2+= a[i][n-1-i]
    #print 'res ' ,abs(sum_d1 - sum_d2 )   
    return abs(sum_d1 - sum_d2 )


n = int(raw_input().strip())
a = []
for a_i in xrange(n):
    a_temp = map(int,raw_input().strip().split(' '))
    a.append(a_temp)
print solve(a)
