# Enter your code here. Read input from STDIN. Print output to STDOUT

'''
ref : https://hr-filepicker.s3.amazonaws.com/infinitum-jun14/editorials/2372-possible-path.pdf
https://stackoverflow.com/questions/24261070/possible-paths-hackerrank


https://math.stackexchange.com/questions/1103904/significance-of-gcd

The crucial observation is that gcd(u,v)=gcd(v,u)=gcd(u,u±v)gcd(u,v)=gcd(v,u)=gcd(u,u±v).

From this follows Euclid's algorithm for computing gcd.

The significance of the gcd in your problem is that the crucial observation implies that all points visited by allowed moves have the same gcd. So, you can divide their coordinates by that gcd and reduce the problem to a grid with unit spacing and whose allowed moves are to immediate neighbors.

The crucial observation proves that if (x,y)(x,y) is reachable from (a,b)(a,b),then gcd(x,y)=gcd(a,b)gcd(x,y)=gcd(a,b).

For the converse, note that the set of all points that are reachable from (a,b)(a,b) have coordinates of the form am+bnam+bn, with m,n∈Zm,n∈Z. The set of all such linear combinations is the set of all multiples of gcd(a,b)gcd(a,b).

similar
https://www.quora.com/How-do-you-count-all-the-paths-from-the-first-element-to-the-last-element-in-a-2d-array-knowing-you-can-only-move-right-or-down


'''

def find(a,b,x,y):  # stack size limit reached
    #print a,b,x,y
    if a > x and b > y:
        return 'NO'
    if a == x and b == y:
        return 'YES'
    elif a > x:
        return find(a-b,b,x,y)
    elif b > y:
        return find(a,b-a,x,y)
    elif a < x:
        return find(a+b,b,x,y)
    elif b < y:
        return find(a,a+b,x,y)
    
    return 'NO'

def oddEven(x,y):
    if x%2 == 0 and y%2 != 0:
        return True
    elif x%2 != 0 and y%2 == 0:
        return True
    
    return False

def check(a,b,x,y):
    if oddEven(a,x) == True:
        return 'NO'
    elif oddEven(b,y) == True:
        return 'NO'
    elif a == x and oddEven(b,y) == False:
        return 'YES'
    elif a == x and oddEven(b,y) == True:
        return 'NO'
    
def getGCD(x,y):
    if y == 0:
        return x
    else:
        return getGCD(y, x%y)
    
    
T = int(raw_input())

for _ in xrange(T):
    a, b, x, y = map(int, raw_input().strip().split(' '))
    if getGCD(x,y) == getGCD(a,b):
        print 'YES'
    else:
        print 'NO'
    #res = check(a,b,x,y)
    #print a,b
    #res = find(a,b,x,y)
    #res = findPath(a,b,x,y)
    #print res