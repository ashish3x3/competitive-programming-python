//Array Declaration  type var_name
/*An array is a container object that holds a fixed number of values of a single type.
 The length of an array is established when the array is created. 
After creation, its length is fixed  Each item in an array is called an element,
 and each element is accessed by its numerical index*/

class ArrayDemo
{
public static void main(String args[])
{
int month_days[]=new int[12];
month_days[0]=31;
month_days[1]=28;
month_days[2]=31;
month_days[3]=30;
System.out.println(month_days[4]);
}
}
// int month_days[]={31,28,31,30};