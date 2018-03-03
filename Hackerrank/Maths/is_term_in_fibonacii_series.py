

# https://www.hackerrank.com/challenges/is-fibo


'''
You are given an integer, . Write a program to determine if  is an element of the Fibonacci sequence.

The first few elements of the Fibonacci sequence are . A Fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are  and .

Formally: 
Input Format 
The first line contains , number of test cases. 
 lines follow. Each line contains an integer .

Output Format 
Display IsFibo if  is a Fibonacci number and IsNotFibo if it is not. The output for each test case should be displayed in a new line.

Constraints 
 

Sample Input

3
5
7
8
Sample Output

IsFibo
IsNotFibo
IsFibo
Explanation 
 is a Fibonacci number given by  
 is not a Fibonacci number 
 is a Fibonacci number given by 

'''

'''
8
2
2
3
2
2
34
13
34
IsFibo
IsFibo
IsFibo
IsFibo
IsFibo
IsFibo
IsFibo
IsFibo

'''

def isFib(N):
    #print N
    a = 0
    b = 1
    for i in xrange(N+1):
        c = a+b
        if c == N:
            print 'IsFibo'
            return
        elif c > N:
            print 'IsNotFibo'
            return
        a = b
        b = c
        
        
T = int(raw_input())

for _ in xrange(T):
    N = int(raw_input())
    isFib(N)
        