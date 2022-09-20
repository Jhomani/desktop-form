import java.sql.*;  

public class MySQL{  
  public static void create(Dessert dessert){  
    try{  
      Class.forName("com.mysql.jdbc.Driver");  

      Connection con = DriverManager.getConnection(  
        "jdbc:mysql://172.17.0.2:3306/systems_two",
        "root",
        "Test1235"
      );

      Statement stmt = con.createStatement();  

      String sentence = String.format(
        "INSERT INTO Dessert(name, detail, price) VALUES('%s', '%s', %.2f)",
        dessert.name,
        dessert.detail,
        dessert.price
      );

      stmt.executeUpdate(sentence);  

      con.close();  
    } catch(Exception e){
      System.out.println(e);
    }  
  }  

  public static void find(){  
    try{  
      Class.forName("com.mysql.jdbc.Driver");  

      Connection con=DriverManager.getConnection(  
        "jdbc:mysql://172.17.0.2:3306/db_colleges",
        "root",
        "Test1235"
      );

      Statement stmt=con.createStatement();  

      ResultSet rs = stmt.executeQuery("SELECT * FROM Quote;");  

      while(rs.next()) {
        System.out.println(
          rs.getString(1) + "  " +
          rs.getString(2) + "  " +
          rs.getString(3)
        );  
      } 

      con.close();  
    } catch(Exception e){
      System.out.println(e);
    }  
  }  
}
