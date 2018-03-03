import java.util.*;
import java.io.*;

public class MatrixRead{ 
		
		public static int  [][] mat=null;
		
		
		public static void main(String [] args) throws IOException{
			
			String fileName="matrixToReadInJava.txt";
			Scanner scan=new Scanner(new FileReader(fileName));
			String rows=scan.nextLine();
			int row=Integer.parseInt(rows);
			String  cols=scan.nextLine();
			int col=Integer.parseInt(cols);
			System.out.println(" rows and cols  " +row +" "+col);
			
			mat=new int[row][col];
			String line;
			String[] temp;
			int lineCount=0;;
			while(scan.hasNextLine()){
				line=scan.nextLine();
				//line = line.trim().replaceAll("\\s+", " ");
				temp=line.split(" ");  //space " " in quptes in cumpolsury
				
				for(int i=0;i<temp.length;++i){
					
						mat[lineCount][i]=Integer.parseInt(temp[i]);
					}
					lineCount++;
				
				
				
			
			}//while
			printArray();
			
			
        } //main
		
		
		
		
		public static void printArray () { 
        for (int i =0; i <mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print("  " +mat[i][j]);
            }
            System.out.println("");
    }    
		
 
 }
 
 } //class