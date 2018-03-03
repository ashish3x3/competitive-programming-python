import java.util.Collections;
import java.util.PriorityQueue;


public class RunningMedian{
// Numbers are randomly generated and passed to a method. Write a program to
// find and maintain the median value as new values are generated.
//
// SOLUTION:
// Use a max heap, a min heap,
// where maxheap.size() == minheap.size() or
// maxheap.size()-1 == minheap.size() always holds.
//maxheap contains all SMALL elements


	/*
===============================================================================================================	
	PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
queue.offer(1);
queue.offer(2);
queue.offer(3);
//...

Integer val = null;
while( (val = queue.poll()) != null) {
    System.out.println(val);
 =================================================================================================
	 
	

You can provide a custom Comparator object that ranks in the reverse order:

PriorityQueue<Integer> pq = new PriorityQueue<Integer>(defaultSize, new Comparator<Integer>() {
    int compare(Integer lhs, Integer rhs) {
        if (lhs > rhs) return +1;
        if (lhs.equals(rhs)) return 0;
        return -1;
    }
});

Now, the priority queue will reverse all its comparisons, so you will get the maximum element rather than the minimum element.

Hope this helps!


 
}

The Collections.reverseOrder() provides a Comparator that would sort the elements in the PriorityQueue in a the oposite order to their natural order in this case.

==================================================================================================

	*/


	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(50, Collections.reverseOrder());
//minheap contains all LARGE elements
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(50); //priority Q is default minHeap

	static void addNum(int n) {
		if (maxHeap.isEmpty()) {
			maxHeap.offer(n);
		}
		if (maxHeap.size() == minHeap.size()) {
			if (n < minHeap.peek()) {
				maxHeap.offer(n);
			}
			else {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(n);
			}
		}
		else {
			if (n > maxHeap.peek()) {
				minHeap.offer(n);
			}
			else {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(n);
			}
		}
	}
	static int getMedian() {
		if (maxHeap.isEmpty()) return 0;
		else if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2;
		}
		else {
			return maxHeap.peek();
		}
	}
//-------------------------------------
	public static void main(String[]args) {
		addNum(3);addNum(2);addNum(4);addNum(5);addNum(1);
		System.out.println(getMedian());
	}
}