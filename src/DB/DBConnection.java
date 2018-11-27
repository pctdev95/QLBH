package DB;
import java.sql.*;

public class DBConnection {
	public static Connection CreateConnection() {
		Connection conn = null;
		
		//"jdbc:mysql://hostname/databaseName"
		String url = "jdbc:mysql://localhost:3306/qlbh";
		String username = "root";
		String password = "thien7761311";
		
		try {
			//Load Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Tao ket noi
			conn = DriverManager.getConnection(url, username, password);
		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		
		return conn;
	}
}
