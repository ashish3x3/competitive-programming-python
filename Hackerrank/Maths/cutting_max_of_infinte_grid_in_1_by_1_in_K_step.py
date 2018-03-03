# https://www.hackerrank.com/challenges/halloween-party

'''
Alex is attending a Halloween party with his girlfriend, Silvia. At the party, Silvia spots the corner of an infinite chocolate bar (two dimensional, infinitely long in width and length).

If the chocolate can be served only as 1 x 1 sized pieces and Alex can cut the chocolate bar exactly  times, what is the maximum number of chocolate pieces Alex can cut and give Silvia?

Input Format 
The first line contains an integer , the number of test cases.  lines follow.
Each line contains an integer .

Output Format
 lines; each line should contain an integer that denotes the maximum number of pieces that can be obtained for each test case.

Constraints



Note: Chocolate must be served in 1 x 1 sized pieces. Alex can't relocate any of the pieces, nor can he place any piece on top of another.

Sample Input #00

4
5
6
7
8
Sample Output #00

6
9
12
16
Explanation
The explanation below is for the first two test cases. The rest of them follow a similar logic.

For the first test-case where , you need  horizontal and  vertical cuts.
halloweenboard For the second test case, where , you need  horizontal and  vertical cuts.
'''

from __future__ import division
import math

T = int(raw_input())

for _ in xrange(T):
    N = int(raw_input())
    if N%2 == 0:
        print int(N/2)*int(N/2)
    else:
        m = int(math.ceil(N/2))
        print m*(N-m)