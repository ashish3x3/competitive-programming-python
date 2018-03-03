import java.util.*;
public class LinkedListEx {
	
	public static void main(String []args){
		
		String[] str={"Ashish","Manish","Sanjeet","Ashish","Rohit","Manish","Raj"};
		
		List<String> list=new LinkedList<String>();
		
		for(String x:str)
			list.add(x);
		
		printList(list);
		reverse(list);
		removeFromTo(list,2,5);
		printList(list);
		
		
	}
	
	public static void printList(List<String> l){
		ListIterator<String> it=l.listIterator();
		System.out.println("");
		
		while(it.hasNext())
			System.out.print("  "+it.next());
		
		System.out.println("");
		
		
	}
	
	public static void reverse(List<String> l){
		ListIterator<String> it=l.listIterator(l.size());
		
		while(it.hasPrevious())
			System.out.print("  "+it.previous());
		
		System.out.println("");
			
		
		
	}
	
	public static void removeFromTo(List<String> l,int start,int end){
		
		l.subList(start, end).clear();         //from start to end-1 as it start from index 0
		
		
	}
	
	

}
