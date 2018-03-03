# Enter your code here. Read input from STDIN. Print output to STDOUT
# https://www.hackerrank.com/challenges/no-prefix-set

import json

def insert_check(trie, str):
    exist =  False
    for letter in str:
        if letter in trie:
            exist = True
            if 'end' in trie[letter]:
                return ['BAD SET',str]
            trie = trie[letter]
        else:
            exist = False
            trie[letter] = {}
            trie = trie[letter]
    trie['end'] = 'end'
    if exist:
        return ['BAD SET',str]



trie = {}

n  = int(raw_input())

for _ in xrange(n):
    strr = raw_input()
    res = insert_check(trie, strr)
    #print res
    if res != None:
        print res[0]
        print res [1]
        break
else:
    print 'GOOD SET'    
#print trie
#print(json.dumps(trie, indent=1)) 

'''
test case that failed was: if 'f' came later and there was 'fvcdfe' was already ther, it won't detect it as bad because till then as per logic after 'f' ther is no 'end' statement, so adding 'exist' check cleared that bug...hackos shows  m =900,100000 i.e 10^5 strings passed

5
bhcifgfbccadjejfeaefcf
dchjh
h
fgfhdahj
f

BAD SET
f
'''

'''

Given  strings. Each string contains only lowercase letters from (both inclusive). The set of  strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, they are considered prefixes of each other.)

For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

Print GOOD SET if it satisfies the problem requirement. 
Else, print BAD SET and the first string for which the condition fails.

Input Format 
First line contains , the number of strings in the set. 
Then next  lines follow, where  line contains  string.

Constraints 
 
 Length of the string 

Output Format 
Output GOOD SET if the set is valid. 
Else, output BAD SET followed by the first string for which the condition fails.

Sample Input00

7
aab
defgab
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad
Sample Output00

BAD SET
aabcde
Sample Input01

4
aab
aac
aacghgh
aabghgh
Sample Output01

BAD SET
aacghgh
Explanation 
aab is prefix of aabcde. So set is BAD SET and it fails at string aabcde.

'''