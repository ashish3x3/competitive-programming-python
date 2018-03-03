
# https://www.hackerrank.com/challenges/game-with-cells

'''
Luke is daydreaming in Math class. He has a sheet of graph paper with  rows and  columns, and he imagines that there is an army base in each cell for a total of  bases. He wants to drop supplies at strategic points on the sheet, marking each drop point with a red dot. If a base contains at least one package inside or on top of its border fence, then it's considered to be supplied. For example:

image

Given  and , what's the minimum number of packages that Luke must drop to supply all of his bases?

Input Format

Two space-separated integers describing the respective values of  and .

Constraints

Output Format

Print a single integer denoting the minimum number of supply packages Luke must drop.

Sample Input 0

2 2
Sample Output 0

1
Explanation 0

Luke has four bases in a  grid. If he drops a single package where the walls of all four bases intersect, then those four cells can access the package:

image

Because he managed to supply all four bases with a single supply drop, we print  as our answer.

'''

'''
1 2 = 1
1 4 = 2
2 5 = 2*(4+1) = 2 * 4 + 2*1
5 2 = (1+4)* 2 = 4*2 + 1*2

so we perform n1 = m and m1= n ..cross initialize...bcz in 7*2 grid, 6*2 is coverd remaining is 1*2 =2(count will be 1*2/2) and 7*1=7(count will be 7*1/2 which was earlier logic i.e over counting).... we initialize remaing m to n1 and remainign m1 to n to make sure row and column is not getting over counted..
'''

'''
editorial:
It's not hard to see from example that the most optimal way is to put bombs in in corners(crossings) because in this case bomb covers 4 adjacent cells. If the bomb is not in a corner, but in the middle of some edge then we can move it to some corner and it still will cover this cell and maybe some new. So we each point in the crossings covers 2 cells horizontally and 2 cells vertically, so the answer equals n/2 * m/2
Be carefull about priority of operations (don't forget brackets) if you are using C, C++ because it may compute  as  which is not always the same (of course we are talking about integer division).

'''


#!/bin/python
from __future__ import division

import sys
import math


n,m = raw_input().strip().split(' ')
n,m = [int(n),int(m)]
res = 0
n1, m1 = 0, 0
n2, m2 = n, m

if n == 1:
    print int(math.ceil(m/2))
    
elif m ==1:
    print int(math.ceil(n/2))

else:
    if n%2 != 0:
        n1 = m
        n2 = n-1
    if m%2 !=0:
        m1= n
        m2 = m-1
    #print n,m
    #print n1,m1
    #print float(math.ceil(n1/2))
    #print math.floor(m1//2)
    res+= ((n2*m2)/4) + int(math.ceil(n1/2)) + int(math.floor(m1/2))

    print int(res)
