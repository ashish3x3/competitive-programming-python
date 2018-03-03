
public class TernaryOperator {
	public static void main(String[] args)
	  {
	    // min value example
	    int minVal, a=3, b=2;
	    minVal = a < b ? a : b;
	    System.out.println("min = " + minVal);
	   
	    // result is assigned the value 1.0
	    float result = true ? 1.0f : 2.0f;
	    System.out.println("float = " + result);
	 
	    // result is assigned the value "Sorry   it's false"
	    String s = false ? "That was true" : "Sorry it's false";
	    System.out.println(s);
	    
	    // example using the ternary operator   in a string
	    int x = 5;
	    String out = "There " + (x > 1 ? " are " + x + " cookies" : "is one cookie") + " in the jar.";
	    System.out.println(out);

	  }
	}
