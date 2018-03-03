# https://www.hackerrank.com/challenges/connecting-towns

T = int(raw_input())
for i in range (0, T):
    d = []
    ans = 0
    A = long(raw_input())
    d = raw_input().split(' ')
    ans = 1
    for j in range (0,A-1):
        d[j] = int(d[j])
        ans = ans * d[j]
        ans = ans % 1234567
    print ans 