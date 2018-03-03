 package com.demoprograms.day4;
import java.sql.*;

 

public class First {

	 
	public static void main(String[] args)   {
		Connection c=null;
		Statement stmt=null;
		 ResultSet rs=null;
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		  c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
	    System.out.println("connected");
 	
    stmt=c.createStatement();
    rs=stmt.executeQuery("select empno,ename,sal from emp");
	while (rs.next())
	{
   System.out.println(rs.getInt("empno")+" "+rs.getString(2)+" "+rs.getInt(3));
	 
	}  
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
     if (rs!=null)
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
