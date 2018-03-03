

# https://www.hackerrank.com/challenges/gem-stones/problem

import sys
from collections import defaultdict


def gemstones(arr):
    mp = defaultdict(list)
    for i in xrange(len(arr)):
        for j in arr[i]:
            if j not in mp:
                mp[j].append(i)    
            elif j in mp and i not in mp[j]:
                mp[j].append(i)
    
    cnt = 0
    for k,v in mp.iteritems():
        if len(v) == len(arr):
            cnt+=1
                
    return cnt        

n = int(raw_input().strip())
arr = []
arr_i = 0
for arr_i in xrange(n):
    arr_t = str(raw_input().strip())
    arr.append(arr_t)
result = gemstones(arr)
print(result)
