import math


def prime_num_between_gen(beg, end, primes):
	num_list = list(xrange(beg, end))
	isBegExec = False
	not_prime = []

	for i in xrange(beg, end+1):
		# if (isPrime(i) and isBegExec == False) or (i not in not_prime and isBegExec == True):
		# 	if isBegExec == False:
		# 		isBegExec = True

		# 	print i
		# 	for j in xrange(i*i, end+1, i):
		# 		not_prime.append(j)
		# if (n in primes):
		# 	print i

		# not_prime_flag = False
		# div = int(math.sqrt(i))
		# print 'div ',div
		# less_arr = []
		# for q in primes:
		# 	if q < div:
		# 		less_arr.append(q)

		# print 'less_arr ',less_arr

		# for k in less_arr:
		# 	print 'k ',k
		# 	if i%k == 0:
		# 		not_prime_flag = True

		# if not_prime_flag == False:
		# 	print 'i ',i

		if isPrime(i, primes):
			print i


def sieve(maxNum):
    yield 2
    D, q = {}, 3
    while q <= maxNum:
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

def primes_sieve2(limit):
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
            print (i)
            prime_list.append(i)
            for j in range(i*i, n+1, i):
                non_prime_list.append(j)

    return prime_list



def isPrime(n, primes):
	# return n in primes
	# if n == 2:
	# 	return True
	# if n%2 == 0 or n <= 1:
	# 	return False
	# sqr = int(math.sqrt(n)) + 1
	# for divisor in range(3, sqr, 2):
	# 	if n%divisor == 0:
	# 		return False
	# return True
	if n == 2:
		return True
		
	div = math.ceil(math.sqrt(n))
	if div == 1:
		return False

	less_arr = []
	for q in primes:
		if q < div+1:
			less_arr.append(q)

	for k in less_arr:
		# print 'k ',k
		if n%k == 0:
			return False

	return True




if __name__ == "__main__":
	primes = [prime for prime in sieve(math.sqrt(1000000000))]
	# print 'done'
	test_cases = int(input())

	while test_cases > 0:
		test_cases = test_cases-1
		m, n = map(int, raw_input().split())
		prime_num_between_gen(m, n, primes)







