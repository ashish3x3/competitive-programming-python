


# https://www.hackerrank.com/challenges/strange-grid


'''
A strange grid has been recovered from an old book. It has  columns and infinite number of rows. The bottom row is considered as the first row. First few rows of the grid are like this:

..............

..............

20 22 24 26 28

11 13 15 17 19

10 12 14 16 18

 1  3  5  7  9

 0  2  4  6  8
The grid grows upwards forever!

Your task is to find the integer in th column in th row of the grid.

Input Format

There will be two integers r and c separated by a single space.

Constraints



Rows are indexed from bottom to top and columns are indexed from left to right.

Output Format

Output the answer in a single line.

Sample Input

6 3
Sample Output

25
Explanation

The number in the 6th row and 3rd column is 25.

'''

from __future__ import division

n, m = map(int, raw_input().strip().split(' '))

if n%2 == 0: #odd case
    res = (((int(n/2)-1)*10)+1) + 2*(m-1)
    print res 
else:  # even case
    res = (int((n-1)/2))*10 + 2*(m-1)
    print res