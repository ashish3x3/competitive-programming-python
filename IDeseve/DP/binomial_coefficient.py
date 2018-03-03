




http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/




Following are common definition of Binomial Coefficients.
1) A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.

2) A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen from among n objects; more formally, the number of k-element subsets (or k-combinations) of an n-element set.

The Problem
Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.




1) Optimal Substructure
The value of C(n, k) can be recursively calculated using following standard formula for Binomial Coefficients.

   C(n, k) = C(n-1, k-1) + C(n-1, k)
   C(n, 0) = C(n, n) = 1


# A naive recursive Python implementation
 
def binomialCoeff(n , k):
 
    if k==0 or k ==n :
        return 1
 
    # Recursive Call
    return binomialCoeff(n-1 , k-1) + binomialCoeff(n-1 , k)
 
# Driver Program to test ht above function
n = 5
k = 2
print "Value of C(%d,%d) is (%d)" %(n , k , binomialCoeff(n , k))






# A Dynamic Programming based Python Program that uses table C[][]
# to calculate the Binomial Coefficient
 
# Returns value of Binomial Coefficient C(n, k)
def binomialCoef(n, k):
    C = [[0 for x in range(k+1)] for x in range(n+1)]
 
    # Calculate value of Binomial Coefficient in bottom up manner
    for i in range(n+1):
        for j in range(min(i, k)+1):
            # Base Cases
            if j == 0 or j == i:
                C[i][j] = 1
 
            # Calculate value using previosly stored values
            else:
                C[i][j] = C[i-1][j-1] + C[i-1][j]
 
    return C[n][k]
 
# Driver program to test above function
n = 5
k = 2
print("Value of C[" + str(n) + "][" + str(k) + "] is "
      + str(binomialCoef(n,k)))











Output:
Value of C[5][2] is 10
Time Complexity: O(n*k)
Auxiliary Space: O(n*k)

Following is a space optimized version of the above code. The following code only uses O(k). Thanks to AK for suggesting this method.
C/C++Python
# Python program for Optimized Dynamic Programming solution to
# Binomail Coefficient. This one uses the concept of pascal
# Triangle and less memory
 
def binomialCoeff(n , k):
 
    # Declaring an empty array
    C = [0 for i in xrange(k+1)]
    C[0] = 1 #since nC0 is 1
 
    for i in range(1,n+1):
 
        # Compute next row of pascal triangle using
        # the previous row
        j = min(i ,k)
        while (j>0):
            C[j] = C[j] + C[j-1]
            j -= 1
 
    return C[k]
 
# Driver Program to test the above function
n = 5
k = 2
print "Value of C(%d,%d) is %d" %(n,k,binomialCoeff(n,k))