import java.util.Scanner;

class Student1
{
 	int id;
	String name;
	
	void accept()
	{
		Scanner scan=new Scanner(System.in);
		id=scan.nextInt();
		name=scan.nextLine();
	}
	
	 
}

public class StudentArray {

	public static void main(String args[])
	{
		 	 
		Student1 studs[]=new Student1[3];
	//	Scanner scan=new Scanner(System.in);
	 
		 for (int i=0;i<studs.length;i++)
		 {
		
			 
		System.out.println("Enter id and name");	 
		 studs[i]=new Student1();
		 			
	     studs[i].accept();
	    
		 }
		 System.out.println(studs[0].id);
	}
}
