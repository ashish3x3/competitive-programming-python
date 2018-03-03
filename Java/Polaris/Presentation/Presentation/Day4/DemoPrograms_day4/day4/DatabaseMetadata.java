package com.demoprograms.day4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetadata {
	
	public static void main(String args[]) throws  Exception
	{
		
		 Class.forName("oracle.jdbc.OracleDriver");
		    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
		    System.out.println("Connected");
		    DatabaseMetaData dm=conn.getMetaData();
		 
		           System.out.println("get Database Product name : - "  + dm.getDatabaseProductName());
		          System.out.println("get Database Product Version : - "+ dm.getDatabaseProductVersion());
		          System.out.println("Get JDBC Driver Major Version :- "+ dm.getDriverMajorVersion());
		           System.out.println("Get JDBC Driver Minor Version :- "+ dm.getDriverMinorVersion());
		           System.out.println("Get driver Name : -" + dm.getDriverName());
		           System.out.println("get driver version :- " + dm.getDriverVersion());
		           String  s1 = dm.getURL();
		           String  s2 = dm.getSQLKeywords();
		           boolean b1 = dm.supportsTransactions();
		           boolean b2 = dm.supportsSelectForUpdate();
		           System.out.println(s1+" "+s2+" "+b1+" "+b2);

		           

	}

}
