package com.demoprograms.day4;

 

import java.sql.*;
class PrepStatementDemo
{
public static void main(String args[])
{

try{


Class.forName("oracle.jdbc.OracleDriver");
	Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
 System.out.println("Connected");

PreparedStatement pst=c.prepareStatement("insert into emp_new values(?,?,?)");


pst.setInt(1,Integer.parseInt(args[0]));
pst.setString(2,args[1]);
pst.setInt(3,Integer.parseInt(args[2]));
System.out.println("Done");
pst.executeUpdate();
pst.close(); 
c.close(); 


}catch(Exception e)
{
System.out.println("Exception :  " +e);
}
}
}






