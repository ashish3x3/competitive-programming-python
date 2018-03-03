# https://www.hackerrank.com/challenges/even-odd-query
'''
You are given an array A of size N. You are also given an integer Q. Can you figure out the answer to each of the Q queries?

Each query contains 2 integers x and y, and you need to find whether the value find(x,y) is Odd or Even:

find(int x,int y)
{
    if(x>y) return 1;
    ans = pow(A[x],find(x+1,y))
    return ans
}
Note : pow(a,b) = ab.

Input Format 
The first line of the input contains an integer N. The next line contains N space separated non-negative integers(whole numbers less than or equal to 9). 
The line after that contains a positive integer, Q , the denotes the number of queries to follow. Q lines follow, each line contains two positive integer x and y separated by a single space.

Output Format 
For each query, display 'Even' if the value returned is Even, otherwise display 'Odd'.

Constraints 
2 ≤ N ≤ 105 
2 ≤ Q ≤ 105 
1 ≤ x,y ≤ N 
x ≤ y

Array is 1-indexed.

No 2 consecutive entries in the array will be zero.

Sample Input

3
3 2 7
2
1 2
2 3
Sample Output

Odd
Even
Explanation

find(1,2) = 9, which is Odd 
find(2,3) = 128, which is even

'''

'''
Use the idea that x^k is even if x is even and odd otherwise for k = 1, 2, 3... 
ps - x^0 is a special case 
pps - This is a constant time complexity solution 
ppps - You never have to use the y
EDIT:You have to use y in the special case of x^0 (follow the thread below)

Input : 4
        3 2 0 7
        2
        2 3
        2 2

Output : Odd
         Even
As you see, though x is same for both inputs, yet, we expect different output because of different y.
Though, I would say that test cases are weak considering they don't test for consecutive zeros (Remember : 0^0 is defined as 1 in C & Python), which would have changed the result.


0^0 is defined as 1 in math, too.

Put 0^0 = 1.
So 1 = 0^0 = 0^(3 - 3) = 0^3 / 0^3 = 0 / 0.
We come to say that 0 / 0 is a number but we all know that it is NOT a number. And we also know why. 

Often, in computer science 0^0 is equal to 1 for other reasons
Infact x^0 is equal to 1 by math convention, except for x = 0, as demonstrated above.
The case 0^0 simply is not a number (0/0).

'''

#global A
A = []
N = int(raw_input())

A = list(map(int, raw_input().strip().split(' ')))
A.insert(0, 0)
#print A

T = int(raw_input())

for _ in xrange(T):
    res = 1
    x,y = map(int, raw_input().strip().split(' '))
    if x!=y and A[x+1] == 0 and x+1<=N:
        print 'Odd'
    elif A[x]%2 == 0:
        print 'Even'
    else:
        print 'Odd'
    
    

        
     
    