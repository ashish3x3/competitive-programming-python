import java.util.*;


public class MakeChangeToN{

		public static void main(String [] args){



			System.out.println("" +makeChange(10, 4));


		} //main


 public static int makeChange(int n, int denom) {
  int next_denom = 0;
  switch (denom) {
  case 4:
  next_denom = 3;
  break;
  case 3:
  next_denom = 2;
  break;
  case 2:
  next_denom = 1;
  break;
  case 1:
  return 1;
  }
  int ways = 0;
  for (int i = 0; i * denom <= n; i++) {

  	System.out.println("n=  "+ n + "  denom= " + denom +"  "+"i= " + i +  "  i *denom =" +(i*denom));
  	System.out.println(" next denom =" +next_denom);
  	System.out.println(" ways = " + ways);
  	System.out.println();
  	System.out.println();
  ways += makeChange(n - i * denom, next_denom);
  }
  return ways;
  }
/*

H:\Computer Science\Java\Recursion>java

H:\Computer Science\Java\Recursion>java
n=  10  denom= 4  i= 0  i *denom =0
 next denom =3
 ways = 0   //it is the result of previous ways


n=  10  denom= 3  i= 0  i *denom =0
 next denom =2
 ways = 0


n=  10  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  10  denom= 2  i= 1  i *denom =2
 next denom =1
 ways = 1


n=  10  denom= 2  i= 2  i *denom =4
 next denom =1
 ways = 2


n=  10  denom= 2  i= 3  i *denom =6
 next denom =1
 ways = 3


n=  10  denom= 2  i= 4  i *denom =8
 next denom =1
 ways = 4


n=  10  denom= 2  i= 5  i *denom =10
 next denom =1
 ways = 5


n=  10  denom= 3  i= 1  i *denom =3
 next denom =2
 ways = 6


n=  7  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  7  denom= 2  i= 1  i *denom =2
 next denom =1
 ways = 1


n=  7  denom= 2  i= 2  i *denom =4
 next denom =1
 ways = 2


n=  7  denom= 2  i= 3  i *denom =6
 next denom =1
 ways = 3


n=  10  denom= 3  i= 2  i *denom =6
 next denom =2
 ways = 10


n=  4  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  4  denom= 2  i= 1  i *denom =2
 next denom =1
 ways = 1


n=  4  denom= 2  i= 2  i *denom =4
 next denom =1
 ways = 2


n=  10  denom= 3  i= 3  i *denom =9
 next denom =2
 ways = 13


n=  1  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  10  denom= 4  i= 1  i *denom =4
 next denom =3
 ways = 14


n=  6  denom= 3  i= 0  i *denom =0
 next denom =2
 ways = 0


n=  6  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  6  denom= 2  i= 1  i *denom =2
 next denom =1
 ways = 1


n=  6  denom= 2  i= 2  i *denom =4
 next denom =1
 ways = 2


n=  6  denom= 2  i= 3  i *denom =6
 next denom =1
 ways = 3


n=  6  denom= 3  i= 1  i *denom =3
 next denom =2
 ways = 4


n=  3  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  3  denom= 2  i= 1  i *denom =2
 next denom =1
 ways = 1


n=  6  denom= 3  i= 2  i *denom =6
 next denom =2
 ways = 6


n=  0  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  10  denom= 4  i= 2  i *denom =8
 next denom =3
 ways = 21


n=  2  denom= 3  i= 0  i *denom =0
 next denom =2
 ways = 0


n=  2  denom= 2  i= 0  i *denom =0
 next denom =1
 ways = 0


n=  2  denom= 2  i= 1  i *denom =2
 next denom =1
 ways = 1


23


*/


}




 