# https://www.hackerrank.com/challenges/die-hard-3

'''
To count no of steps also Generic: http://www.geeksforgeeks.org/two-water-jug-puzzle/

There are several ways of solving this problem including BFS and DP. In this article an arithmetic approach to solve the problem is discussed. The problem can be modeled by means of Diophantine equation of the form mx + ny = d which is solvable if and only if gcd(m, n) divides d. Also, the solution x,y for which equation is satisfied can be given using the Extended Euclid algorithm for GCD.
For example, if we have a jug J1 of 5 litre (n = 5) and another jug J2 of 3 litre (m = 3) and we have to measure 1 litre of water using them. The associated equation will be 5n + 3m = 1. First of all this problem can be solved since gcd(3,5) = 1 which divides 1 (See this for detailed explanation). Using the Extended Euclid algorithm, we get values of n and m for which the equation is satisfied which are n = 2 and m = -3. These values of n, m also have some meaning like here n = 2 and m = -3 means that we have to fill J1 twice and empty J2 thrice.
Now to find the minimum no of operations to be performed we have to decide which jug should be filled first. Depending upon which jug is chosen to be filled and which to be emptied we have two different solutions and the minimum among them would be our answer.

Solution 1 (Always pour from m litre jug into n litre jug)

Fill the m litre jug and empty it into n litre jug.
Whenever the m litre jug becomes empty fill it.
Whenever the n litre jug becomes full empty it.
Repeat steps 1,2,3 till either n litre jug or the m litre jug contains d litres of water.
Each of steps 1, 2 and 3 are counted as one operation that we perform. Let us say algorithm 1 achieves the task in C1 no of operations.

Solution 2 (Always pour from n litre jug into m litre jug)

Fill the n litre jug and empty it into m litre jug.
Whenever the n litre jug becomes empty fill it.
Whenever the m litre jug becomes full empty it.
Repeat steps 1, 2 and 3 till either n litre jug or the m litre jug contains d litres of water.
Let us say solution 2 achieves the task in C2 no of operations.

Now our final solution will be minimum of C1 and C2.

Now we illustrate how both of the solutions work. Suppose there are a 3 litre jug and a 5 litre jug to measure 4 litres water so m = 3,n = 5 and d = 4. The associated Diophantine equation will be 3m + 5n = 4. We us pair (x, y) to represent amounts of water inside 3 litre jug and 5 litre jug respectively in each pouring step.

Using Solution 1, successive pouring steps are:

(0,0)->(3,0)->(0,3)->(3,3)->(1,5)->(1,0)->(0,1)->(3,1)->(0,4)
Hence the no of operations you need to perform are 8.

Using Solution 2, successive pouring steps are:

(0,0)->(0,5)->(3,2)->(0,2)->(2,0)->(2,5)->(3,4)
Hence the no of operations you need to perform are 6.

'''
import math

def getGCD(n, m):
    if m == 0:
        return n
    else:
        return getGCD(m, n%m)

T = int(raw_input())
for _ in xrange(T):
    a,b,c = map(int,raw_input().strip().split(' '))
    if c > a + b:
        print 'NO'
    elif c%getGCD(a,b) == 0:
        print 'YES'
    else:
        print 'NO'


'''
int minSteps(int m, int n, int d)
{
    // To make sure that m is smaller than n
    if (m > n)
        swap(m, n);
 
    // For d > n we cant measure the water
    // using the jugs
    if (d > n)
        return -1;
 
    // If gcd of n and m does not divide d
    // then solution is not possible
    if ((d % gcd(n,m)) != 0)
        return -1;
 
    // Return minimum two cases:
    // a) Water of n litre jug is poured into
    //    m litre jug
    // b) Vice versa of "a"
    return min(pour(n,m,d),   // n to m
               pour(m,n,d));  // m to n
}

/* fromCap -- Capacity of jug from which
              water is poured
   toCap   -- Capacity of jug to which
              water is poured
   d       -- Amount to be measured */
int pour(int fromCap, int toCap, int d)
{
    // Initialize current amount of water
    // in source and destination jugs
    int from = fromCap;
    int to = 0;
 
    // Initialize count of steps required
    int step = 1; // Needed to fill "from" Jug
 
    // Break the loop when either of the two
    // jugs has d litre water
    while (from != d && to != d)
    {
        // Find the maximum amount that can be
        // poured
        int temp = min(from, toCap - to);
 
        // Pour "temp" litres from "from" to "to"
        to   += temp;
        from -= temp;
 
        // Increment count of steps
        step++;
 
        if (from == d || to == d)
            break;
 
        // If first jug becomes empty, fill it
        if (from == 0)
        {
            from = fromCap;
            step++;
        }
 
        // If second jug becomes full, empty it
        if (to == toCap)
        {
            to = 0;
            step++;
        }
    }
    return step;
}

'''