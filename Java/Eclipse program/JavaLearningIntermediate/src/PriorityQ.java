import java.util.*;
public class PriorityQ {

	public static void main(String[] args) {
		PriorityQueue<String> queue=new PriorityQueue<String>();
		
		queue.offer("First");
		queue.offer("Second");
		queue.offer("Third");
		
		System.out.println(""+queue);
		
		System.out.println(""+queue.peek());
		
		queue.poll();
		
		System.out.println(""+queue.peek());
		System.out.println(""+queue);

	}

}
