package com.demoprograms.day4;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Fun_Demo {

	public static void main(String[] args) throws Exception {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
	    System.out.println("connected"); 
		
	    CallableStatement cs=c.prepareCall("{?=call Findsal(?)}");
	    cs.registerOutParameter(1,Types.INTEGER);//java.sql type
		cs.setString(2, args[0]);
		
		cs.execute();
		int retvalue=cs.getInt(1);
		if (retvalue!=0)
		System.out.println(retvalue);
		else
			System.out.println("not found");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
}
