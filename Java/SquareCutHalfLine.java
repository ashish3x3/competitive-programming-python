import java.util.*;


public class SquareCutHalfLine{
			
			public static Scanner scan=new Scanner(System.in);
				
				public static Square s1;
				public static Square s2;
				
				public static void main(String [] args){
				
						SquareCutHalfLine sc=new SquareCutHalfLine();
						sc.input(s1);
						sc.input(s2);
						
						sc.cutCall(s1,s2);
				
				
				} //main
				
				public void cutCall(Square s1,Square s2){
						
						Square.print(s1);
						Square.print(s2);
						Line X=Square.cut(s1,s2);
						//System.out.println(" "+ X.start.x + " " +X.y);
						X.print();
				
				} //cutCall
				
				public void input(Square s){
					
					int x,y;
					Point a,b,c,d;
					/*
					System.out.println(" enter x and y of point");
					x=scan.nextInt();
					y=scan.nextInt();
					*/
					/*
					a=new Point(scan.nextInt(),scan.nextInt());
					b=new Point(scan.nextInt(),scan.nextInt());
					c=new Point(scan.nextInt(),scan.nextInt());
					d=new Point(scan.nextInt(),scan.nextInt());
					*/
					a=new Point(1,1);
					b=new Point(3,1);
					c=new Point(3,1);
					d=new Point(3,3);
					s=new Square();
					s.init(a,b,c,d);
					
				
				
				} //input

} //class


	class Square{
			
				Point leftTop;
				Point rightTop;
				Point leftBottom;
				Point rightBottom;
				
				public Square(){System.out.println("Square constructor");}
				
				public void init(Point a, Point b,Point c,Point d){
						
						this.leftBottom=a;
						System.out.println(" leftBottom = " + this.leftBottom.x + "  " +this.leftBottom.y);
						this.rightBottom=b;
						System.out.println(" leftBottom = " + this.rightBottom.x + "  " +this.rightBottom.y);
						this.leftTop=c;
						System.out.println(" leftBottom = " + this.leftTop.x+ "  " +this.leftTop.y);
						this.rightTop=d;
						System.out.println(" leftBottom = " + this.rightTop.x+ "  " +this.rightTop.y);
						
						System.out.println(" initialization done");
						
				
				} //init
				
				
				public static Line cut(Square s1,Square s2){
				
					System.out.println(" cut call");
				
					Point e=middle(s1);
					Point r=middle(s2);
					if(e==r){
						System.out.println(" cut call if ");
						return new Line(new Point((s1.leftBottom.x+s1.rightBottom.x)/2,(s1.leftBottom.y+s1.leftTop.y)/2),new Point((s2.leftBottom.x+s2.rightBottom.x)/2,(s2.leftBottom.y+s2.leftTop.y)/2));
					}
					else{
							System.out.println(" cut call else ");
							return new Line(e,r);
					}
				
				} //cut
				
				public static  Point middle(Square s){
					
						System.out.println(" Point Middle call ");
				
						return new Point((s.leftBottom.x+s.rightBottom.x)/2,(s.leftBottom.y+s.leftTop.y)/2);
				
				} //middle
				
				public static void print(Square s){
				
						//System.out.println(" Square obj = " + s.leftBottom.x +" "+ s.rightBottom.y+" "+ s.leftTop.x+ " " +s.rightTop.y );
				
				}
				
				
	 
	} //Square
	
	
	class Point{
				
					int x;
					int y;
				
					public Point(int x, int y) {
							this.x = x;
							this.y = y;
					}
					
				} //Point

	class Line {
	
				Point start;
				Point end;
				
				public Line(Point st,Point en){
					
					this.start=st;
					this.end=en;
				
				}
				
				public void print(){
						
					System.out.println(" "+ this.start.x + " " +this.start.y + " "+ this.end.x + " " +this.end.y);	
				
				} //print
			} //Line
					