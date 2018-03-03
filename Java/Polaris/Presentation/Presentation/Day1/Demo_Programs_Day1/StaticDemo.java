import java.io.*;
  class Stat{
   // salary  variable is a private static variable
   private  double salary;

   // DEPARTMENT is a constant
   public static final String DEPARTMENT = "Development";

public double retsal(double sl)
{
salary=sl;
return salary;

}
}

class StaticDemo  
{
   public static void main(String args[]){
        Stat d=new Stat();
 
         
        System.out.println(Stat.DEPARTMENT+" Average salary:"+d.retsal(1000));
          
        
   }
}
