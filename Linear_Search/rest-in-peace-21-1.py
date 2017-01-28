'''

https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/

https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/rest-in-peace-21-1/

3
120
121
231

'''

T = int(raw_input())

st_list = []

for i in range(T):
    str_num = raw_input()
    if '21' in str_num or int(str_num)%21 == 0:
        st_list.append('The streak is broken!')
    else:
        st_list.append('The streak lives still in our heart!')

for i in st_list:
    print i

