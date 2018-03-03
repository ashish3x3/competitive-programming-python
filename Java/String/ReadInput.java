/*Parse Multiple Words From A Sinlgle Input
This java example uses a Scanner that takes a single line and parses it into different object types.
Source: (ReadInput.java)*/

import java.util.*;
 
public class ReadInput {
 
   public static void main(String[] args) {
 
      Scanner sc = new Scanner(System.in);
 
      System.out.println("Example: Hello 123 4.1234 ");
 
      System.out.print("Input: ");
      String str1 = sc.nextLine();
      StringTokenizer st = new StringTokenizer(str1);
 
      try {
 
         String name = st.nextToken();
         int i = Integer.parseInt(st.nextToken());
         float f = Float.parseFloat(st.nextToken());
 
         System.out.println(name + " " + i + " " + f );
 
      } catch (Exception e) {
         System.out.println("Invalid input");
      }
   }
}

/*
Output:

$ java ReadInput
Example: Hello 123 4.1234 
Input: Hello 123 4.567
Hello 123 4.567*/