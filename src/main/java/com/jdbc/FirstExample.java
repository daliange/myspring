package com.jdbc;

//STEP 1. Import required packages
import java.sql.*;

public class FirstExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/test";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "daliange";
   
   public static void main(String[] args) {
	   
   Connection conn = null;
   PreparedStatement pstmt = null;
   Statement stmt = null;
   String sql = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      
      
      /*delete删除*/
      sql = "delete from Employees";
      pstmt = (PreparedStatement) conn.prepareStatement(sql);
      pstmt.execute();
      
      /*insert插入*/
      sql = "insert into Employees (id, first, last, age) values (?,?,?,?)";
      pstmt = (PreparedStatement) conn.prepareStatement(sql);
      pstmt.setInt(1, 1);
      pstmt.setInt(2, 2);
      pstmt.setInt(3, 3);
      pstmt.setInt(4, 4);
      pstmt.executeUpdate();
      
      /*update更新*/
      sql = "update Employees set first=?,last=?";
      pstmt = (PreparedStatement) conn.prepareStatement(sql);
      pstmt.setString(1, "a");
      pstmt.setString(2, "b");
      pstmt.executeUpdate();
      
      /*select查询*/
      sql = "SELECT id, first, last, age FROM Employees";
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         int age = rs.getInt("age");
         String first = rs.getString("first");
         String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", First: " + first);
         System.out.print(", Last: " + last);
         System.out.println(", Age: " + age);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample - by www.yiibai.com