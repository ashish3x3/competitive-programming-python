import bisect


n = input()

def medium(l):
    mi = len(l) // 2
    if len(l) % 2 == 0:
        return (l[mi] + l[mi-1])/2.0
    else:
        return l[mi]

l = []
for _ in xrange(n):
    bisect.insort(l, input())
    print '{:.1f}'.format(medium(l))

'''
N = int(raw_input().strip())
A = [ int(raw_input()) for _ in xrange(N) ]
from bisect import insort
B = []
for i,x in enumerate(A):
    insort(B, x)
    if i%2:
        print (B[i/2] + B[i/2 + 1])/2.
    else:
        print B[i/2]*1.

import bisect

n = int(raw_input().strip())

num_list = []

for ticker in xrange(n):
    bisect.insort_left(num_list, map(int, raw_input().strip().split(' '))[0])
    if len(num_list) % 2 == 0:
        median = (num_list[len(num_list) / 2] + num_list[(len(num_list) / 2) - 1]) / 2.0
    else:
        median = num_list[len(num_list) / 2]
    print("%.1f" % median)


from Queue import PriorityQueue
n = input()
a = PriorityQueue()
b = PriorityQueue()
for m in range(1, n + 1):
    x = input()
    if m == 1 or x > b.queue[0]:
        b.put(x)
    else:
        a.put(-x)
    if a.qsize() > b.qsize():
        b.put(-a.get())
    elif b.qsize() > a.qsize() + 1:
        a.put(-b.get())
    if m % 2 == 1:
        print b.queue[0] * 1.0
    else:
        print (b.queue[0] - a.queue[0]) * 0.5
'''


'''

// Java 8

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RunningMedianHeaps s = new RunningMedianHeaps();
        int n = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
            printMedian(s,in.nextInt());
        }
        in.close();       
    }

    public static void printMedian(RunningMedianHeaps s, int nextNum){
            s.addNumberInHeap(nextNum);
            System.out.printf("%.1f\n",s.getMedian());
    }
}

class RunningMedianHeaps{
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());  // Comparator.reverseOrder() available in java 8

    public double getMedian() {

        int size = minHeap.size() + maxHeap.size();     
        if(size % 2 == 0)
            return (maxHeap.peek()+minHeap.peek())/2.0;
        return maxHeap.peek()*1.0;
    }

    private void balanceHeaps() {
        if(maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }   
        else if(maxHeap.size() > 1+minHeap.size())
        {
            minHeap.add(maxHeap.poll());
        }
    }

    public void addNumberInHeap(int num) {
        if(maxHeap.size()==0 || num <= maxHeap.peek())
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }
        balanceHeaps();
    }
}
'''