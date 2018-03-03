import java.util.Scanner;
public class InputDemo2
{
public int d=10;
public static void main(String args[]) 
{

Scanner scan=new Scanner(System.in);
System.out.println("Enter number");
int n=scan.nextInt();
System.out.println("Enter String");
String s=scan.next();

System.out.println(n+" "+s);

}
}