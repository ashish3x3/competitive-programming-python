from collections import defaultdict
d = defaultdict(list)
list1=[]

n, m = map(int,raw_input().split())

for i in range(0,n):
    d[raw_input()].append(i+1) 

for i in range(0,m):
    list1=list1+[raw_input()]  

for i in list1: 
    if i in d:
        print " ".join( map(str,d[i]) )
    else:
        print -1


'''

Hackerrank :

Maths :  all easy ones in fundamentals

Number theory : all easy ones

Combinatorics : all easy ones

Geometry : all easy ones

Probability : all easy ones



Linux Shell:



Regex:


Python :

Math: all easy and medium
itertootls: all
Collections: all
class : both
python functionals: all 3





DS:

Trie : all 2
Disjoint set : all 4
heap : all 4
Trees : all easy (total 17 overall)
Balanced trees : all 3


'''