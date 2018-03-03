import java.util.Scanner;


public class HashTablePrimeNo {

	public static void main(String [] args){
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("enetr size of Hash Table");
		
		HashTable ht=new HashTable(scan.nextInt());
		
		char choice;
		
		//System.out.println("");
		do{
            System.out.println("\nHash Table Operations\n");

            System.out.println("1. insert ");

            System.out.println("2. remove");

            System.out.println("3. contains");            

            System.out.println("4. clear");  
            
            //int choice;
            
            switch(scan.nextInt()){
            
            case 1 : System.out.println("\nEnter number to insert\n");
            			ht.insert(scan.nextInt());
            			break;
            case 2:  System.out.println("\nEnetr element to delete\n");	
            			ht.delete(scan.nextInt());
            			break;
            			
            case 3 :	System.out.println("\n Enete number to check\n");
            				if(ht.contains(scan.nextInt()))
            					System.out.println("element found");
            				else
            					System.out.println("element NOT found");
            				break;
            				
            case 4 :	System.out.println("\n Want to clear Hash Table to 0\n");
            				ht.clear();
            				break;
            				
            default :  System.out.println("\n Wrong Choice \n");
            			break;
         
            
            }
            ht.printTable();
            System.out.println("\n Want to Enter again\n");
            choice=scan.next().charAt(0);
			
		}while(choice=='Y' || choice=='y');
		
		
		
	}

}
