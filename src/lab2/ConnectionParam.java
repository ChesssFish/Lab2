package lab2;

public class ConnectionParam {
	
	public String dburl;
	public String dbusername;
	public String dbpassword;
	public String dbdriver;
	
	ConnectionParam()
	{
   	 	dburl = String.format("jdbc:mysql://%s:%s/%s",
			 	System.getenv("MYSQL_HOST"),
			 	System.getenv("MYSQL_PORT"),
			 	System.getenv("MYSQL_DB"));
   	 	dbusername = System.getenv("ACCESSKEY");
   	 	dbpassword = System.getenv("SECRETKEY");
   	 	dbdriver = "com.mysql.jdbc.Driver";
	}
}
