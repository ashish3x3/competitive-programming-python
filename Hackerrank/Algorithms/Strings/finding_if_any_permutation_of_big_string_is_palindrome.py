#!/bin/python
# http://www.quickermaths.com/palindromes-interesting-numbers/
# https://www.hackerrank.com/challenges/game-of-thrones/editorial


'''
Problem: Given a string. tell whether any anagram of given sub-string will be palindrome

Approach: Suppose length of given string is l. then, If any anagram of given string will be palindrome if X[i] = X[l-1-i] where X is given string. So, every character has to be repeated even number of time . only one of the character can happen odd number of times which will occur in middle of string .

If len(str) is even, count of each elemnt should be even.
If len(str) is odd, count of ONLY one element should be odd, counts of all other elements should be even.

'''

import sys
import itertools
from collections import Counter

def gameOfThrones(s):
    if len([c for c in set(s) if s.count(c) % 2 != 0]) < 2:
        return 'YES'
    else:
        return 'NO'
        
def gameOfThrones_sol_accepted(s):
    print "YES" if len(filter(lambda x: x & 1, Counter(s).values())) <= 1 else "NO"   # (x & 1)? printf("Odd"): printf("Even");

def gameOfThrones(s):
    temp = Counter(s)
    l = len(s)
    if l%2 == 0 : #even case
        f = True
        for v in temp.values():
            if v%2 !=0:
                F =False
                break
        if f == False:
            return 'NO'
        else:
            return 'YES'
    else:
        cnt = 0
        for v in temp.values():
            if v%2 !=0:
                cnt+=1
                if cnt > 1:
                    break
        if cnt > 1:
            return 'NO'
        else:
            return 'YES'

def gameOfThrones1(s):
    l = len(s)
    mp = {}
    for i in xrange(l):
        ai = s[i]
        #aj = s[-(i+1)]
        
        #if i != l-1-i:
        if ai in mp:
            mp[ai]+=1
        else:
            mp[ai] = 1
                
    
    if l%2 == 0 : #even case
        f = True
        #print 'if ',mp
        for key, v in mp.iteritems():
            if v%2 !=0:
                F =False
        if f == False:
            return 'NO'
        else:
            return 'YES'
    else:
        cnt = 0
        #print 'else ',mp
        for key, v in mp.iteritems():
            if v%2 !=0:
                cnt+=1
        if cnt > 1:
            return 'NO'
        else:
            return 'YES'

def gameOfThrones_with_all_perm(s):
    l = list(set(itertools.permutations(s)))
    for x in l:
        #print x
        st = ''.join(x)
        #print st, st[::-1]
        if st == st[::-1]:
            print st
            return 'YES'
    return 'NO'
    

s = raw_input().strip()
result = gameOfThrones(s)
print(result)
