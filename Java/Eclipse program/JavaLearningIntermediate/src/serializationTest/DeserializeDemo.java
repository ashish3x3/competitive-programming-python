package serializationTest;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class DeserializeDemo implements Serializable {
	
	public static void main(String [] args){
		
		
		Employee e=null;
		 try{
			 
			 FileInputStream fin=new FileInputStream("C:/Users/Ashish/Documents/test.ser");  //opening file for reading
			 ObjectInputStream i=new ObjectInputStream(fin); //deserializing method
			 e = (Employee) i.readObject();   //casting to reading object mandatory
			 i.close();
			 fin.close();
			 
			 
			 
			 
		 }catch(IOException ex){
			 ex.printStackTrace();
			 return;
			 
		 }catch(ClassNotFoundException exx){
			 
			 System.out.println("Class not found");
			 exx.printStackTrace();
			 return;
		 }
		 
		 System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
		
		
	}

}
