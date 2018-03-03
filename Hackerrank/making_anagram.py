#https://www.hackerrank.com/challenges/ctci-making-anagrams

def number_needed(str1, str2):
    if len(str1) == 0 and len(str2) == 0:
        return 0
    if len(str1) == 0:
        return len(str2)
    if len(str2) == 0:
        return len(str1)
    mp1 = [0] * 26
    mp2 = [0] * 26
    cnt = 0
    for ch in str1:
        #print ch
        mp1[ord(ch) - 97] = mp1[ord(ch) - 97] + 1
    for ch1 in str2:
        mp2[ord(ch1) - 97] = mp2[ord(ch1) - 97] + 1
    #print(a)
    for i in xrange(26):
        if mp1[i] > mp2[i]:
            cnt = cnt + mp1[i] - mp2[i]
        else:
            cnt = cnt + mp2[i] - mp1[i]
            
    return cnt
        

a = raw_input().strip()
b = raw_input().strip()

print number_needed(a, b)