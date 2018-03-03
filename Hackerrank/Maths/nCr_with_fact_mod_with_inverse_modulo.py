# https://www.hackerrank.com/challenges/matrix-tracing

'''
Firstly we note that we are given a grid, and only possible ways to reach from top left to bottom right is a DOWN move and RIGHT move. 
It can be observed that that from each point there are always a DOWN and LEFT move (if it doesn't go off board). So given m,n in total we have m-1 RIGHT moves and n-1 LEFT moves. And imagine we auto-move RIGHT and just have to choose when to move DOWN.
So from m+n-2 total moves we choose m-1 down moves. Hence total ways comes out to be m+n-2Cm-1.
Another way to look at is m+n-2 total moves where m-1 are of one type and n-1 are of another type
Hence total number of move is: (m+n-2)!/(m-1)!(n-1)!
As we have to print ans mod 109+7, answer should go as
moves = (m+n-2)! / (m-1)! (n-1)!               % (10^9+7)
      = (m+n-2)! * (m-1)!^(-1) * (n-1)!^(-1)   % (10^9+7)
For this we need to separately calculate Numerator and Denominator using modular and inverse modular operation.


'''


fact = [1]
n = 1
#print 2 * 10 ** 6 # 2000000
while n < 2 * 10 ** 6:
    fact.append((n * fact[-1]) % (10 ** 9 + 7))  
    n += 1

def inverse(n):
    return pow(n, 10 ** 9 + 5, 10 ** 9 + 7)  # n^p-2  # return x to the power y, modulo z

def choose(n,k):
    return (fact[n] * inverse(fact[k]*fact[n-k])) % (10 ** 9 + 7)

for _ in xrange(input()):
    m,n = map(int, raw_input().split())
    print choose(m+n-2, m-1)






'''
def binom(n, k, p):
  if k + k > n: return binom(n, n - k, p)
  res = 1
  for i in range(k):
    res = (res * (n - i)) % p
    res = (res * pow(i + 1, p - 2, p)) % p
  return res
  
print(binom(m + n - 2, m - 1, P))

'''






'''
mod = 10**9 + 7
    
def getfactmod(b):
  val = 1
  for i in range(1,b):
    val =((val%mod)*((i+1)%mod))%mod
  return val
    
def getpowermod(a,b):
  if b==0:
    return 1
  if b == 1:
    return a
  temp = getpowermod(a,b/2)
  if b%2==0:
    return ((temp%mod)**2)%mod
  else:
    return (a*((temp%mod)**2))%mod
  
def inversemod(a):
  return getpowermod(a,mod-2)
  
if __name__ == '__main__':
  t = input()
  assert 1 <= t <= 10**3
  for _ in range(t):
      a,b = map(int, raw_input().strip().split(' '))
      assert 1 <= a <= 10**6
      assert 1 <= b <= 10**6
      denominator = 1
      numerator = 1
      for i in range(1, a+b-1): # till a+b-2
          numerator = ((numerator%mod)*(i%mod))%mod
      for i in range(1, a): # till a-1
          denominator = ((denominator%mod)*(i%mod))%mod
      for i in range(1, b):
          denominator = ((denominator%mod)*(i%mod))%mod
      answer = ((numerator%mod)*(inversemod(denominator)%mod))%mod
      print answer

'''
'''
from math import factorial

def nCr(n, r):
    return factorial(n) // factorial(r) // factorial(n-r)

T  = int(raw_input())
for _ in xrange(T):
    m,n = map(int, raw_input().strip().split(' '))
    print nCr(m+n-2, n-1)%1000000007
'''

