# https://www.hackerrank.com/challenges/alternating-characters/problem

'''

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4



AAAA  A, 3 deletions
BBBBB  B, 4 deletions
ABABABAB  ABABABAB, 0 deletions
BABABA  BABABA, 0 deletions
AAABBB  AB, 4 deletions because to convert it to AB we need to delete 2 A's and 2 B's
'''

import sys

def alternatingCharacters(s):
    i = 0;
    j = i+1
    cnt = 0
    while j < len(s):
        if s[i] == s[j]:
            cnt+=1
            j+=1
        elif s[i] != s[j]:
            i = j
            j = i+1
    return cnt

q = int(raw_input().strip())
for a0 in xrange(q):
    s = raw_input().strip()
    result = alternatingCharacters(s)
    print(result)

