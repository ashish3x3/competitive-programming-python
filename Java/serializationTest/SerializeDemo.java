package serializationTest;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerializeDemo implements Serializable {
	
	public static void main(String [] args){
	
	//create a employee object
	Employee e=new Employee();
	e.name="Ashish";
	e.SSN=123456;
	e.address="aks133844@gmail.com";
	e.number=123;
	
	//create a try catch block to implement seriliazable methods
	try{
		
		FileOutputStream fout=new FileOutputStream("C:/Users/Ashish/Documents/test.ser");
		ObjectOutputStream o=new ObjectOutputStream(fout); //to make serilizable object
		o.writeObject(e); //making it serializable
		o.close();
		fout.close();
		System.out.printf("Serialized data is saved in /test.ser");
		
	}catch(IOException ex){
		
		ex.printStackTrace();
		return;
	}
	
	
	
	
	
	
	}
	

}
