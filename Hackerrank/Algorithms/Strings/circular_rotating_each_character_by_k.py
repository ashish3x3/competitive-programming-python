# https://www.hackerrank.com/challenges/caesar-cipher-1/problem

'''
Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every letter in a string by a fixed number, K, making it unreadable by his enemies. Given a string, S , and a number, K , encrypt  and print the resulting string.

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

Input Format

The first line contains an integer,N , which is the length of the unencrypted string. 
The second line contains the unencrypted string, S. 
The third line contains the integer encryption key, K , which is the number of letters to rotate.

78
1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M
27

1 Y7U4WsDt23l4ww08E6  zR3T19H4sWQ188N9  H ivyC6k1uNHAt1n10fz  7fVk62XW2fyMU4 D83am7R80N


11
middle-Outz
2
Sample Output

okffng-Qwvb

Each unencrypted letter is replaced with the letter occurring K spaces after it when listed alphabetically. Think of the alphabet as being both case-sensitive and circular; if K  rotates past the end of the alphabet, it loops back to the beginning (i.e.: the letter after z is a, and the letter after Z is A).
'''
import sys

small_alph = 'abcdefghijklmnopqrstuvwxyz'
capital_alph = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'


n = int(raw_input().strip())
s = raw_input().strip()
k = int(raw_input().strip())

#print s[36]
res = ''
for i in xrange(len(s)):
    #print ord(s[i]),res
    if ord(s[i]) < 65 or (ord(s[i]) > 90 and ord(s[i]) < 97) or ord(s[i]) > 122:
        res+= s[i]
    else:   
        if ord(s[i]) >= 97:
            #print ord(s[i]), ord(s[i]) + k, ord(s[i]) + k - 97, res
            res+= small_alph[(ord(s[i]) + (k%26) - 97)%26]
        else:
            #print ord(s[i]) + k - 65,res
            res+= capital_alph[(ord(s[i]) + (k%26) - 65)%26]
            
    
print res



'''
import sys

INDEX_TABLE = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9, 'k': 10, 'l': 11, 'm': 12, 'n': 13, 'o': 14, 'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19, 'u': 20, 'v': 21, 'w': 22, 'x': 23, 'y': 24, 'z': 25}
raw_alphabet = 'abcdefghijklmnopqrstuvwxyz'

sys.stdin.readline()
to_encode = sys.stdin.readline()
shift_amount = int(sys.stdin.readline()) % 26

encoded_alphabet = raw_alphabet[shift_amount:] + raw_alphabet[0:shift_amount]
# print encoded_alphabet
result_str = ''
for ch in to_encode:
    is_upper = ch.isupper()
    ch = ch.lower()
    if ch in INDEX_TABLE:
        if is_upper:
            result_str += encoded_alphabet[INDEX_TABLE[ch]].upper()
        else:
            result_str += encoded_alphabet[INDEX_TABLE[ch]]
    else:
        result_str += ch
print result_str

'''

'''
from string import ascii_lowercase
from string import ascii_uppercase


def encode_message(message, shift):
    encoded_message = ''
    for letter in message:
        if letter.lower() in ascii_lowercase:
            if letter.islower():
                pos = ascii_lowercase.index(letter)
                encoded_message += ascii_lowercase[(pos + shift) % 26]
            else:
                pos = ascii_uppercase.index(letter)
                encoded_message += ascii_uppercase[(pos + shift) % 26]
        else:
            encoded_message += letter

    return encoded_message

N = input()
message = raw_input()
shift = input()

print encode_message(message, shift)

'''

'''
n = int(raw_input())
s = raw_input()
k = int(raw_input())
outList = []
for c in s:
    if c.isalpha():
        if c.islower():
            x = (ord(c)-ord('a') + k)%26 + ord('a')
            outList.append(chr(x))
        if c.isupper():
            x = (ord(c)-ord('A') + k)%26 + ord('A')
            outList.append(chr(x))
    else:
        outList.append(c)
print "".join(outList)

'''