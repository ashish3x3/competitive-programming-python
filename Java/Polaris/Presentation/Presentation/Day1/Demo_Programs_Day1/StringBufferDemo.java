import java.lang.*;

public class StringBufferDemo{
  public static void main(String[] args) {
  System.out.println("StringBuffer insert and append example!");
  StringBuffer sb = new StringBuffer();
  //First position
  System.out.println(sb.insert(0, "vinod"));
  int len = sb.length();
  //last position
  System.out.println(sb.insert(len, "Deepak"));
  //Six position
  System.out.println(sb.insert(6, "Raj"));
  //Always last
  System.out.println(sb.append("Mohit"));
  String st=sb.toString();
  StringBuffer sb1=new StringBuffer(st); 
   
  }
} 