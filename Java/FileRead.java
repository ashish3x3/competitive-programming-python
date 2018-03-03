import java.util.*;
import java.io.*;

public class FileRead{ 
		
		public static String [] words=null;
		
		
		public static void main(String [] args){
		
			Scanner scan=new Scanner(System.in);
			String fileName="TextFileToReadInJava.txt";
			
			try{
			//System.out.println(" before reading file" );
			readFile(fileName);
			//System.out.println(" After reading file" );
			}catch(IOException ex){
			System.out.println(" after read file exception" );
				ex.printStackTrace();
			}
			
			for(int i=0;i<words.length;++i){
				System.out.println(" " + words[i]);
			}
			
		
		} //main
		
		public static void readFile(String fileName)throws IOException
      {	
         Scanner input = new Scanner(new FileReader(fileName));
         int i=0;									//index for placement in the array
         String line;
		 
		 try{
			//System.out.println(" before rgeting file Size" );
			int N=getFileSize(fileName);
			words=new String[N];
			//System.out.println(" after rgeting file Size" );
			}catch(IOException ex){
			//System.out.println(" after rgeting file Size exception" );
				ex.printStackTrace();
			}
		
         while (input.hasNextLine())		//while there is another line in the file
         {
            line=input.nextLine();			//read in the next Line in the file and store it in line
            words[i]= line;					//add the line into the array
            i++;									//advance the index of the array         
         }
         input.close();						
      }
 
 
       public static int getFileSize(String fileName)throws IOException
 
      {
         Scanner input = new Scanner(new FileReader(fileName));
         int size=0;
         while ((input.hasNextLine()))	//while there is another line in the file
         {
			//System.out.println(" calc size" );
            size++;	
			input.nextLine();
		}
		return size;		//add to the size
	}	
/*

H:\java>java FileRead
 ashish
 kumar
 singh

 manish kumar singh

 sanjeet giri

 over...
*/


/*
File file =new File("c:\\ihave10lines.txt");
 
    		if(file.exists()){
 
    		    FileReader fr = new FileReader(file);
				
				=====
				File file = new File(filename);
      if (!file.exists() || !file.isFile()) {
         System.out.println("File doesn\'t exist");
         return -1;
      }
      return file.length();
*/
} //class