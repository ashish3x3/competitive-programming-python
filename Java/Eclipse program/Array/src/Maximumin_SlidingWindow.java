
/*
 * Question: A long array A[] is given to you. There is a sliding window of size w, which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position.

Example: The array is [1 3 -1 -3 5 3 6 7], and w is 3.

    Window position                Max 
    ---------------               ----- 
    [1  3  -1] -3  5  3  6  7       3  
    1  [3  -1  -3] 5  3  6  7       3  
    1  3  [-1  -3  5] 3  6  7       5  
    1  3  -1  [-3  5  3] 6  7       5  
    1  3  -1  -3  [5  3  6] 7       6  
    1  3  -1  -3  5  [3  6  7]      7


Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
 */
/*
 * 
 */

/*
 * 	static void findMax(){
int x[]={2,5,1,2,0,2,7,6,5,4,8};
int i=0;
int k=3;
 
// Create a Double Ended Queue, Qi that will store indexes of array elements
// The queue will store indexes of useful elements in every window and it will
// maintain decreasing order of values from front to rear in Qi, i.e.,
// arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
Deque<Integer> q=new ArrayDeque<Integer>();
 
for(;i<k;i++){
// For every element, the previous smaller elements are useless so
// remove them from q
while(!q.isEmpty() && x[q.peekLast()]<=x[i]){
q.removeLast();
}
q.addLast(i); // Add new element at rear of queue
}
for ( ; i <x.length; ++i){
 
// The element at the front of the queue is the largest element of
// previous window, so print it
System.out.println(x[q.peek()]);
 
// Remove the elements which are out of this window
while(!q.isEmpty() && q.peekFirst()<=i-k){
q.removeFirst();// Remove from rear
}
 
// Remove all elements smaller than the currently
// being added element (remove useless elements)
while(!q.isEmpty() && x[q.peekLast()]<=x[i]){
q.removeLast();
}
 
q.addLast(i);
}
 
System.out.println(x[q.peek()]);
}
 */

import java.util.*;

class Maximumin_SlidingWindow
{

public static void main(String ar[])
{

Integer a[]=new Integer[]{1,3,-1,-3,5,3,6,7};
int w=3,i=0;
int size=a.length;
Integer b[]=new Integer[size-w+1];

maxSlidingWindow(a,size,w,b);

for(i=0;i<b.length;++i)
	System.out.print(" "+b[i]);

}

static void maxSlidingWindow(Integer A[], int n, int w, Integer B[])
{
//Integer ar[]=new Integer[1];
Deque Q = new ArrayDeque();
 Q.add(0);
 
 System.out.println("initial " + Q.toString());

//Initilize deque Q for first window
for (int i = 0; i < w; i++)
{
while (!Q.isEmpty() && A[i] >= A[(int) Q.peekLast()]){
     Q.pollLast();
    }
Q.offerLast(i);
} //for
System.out.println(" " + Q.toString());

for (int i = w; i < n; i++)
{
B[i-w] = A[(int) Q.peekFirst()];
System.out.println("B [i] " +B[i-w]);

//update Q for new window
while (!Q.isEmpty() && A[i] >= A[(int) Q.peekLast()])
         Q.pollLast();

//System.out.println("i= " +i +"" + Q.toString());

//Pop older element outside window from Q
while (!Q.isEmpty() && (int)Q.peekFirst() <= i-w){   //i-w as only w elemnt of present window
	Q.pollFirst();							//	must be in queue not previous elemnt..
										//so if i-w  i.e 5-3=2..so if now Q is 
											//having index 1 so it is not allowed as only 
									//2-5 are allowd in Q window..sliding window concept

}
//System.out.println("i= " +i +"" + Q.toString());

//Insert current element in Q
Q.offerLast(i);
}
B[n-w] = A[(int) Q.peekFirst()];
}

} 