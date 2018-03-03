

# https://www.hackerrank.com/challenges/sherlock-and-array
import sys

def solve(a):
    if len(a) == 1:
        return 'YES'
    for i in xrange(1,len(a)):
        #print a[0:i],'-- ',a[i+1:]
        #print sum(a[0:i]), sum(a[i+1:])
        if sum(a[0:i]) == sum(a[i+1:]):
            return 'YES'
        
    return 'NO'

def solve_opt(a):
    sum_r = sum(a)
    sum_l = a[0]
    
    if len(a) == 1:
        return 'YES'
    
    for i in xrange(1,len(a)):
        sum_l+=a[i-1]
        sum_r-=a[i]
        if sum_l == sum_r:
            return 'YES'
    
    
    return 'NO'
    
    
T = int(raw_input().strip())
for a0 in xrange(T):
    n = int(raw_input().strip())
    a = map(int, raw_input().strip().split(' '))
    result = solve_opt(a)
    print(result)

