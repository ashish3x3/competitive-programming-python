# 
# Sliding window min/max (Python 2, 3)
# 
# Copyright (c) 2017 Project Nayuki. (MIT License)
# https://www.nayuki.io/page/sliding-window-minimum-maximum-algorithm
# 
# Permission is hereby granted, free of charge, to any person obtaining a copy of
# this software and associated documentation files (the "Software"), to deal in
# the Software without restriction, including without limitation the rights to
# use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
# the Software, and to permit persons to whom the Software is furnished to do so,
# subject to the following conditions:
# - The above copyright notice and this permission notice shall be included in
#   all copies or substantial portions of the Software.
# - The Software is provided "as is", without warranty of any kind, express or
#   implied, including but not limited to the warranties of merchantability,
#   fitness for a particular purpose and noninfringement. In no event shall the
#   authors or copyright holders be liable for any claim, damages or other
#   liability, whether in an action of contract, tort or otherwise, arising from,
#   out of or in connection with the Software or the use or other dealings in the
#   Software.
#
'''
 >>> from collections import deque
>>> d = deque('ghi')                 # make a new deque with three items
>>> for elem in d:                   # iterate over the deque's elements
...     print elem.upper()
G
H
I

>>> d.append('j')                    # add a new entry to the right side
>>> d.appendleft('f')                # add a new entry to the left side
>>> d                                # show the representation of the deque
deque(['f', 'g', 'h', 'i', 'j'])

>>> d.pop()                          # return and remove the rightmost item
'j'
>>> d.popleft()                      # return and remove the leftmost item
'f'
>>> list(d)                          # list the contents of the deque
['g', 'h', 'i']
>>> d[0]                             # peek at leftmost item
'g'
>>> d[-1]                            # peek at rightmost item
'i'

>>> list(reversed(d))                # list the contents of a deque in reverse
['i', 'h', 'g']
>>> 'h' in d                         # search the deque
True
>>> d.extend('jkl')                  # add multiple elements at once
>>> d
deque(['g', 'h', 'i', 'j', 'k', 'l'])
>>> d.rotate(1)                      # right rotation
>>> d
deque(['l', 'g', 'h', 'i', 'j', 'k'])
>>> d.rotate(-1)                     # left rotation
>>> d
deque(['g', 'h', 'i', 'j', 'k', 'l'])
'''


The double-ended queue is the perfect data structure for this problem. It supports insertion/deletion from the front and back. The trick is to find a way such that the largest element in the window would always appear in the front of the queue. How would you maintain this requirement as you push and pop elements in and out of the queue?

Besides, you might notice that there are some redundant elements in the queue that we shouldn’t even consider about. For example, if the current queue has the elements: [10 5 3], and a new element in the window has the element 11. Now, we could have emptied the queue without considering elements 10, 5, and 3, and insert only element 11 into the queue.

A natural way most people would think is to try to maintain the queue size the same as the window’s size. Try to break away from this thought and try to think outside of the box. Removing redundant elements and storing only elements that need to be considered in the queue is the key to achieve the efficient O(n) solution below.


void maxSlidingWindow(int A[], int n, int w, int B[]) {
  deque<int> Q;
  for (int i = 0; i < w; i++) {
    while (!Q.empty() && A[i] >= A[Q.back()])
      Q.pop_back();
    Q.push_back(i);
  }
  for (int i = w; i < n; i++) {
    B[i-w] = A[Q.front()];
    while (!Q.empty() && A[i] >= A[Q.back()])
      Q.pop_back();
    while (!Q.empty() && Q.front() <= i-w)
      Q.pop_front();
    Q.push_back(i);
  }
  B[n-w] = A[Q.front()];
}

The above algorithm could be proven to have run time complexity of O(n). This is because each element in the list is being inserted and then removed at most once. Therefore, the total number of insert + delete operations is 2n.


import collections, numbers


# ---- Function for one-shot computation ----

def compute(array, window, maximize):
	if not isinstance(window, numbers.Integral):
		raise TypeError()
	if not isinstance(maximize, bool):
		raise TypeError()
	if window <= 0:
		raise ValueError("Window size must be positive")
	
	result = []
	deque = collections.deque()
	for (i, val) in enumerate(array):
		val = array[i]
		while len(deque) > 0 and ((not maximize and val < deque[-1]) or (maximize and val > deque[-1])):
			deque.pop()
		deque.append(val)
		
		j = i + 1 - window
		if j >= 0:
			result.append(deque[0])
			if array[j] == deque[0]:
				deque.popleft()
	return result



# ---- Stateful instance for incremental computation ----

class SlidingWindowMinMax(object):
	
	def __init__(self):
		self.mindeque = collections.deque()
		self.maxdeque = collections.deque()
	
	
	def get_minimum(self):
		return self.mindeque[0]
	
	
	def get_maximum(self):
		return self.maxdeque[0]
	
	
	def add_tail(self, val):
		while len(self.mindeque) > 0 and val < self.mindeque[-1]:
			self.mindeque.pop()
		self.mindeque.append(val)
		
		while len(self.maxdeque) > 0 and val > self.maxdeque[-1]:
			self.maxdeque.pop()
		self.maxdeque.append(val)
	
	
	def remove_head(self, val):
		if val < self.mindeque[0]:
			raise ValueError("Wrong value")
		elif val == self.mindeque[0]:
			self.mindeque.popleft()
		
		if val > self.maxdeque[0]:
			raise ValueError("Wrong value")
		elif val == self.maxdeque[0]:
			self.maxdeque.popleft()