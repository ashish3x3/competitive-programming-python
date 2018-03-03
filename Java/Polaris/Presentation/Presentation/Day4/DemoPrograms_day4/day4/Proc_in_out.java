package com.demoprograms.day4;

import java.sql.*;

public class Proc_in_out {
	public static void main(String[] args) throws Exception {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
	    System.out.println("connected");
	    CallableStatement cs=c.prepareCall("{call proc2(?,?)}");
	    cs.setInt(1, 100);
	    cs.registerOutParameter(2,Types.VARCHAR);
	    cs.execute();
	    System.out.println(cs.getString(2));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
}