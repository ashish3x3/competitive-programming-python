

# https://www.hackerrank.com/challenges/anagram/submissions/code/48162047

'''
Lets us consider that the length of the given string is X. If X is an odd number, we can't break it into two strings of equal length. As we know, two strings having unequal length cannot be anagrams. So, the required output will be "-1". Now suppose the length of string is an even number, we can change any character of the string to any alphabet. So, only difference of number of each character matters. We can count the difference of number of occurances of each character in the first half and the second half i.e., from 'a' to 'z'. Our required output will be half of sum of magnitude of difference in number of occurances of each character.

'''



from collections import Counter
for _ in range(input()):
    s = raw_input()
    if len(s)%2 == 1:
        print "-1"
        continue
    temp = Counter(s[0:len(s)/2]) - Counter(s[len(s)/2:])
    print temp
    print sum(temp.values())

'''
Counter({'a': 3})
3
Counter({'a': 1})
1
-1
Counter({'m': 1, 'n': 1})
2
Counter()
0
Counter({'a': 1})
1
'''
#################################################

python 2
#!/usr/bin/py
T = input()
assert 1 <= T <= 100
def get_num(word):
    first = word[:word.__len__()/2]
    second = word[word.__len__()/2:]
    count = 0
    for char in first:
        if char not in second:
            count += 1
        if char in second:
            second = second.replace(char,'',1)
    return count
for i in range(T):
    aplusb = raw_input().strip()
    assert 1 <= aplusb.__len__() <= 10000
    if aplusb.__len__() % 2 == 1:
        print -1
    else:
        print get_num(aplusb)














import sys

def anagram(s):
    if len(s)%2 != 0:
        #print 'len(s)%2 ',len(s)%2
        return -1
    s1 = s[:len(s)//2]
    s2 = s[len(s)//2 :]
    
    #print s1,s2
    arr1 = [0]*26
    arr2 = [0]*26
    
    for i in xrange(len(s1)):
        arr1[ord(s1[i])-97]+=1
    #print arr1
    
    for i in xrange(len(s2)):
        if(arr1[ord(s2[i])-97] != 0):
            arr1[ord(s2[i])-97]-=1
    #print arr1
    
    
    for i in xrange(len(s2)):
        arr2[ord(s2[i])-97]+=1
    #print arr2
    
    for i in xrange(len(s1)):
        if(arr2[ord(s1[i])-97] != 0):
            arr2[ord(s1[i])-97]-=1
    #print arr2
    
    cnt1 = 0
    for i in xrange(len(arr1)):
        if arr1[i] != 0 :
            cnt1+=arr1[i]
            
    #print cnt1
    
    cnt2 = 0
    for i in xrange(len(arr2)):
        if arr2[i] != 0 :
            cnt2+=arr2[i]
            
    #print cnt2
    #print cnt1,cnt2       
    if abs(cnt1) > abs(cnt2):
        return abs(cnt2)
    else:
        return abs(cnt1)

q = int(raw_input().strip())
for a0 in xrange(q):
    s = raw_input().strip()
    result = anagram(s)
    print(result)

