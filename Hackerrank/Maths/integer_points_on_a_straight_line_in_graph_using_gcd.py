


# https://www.hackerrank.com/challenges/harry-potter-and-the-floating-rocks

'''
Famous wizard Sumar moonji kumaru is stuck in a huge room and has to save Hermione Granger from a monster. Kumaru is at location P1 given by integral coordinates (x1,y1) and Hermione is at location P2 given by integral coordinates (x2,y2). Sadly P1 and P2 are the only points at which floating rocks are present. Rest of the room is without floor and underneath is hot lava.

Kumaru has to go from P1 to P2 but there are no floating rocks to walk on. Kumaru knows a spell that can make the rocks appear but only on the integral coordinates on the straight line joining P1 and P2.

How many rocks can appear at locations (x,y) on the line segment between P1 and P2 (excluding P1 and P2) which satisfy the condition that both x and y are integers?

Input Format 
The first line contains a single integer T, the number of test cases. T lines follow. 
Each of the following T lines contains one test case each. Each test case contains 4 integers x1, y1, x2 and y2 separated by a single space.

Output Format 
A single line containing the number of rocks.

Constraints 
1 <= T <= 105 
-109 <= x1, y1, x2, y2 <= 109

Sample input

3
0 2 4 0
2 2 5 5
1 9 8 16
Sample Output

1
2
6
Explanation

2Dplane

Case 1: As shown in the figure, between (0,2) and (4,0) there's only 1 integral point (2,1) hence 1 rock. 
Case 2: Between (2,2) and (5,5) lies (3,3) and (4,4), hence 2 rocks. 
Case 3: Between (1,9) and (8,16) there lies 6 rocks at positions (2,10) (3,11) (4,12) (5,13) (6,14) (7,15).
'''




'''
Basic logic says that we have to find maximum number of rocks that can be put along a straight line from p(x1,y1) to q(x2,y2). This means that we need to find , maximum number of divisions that this line can have only in INTEGER form. Because in floating notation it can be divided infinitely based upon the data type ..:)
    Hence we got to find the gcd which will give us the greatest divisor of the line from p(x1,y1) to q(x2,y2). i.e
    abs(gcd((y1-y2),(x1-x2)))

    Also the question says that we got to exclude the end points of the line ...the gcd received will also be inclusive of the end points ....hence subtract "1"  : abs(gcd((y1-y2),(x1-x2))-1). 

explanation 2:
I agree, the editorial is overly complicating the explanation, in my opinion. Consider instead this, once you have calcualted your dx and dy values, then your slope (m) will be dx/dy, keeping this relationship in integral fractional format, you will be able to reduce it by a factor of the gcd(dx, dy) for all dx, dy != 0 (aka. it doesn't work for horizontal/vertical lines). In reduced form, you now have a stepwise slope for each point from starting point x1, y1 through x2, y2, and it takes gcd(dx, dy) steps to traverse those steps. This includes the destination point, so that has to be removed (hence : -1) from your overall count (ans = gcd(dx, dy)-1). For dx=0, ans = (dy-1) (for dy!=dx), and for dy=0, ans = (dx-1) (also for dy!=dx). If dx=dy=0, then same point, ans=0;

Explanation 3:

Let the fraction a / b in its reduced form be the slope of the line joining P(x1 , y1) and Q(x2 , y2), which is equal to (y1 - y2) / (x1 - x2). To get all the points with integral coordinates, lying on the line PQ and between P and Q, we need to keep moving b units in the x-direction and a units in the y-direction, starting from P until we reach Q. So the number of such points (excluding P and Q) is given by n, where
n = abs((y1 - y2) / a) - 1
or equivalently,
n = abs((x1 - x2) / b) - 1.
However, since
a = (y1 - y2) / g
and
b = (x1 - x2) / g,
where
g = gcd(y1 - y2 , x1 - x2),
we have
n = abs(g) - 1,
and that's the answer we need.

'''


from __future__ import division
import math

def getGCD(n, m):
    if m == 0:
        return n
    else:
        return getGCD(m, n%m)

def find(x1, y1, x2, y2):
    res  = getGCD(int(math.fabs(x2-x1)), int(math.fabs(y2-y1)))
    print res - 1
    

T = int(raw_input())

for _ in xrange(T):
    x1, y1, x2, y2  = map(int, raw_input().strip().split(' '))
    find(x1, y1, x2, y2)
