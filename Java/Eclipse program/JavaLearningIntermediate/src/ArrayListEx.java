import java.util.ArrayList;
import java.util.*;


public class ArrayListEx {

	public static void main(String[] args) {
		String [] str1= {"Ashish","Manish","Sanjeet","Ashish","Rohit","Manish","Raj"};
		
		String [] str2= {"Ashish","Manish","Ravi","Ashish","Prakash","Manish","Sanjeet"};
		
		List<String> list =new ArrayList<String>();
		
		List<String> list2 =new ArrayList<String>();
		
		for(String x:str1)
			list.add(x);
	    for(int i=0;i<list.size();++i)	
		System.out.println(""+list.get(i));
	    
	    for(String x:str2)
			list2.add(x);
	    
	    Set<String> intersect =new HashSet<String>(list);
	    
	    intersect.retainAll(list2) ;
	    
	    System.out.println("Intersection"+intersect);
	    
	    
	    Set<String> diff =new HashSet<String>(list);
	    
	    diff.removeAll(list2);
	    
	    System.out.println("Diffrence"+diff);
	    
	    
	    Set<String> union = new HashSet<String>(list);
	    union.addAll(list2);
	    
	    System.out.println("Union"+union);
	    
	    // removing item from list1 that are present in list2
	    
	    editList(list,list2);
	    
	    for(int i=0;i<list.size();++i)
	    System.out.println("list after removing list2 from it"+list.get(i));

	}
	
	public static void editList(List<String> l1,List<String> l2){
		
		Iterator<String> it=l1.iterator();
		
		
		
		while(it.hasNext()){
			
			if(l2.contains(it.hasNext()))
				it.remove();
		}
		
		
	}

}
