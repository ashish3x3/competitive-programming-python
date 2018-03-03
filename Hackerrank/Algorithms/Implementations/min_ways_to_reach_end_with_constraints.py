#!/bin/python
# https://www.hackerrank.com/challenges/jumping-on-the-clouds

import sys


n = int(raw_input().strip())
c = map(int,raw_input().strip().split(' '))

cnt = 0
i = 0
while i < n:
    if i+2 < n and c[i+2] == 0:
        cnt+=1
        i+=2
    elif i+1 < n and c[i+1] == 0:
        cnt+=1
        i+=1
    else:
        break

print cnt
        
