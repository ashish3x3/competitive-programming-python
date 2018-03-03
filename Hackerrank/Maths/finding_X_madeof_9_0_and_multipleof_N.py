# https://www.hackerrank.com/challenges/special-multiple
'''

You are given an integer N. Can you find the least positive integer X made up of only 9's and 0's, such that, X is a multiple of N?

Update

X is made up of one or more occurences of 9 and zero or more occurences of 0.

Input Format 
The first line contains an integer T which denotes the number of test cases. T lines follow. 
Each line contains the integer N for which the solution has to be found.

Output Format 
Print the answer X to STDOUT corresponding to each test case. The output should not contain any leading zeroes.

Constraints 
1 <= T <= 104 
1 <= N <= 500

Sample Input

3
5
7
1
Sample Output

90
9009
9
Explanation 
90 is the smallest number made up of 9's and 0's divisible by 5. Similarly, you can derive for other cases.

'''
'''
The binary to decimal conversion algorithm is of complexity O(k), i.e. the complexity of the loop. However, k is a count of the number of digits in the binary representation of x, that is log2x, thus this can also be treated as a algorithm of complexity O(log x)!
The decimal to binary algorithm contains a while loop that depends on the value associated with the variable identified as x, but the range is divided in half at each iteration. Thus this is similar to the binary search algorithm and is of complexity O(log x) also!



alternate: but not sufficient for this
The Pigeonhole Principle
http://www.geeksforgeeks.org/discrete-mathematics-the-pigeonhole-principle/

https://math.stackexchange.com/questions/233746/existance-of-multiple-of-n-with-only-0-and-1-as-its-digits
Consider the numbers 1,11,111,...,111...11 (1 is repeated n+1 times). Since these are n+1 numbers we can use the pegionhole principle to deduce that 2 of them are congruent modulomodulo nn. Find the absolute value of the difference between the 2 numbers that are congruent modulo n. The difference is made up of 1(s) and zeros. This number is also divisible by n. (done)
--will work for 9000,99900 but not for 9009 type of answers
    
'''
for _ in range(int(input())):
    i = 1
    c = int(input())
    while True:  # O(N)
        j = int(bin(i)[2:].replace('1','9'))  # O(logi)
        if j % c == 0:
            break
        i+=1
    print(j)
    