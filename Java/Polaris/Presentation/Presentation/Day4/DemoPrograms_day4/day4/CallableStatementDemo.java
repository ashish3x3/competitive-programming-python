package com.demoprograms.day4;

 
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementDemo {

	public static void main(String[] args) throws Exception {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
	    System.out.println("connected"); 
		CallableStatement cs=c.prepareCall("{call proc}");
		cs.execute();
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}
		}
}
