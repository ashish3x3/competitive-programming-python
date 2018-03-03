# Enter your code here. Read input from STDIN. Print output to STDOUT
from collections import defaultdict
from math import factorial

def calculate_combinations(n, r):
    return factorial(n) // factorial(r) // factorial(n-r)

def baseN(num,b,numerals="0123456789"):
    return ((num == 0) and numerals[0]) or (baseN(num // b, b, numerals).lstrip(numerals[0]) + numerals[num % b])

def checkDayMonthValid(n, m):
    if m > 31:
        return False
    if n > 12:
        return False
    if str(n) not in '1,3,5,7,8,10,12' and m == 31:
        return False
    return True
        

T = int(raw_input())
global mp
mp = defaultdict(lambda: 0)
global st
st = set()
for _ in xrange(T):
    n, m = map(int, raw_input().strip().split(' '))
    #if checkDayMonthValid(n, m) == False:
        #continue
    if True:
        #st.add((n,m))
        #print max([int(c) for c in str(m)])
        if n > max([int(c) for c in str(m)]):
            #if True:
            #break
            nm = long(str(m),n)
            #nm = baseN(m,n)
            #print 'nm ',nm
            if nm == 0:
                #print 0
                break
            if nm not in mp:
                #print 'new nm ',nm
                mp[nm] = 1
            else:
                #print 'existing nm ',nm
                mp[nm]+=1

#print mp
#print st
cnt = 0
for key, value in mp.iteritems():
    if value > 1:
        cnt+=calculate_combinations(value,2)
print cnt
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    