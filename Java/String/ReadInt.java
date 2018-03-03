/*Validate Input Is A Number
Source: (ReadInt.java)*/

import java.util.*;
 
public class ReadInt {
 
   public static void main(String[] args) {
 
      Scanner sc = new Scanner(System.in);
 
      try {
 
         System.out.print("Enter Integer: ");
         int i = sc.nextInt();
         System.out.println("You entered: " + i);
 
      } catch (InputMismatchException e) {
         System.out.println("You did not enter a Integer.");
      }
   }
}
 

/*Output:

$ java ReadInt 
Enter Integer: string
You did not enter a Integer.

$ java ReadInt 
Enter Integer: 222
You entered: 222*/
