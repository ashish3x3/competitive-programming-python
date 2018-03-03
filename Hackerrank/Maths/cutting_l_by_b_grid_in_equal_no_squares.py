# https://www.hackerrank.com/challenges/restaurant

'''

Martha is interviewing at Subway. One of the rounds of the interview requires her to cut a bread of size  into smaller identical pieces such that each piece is a square having maximum possible side length with no left over piece of bread.

Input Format

The first line contains an integer .  lines follow. Each line contains two space separated integers  and  which denote length and breadth of the bread.

Constraints

Output Format

 lines, each containing an integer that denotes the number of squares of maximum size, when the bread is cut as per the given condition.

Sample Input 0

2
2 2
6 9
Sample Output 0

1
6
Explanation 0

The 1st testcase has a bread whose original dimensions are , the bread is uncut and is a square. Hence the answer is 1. 
The 2nd testcase has a bread of size . We can cut it into 54 squares of size , 6 of size . For other sizes we will have leftovers. Hence, the number of squares of maximum size that can be cut is 6.

'''


from __future__ import division

def getGCD(n, m):
    if m == 0:
        return n
    else:
        return getGCD(m, n%m)

T = int(raw_input())

for _ in xrange(T):
    n, m = map(int, raw_input().strip().split(' '))
    
    if n == m:
        print 1
    elif n == 1:
        print m
    elif m == 1:
        print n
    else:
        gcd = getGCD(n, m)
        #print gcd
        res = int((n*m)/(gcd*gcd))
        print res