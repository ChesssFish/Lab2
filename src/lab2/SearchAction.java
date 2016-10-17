package lab2;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchAction extends ActionSupport {
	
	private String name = "";
	private List<Book> booklist;
	Connection conn = null;
	ConnectionParam param;
	String ret = null;
	
	public String execute()
	{
		
		booklist = new ArrayList<Book>();
		param = new ConnectionParam();
		try{
	        Class.forName(param.dbdriver);
	        conn = DriverManager.getConnection(param.dburl, param.dbusername, param.dbpassword);
	        
	        String authorsql = "SELECT * FROM author";
	        if(name.length() != 0){
	        	authorsql += " WHERE name = '" + name +"';";
	        }
	        Statement s = conn.createStatement();
	        ResultSet author = s.executeQuery(authorsql);
	        
	        while(author.next())
	        {
	        	String booksql = "SELECT * FROM book WHERE ";
	        	booksql += "authorid = " + author.getInt("authorid") + ";";
	        	Statement b = conn.createStatement();
	        	ResultSet books = b.executeQuery(booksql);
	        	while(books.next())
	        	{
	        		Book book = new Book();
	        		
	        		book.isbn = books.getString("isbn");
	        		book.title = books.getString("title");
	        		book.authorid = books.getInt("authorid");
	        		book.authorname = author.getString("name");
	        		book.publisher = books.getString("publisher");
	        		if(books.getDate("publishdate") != null)
	        			book.publishdate = books.getDate("publishdate").toString();
	        		else
	        			book.publishdate = null;
	        		book.price = books.getDouble("price");
	        		
	        		booklist.add(book);
	        	}
	        }
		}
		catch(Exception e)
		{
			ret = ERROR;
		}
		finally
		{
			if(conn != null){
				try{
					conn.close();
					ret = SUCCESS;
				}catch(Exception e){}
			}
		}
		return ret;
	}
	
	public List<Book> getBooklist()
	{
		return booklist;
	}
	
	public void setAuthorname(String name)
	{
		this.name = name;
	}
}
