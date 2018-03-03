


Method 1 (Simple)
Run two loops. In the outer loop, take all subarrays of size k. In the inner loop, get the maximum of the current subarray.

C/C++Java
//Java Program to find the maximum for each and every contiguous subarray of size k.
 
public class GFG
{
    // Method to find the maximum for each and every contiguous subarray of size k.
    static void printKMax(int arr[], int n, int k) 
    {
        int j, max;
 
        for (int i = 0; i <= n - k; i++) {
             
            max = arr[i];
 
            for (j = 1; j < k; j++) 
            {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }
 
    // Driver method
    public static void main(String args[]) 
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        printKMax(arr, arr.length, k);
    }
}



Method 2 (Use Self-Balancing BST)
1) Pick first k elements and create a Self-Balancing Binary Search Tree (BST) of size k.
2) Run a loop for i = 0 to n – k
…..a) Get the maximum element from the BST, and print it.
…..b) Search for arr[i] in the BST and delete it from the BST.
…..c) Insert arr[i+k] into the BST.

Time Complexity: Time Complexity of step 1 is O(kLogk). Time Complexity of steps 2(a), 2(b) and 2(c) is O(Logk). Since steps 2(a), 2(b) and 2(c) are in a loop that runs n-k+1 times, time complexity of the complete algorithm is O(kLogk + (n-k+1)*Logk) which can also be written as O(nLogk).

done in another file with same name usig AVl..




Method 3 (A O(n) method: use Dequeue)
We create a Dequeue, Qi of capacity k, that stores only useful elements of current window of k elements. An element is useful if it is in current window and is greater than all other elements on left side of it in current window. We process all array elements one by one and maintain Qi to contain useful elements of current window and these useful elements are maintained in sorted order. The element at front of the Qi is the largest and element at rear of Qi is the smallest of current window.

https://stackoverflow.com/questions/8031939/finding-maximum-for-every-window-of-size-k-in-an-array

Dynamic programming approach is very neatly explained by Shashank Jain. I would like to explain how to do the same using dequeue. 

The key is to maintain the max element at the top of the queue(for a window ) and discarding the useless elements and we also need to discard the elements that are out of index of current window.
useless elements = If Current element is greater than the last element of queue than the last element of queue is useless . 
Note : We are storing the index in queue not the element itself. It will be more clear from the code itself. 
1. If Current element is greater than the last element of queue than the last element of queue is useless . We need to delete that last element. (and keep deleting until the last element of queue is smaller than current element).
2. If if current_index - k >= q.front() that means we are going out of window so we need to delete the element from front of queue. 


Since each element is enqueued and dequeued atmost 1 time to time complexity is 
O(n+n) = O(2n) = O(n).
And the size of queue can not exceed the limit k . so space complexity = O(k).


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




//Java Program to find the maximum for each and every contiguous subarray of size k.
 
import java.util.Deque;
import java.util.LinkedList;
 
public class SlidingWindow 
{
     
    // A Dequeue (Double ended queue) based method for printing maixmum element of
    // all subarrays of size k
    static void printMax(int arr[],int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e., 
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
         
        /* Process first k (or first window) elements of array */
        int i;
        for(i = 0; i < k; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear
             
            // Add new element at rear of queue
            Qi.addLast(i);
        }
         
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
             
            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();
             
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
             
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
             
        }
         
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
     
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        int arr[]={12, 1, 78, 90, 57, 89, 56};
        int k=3;
        printMax(arr, arr.length,k);
    }
 
}