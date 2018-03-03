


# Python program to print all permutations with
# duplicates allowed

call 0,2 then 1,2 then 2,2 return 1,2 swap 1,2 i.e bc then again call 2,2..print swapped str.. then go back to first call 0,2.. swap 1,2 i.e ab to ba.. call 1,2 again with bac as string as sae process as before..lastly swap 1,3, i.e a,c to bacome cab and call 1,2 again with modified string..done..

Algorithm Paradigm: Backtracking
Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.
How runtime : to swap it will take O(1) and calling permtation with i+1 to N will take N-1 character instead of N, so
T(n) = O(1) + T(N-1) +  O(1) === > T(N) = N-1 * N-2 * N-3 ... 1 ===> O(N!)..now in each call if base case matches we print a stainf which takes O(N)..so overal O(N * N!)..if you remove the printing out of func, it will be O(N!) 
 
def toString(List):
    return ''.join(List)
 
# Function to print permutations of string
# This function takes three parameters:
# 1. String
# 2. Starting index of the string
# 3. Ending index of the string.
def permute(a, l, r):
    if l==r:
        print toString(a)
    else:
        for i in xrange(l,r+1):
            a[l], a[i] = a[i], a[l]
            permute(a, l+1, r)
            a[l], a[i] = a[i], a[l] # backtrack
 
# Driver program to test the above function
string = "ABC"
n = len(string)
a = list(string)
permute(a, 0, n-1)



ABC
ACB
BAC
BCA
CBA
CAB