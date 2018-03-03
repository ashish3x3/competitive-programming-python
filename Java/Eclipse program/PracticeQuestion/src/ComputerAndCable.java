import java.util.*;
public class ComputerAndCable {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N,K;
		System.out.println("Enter the N and K");
		N=scan.nextInt();
		K=scan.nextInt();
		
		int currPc=1;
		int hr=0;
		
		while(true){
			
			
			while(currPc<K){
				
				currPc=currPc*2;
				hr++;
				
				
			}
			hr+=Math.ceil((N-currPc)/(double)K);
			break;
			
			
		}
		
		System.out.println(" hours = "+hr);

	}

}

/*
 * A new educating program was received by the kindergarten. Of course, children have 
 * discovered it immediately and want to play with it as soon as possible. In order 
 * to let them do it the program has to be copied to all the N computers that the 
 * kindergarten had bought just before the default of 1998. At the moment the program 
 * is installed only on one computer. Other computers do not have floppy drives and are 
 * not connected with a local network. The only way to transfer information from one 
 * computer to another is to copy it using a null-modem cable (a cable that connects 
 * two computers directly). So, if the program is installed on a computer, it can be 
 * copied to some other (but only one!) computer within an hour. There are only 
 * K null-modem cables in the kindergarten. Your task is to estimate the minimal 
 * time necessary for copying the program to all the computers in the kindergarten.
Input
The only input line contains two integers separated with a space: N and
 K (1 ≤ N ≤ 109; 1 ≤ K ≤ 109).
Output
You are to output the minimal time (in hours) necessary for copying of 
the program to all the computers.
Sample
input	output

8 3		4

	


*/
