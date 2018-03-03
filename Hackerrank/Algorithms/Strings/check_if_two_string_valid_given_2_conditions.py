#!/bin/python
# https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem


'''
Short Problem Definition:
A “valid” string is a string S such that for all distinct characters in S each such character occurs the same number of times in S.

'''

import sys
from collections import Counter


def isValid(s):
    val =  Counter(Counter(s).values()).values()
    #print val
    if len(val) == 1:
        return 'YES'
    elif len(val) > 2:
        return 'NO'
    elif len(val) == 2 and 1 in val:
        return 'YES'
    else:
        return 'NO'
    

s = raw_input().strip()
result = isValid(s)
print(result)







from collections import Counter
 
 
def isValid(S):
    char_map = Counter(S)
    char_occurence_map = Counter(char_map.values())
 
    if len(char_occurence_map) == 1:
        return True
 
    if len(char_occurence_map) == 2:
        for v in char_occurence_map.values():
            if v == 1:
                return True
 
    return False
 
 
S = raw_input()
if isValid(S):
    print "YES"
else:
    print "NO"