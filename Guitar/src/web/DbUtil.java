package web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	
	static String url="jdbc:mariadb://localhost:3306/test";
	static String userName="root";
	static String password="123";
	static Connection conn=null;
	public static Connection getConnection(){
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");	
			conn=DriverManager.getConnection(url,userName,password);
	System.out.println("數據庫鏈接成功");
		}catch(ClassNotFoundException e){
			
		}		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
