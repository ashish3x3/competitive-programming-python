import java.util.*;
public class ArrayToListAndViceVersa {

	public static void main(String[] args) {
		
		String[] str={"Ashish","Manish","Sanjeet","Ashish","Rohit","Manish","Raj"};
	
		List<String> l=Arrays.asList(str);
		
		LinkedList<String> list=new LinkedList<String>(Arrays.asList(str));
		
	     Collections.sort(l);
	     System.out.println("1111"+l); 
	     
	     Collections.sort(l,Collections.reverseOrder());   //reverse order
	     System.out.println("2222"+l); 
	     
	     Collections.reverse(l); 
	     System.out.println("333"+l); 
	     
	     String[] newArray=new String[str.length]; 
	     List<String> listCopy=Arrays.asList(newArray);
	     
	     Collections.copy(listCopy,l);
	     System.out.println("Copyyy"+listCopy);
	     
	     Collections.fill(listCopy,"A");                        //replace all elements with "A"
	     System.out.println("Filll"+listCopy);
	     
	   //  Collections.addAll(l, str);
	     //System.out.println("l+listCopy"+l);
	     
	    // l.addAll(listCopy);
	     //System.out.println("l+listCopy"+l);
	     
	     System.out.println(Collections.frequency(list, "Ashish"));
	     
	     if(Collections.disjoint(l, listCopy))
	    	 System.out.println("They are disjoint");
	     Collections.sort(list);
	     
	     printList(list);
		
		list.add("Manisha");
		list.addFirst("First");
		list.addLast("Last");
		
		str=list.toArray(new String[list.size()]);
		
		System.out.println(""+Arrays.toString(str)); 
		
		
		
		Arrays.sort(str); 
		
		System.out.println(""+Arrays.toString(str));

	}
	
	public static void printList(List<String> l){
		ListIterator<String> it=l.listIterator();
		System.out.println("");
		
		while(it.hasNext())
			System.out.print("  "+it.next());
		
		System.out.println("");
		
		
	}

}
