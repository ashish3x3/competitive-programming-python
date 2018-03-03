/*Populate Multidimensional Array From Contents Of File
Source: (PopulateArrayFromFile.java)
*/
import java.io.*;
import java.util.*;
 
public class PopulateArrayFromFile {
 
   public static void main(String[] args) throws FileNotFoundException{
 
      File f = new File("file.txt");
      Scanner sc = new Scanner(f);
 
      int[][] myArray = new int[4][3];
 
      for (int i=0; i<4; i++) {
         for (int j=0; j<3; j++) {
            myArray[i][j]=sc.nextInt();
         }
      }
 
      System.out.println("Array contents:");
      for (int i=0; i<4; i++) {
         for (int j=0; j<3; j++) {
            System.out.print(myArray[i][j] + " ");
         }
         System.out.println();
      }
   }
}
 
/*
Output:

$ cat file.txt 
1 2 3
4 5 6
7 8 9
2 4 6

$ java PopulateArrayFromFile
Array contents:
1 2 3 
4 5 6 
7 8 9 
2 4 6 

*/

