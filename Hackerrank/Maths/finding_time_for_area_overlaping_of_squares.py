# https://www.hackerrank.com/challenges/sherlock-and-moving-tiles

'''
Sherlock is given  square tiles, initially both of whose sides have length  placed in an  plane; so that the bottom left corner of each square coincides with the the origin and their sides are parallel to the axes.

At , both squares start moving along line  (along the positive  and ) with velocities  and .

For each query of form , Sherlock has to report the time at which the overlapping area of tiles is equal to qi.

Note: Assume all distances in meter, time in seconds and velocities in meter per second unless otherwise specified.

Input Format 
First line contains integers . Next line contains , the number of queries. Each of the next  lines consists of one integer  in one line.

Constraints 
 
 
 

Output Format 
For each query, print the required answer in one line. Your answer will be considered correct if it is at most away from the true answer. See the explanation for more details.

Sample Input

10 1 2
2
50
100
Sample Output

4.1421
0.0000
Explanation

For the first case, note that the answer is around 4.1421356237..., so any of the following will be accepted:

4.1421356237
4.14214
4.14215000
4.1421
4.1422

'''

# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys 
import math
par = [int(i) for i in raw_input().strip().split(' ')] 
Q = int(input())
for j in range(0,Q): 
    Aq = int(raw_input()) 
    t = float((math.sqrt(2)*(par[0]-math.sqrt(Aq)))/(abs(par[1]-par[2])))
    print format(t, '.20f')