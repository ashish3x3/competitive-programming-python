package com.demoprograms.day4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class First_Prop {


	public static void main(String[] args) {


		Connection c=null;
		Statement stmt=null;
		ResultSet rs=null;

		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream("Data.properties"));


			String user = prop.getProperty("username");
			String pass = prop.getProperty("password");
		 
			String url=prop.getProperty("url");
			Class.forName("oracle.jdbc.OracleDriver");
			  c=DriverManager.getConnection(url,user,pass);
			System.out.println("connected");

			  stmt=c.createStatement();
			String sql="select "+ prop.getProperty("eno")+",ename,sal from emp";
			System.out.println(sql);
			  rs=stmt.executeQuery(sql);
			while (rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
            
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
