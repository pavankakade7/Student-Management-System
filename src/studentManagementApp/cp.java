package studentManagementApp;

import java.sql.Connection;
import java.sql.DriverManager;

// cps is connection provider...	

public class cp {
	
	static Connection con;
	public  static Connection createC(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//create connections
			String user="root";
			String password="skywalker";
			String url="jdbc:mysql://localhost:3306/student";
			con=DriverManager.getConnection(url, user, password);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
