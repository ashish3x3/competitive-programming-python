import java.util.*;
public class HashSetEx {

	public static void main(String[] args) {
		String[] str={"Ashish","Manish","Sanjeet","Ashish","Rohit","Manish"};
		
		
		System.out.println(""+Arrays.toString(str)) ;
		
		List<String> list= Arrays.asList(str);
		
		System.out.println(""+list);
		
		
		
		HashSet<String> has =new HashSet<String>(list);
		
		System.out.println(""+has);

	}

}
