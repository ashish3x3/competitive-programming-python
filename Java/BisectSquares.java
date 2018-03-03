/**
* Given two squares on a two dimensional plane, find a line that would cut
* these two squares in half.
*
* Soln: The line that cuts the squares passes between the center of both the
* squares!
*
* @author praveen
*
*/

import java.util.*;

		public class BisectSquares {
		
			public static void main(String [] args){
					int [] leftTop=new int[2];	
					int [] rightTop=new int[2];	
					int [] leftBottom=new int[2];	
					int [] rightBottom=new int[2];	
					
					Scanner scan=new Scanner(System.in);
					
					System.out.println(" Enter leftTop x , y with space separated");
						leftTop[0]=scan.nextInt();
						leftTop[1]=scan.nextInt();
						
					System.out.println(" Enter rightTop x , y with space separated");
						rightTop[0]=scan.nextInt();
						rightTop[1]=scan.nextInt();
						
					System.out.println(" Enter leftBottom x , y with space separated");
						leftBottom[0]=scan.nextInt();
						leftBottom[1]=scan.nextInt();
						
					System.out.println(" Enter rightBottom x , y with space separated");
						rightBottom[0]=scan.nextInt();
						rightBottom[1]=scan.nextInt();
						
						BisectSquares b=new BisectSquares(leftTop,rightTop,leftBottom,rightBottom);
						
						
						
						
						System.out.println(" Enter leftTop x , y with space separated");
						leftTop[0]=scan.nextInt();
						leftTop[1]=scan.nextInt();
						
					System.out.println(" Enter rightTop x , y with space separated");
						rightTop[0]=scan.nextInt();
						rightTop[1]=scan.nextInt();
						
					System.out.println(" Enter leftBottom x , y with space separated");
						leftBottom[0]=scan.nextInt();
						leftBottom[1]=scan.nextInt();
						
					System.out.println(" Enter rightBottom x , y with space separated");
						rightBottom[0]=scan.nextInt();
						rightBottom[1]=scan.nextInt();
						
						BisectSquares b1=new BisectSquares(leftTop,rightTop,leftBottom,rightBottom);
						
					Line s=	b1.cut(b);
					
					System.out.println(" Line .x and Line.y =  " +s.x + " " +s.y);
			
			
			} //main
				
		
		
		public BisectSquares(int [] a,int [] b,int [] c,int [] d){
				
				Square s=new Square(a,b,c,d);
		
		}
		
		
		
			Point middle() {
			
				return new Point((this.leftBottom.x + this.rightBottom.x) / 2,(this.leftBottom.y + this.leftTop.y) / 2);
			}
				
				
				public Line cut(Square s) {
				
					Point middle_s = this.middle();
					Point middle_t = s.middle();
					Line line = new Line();
					if (middle_s.x == middle_t.x && middle_s.y == middle_t.y) {
					line.start = s.leftBottom;
					line.end = s.rightTop;
					
				} 
				else {
					line.start = middle_s;
						line.end = middle_t;
				}
	return line;
	}



} //class


class Point {
					public Point(int x, int y) {
							this.x = x;
							this.y = y;
					}
					int x;
					int y;
				}
				
				class Line {
				Point start;
				Point end;
			}
				class Square {
				
				Point leftTop;
				Point rightTop;
				Point leftBottom;
				Point rightBottom;
				
				
				
				public Square(int [] a,int [] b,int [] c,int [] d){
					
					this.leftTop.x=a[0];
					this.leftTop.y=a[1];
					
					this.rightTop.x=b[0];
					this.rightTop.y=b[1];
					
					this.leftBottom.x=c[0];
					this.leftBottom.y=c[1];
					
					this.rightBottom.x=d[0];
					this.rightBottom.y=d[1];
					
					
				
			
			} //Square
		} //class