package lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

   private String user;
   private String password;
   
   Connection conn = null;
   ConnectionParam param;
   String ret = null;
   public String execute() {
	  param = new ConnectionParam();
      try {
    	  Class.forName(param.dbdriver);
    	  conn = DriverManager.getConnection(param.dburl, param.dbusername, param.dbpassword);
         
    	  String sql = "SELECT * FROM users WHERE";
    	  sql+=" username = '" + user +"' AND password = '" + password + "';";
    	  Statement s = conn.createStatement();
         
    	  ResultSet rs = s.executeQuery(sql);

    	  while (rs.next()) {
    		  ret = SUCCESS;
    	  }
      } catch (Exception e) {
         ret = ERROR;
      } finally {
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
            }
         }
      }
      return ret;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}