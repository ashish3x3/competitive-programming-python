

# https://www.hackerrank.com/challenges/find-point

'''
Consider two points,  and . We consider the inversion or point reflection, , of point  across point  to be a  rotation of point  around .

Given  sets of points  and , find  for each pair of points and print two space-separated integers denoting the respective values of  and  on a new line.

Input Format

The first line contains an integer, , denoting the number of sets of points. 
Each of the  subsequent lines contains four space-separated integers describing the respective values of , , , and  defining points  and .

Constraints

Output Format

For each pair of points  and , print the corresponding respective values of  and  as two space-separated integers on a new line.

Sample Input

2
0 0 1 1
1 1 2 2
Sample Output

2 2
3 3
Explanation

The graphs below depict points , , and  for the  points given as Sample Input:

find-point-0011.png
Thus, we print  and  as 2 2 on a new line.
find-point-1122.png
Thus, we print  and  as 3 3 on a new line.
'''

# Enter your code here. Read input from STDIN. Print output to STDOUT
N = int(raw_input())

for _ in xrange(N):
    Px, Py, Qx, Qy = map(int, raw_input().strip().split(' '))

    # transform asix (x,y) --> (x-h,y-k) if (h,k) is new origin
    newPx = Px-Qx
    newPy = Py-Qy

    # roatating by 180 (x,y)-->(-x,-y)
    t_Px = -newPx
    t_Py = -newPy

    # final ansewer (transformed t_Px,t_Py) --> (t_Px + h, t_Py+k) if (h,k) is new origin
    print t_Px+Qx, t_Py+Qy
