

# https://www.hackerrank.com/challenges/sherlock-and-divisors

'''
Watson gives an integer  to Sherlock and asks him: What is the number of divisors of  that are divisible by 2?.

Input Format 
First line contains , the number of testcases. This is followed by  lines each containing an integer .

Output Format 
For each testcase, print the required answer in one line.

Constraints 
 

Sample Input

2
9
8
Sample Output

0
3
Explanation 
9 has three divisors 1, 3 and 9 none of which is divisible by 2. 
8 has four divisors 1,2,4 and 8, out of which three are divisible by 2.

'''

'''
Earlier it was failing one testcase bcz of last i=54 and n/i = 54 both were getting added ..so making count increase by 1 in some case where i == n/i

i  1
n/i  2916
...
...
i  2
n/i  1458
...
...
i  3
n/i  972
...
...
i  4
n/i  729
...
...
i  6
n/i  486
...
...
i  9
n/i  324
...
...
i  12
n/i  243
...
...
i  18
n/i  162
...
...
i  27
n/i  108
...
...
i  36
n/i  81
...
...
i  54
n/i  54
...
14

'''

# Enter your code here. Read input from STDIN. Print output to STDOUT
import math

def factors(n):
    results = set()
    count = 0
    for i in xrange(1, int(math.sqrt(n)) + 1):
        if n % i == 0:
            print '...'
            print 'i ', i
            print 'n/i ',int(n/i)
            print '...'

            if i % 2 == 0:
                count+=1
                results.add(i)
            if int(n/i) % 2 == 0 and int(n/i) not in results:
                count+=1
                results.add(int(n/i))
                
    print count
    
T = int(raw_input())

for _ in xrange(T):
    N = int(raw_input())
    factors(N)


'''

Solution 

Time Complexity:
O(sqrt(N))




Let's say  where  are integers. 

There is no solution to above equation where  and . So we can traverse from  to supposing that  is a factor of . If  is a factor so will be . We will cover all factors this way. 

Note that if  is a perfect square,  should be counted only once, not twice. 

Another way to look at it
Here's another way to approach the problem. First, if  is odd, then it doesn't have even divisors, so you can immediately output . 

But if  is even, it has even divisors. Say  for some . Also, let  be an even divisor of . Then  is a divisor of  :) Furthermore, for every divisor  of , there corresponds exactly one even divisor  of . So the answer is simply the number of divisors of . 

Using this, we don't have to pass through all divisors and check if each is even. We can use the fact that if factorizes as , then the number of divisors of  is . The following Python code implements that idea:
z = input()
for cas in xrange(z):
    n = input()
    if n % 2: # odd
        print 0
    else:
        n /= 2
        ans = 1
        p = 2
        while p <= n:
            if p * p > n: p = n
            e = 0
            while n % p == 0:
                e += 1
                n /= p
            ans *= e + 1
            p += 1
        print ans

'''