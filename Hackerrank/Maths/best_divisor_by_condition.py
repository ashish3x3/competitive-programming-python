

# https://www.hackerrank.com/challenges/best-divisor

'''
Kristen loves playing with and comparing numbers. She thinks that if she takes two different positive numbers, the one whose digits sum to a larger number is better than the other. If the sum of digits is equal for both numbers, then she thinks the smaller number is better. For example, Kristen thinks that  is better than  and that  is better than .

Given an integer, , can you find the divisor of  that Kristin will consider to be the best?

Input Format

A single integer denoting .

Constraints

Output Format

Print an integer denoting the best divisor of .

Sample Input 0

12
Sample Output 0

6
Explanation 0

The set of divisors of  can be expressed as . The divisor whose digits sum to the largest number is  (which, having only one digit, sums to itself). Thus, we print  as our answer.
 
'''


#!/bin/python

import sys

from collections import defaultdict


def factors(n):    
    return set(reduce(list.__add__, 
                ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

def factors(n):
    results = set()
    for i in xrange(1, int(math.sqrt(n)) + 1):
        if n % i == 0:
            results.add(i)
            results.add(int(n/i))
    return results

import math


def divisorGenerator(n):		# print list(divisorGenerator(100))
    large_divisors = []
    for i in xrange(1, int(math.sqrt(n) + 1)):
        if n % i == 0:
            yield i
            if i*i != n:
                large_divisors.append(n / i)
    for divisor in reversed(large_divisors):
        yield divisor


def sum_digits(n):
    r = 0
    while n:
        r, n = r + n % 10, n // 10
    return r

def digitsum(x):
    return sum(map(int,str(x)))

n = int(raw_input().strip())
l = factors(n)
mp = defaultdict(list)

for f in l:
    #map[sum_digits(f)].append(f)
    mp[digitsum(f)].append(f)
    
print min(mp[max(mp.keys())])



'''
editorial
As the constraint on  is quite small, we can use a straightforward brute force approach.
Let's iterate through each integer from  to  and, for each divisor  of , calculate the sum of its digits. If this sum is greater than the greatest current sum, then update the best divisor. It's important to note that you must only update this value when it's strictly greater than the greatest current sum, as we always choose the smaller number when two numbers have the same digit sum. See the code for details.



import java.util.*;

public class Solution {
    
    public static int getDigitSum(int k) {
        int sum = 0;
        
        while (k > 0) {
            sum += k % 10;
            k /= 10;
        }
        
        return sum;
    }
    
    public static int getBestDivisor(int n) {
        int maxSum = 1;
        int bestNumber = 1;
        
        // Check all possible factors of n
        for(int i = 2; i <= n; i++) {
            // If a number is evenly divisible, it's a factor of n
            if ((n % i) == 0) {
                int digitSum = getDigitSum(i);
                
                // Only need to track one number because if two numbers have same digitSum, 
                // smaller (previously stored value) is better.
                if (digitSum > maxSum) {
                    maxSum = digitSum;
                    bestNumber = i;
                }
            }
        }
        
        return bestNumber;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        System.out.println(getBestDivisor(n));
    }
}

'''
