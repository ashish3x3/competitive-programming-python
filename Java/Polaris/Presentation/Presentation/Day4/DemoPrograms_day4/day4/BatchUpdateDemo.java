package com.demoprograms.day4;


import java.sql.*;

public class BatchUpdateDemo{
	public static void main(String[] args) {
		System.out.println("Prepared Statement Batch Update example!");
		Connection  con;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
			try{
				con.setAutoCommit(false);
				Statement st = con.createStatement();
				st.addBatch("INSERT into emp_new VALUES(12,'binu',3500)");

				String table2 = "DELETE FROM trial WHERE i = 42";

				st.addBatch(table2);
				st.executeBatch();

				con.commit();
				con.close();
				System.out.println("Successfull!");
			}
			catch (BatchUpdateException s){
				System.out.println("SQL statement is not executed!");
				con.rollback();
				System.out.println(s);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
} 