package com.demoprograms.day4;
import java.util.*;
 
class Employee{
    
    private int age;    
    private String name;
    
    public void setAge(int age){
        this.age=age;    
    }
    
    public int getAge(){
        return this.age;    
    }
    
    public void setName(String name){
        this.name=name;    
    }
    
    public String getName(){    
        return this.name;    
    }
}
 

class AgeComparator implements Comparator<Employee> {
    
    public int compare(Employee emp1, Employee emp2){
    
      
        int emp1Age = emp1.getAge();        
        int emp2Age = emp2.getAge();
       
        if(emp1Age < emp2Age)
            return -1;
        else if(emp1Age >emp2Age)
            return 1;
        else
            return 0;    
    }
    
}
 

 
class NameComparator implements Comparator<Employee>{
 
    public int compare(Employee emp1,Employee emp2){    
 
        String emp1Name = emp1.getName();        
        String emp2Name = emp2.getName();
       
        return emp1Name.compareTo(emp2Name);
    
    }
 
}
 
 
public class JavaComparatorExample{
    
    public static void main(String args[]){
       
       
        Employee employee[] = new Employee[4];
       
       
        employee[0] = new Employee();
        employee[0].setAge(40);
        employee[0].setName("Joe");
       
        employee[1] = new Employee();
        employee[1].setAge(20);
        employee[1].setName("Mark");


        employee[2] = new Employee();
        employee[2].setAge(25);
        employee[2].setName("Andrew");
        
        
        employee[3] = new Employee();
        employee[3].setAge(35);
        employee[3].setName("Mark");

        System.out.println("Order of employee before sorting is");
       
        for(int i=0; i < employee.length; i++){
            System.out.println( "Employee " + (i+1) + " name :: " + employee[i].getName() + ", Age :: " + employee[i].getAge());
        }
       
              
        Arrays.sort(employee, new AgeComparator());
        System.out.println("\n\nOrder of employee after sorting by employee age is");
       
        for(int i=0; i < employee.length; i++){
            System.out.println( "Employee " + (i+1) + " name :: " + employee[i].getName() + ", Age :: " + employee[i].getAge());
        }
       
        
        Arrays.sort(employee, new NameComparator());
       
        System.out.println("\n\nOrder of employee after sorting by employee name is");    
        for(int i=0; i < employee.length; i++){
            System.out.println( "Employee " + (i+1) + " name :: " + employee[i].getName() + ", Age :: " + employee[i].getAge());
        }
    
    }
 
}
