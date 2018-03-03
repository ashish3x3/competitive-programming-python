import java.util.Scanner;
 
public class Validate {
 
   public static void main(String[] args) {
 
      // These are the valid charecters
      String valids = "12345abcde";
 
      Scanner sc = new Scanner(System.in);
 
      System.out.print("Enter string: ");
      String str = sc.nextLine();
 
      for (int x=0; x < str.length(); x++){
 
         // less then zero means invalid char
         if( valids.indexOf(str.charAt(x)) < 0 ) {
            System.out.println("Invalid string: " + str);
            System.exit(0);
         }
      }
 
      System.out.println("Valid string: " + str);
   }
}
 
/*
Output:

$ java Validate
Enter string: abcdef
Invalid string: abcdef

$ java Validate
Enter string: abc123
Valid string: abc123*/

