import java.sql.*;  

class MysqlCon{  
  public static void main(String args[]){  
    try{  
      Class.forName("com.mysql.jdbc.Driver");  
      Connection con=DriverManager.getConnection(  
        "jdbc:mysql://172.17.0.2:3306/db_colleges",
        "root",
        "Test1235"
      );

      Statement stmt=con.createStatement();  

      ResultSet rs = stmt.executeQuery("SELECT * FROM Quote;");  

      while(rs.next())  
      System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  

      con.close();  
    } catch(Exception e){
      System.out.println(e);
    }  
  }  
}
