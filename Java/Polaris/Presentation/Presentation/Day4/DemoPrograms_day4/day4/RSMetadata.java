package com.demoprograms.day4;

 

import java.sql.*;
public class RSMetadata {
  public static void main(String[] args) throws Exception {
       
    Class.forName("oracle.jdbc.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
    System.out.println("Connected");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM emp");
    ResultSetMetaData rsmd = rs.getMetaData();
    int NumOfCol=rsmd.getColumnCount();
   
    String ColName=rsmd.getColumnName(1);
    
    System.out.println("Number of Columns="+NumOfCol);
    System.out.println("column name="+ColName);
    st.close();
    conn.close();
  }
}