

'''
We have discussed dynamic programming solution in the previous post. The time complexity of the Dynamic Programming based solution is O(n^2) and it requires O(n^2) extra space. We can find the longest palindrome substring in (n^2) time with O(1) extra space. The idea is to generate all even length and odd length palindromes and keep track of the longest palindrome seen so far.

Step to generate odd length palindrome:
Fix a centre and expand in both directions for longer palindromes.

Step to generate even length palindrome
Fix two centre ( low and high ) and expand in both directions for longer palindromes.


'''




# A O(n^2) time and O(1) space program to find the 
#longest palindromic substring
 
# This function prints the longest palindrome substring (LPS)
# of str[]. It also returns the length of the longest palindrome
def longestPalSubstr(string):
    maxLength = 1
 
    start = 0
    length = len(string)
 
    low = 0
    high = 0
 
    # One by one consider every character as center point of 
    # even and length palindromes
    for i in xrange(1, length):
        # Find the longest even length palindrome with center
    # points as i-1 and i.
        low = i - 1
        high = i
        while low >= 0 and high < length and string[low] == string[high]:
            if high - low + 1 > maxLength:
                start = low
                maxLength = high - low + 1
            low -= 1
            high += 1
 
        # Find the longest odd length palindrome with center 
        # point as i
        low = i - 1
        high = i + 1
        while low >= 0 and high < length and string[low] == string[high]:
            if high - low + 1 > maxLength:
                start = low
                maxLength = high - low + 1
            low -= 1
            high += 1
 
    print "Longest palindrome substring is:",
    print string[start:start + maxLength]
 
    return maxLength
 
# Driver program to test above functions
string = "forgeeksskeegfor"
print "Length is: " + str(longestPalSubstr(string))
 
# This code is contributed by BHAVYA JAIN
Run on IDE
Output:

Longest palindrome substring is: geeksskeeg
Length is: 10
Time complexity: O ( n^2 ) where n is the length of input string.
Auxiliary Space: O ( 1 )