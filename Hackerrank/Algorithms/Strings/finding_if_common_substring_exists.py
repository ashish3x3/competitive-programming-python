# https://www.hackerrank.com/challenges/two-strings/problem

# Given two strings,  a and b, determine if they share a common substring.
'''
2
hello
world
hi
world
Sample Output

YES
NO


even if single character matches its a substring.so put it in a map and check if ant char from other sting is present or fins the intersection uinf set
'''


import sys,os
from collections import defaultdict

def method2(s1, s2):
    mp = defaultdict()
    for i in xrange(len(s1)):
        if s1[i] not in mp:
            mp[s1[i]] = True
    
    for j in xrange(len(s2)):
        if s2[j] in mp:
            return 'YES'
    
    return 'NO'
    

def twoStrings(s1, s2):
    cnt = 0
    done = False
    for k in xrange(1,len(s1)+1):
        for i in xrange(len(s1)):
            st1 = s1[i:i+k]
            #print s1[i:]
            #print '@@@@@@@@',st1
            #'''
            for j in xrange(len(s2)):
                if j+i < len(s2)+1:
                    st2 = s2[j:j+k]
                    #print st1,st2
                    if st1 == st2:
                        return 'YES'
                        #cnt+=1
                        ##if cnt == q:
                          #  done = True
                          #  return 'YES'
            #'''


    return 'NO'

q = int(raw_input().strip())
for a0 in xrange(q):
    s1 = raw_input().strip()
    s2 = raw_input().strip()
    result = method2(s1, s2)
    print(result)





a=set(raw_input().strip())
b=set(raw_input().strip())
if len(a.intersection(b))>0:
	print "YES"
else:
	print "NO"


print "YES" if set(list(s1)) & set(list(s2)) else "NO"




def twoStrings(s1, s2):
    m1 = set(s1)
    m2 = set(s2)
    if set.intersection(m1,m2):
        return "YES"
    return "NO"
 
if __name__ == '__main__':
    t = input()
    for _ in xrange(t):
        first = raw_input()
        second = raw_input()
        print twoStrings(first, second)