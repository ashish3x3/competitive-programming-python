package com.demoprograms.day4;

 

import java.sql.*;


public class DML_Demo {
 
	 
	public static void main(String[] args) throws Exception {
		
		Connection c=null;
		Statement stmt=null;
		 

	try{
		Class.forName("oracle.jdbc.OracleDriver");
	  c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
    System.out.println("connected"); 
	  stmt=c.createStatement();
    stmt.executeUpdate("Insert into emp_new values(107,'priyas',5500)");
	 stmt.executeUpdate("update emp_new set sal=14000 where eno=34");
     
	 }
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
		//finally block used to close resources
     if (c!=null)
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     if (stmt!=null)
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}
	}

}
