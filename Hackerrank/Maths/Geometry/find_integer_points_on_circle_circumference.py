
# https://www.hackerrank.com/challenges/circle-city/problem

'''
Iterate over all possible values of one axis, then calulate the corresponding value on the other axis using Pythagorean theorem. For example, for all possible integer x  co ordinates, calculate the corresponding y  co ordinate which lies upon the city's border. Then check if (x,y)  is a lattice point or not. If yes, we found a suburb which is on the city's border and thus, unprotected. There are another 3 suburbs symmetric to (x,y)  inside other 3 quadrants.
After calculating the total number of unprotected suburbs, check if  police stations are enough to protect them.

Complexity:
time complexity is O(sqrt(N))

space complexity is O(1)

Execution:
You have to solve the circle equation M^2 + N^2 = D where M and N are integral numbers.

'''
import sys,math

def solve(R,K):
    count = 0
    for m in xrange(int(math.ceil(math.sqrt(R)))):
        if math.sqrt(R - m*m).is_integer():
            count += 4
     
    if count <= K:
        return 'possible'
    
    return 'impossible'
            
T = int(raw_input())
for _ in xrange(T):
    r,k = map(int, raw_input().strip().split(' '))
    print solve(r,k)