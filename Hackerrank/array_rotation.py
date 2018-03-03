def array_left_rotation(a, n, d):
    a = rev(a, 0, d)
    # print a
    a = rev(a, d, n)
    # print a
    a = rev(a, 0, n)
    # print a
    
    return a

def rev(a, beg, end):
    limit = (end-beg)/2
    # print 'beg,end ',beg,end
    # print 'limit ',limit
    last = end
    for i in xrange(beg, beg+limit):
    	# print 'before swap ',a
        #swap a[i] with a[end-1]
        a[i], a[last-1] = a[last-1], a[i]
        last = last-1
    	# print 'after swap ',a
        
    return a



if __name__ == "__main__":

	n, d = map(int, raw_input().strip().split(' '))
	a = map(int, raw_input().strip().split(' '))
	answer = array_left_rotation(a, n, d);
	print ' '.join(map(str,answer))

'''

C:\Users\lenovo\Google Drive\Laptop Saved\STUDIES\GOOGLE PREP PROGRAMMING\Hackerrank>python array_rotation.py
5 2
1 2 3 4 5
beg,end  0 2
limit  1
before swap  [1, 2, 3, 4, 5]
after swap  [2, 1, 3, 4, 5]
[2, 1, 3, 4, 5]
beg,end  2 5
limit  1
before swap  [2, 1, 3, 4, 5]
after swap  [2, 1, 5, 4, 3]
[2, 1, 5, 4, 3]
beg,end  0 5
limit  2
before swap  [2, 1, 5, 4, 3]
after swap  [3, 1, 5, 4, 2]
before swap  [3, 1, 5, 4, 2]
after swap  [3, 4, 5, 1, 2]
[3, 4, 5, 1, 2]
3 4 5 1 2

C:\Users\lenovo\Google Drive\Laptop Saved\STUDIES\GOOGLE PREP PROGRAMMING\Hackerrank>python array_rotation.py
5 4
1 2 3 4 5
beg,end  0 4
limit  2
before swap  [1, 2, 3, 4, 5]
after swap  [4, 2, 3, 1, 5]
before swap  [4, 2, 3, 1, 5]
after swap  [4, 3, 2, 1, 5]
[4, 3, 2, 1, 5]
beg,end  4 5
limit  0
[4, 3, 2, 1, 5]
beg,end  0 5
limit  2
before swap  [4, 3, 2, 1, 5]
after swap  [5, 3, 2, 1, 4]
before swap  [5, 3, 2, 1, 4]
after swap  [5, 1, 2, 3, 4]
[5, 1, 2, 3, 4]
5 1 2 3 4

'''