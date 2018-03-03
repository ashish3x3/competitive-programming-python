public class EqualTest{
	public static void main(String args[]){
		String str1 =  new String("abc");
		String str2 =  new String ("abc");
		//JVM makes some optimization steps with Strings
               if(str1==str2){
			System.out.println("str1==str2 is true");
		}else{
			System.out.println("str1==str2 is false");
		}

		if(str1.equals(str2)){
			System.out.println("str1.equals(str2) is true");
		}else{
			System.out.println("str1.equals(str2) is false");
		}

		 String str3="abc",str4="abc";
		if(str3==str4){
			System.out.println("str3==str4 is true");
		}else{
			System.out.println("str3==str4 is false");
		}
	}
}
