import java.util.*;


public class SquarCut{
			
			//public static Scanner scan=new Scanner(System.in);
				
				public  Square sq;
				//public static Square s2;
				
				public static void main(String [] args){
				
						SquarCut s1=new SquarCut();
						SquarCut s2=new SquarCut();
						
					Line X=	s1.cut(s2);
					X.print();
				
				} //main
				
				
				public SquarCut(){
				
					this.sq=new Square();
					sq.init();
				
				}
				
				public void print(){
						
						this.sq.print();
				
				
				}
				
				public  Line cut(SquarCut s2){
				
					System.out.println(" cut call");
				
					Point e=this.sq.middle();
					Point r=s2.sq.middle();
					if(e.x==r.x && e.y==r.y){
						System.out.println(" cut call if ");
						return new Line(new Point((this.sq.leftBottom.x+this.sq.rightBottom.x)/2,(this.sq.leftBottom.y+this.sq.leftTop.y)/2),new Point((s2.sq.leftBottom.x+s2.sq.rightBottom.x)/2,(s2.sq.leftBottom.y+s2.sq.leftTop.y)/2));
					}
					else{
							System.out.println(" cut call else ");
							return new Line(e,r);
					}
					
				
				
				} //cut
				
				
				
				

} //class


	class Square{
			
				Point leftTop;
				Point rightTop;
				Point leftBottom;
				Point rightBottom;
				
				public void init(){
				
					Point a,b,c,d;
					/*
					a=new Point(1,1);
					b=new Point(3,1);
					c=new Point(3,1);
					d=new Point(3,3);
					
					*/
					Scanner scan=new Scanner(System.in);
					a=new Point(scan.nextInt(),scan.nextInt());
					b=new Point(scan.nextInt(),scan.nextInt());
					c=new Point(scan.nextInt(),scan.nextInt());
					d=new Point(scan.nextInt(),scan.nextInt());
					
					this.leftBottom=a;
						System.out.println(" leftBottom = " + this.leftBottom.x + "  " +this.leftBottom.y);
					this.rightBottom=b;
						System.out.println(" rightBottom = " + this.rightBottom.x + "  " +this.rightBottom.y);
					this.leftTop=c;
						System.out.println(" leftTop = " + this.leftTop.x+ "  " +this.leftTop.y);
					this.rightTop=d;
						System.out.println(" rightTop = " + this.rightTop.x+ "  " +this.rightTop.y);
						
						System.out.println(" initialization done");
					
				
				}  //init
				
				
				
				public  Square(){
						
				} //Square
				
				
				
				public Point middle(){
					
						System.out.println(" Point Middle call ");
				
						return new Point((this.leftBottom.x+this.rightBottom.x)/2,(this.leftBottom.y+this.leftTop.y)/2);
				
				} //middle
				
				public  void print(){
				
						System.out.println(" Square obj \n 1st cordinate = " + this.leftBottom.x +" "+ this.rightBottom.y+" \n 2nd cordinate"+ this.leftTop.x+ " " +this.rightTop.y );
				
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
			
			
	/*
	H:\java>java SquarCut
1 1
3 1
1 3
3 3
 leftBottom = 1  1
 rightBottom = 3  1
 leftTop = 1  3
 rightTop = 3  3
 initialization done
4 1
6 1
4 3
6 3
 leftBottom = 4  1
 rightBottom = 6  1
 leftTop = 4  3
 rightTop = 6  3
 initialization done
 cut call
 Point Middle call
 Point Middle call
 cut call else
 2 2 5 2
	
	*/
					