package com.demoprograms.day4;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RSDemo {
  public static void main(String[] args) throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","mindspeed");
    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");
    resultSet.first();
    System.out.println( resultSet.getInt(1));
    // Move to the second row
    resultSet.absolute(2);
    System.out.println("You are now in: " + resultSet.getRow());

    // Move 2 records forward from the current position (fourth row)
    resultSet.relative(2);
    System.out.println("You are now in: " + resultSet.getRow());
    resultSet.next();
    System.out.println( resultSet.getInt(1));
   
   System.out.println("You are now in: " + resultSet.getRow());
 
   System.out.println( resultSet.getInt(1));
    // Move to the last row in the result set
    resultSet.absolute(2);
    System.out.println("You are now in: " + resultSet.getRow());
    System.out.println( resultSet.getInt(1));
    resultSet.previous();
     System.out.println("You are now in: " + resultSet.getRow());
     resultSet.absolute(-1);
     System.out.println("You are now in: " + resultSet.getRow());
     
    
  }
}

   
