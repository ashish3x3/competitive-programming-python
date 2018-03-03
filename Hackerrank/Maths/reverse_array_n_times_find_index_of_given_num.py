#!/bin/python

# https://www.hackerrank.com/challenges/reverse-game

'''
Akash and Akhil are playing a game. They have  balls numbered from  to . Akhil asks Akash to reverse the position of the balls, i.e., to change the order from say, 0,1,2,3 to 3,2,1,0. He further asks Akash to reverse the position of the balls  times, each time starting from one position further to the right, till he reaches the last ball. So, Akash has to reverse the positions of the ball starting from  position, then from  position, then from position and so on. At the end of the game, Akhil will ask Akash the final position of any ball numbered . Akash will win the game, if he can answer. Help Akash.

Input Format 
The first line contains an integer , i.e., the number of the test cases. 
The next  lines will contain two integers  and .

Output Format 
Print the final index of ball  in the array.

Constraints 
 
 

Sample Input

2
3 1
5 2
Sample Output

2
4
Explanation 
For first test case, The rotation will be like this: 
0 1 2 -> 2 1 0 -> 2 0 1 -> 2 0 1
So, Index of 1 will be 2.

'''

'''
After swapping N times the array takes a special pattern of [0,n-1],[1,n-2],[2,n-3]...
for eg. N =5
      0 1 2 3 4 
n=1   4 3 2 1 0
n =2  4 0 1 2 3
n=3   4 0 3 2 1
n=4   4 0 3 1 2
n=5   4 0 3 1 2  of pattern [n-1,0, n-2,1, n-3,2 ....]

now it's all about calculating the pattern using code..
'''

import sys

t = int(raw_input().strip())


res = 0
for _ in xrange(t):
    n,k = raw_input().strip().split(' ')
    n,k = [int(n),int(k)]
    if (2*k+1) > (n-1):
        res = (n-1) - (2*k+1-(n-1)) + 1
        print res
    else:
        print 2*k+1
