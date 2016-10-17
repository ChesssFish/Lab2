package lab2;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteAction extends ActionSupport {
	private String isbn;
	
	Connection conn = null;
	ConnectionParam param;
	private String ret = null;
	
	public String execute()
	{
		System.out.println(isbn);
		
		param = new ConnectionParam();
		try{
	         Class.forName(param.dbdriver);
	         conn = DriverManager.getConnection(param.dburl, param.dbusername, param.dbpassword);
	        
	        String query = "DELETE FROM book WHERE ";
	        query += "isbn = '" + isbn +"';";
	        
	        Statement s = conn.createStatement();
	        s.executeUpdate(query);
	        
		}catch(Exception e){
			ret = ERROR;
		}finally{
			if(conn != null){
				try{
					conn.close();
					ret = SUCCESS;
				}catch(Exception e){}
			}
		}
		
		return ret;
	}
	
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
}
