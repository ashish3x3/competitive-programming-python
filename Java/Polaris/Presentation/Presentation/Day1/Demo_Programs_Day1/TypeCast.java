class TypeCast
{
public static void main(String args[])
{
System.out.println("variables created");

byte b=50;
int i=1234;
float f1=3.142F;



System.out.println("b="+b);
System.out.println("i="+i);
System.out.println("f1="+f1);


System.out.println("");
System.out.println("Types converted");
short s1=(short)b;
short s2=(short)i; 
int m1=(int)f1; 

System.out.println("b="+s1);
System.out.println("(short)i="+s2);
System.out.println("(int)f1="+m1);
}
}