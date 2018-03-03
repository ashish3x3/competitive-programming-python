

# https://www.hackerrank.com/challenges/building-a-list/

# http://www.keithschwarz.com/binary-subsets/

t=int(raw_input())
for f in range(0,t):
    n=int(raw_input())
    s=str(raw_input())
    n=len(s)
    a=[]
    for i in range(1,2**n):
        #print 'bin(i) ',str(bin(i))[2:]
        test=str(bin(i))[2:][::-1]
        #print 'test ',test
        out=""
        for i in range(0,len(test)):
            #print 'test[i] ',test[i],s[i]
            if test[i]=='1':
                out=out+str(s[i])
        a.append(out)
    #print a
    a.sort()
    #print a
    for i in a:
        print i


############################################################################

import itertools


def solve(S):
    combs = set()
    for i in xrange(1, len(S) + 1):
        for comb in itertools.combinations(S, i):
            combs.add(''.join(comb))
    print '\n'.join(sorted(combs))


for i in xrange(int(raw_input())):
    raw_input()
    solve(raw_input())


############################################################################


from itertools import combinations

tests = input()
for test in xrange(tests):
    strlen = input()
    string = raw_input()
    result = []
    for i in xrange(1, len(string) +1):
        for m in combinations(string, i):
            result.append("".join(m))

    print "\n".join(sorted(result))

############################################################################



from itertools import chain, combinations

def powerset(iterable):
    s = list(iterable)
    return chain.from_iterable(combinations(s, r) for r in range(len(s) + 1))

def print_sol(sol):
    for el in sol:
        print el

if __name__ == "__main__":
    t = int(raw_input())
    for i in xrange(t):
        chr_size = int(raw_input())
        word = str(raw_input())
        sol = list(sorted(["".join(el) for el in list(powerset(word))]))
        sol.remove('')
        print_sol(sol)



############################################################################



import itertools as it

cases = int(raw_input())

for _ in xrange(cases):
    N = int(raw_input())
    string = raw_input().strip()
    foo = []
    for i in range(1,N+1):
    	#Generate combinations of length i
        combs = list(it.combinations(string,i))
        print combs
        
        #Add combinations to list
        [foo.append(x) for x in combs]
        print foo
        
        for x in foo:
            print '--',x
            print ''.join(x)
        
        #Join elements in list so they can be sorted
        #This is because itertools gives back tuples
        bar = [''.join(x) for x in foo]
        print bar
        
    bar.sort()
    
    for val in bar:
        print val  

'''
1
3
xyz

[('x',), ('y',), ('z',)]
[('x',), ('y',), ('z',)]
-- ('x',)
x
-- ('y',)
y
-- ('z',)
z
['x', 'y', 'z']
[('x', 'y'), ('x', 'z'), ('y', 'z')]
[('x',), ('y',), ('z',), ('x', 'y'), ('x', 'z'), ('y', 'z')]
-- ('x',)
x
-- ('y',)
y
-- ('z',)
z
-- ('x', 'y')
xy
-- ('x', 'z')
xz
-- ('y', 'z')
yz
['x', 'y', 'z', 'xy', 'xz', 'yz']
[('x', 'y', 'z')]
[('x',), ('y',), ('z',), ('x', 'y'), ('x', 'z'), ('y', 'z'), ('x', 'y', 'z')]
-- ('x',)
x
-- ('y',)
y
-- ('z',)
z
-- ('x', 'y')
xy
-- ('x', 'z')
xz
-- ('y', 'z')
yz
-- ('x', 'y', 'z')
xyz
['x', 'y', 'z', 'xy', 'xz', 'yz', 'xyz']
x
xy
xyz
xz
y
yz
z

'''



##############################################################

l=0
def f(s,i,S):
    if i==l:
        return [S] if S<>"" else []
    return f(s,i+1,S+s[i])+f(s,i+1,S)

    
for i in range(input()):
    n=input()
    s=raw_input()
    l=len(s)
    for i in sorted(f(s,0,"")):
        print i