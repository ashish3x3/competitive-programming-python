
'''
You are given a string that is either already a palindrome or can be made into a palindrome by removing a single character. 

We must consider the following cases: 

If the string is already a palindrome,  is the answer (because no character need be removed). The index of the middle character is also accepable if the string is a palindrome of odd length. The index of either of the two middle characters is also acceptable in the case of a palindrome of even length.
If the given string is not a palindrome, we must find  character that, once removed, will make it a palindrome. We can do this by checking if str[i] == str[N - 1 - i] where  is the length of the string for all  starting from . Once this condition fails, all we have to do is to check if str[0:i-1] + str[i+1:N-1] is a palindrome. If it is a palindrome, we print the value of i; otherwise, we print the value of n-1-i. 

'''

n=int(raw_input())
for n0 in range(n):
    s=list(raw_input())
    if list(reversed(s))==s:
        print -1
    else:
        for i in range(0,(len(s)/2)+1):
            if s[i]!= s[-(i+1)]:
                break
        del s[i]
        if list(reversed(s))==s:
            print i
        else:
            print len(s)-i     # len(s)+1-i but our l-i is -(i+1)  i.e for i =0, j =-1 i.e end element




######################################################


T = input()
for _ in xrange(T):
    S = raw_input()
    l = len(S)
    a = -1
    for i in xrange(l):
        if S[i] != S[l - 1 - i]:
            x = S[:i] + S[i + 1:]
            if x == x[::-1]:
                a = i
            else:
                a = l - 1 - i
            break
    print a


#########################################################

T = int(raw_input())

def is_palin(s):
    return s == s[::-1]

for t in xrange(T):
    s = raw_input()
    n = len(s)
    l = 0
    r = n-1
    ans = -1
    while l < r:
        if s[l] != s[r]:
            if is_palin(s[:l]+s[l+1:]):
                ans = l
                break
            else:
                ans = r
                break
        l += 1
        r -= 1
    print ans
            

























