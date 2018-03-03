# https://www.hackerrank.com/contests/w33/challenges/pattern-count/copy-from/1302090903

import sys

def patternCount(s):
    # Complete this function
    l = len(s)
    cnt = 0
    i = 0
    while i < l:
        if s[i] != '1':
            i+=1
            continue
        if s[i] == '1' and i+1 < l and s[i+1] != '0':
            i = i+1
            continue
        elif s[i] == '1' and i+1 < l and s[i+1] == '0':
            
            i = i+1
            while i < l and s[i] == '0':   # for case like 1aa10, length check make sure we are in bound
                i+=1
            if i >= l:
                break
            if s[i] == '1':
                cnt+=1
        else:
            i+=1
       
            
    return cnt
            

q = int(raw_input().strip())
for a0 in xrange(q):
    s = raw_input().strip()
    result = patternCount(s)
    print(result)

