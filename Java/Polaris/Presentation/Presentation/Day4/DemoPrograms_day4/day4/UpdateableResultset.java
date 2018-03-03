package com.demoprograms.day4;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateableResultset {
	

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("loaded");
		 conn=DriverManager.getConnection(" jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
		
	    System.out.println("connected"); 
		Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		 
		String query = "SELECT empno,ename,sal FROM emp";
		ResultSet rs = statement.executeQuery(query);
		System.out.println("Before Update");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":"+ rs.getInt(3));
		}
		//Updating First Row 
		rs.first();
		rs.updateString(2, "priyanew");
		rs.updateRow();
		
		rs.last();
		rs.updateString(2, "monadnew");
		rs.updateRow();
		
		System.out.println("After Update");

		rs.beforeFirst();
		while (rs.next()) {
			System.out.println(rs.getString(1) + ":" + rs.getString(2) + ":"+ rs.getString(3));
					 

		}
		rs.close();
		
		statement.close();
		conn.close();
	}
}

