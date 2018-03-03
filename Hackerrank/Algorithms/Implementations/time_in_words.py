#!/bin/python

# https://www.hackerrank.com/challenges/the-time-in-words

import sys
from collections import defaultdict

def int_to_en(num):
    d = { 0 : 'zero', 1 : 'one', 2 : 'two', 3 : 'three', 4 : 'four', 5 : 'five',
          6 : 'six', 7 : 'seven', 8 : 'eight', 9 : 'nine', 10 : 'ten',
          11 : 'eleven', 12 : 'twelve', 13 : 'thirteen', 14 : 'fourteen',
          15 : 'fifteen', 16 : 'sixteen', 17 : 'seventeen', 18 : 'eighteen',
          19 : 'nineteen', 20 : 'twenty',
          30 : 'thirty', 40 : 'forty', 50 : 'fifty', 60 : 'sixty',
          70 : 'seventy', 80 : 'eighty', 90 : 'ninety' }
    k = 1000
    m = k * 1000
    b = m * 1000
    t = b * 1000

    assert(0 <= num)

    if (num < 20):
        return d[num]

    if (num < 100):
        if num % 10 == 0: return d[num]
        else: return d[num // 10 * 10] + ' ' + d[num % 10]

    if (num < k):
        if num % 100 == 0: return d[num // 100] + ' hundred'
        else: return d[num // 100] + ' hundred and ' + int_to_en(num % 100)

    if (num < m):
        if num % k == 0: return int_to_en(num // k) + ' thousand'
        else: return int_to_en(num // k) + ' thousand, ' + int_to_en(num % k)

    if (num < b):
        if (num % m) == 0: return int_to_en(num // m) + ' million'
        else: return int_to_en(num // m) + ' million, ' + int_to_en(num % m)

    if (num < t):
        if (num % b) == 0: return int_to_en(num // b) + ' billion'
        else: return int_to_en(num // b) + ' billion, ' + int_to_en(num % b)

    if (num % t == 0): return int_to_en(num // t) + ' trillion'
    else: return int_to_en(num // t) + ' trillion, ' + int_to_en(num % t)

    raise AssertionError('num is too large: %s' % str(num))


h = int(raw_input().strip())
m = int(raw_input().strip())

#print m, '0'

mp = defaultdict()

mp[0] = ' o\' clock'
mp[15] = 'quarter past '
mp[30] = 'half past '
mp[45] = 'quarter to '

st = ''
if str(m) == '0':
    st+=int_to_en(h)+mp[m]
    print st
elif str(m) == '15':
    st+=mp[m]+int_to_en(h)
    print st
elif str(m) == '30':
    st+=mp[m]+int_to_en(h)
    print st
elif str(m) == '45':
    st+=mp[m]+int_to_en(h+1)
    print st
elif m < 30:
    st+=int_to_en(m)+' minutes past '+int_to_en(h)
    print st
elif m > 30:
    st+= int_to_en(60-m)+' minutes to '+int_to_en(h+1)
    print st







