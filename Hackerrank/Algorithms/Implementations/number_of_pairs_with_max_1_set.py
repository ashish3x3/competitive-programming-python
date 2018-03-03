# https://www.hackerrank.com/challenges/acm-icpc-team


n,m = [int(x) for x in raw_input().split()]
maxi = 0
cnt = 0
inp = [raw_input() for _ in range(n)]
for i in range(0,n):
    for j in range(i+1,n):
        set_bit = bin(int(inp[i],2) | (int(inp[j],2))).count("1")
        if set_bit>maxi:
            maxi = set_bit
            cnt = 1
        elif set_bit == maxi:
            cnt+=1
print maxi
print cnt

####################################################################


import itertools
N,M = map(int,raw_input().strip().split())
knowledge=[]
for i in range(N):
    knowledge.append(int(raw_input(),2))
    
print knowledge
mx = -float('inf')
teams=0
print list(itertools.combinations(range(N),2))
for p1,p2 in itertools.combinations(range(N),2):
    print bin(knowledge[p1])
    combined_topics = bin(knowledge[p1]|knowledge[p2]).count('1')
    if (combined_topics==mx):
        teams+=1
    elif (combined_topics>mx):
        mx = combined_topics
        teams=1

print(mx)
print teams


'''
[21, 28, 26, 5]
[(0, 1), (0, 2), (0, 3), (1, 2), (1, 3), (2, 3)]
0b10101
0b10101
0b10101
0b11100
0b11100
0b11010
5
2

'''