import java.util.*;

public class ArithWithOnlyPlusOp{
		
		public static void main(String [] args){
				
				int a,b;
				int ch=0,res=0;
				System.out.println("Enter a and b with space separated");
				Scanner scan=new Scanner(System.in);
				a=scan.nextInt();
				b=scan.nextInt();
				
				while(true){
					System.out.println("Enter your choice");
					System.out.println("1. Sub ");
					System.out.println("2. Multiply");
					System.out.println("3. Div");
					System.out.println("4. Exit");
					
					ch=scan.nextInt();
					
					if(ch>=1 && ch<=4){
							
							res=arith(a,b,ch);
							System.out.println("Res = " + res);
					
					} //if
					
					else
						System.out.println("Enter your choice Between 1 to 4");
				
				
				} //while
		
		} //main
		
		public static int FnNegate(int a) {
				int neg = 0;
				int d = a < 0 ? 1 : -1;
					while (a != 0) {
						neg += d;
						a += d;
					}
		return neg;
		}
		
		public static boolean neg(int b){
		
				return b<0;
		}
		
		
		
		public static int arith(int a,int b,int ch){
					
					int res=0;
					int flag=0;
					switch(ch){
							
							case 1 :	flag=0;
										System.out.println("1. Sub ");
										b=FnNegate(b);
										res+=a+b;
										break;
										
							case 2 : 	
										System.out.println("2. Multiply ");
										if(neg(b)){
										b=FnNegate(b);
										flag=1;
										}
										for(int i=1;i<=b;++i){
											
											res+=a;
											
										}
										break;
										
							case 3 :	
										System.out.println("3. Divide ");
										if(neg(b) && neg(b)){
											b=FnNegate(b);
											a=FnNegate(a);											
										}
										if(!neg(b)){
											System.out.println("inside !neg(b)");
											b=FnNegate(b);
											flag=0;
										}
										 if(neg(a)){
										System.out.println("inside neg(a)");
											a=FnNegate(a);
											flag=1;
											
										}
										
										//if(flag==0) flag=1;
											while(true){
												
												a=a+b;
												if(a>=0){
													res++;
												}
												else{
													break;
												}
											
											} //while
										break;
							case 4 :
										System.out.println("4. Exit ");
										System.exit(1);
					
					}//switch
					
					
					return (flag==0  )?res:FnNegate(res);
					
					
					
					
					
					
		
		} //arith
		
		/*
			H:\java>javac ArithWithOnlyPlusOp.java

H:\java>java ArithWithOnlyPlusOp
Enter a and b with space separated
12 4
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
3
3. Divide
Res = 3
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
1
1. Sub
Res = 8
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
2
2. Multiply
Res = 48
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
4
4. Exit
		*/
		
		/*  AFTER HANDING ALL CORNER CASES OF ++ +- -+ --
		
		
H:\java>javac ArithWithOnlyPlusOp.java

H:\java>java ArithWithOnlyPlusOp
Enter a and b with space separated
-12 -4
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
3
3. Divide
inside !neg(b)
Res = 3
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
4
4. Exit

H:\java>java ArithWithOnlyPlusOp
Enter a and b with space separated
-12 4
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
3
3. Divide
inside !neg(b)
inside neg(a)
Res = -3
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
4
4. Exit

H:\java>java ArithWithOnlyPlusOp
Enter a and b with space separated
12 -4
Enter your choice
1. Sub
2. Multiply
3. Div
4. Exit
3
3. Divide
inside !neg(b)
inside neg(a)
Res = -3
		
		*/

}  //class