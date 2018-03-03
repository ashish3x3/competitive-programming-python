# https://www.hackerrank.com/challenges/non-divisible-subset/problem


'''
see editorial ..good explnation


For a sum of two numbers to be evenly divisible by k the following condition has to hold. If the remainder of N1%k == r then N2%k = k-r for N1+N2 % k == 0. Let us calculate the set of all numbers with a remainder of r and k-r and pick the larger set. If the remainder is half of k such as 2 % 4 = 2 or exactly k such as 4 % 4 = 0, just one number from each of these sets can be contained in S’.
'''

#O(n+k)

def solveSubset(S, k, n):
    r = [0] * k
     
    for value in S:
        r[value%k] += 1
     
    result = 0
    for a in xrange(1, (k+1)//2):
        result += max(r[a], r[k-a])
    if k % 2 == 0 and r[k//2]:
        result += 1
    if r[0]:
        result += 1
    return result
     
n, k = map(int, raw_input().split())
S = map(int, raw_input().split())
print solveSubset(S, k, n)



#############################################################


n,k = map(int,raw_input().strip().split(' '))

count = 0
nums = list(map(int,raw_input().strip().split(' ')))
remainder_list = []
for i in range(len(nums)):
    remainder_list.append(nums[i] % k) # taking all the remainders

#if there is any number evenly divisible, just add one to count because, adding it with any other number wont divide by k. and then remove all occurence of 0(read next comment)
if 0 in remainder_list:                
    count+=1

# and then remove all the 0 remainders (because there sum will always be divisible by k)
remainder_list = [x for x in remainder_list if x!=0] 


counter = [0]*k                                      # make a counter 
for i in range(len(remainder_list)):
    counter[remainder_list[i]] += 1                 # add one for each occurance of same remainder using it as index

index = []

for i in range(len(counter)):
    maxCount = max(counter)                         # check the max value of  occurance of a remainder in the list
    maxIndex = counter.index(maxCount)              # and its index too (that is remainder actually since we used 
                                                    # the empty list and   got all values with remainder as index)
    if k-maxIndex not in index and maxCount !=0 :   # the logic is, if the sum of two remainders are equal to k, then it will be                                                                divisble by k, so only add the max number of either
        index.append(maxIndex)
        if maxIndex*2 % k==0:                       # also, if same remainder after adding to itself gets divided by k, just add count                                                          as one (same case of evenly divisble , 'remainder = 0' )
            count+=1
        else:
            count += maxCount                       # if that is not the case, then we can add all the occurance of number having the                                                                   remainder
            
    counter[maxIndex] = 0                           # once we used the max remainder, set it to 0, to get the second max remainder                                                                  occurance from the list,, till list's all value
print(count)                                        