import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.*;

/*

H:\Computer S
1
Enetr N
5
9 31
28 84
51 67
71 91
80 99
Enetr M

7
17 7
85 41
54 34
62 19
64 60
87 24
93 73

8

H:\Computer S
1
Enetr N
3
32 62
42 68
12 98
Enetr M
7
95 13
97 25
93 37
79 27
75 19
49 47
67 17

3




*/


public class SnakesAndLaddersWithTest
{

 private static List<Movers> snakesAndLadders;

        public static void main(String[] args)
        {

          snakesAndLadders = new ArrayList<Movers>();

          int T;

          Scanner scan=new Scanner(System.in);

          T=scan.nextInt();

         
         

          while(T-- > 0){
          	 snakesAndLadders = new ArrayList<Movers>();
          	 //System.out.println("Enetr N");
          	 int N=scan.nextInt();
          while(N-- > 0){

          snakesAndLadders.add(new Movers(scan.nextInt(), scan.nextInt()));

      }

      // System.out.println("Enetr M");
          int M=scan.nextInt();


          while(M-- > 0){

          snakesAndLadders.add(new Movers(scan.nextInt(), scan.nextInt()));

      }

          /*snakesAndLadders.add(new Movers(17, 7));

          snakesAndLadders.add(new Movers(28, 84));

          snakesAndLadders.add(new Movers(85, 41));

          snakesAndLadders.add(new Movers(51, 67));

          snakesAndLadders.add(new Movers(54, 34));

          snakesAndLadders.add(new Movers(62, 19));

          snakesAndLadders.add(new Movers(64, 60));

          snakesAndLadders.add(new Movers(71, 91));

          snakesAndLadders.add(new Movers(80, 99));

          snakesAndLadders.add(new Movers(87, 24));

          snakesAndLadders.add(new Movers(93, 73));*/


          int[] moveMap = new int[101];

          for (Movers movers : snakesAndLadders)
               moveMap[movers.start] = movers.end;

         int[] minMove = new int[101];
         int[] dice = new int[101];
         int[]fromCell=new int[101];

         LinkedList<Integer> queue = new LinkedList<Integer>();
         queue.add(1);
         boolean finished=false;
         while (!queue.isEmpty()&&!finished)
         {
           int cell = queue.poll();

           for (int i = 1; i <= 6; ++i)
           {
            int newCell = moveMap[cell + i] == 0 ? cell + i : moveMap[cell + i];
            if (minMove[newCell] == 0)
            {
             minMove[newCell] = minMove[cell] + 1;
             dice[newCell]=i;
             fromCell[newCell]=cell;
             queue.add(newCell);
           }
           if(newCell==100)
           {	
           		System.out.println(""+minMove[newCell]);
             finished=true;
             break;
           }

         }

       }
       if(minMove[100]==0)
                System.out.println("-1");  
       /*int cell=100;
       Stack<String> stack=new Stack<String>();*/
      /* while(cell!=1)
       {
         stack.push("new cell "+cell);
         stack.push("dice throw "+dice[cell]);

         cell=fromCell[cell];
       }
       while(!stack.isEmpty())
         System.out.println(stack.pop());
     }*/
 }

    
  }

}


class Movers
  {

   public int start;

   public int end;

   public boolean goingUp;

   public Movers(int start, int end)
   {

    this.start = start;

    this.end = end;
  }
}       


/*
2
3
32 62
42 68
12 98
7
95 13
97 25
93 37
79 27
75 19
49 47
67 17

4
8 52
6 80
26 42
2 72
9
51 19
39 11
37 29
81 3
59 5
79 23
53 7
43 33
77 21 

3 
5

*/

