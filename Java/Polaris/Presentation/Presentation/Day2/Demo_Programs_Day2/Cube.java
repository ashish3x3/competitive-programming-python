 
public class Cube {

	int length;
	int breadth;
	int height;

	 void getVolume() {
     System.out.println("Volume of cube is "+length *breadth * height);
	}

// Constructor

	   Cube() {
		length = 10;
		breadth = 10;
		height = 10;
	}
	
//Constructor with arguments

    Cube(int l, int b, int h) {
		length = l;
		breadth = b;
		height = h;
               
	}
    
// Constructor with object as parameters
Cube(Cube cube)
{
	
	this.breadth=cube.breadth;
	this.height=cube.height;
	this.length=cube.length;
}

public static void main(String[] args) {

	Cube cubeObj1 = new Cube();
	Cube cubeObj2 = new Cube(10, 20, 30);
    Cube cubeObj3=new Cube(cubeObj2);
               cubeObj1.getVolume();
               cubeObj2.getVolume();
               cubeObj3.getVolume();
}
}