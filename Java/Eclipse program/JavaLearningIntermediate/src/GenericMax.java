
public class GenericMax {

	public static void main(String[] args) {
		
		String[] str={"Ashish","Manish","Sanjeet","Ashish","Rohit","Manish","Raj"};
		
		System.out.println(max("A","S","R"));

	}
	
	public static <T extends Comparable> T max(T a,T b ,T c){
		T m=a;
		if(a.compareTo(b)>0)
			m=b;
		if(c.compareTo(m)>0)
			m=c;
		
		return m;
	}

}
