# https://www.hackerrank.com/challenges/handshake


'''

The answer for this problem is . We can derive this equation by thinking in several ways.
Way 1:
There are  People in the room. Each person will shake hand with  other people. So total number of handshakes should be . But it will count duplicate handshakes ( shakes hand with , and  shakes hand with ) and the condition in this problem is any two persons shake hand exactly once. So we will divide by to get the answer.
Way 2:
There are  People in the room. So, the  person can shake hands with all of the  other people.
As the  person has already shaken hands with the  person, he can shake hands with other  people. Similarly the  person can shake hands with  other people and so on.
So the  person can shake hands with  other person only. Everyone have already shaken hand with the  person, so he will not shake hand with any other person.
So the total number of handshakes are:
Way 3
The total number of handshakes is equal to the number of ways in which 2 people can be chosen among people which is equal to .
Time complexity: O(1)

'''


#!/bin/python

import sys


T = int(raw_input().strip())
for a0 in xrange(T):
    N = int(raw_input().strip())
    print N * (N - 1) / 2