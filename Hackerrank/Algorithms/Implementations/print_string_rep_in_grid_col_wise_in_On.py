# https://www.hackerrank.com/challenges/encryption

'''
logic is: there will alwasy be two number row and col bcz of ceil and floor difference by 1. so we need to check if row*col < len(str) then incemenrt row to col(i.e ceil)... now all we need it run obver the string by incremetning i,j where j=i+col till end

'''

import sys,math


s = raw_input().strip()
#print s
l = len(s)
l_sqr = math.sqrt(l)
col = int(math.ceil(l_sqr))
row = int(math.floor(l_sqr))
if row*col < l:
    row = col
    
i = 0
while i < col:
    for j in xrange(i,l,col):
        sys.stdout.write(s[j])
    sys.stdout.write(' ')
    
    i+=1




from math import sqrt, floor, ceil
s = raw_input()
n = len(s)
r = int(floor(sqrt(n)))
c = int(ceil(sqrt(n)))
if r * c < n:
    r += 1

res = [[0 for _ in xrange(c)] for __ in xrange(r)]

it = 0
i = 0
j = 0

while it < n:
    res[i][j] = s[it]
    it += 1
    j += 1
    if j == c:
        j = 0
        i += 1
out = ""
for i in xrange(c):
    for j in xrange(r):
        if res[j][i] != 0:
            out += res[j][i]
    out += " "
print out