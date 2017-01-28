# Last Occurrence
'''
You have been given an array of size N
In addition you have been given an element M
you need to find and print the index of the last occurrence of this element
M in the array if it exists in it, otherwise print -1. Consider this array to be 1 indexed.

https://www.hackerearth.com/practice/algorithms/searching/linear-search/tutorial/

5 1
1 2 3 4 1
o/p : 5
'''

str_arr = raw_input().split(' ')
arr = [int(num) for num in str_arr]
N = arr[0]
M = arr[1]

str_arr = raw_input().split(' ')
arr_val = [int(num) for num in str_arr]
# print(arr_val)

index = -1

for i in range(0, len(arr_val)):
    if arr_val[i] == M:
        index = i

if index != -1:
    print(index + 1)
else:
    print(index)
