import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class EditListEx {

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
	    
 editList(list,list2);
	    
	    for(int i=0;i<list.size();++i)
	    System.out.print("list after removing list2 from it"+list.get(i));

	}
	
public static void editList(Collection<String> l1,Collection<String> l2){
		
		Iterator<String> it=l1.iterator();
		
		
		
		while(it.hasNext()){
			
			if(l2.contains(it.next()))
				it.remove();
		}


}
}
