#!/bin/python
from __future__ import division
import sys


n = int(raw_input().strip())
arr = map(int,raw_input().strip().split(' '))

pos = 0
neg = 0
zer = 0

for i in xrange(len(arr)):
    if arr[i] > 0:
        pos+=1
    elif arr[i] < 0:
        neg+=1
    else:
        zer+=1

print format(pos/len(arr), '.6f')
print format(neg/len(arr), '.6f')
print format(zer/len(arr), '.6f')

###########################################################

def getPartitionPythonesque(values):
    c1 = len(filter(lambda x:x>0,values))
    c2 = len(filter(lambda x:x<0,values))
    c3 = len(filter(lambda x:x==0,values))
    v_len = float(len(values))
     
    return (c1/v_len, c2/v_len, c3/v_len)