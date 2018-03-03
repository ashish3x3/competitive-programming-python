# https://www.hackerrank.com/contests/infinitum10/challenges/fibonacci-finding-easy

def fibonacci(a,b,n):
    a = a
    b = b
    if n < 0:
        print("Incorrect input")
    elif n == 0:
        return a
    elif n == 1:
        return b
    else:
        for i in xrange(2,n+1):
            c = a + b
            #print i,c
            a = b
            b = c
        return b
    
def fib0(n):
    v1, v2, v3 = 1, 1, 0    # initialise a matrix [[1,1],[1,0]]
    for rec in bin(n)[3:]:  # perform fast exponentiation of the matrix (quickly raise it to the nth power)
        calc = v2*v2
        v1, v2, v3 = v1*v1+calc, (v1+v3)*v2, calc+v3*v3
        if rec=='1':    v1, v2, v3 = v1+v2, v1, v2
    return v2    

global fibs
def fib(n):
    print fibs
    if n in fibs: return fibs[n]
    if n % 2 == 0:
        fibs[n] = ((2 * fib((n / 2) - 1)) + fib(n / 2)) * fib(n / 2)
        return fibs[n]
    else:
        fibs[n] = (fib((n - 1) / 2) ** 2) + (fib((n+1) / 2) ** 2)
        return fibs[n]
    

    
# (Public) Returns F(n).
def fibonacci_fast(n):
	if n < 0:
		raise ValueError("Negative arguments not implemented")
	return _fib(n)[0]


# (Private) Returns the tuple (F(n), F(n+1)).
def _fib(n):
	if n == 0:
		return (0, 1)
	else:
		a, b = _fib(n // 2)
		c = a * (b * 2 - a)
		d = a * a + b * b
		if n % 2 == 0:
			return (c, d)
		else:
			return (d, c + d)
        
        
def mult(x,y):
    if ( len(y) == 2 ):
        a = ((x[0]*y[0])%1000000007+(x[1]*y[1])%1000000007)%1000000007
        b = ((x[2]*y[0])%1000000007+(x[3]*y[1])%1000000007)%1000000007
        return [a,b]
    a = ((x[0]*y[0])%1000000007 + (x[1]*y[2])%1000000007)%1000000007
    b = ((x[0]*y[1])%1000000007+ (x[1]*y[3])%1000000007)%1000000007
    c = ((x[2]*y[0])%1000000007 + (x[3]*y[2])%1000000007)%1000000007
    d = ((x[2]*y[1])%1000000007 + (x[3]*y[3])%1000000007)%1000000007
    return [a,b,c,d]
 
# Only works for positive powers!
def matrix_power( x, n ):
    if ( n == 1 or n == 0 ):
        return x
    if ( n%2 == 0 ):
        return matrix_power( mult(x, x), n//2 )
    return mult(x, matrix_power( mult(x, x), n//2 ) )

T = int(raw_input())
for  _ in xrange(T):
    
    a,b,n = map(int, raw_input().strip().split(' ')) 
    fibs = {0: a, 1: b}
    #print fibonacci_fast(n)    
    #print '....'
    A = [1,1,1,0]
    v = [b%1000000007,a%1000000007]
    if n == 1:
        print b
        continue
    if n == 0:
        print a
        continue
    print mult(matrix_power(A,n-1),v)[0]    
    
    




def pow_mod(x, y, z):
    number=[[1,1],[1,0]]
    while y:
        if y & 1:
            number = matmult(number,x,z)
        y >>= 1
        x = matmult(x,x,z)
    return number

def matmult(a,b,m):
    zip_b = zip(*b)
    return [[sum(ele_a*ele_b for ele_a, ele_b in zip(row_a, col_b))%m for col_b in zip_b] for row_a in a]


mod = 10**9 + 7
t=input()
a = [[1,1],[1,0]]
for i in range(t):
    A,B,N = map(int,raw_input().split())
    t = pow_mod(a,N-1,mod)
    print (t[1][0]*B + t[1][1]*A)%mod
    