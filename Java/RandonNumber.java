import java.util.*;

public class RandonNumber{
		
		public static void main(String [] args){
		
				Random t=new Random();
				int high=23,low=12;
				int r=high-low-1;
				int c=t.nextInt(r);
				System.out.println(""+(c+low));
				System.out.println(""+(c+high));
		
		}  //main

} //class