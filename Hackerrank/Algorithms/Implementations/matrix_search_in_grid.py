

#https://www.hackerrank.com/challenges/the-grid-search/problem


'''
Complexity:
time complexity is O(n^2 * m^2)

space complexity is O(1)

More optimized solution are below

This is simply checking from each starting point for n*m pattern matrix...
like if 1,2 matches with 0,0 of pattern and follwing all mact in that row, next row to check wiill be 2,1 directly and not 2,0. i.e we check directly below the first match element in next rows and not entire row.

Execution:
There are many sophisticated 2d pattern matching algorithms out there. Just think of computer vision, robotics, gaming… The issue with most of them is, that they are rather heuristics than complete matches. I first started solving this challenge by using brute force and well.. It passed the time constraints. I did not expect that. If anyone has a good way of reducing the number of subarray checks, please post it in the comments!

SubArray-Check reduction techniques:

keep the sum of the sub-array in a separate grid, check only if sum matches the pattern
Rabin-Karp string searching algorithm on each line to fast forward

'''
def matchSubArray(arr, pat, x, y, pat_x, pat_y):
    #print (pat_y),(pat_x)
    
    for running_x in xrange(pat_x):
        for running_y in xrange(pat_y):
            #print pat[1][4]
            print 'running_x,running_y',running_x,running_y
            print 'running_x+x,running_y+y',running_x+x,running_y+y
            print arr[running_x+x][running_y+y],pat[running_x][running_y]
            if arr[running_x+x][running_y+y] != pat[running_x][running_y]:
                return False
     
    return True
             
             
def solveBruteForce(arr, pat, arr_x, arr_y, pat_x, pat_y):
    for x in xrange(arr_x-pat_x+1):
        for y in xrange(arr_y-pat_y+1):
            print 'x,y',x,y
            if matchSubArray(arr, pat, x, y, pat_x, pat_y):
                return True
     
    return False
     
if __name__ == '__main__':
    t = int(raw_input())
    for _ in xrange(t):
        arr_x, arr_y = map(int, raw_input().split())
        arr = [0] * arr_x
        for x in xrange(arr_x):
            arr[x] = list(raw_input())
         
        pat_x, pat_y = map(int, raw_input().split())
        pat = [0] * pat_x
        for x in xrange(pat_x):
            pat[x] = list(raw_input())
         
        if solveBruteForce(arr, pat, arr_x, arr_y, pat_x, pat_y):
            print "YES"
        else:
            print "NO"





'''
1
4 6
123412
561212
123634
781288
2 2
12
34


x,y 0 0
running_x,running_y 0 0
running_x+x,running_y+y 0 0
1 1
running_x,running_y 0 1
running_x+x,running_y+y 0 1
2 2
running_x,running_y 1 0
running_x+x,running_y+y 1 0
5 3
x,y 0 1
running_x,running_y 0 0
running_x+x,running_y+y 0 1
2 1
x,y 0 2
running_x,running_y 0 0
running_x+x,running_y+y 0 2
3 1
x,y 0 3
running_x,running_y 0 0
running_x+x,running_y+y 0 3
4 1
x,y 0 4
running_x,running_y 0 0
running_x+x,running_y+y 0 4
1 1
running_x,running_y 0 1
running_x+x,running_y+y 0 5
2 2
running_x,running_y 1 0
running_x+x,running_y+y 1 4
1 3
x,y 1 0
running_x,running_y 0 0
running_x+x,running_y+y 1 0
5 1
x,y 1 1
running_x,running_y 0 0
running_x+x,running_y+y 1 1
6 1
x,y 1 2
running_x,running_y 0 0
running_x+x,running_y+y 1 2
1 1
running_x,running_y 0 1
running_x+x,running_y+y 1 3
2 2
running_x,running_y 1 0
running_x+x,running_y+y 2 2
3 3
running_x,running_y 1 1
running_x+x,running_y+y 2 3
6 4
x,y 1 3
running_x,running_y 0 0
running_x+x,running_y+y 1 3
2 1
x,y 1 4
running_x,running_y 0 0
running_x+x,running_y+y 1 4
1 1
running_x,running_y 0 1
running_x+x,running_y+y 1 5
2 2
running_x,running_y 1 0
running_x+x,running_y+y 2 4
3 3
running_x,running_y 1 1
running_x+x,running_y+y 2 5
4 4
YES

'''


There are 2 approaches demonstrated here.
One is the C++ Program which does an element by element match for the smaller array in the larger 2D and breaks as soon as there is a mismatch.
The second one is a short but tricky Ruby script which uses a regular expression based approach to search for the smaller pattern inside the larger one. It will be an interesting exercise for the reader to brainstorm on how and why it works!


# search based solution  
for _ in range(input()):
    big = []
    small = []
    R, C = map(int, raw_input().split())
    for __ in range(R):
        big.append(raw_input())
    big_str = "".join(big)
    print big_str
    r, c = map(int, raw_input().split())
    for __ in range(r):
        small.append(raw_input())
    small_str = small[0]
    print small_str
    # get all starting positions of first line of small grid
    t = [i for i in range(len(big_str)) if big_str.startswith(small_str, i)]
    print t
    t1= []
    for i in range(len(big_str)):
        print i
        if big_str.startswith(small_str, i):
            t1.append(i)
    print t1
    for i in t:
        flag = 1
        row = i / C
        col = i % C
        print row,col
        if row > R - r:
            flag = 0
            continue
        for j in range(1,r):
            if small[j] != big[row+j][col: col + c]:
                flag = 0
                break
        if flag == 1:
            print "YES"
            break
    else:
        print "NO"


'''
1
4 6
123412
561212
123634
781288
2 2
12
34
Your Output
123412561212123634781288
12
[0, 4, 8, 10, 12, 20]
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
[0, 4, 8, 10, 12, 20]
0 0
0 4
1 2
1 4
YES
'''











# iterate over every element in grid  
for _ in range(input()):
    big = []
    small = []
    R, C = map(int, raw_input().split())
    for __ in range(R):
        big.append(raw_input())
    r, c = map(int, raw_input().split())
    for __ in range(r):
        small.append(raw_input())
    found = False
    for i in range(R - r + 1):
        for j in range(C - c + 1):
            flag = True
            for k in range(r):
                for l in range(c):
                    if big[i + k][j + l] != small[k][l]:
                        flag = False
                        break
                if not flag:
                    break
            if flag:
                print "YES"
                found = True
                break
        if found:
            break
    else:
        print "NO"
Python 2