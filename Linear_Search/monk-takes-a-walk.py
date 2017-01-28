
'''
Today, Monk went for a walk in a garden. There are many trees in the garden and each tree has an English alphabet on it.
While Monk was walking, he noticed that all trees with vowels on it are not in good state.
He decided to take care of them. So, he asked you to tell him the count of such trees in the garden.
Note : The following letters are vowels: 'A', 'E', 'I', 'O', 'U' ,'a','e','i','o' and 'u'.

Input:
The first line consists of an integer T
T denoting the number of test cases.
Each test case consists of only one string, each character of string denoting the alphabet
(may be lowercase or uppercase) on a tree in the garden.


2
nBBZLaosnm
JHkIsnZtTL
'''

T = int(raw_input())
str_list = []
for i in range(0,T):
    str = raw_input()
    # print str
    str_list.append(str)

# print(str_list)
vovel_count = 0
res = []

for i in range(len(str_list)):
    vovel_count = 0
    for ii in str_list[i]:
        # print ' ---- ',ii, '    ', str_list[i]
        if ii in 'aeiouAEIOU':
            vovel_count += 1
    res.append(vovel_count)

# print res
for elem in res:
    print elem