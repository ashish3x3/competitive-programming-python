from __future__ import division
import math

def sieve(N):   # N will be sqrt(Real_N) i.e N = 10, then sqrt(N) will be 3
    yield 2
    D, q = {}, 3
    while q <= N:
        p = D.pop(q, 0)
        if p:
            x = q + p
            while x in D: x += p
            D[x] = p
        else:
            yield q
            D[q*q] = 2*q
        q += 2
    raise StopIteration

def primes_sieve2(limit):   # this will get accepted
    a = [True] * limit                          # Initialize the primality list
    a[0] = a[1] = False

    for (i, isprime) in enumerate(a):
        if isprime:
            yield i
            for n in xrange(i*i, limit, i):     # Mark factors non-prime
                a[n] = False


def prime_eratosthenes(n):
    non_prime_list = []
    prime_list = []
    for i in range(2, n+1):
        if i not in non_prime_list:
            # #print (i)
            prime_list.append(i)
            for j in range(i*i, n+1, i):
                non_prime_list.append(j)

    return prime_list

def prime_num_between_gen(beg, end):
	sqrt_num_of_end = int(math.floor(math.sqrt(end))) + 1
	prime = sieve(int(math.sqrt(end)))   # primes_sieve2() will also get accepted ...using prime_eratosthenes() will give time limit exceeded..
	# print prime  

	if beg <= 2:
		# print '2'
		beg = 2

	mark = [True] * (end-beg+1)
	# print mark

	# print mark
		
	for i in prime:
		# print 'i ',i
		# print 'beg ',beg

		lo_lim = int(math.floor((beg/i)))*i

		for j in xrange(lo_lim, end+1, i):
			if j != i and j >= beg:
				mark[j - beg] = False



		# if i == beg:
		# 	mark[0] = True
		# 	print 'math.ceil((beg/i)) ',math.floor((beg/i))
		# 	lo_lim = int(math.floor((beg/i)))*i
		# 	print 'lo_lim ',lo_lim

		# 	if(lo_lim < beg):
		# 		print 'lo_lim < beg' 
		# 		lo_lim = lo_lim + i
		# 		print 'new lo_lim ',lo_lim

		# 	for j in xrange(lo_lim, end+1, i):
		# 		print 'j,beg ',j,beg
		# 		print 'j - beg ',j-beg

		# 		if(j != i):
		# 			if j - beg != 0:
		# 				mark[j - beg] = False
		# 				print 'mark ',mark

		# else:
		# 	print 'math.ceil((beg/i)) ',math.floor((beg/i))
		# 	lo_lim = int(math.floor((beg/i)))*i
		# 	print 'lo_lim ',lo_lim

		# 	if(lo_lim < beg):
		# 		print 'lo_lim < beg' 
		# 		lo_lim = lo_lim + i
		# 		print 'new lo_lim ',lo_lim

		# 	for j in xrange(lo_lim, end+1, i):
		# 		print 'j,beg ',j,beg
		# 		print 'j - beg ',j-beg

		# 		if(j != i):
		# 			print 'j - beg ',j-beg
		# 			mark[j - beg] = False
		# 			print 'mark ',mark

	for k in xrange(beg, end+1):
		if mark[k - beg] == True:
			print k
			# print k


if __name__ == "__main__":
	# primes = [prime for prime in sieve(math.sqrt(1000000000))]
	#print 'done'
	test_cases = int(input())

	while test_cases > 0:
		test_cases = test_cases-1
		m, n = map(int, raw_input().split())
		prime_num_between_gen(m, n)



