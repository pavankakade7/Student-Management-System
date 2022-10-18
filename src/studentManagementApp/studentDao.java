package studentManagementApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class studentDao {
	
	
	public static boolean insertStudentToDB(student st) {
		
		boolean f=false;
		//jdbc code is here...
		try {
		Connection con =cp.createC();
		String q="insert into students(sname,sphone,scity) values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(q);
		// set the values of parameter..
		
		pstmt.setString(1, st.getStudent_name());
		pstmt.setString(2,st.getStudent_phone());
		pstmt.setString(3,st.getStudent_city());
		
		// execute...
		
		pstmt.executeUpdate();
		
		f=true;
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f=false;
		//jdbc code is here...
		try {
		Connection con =cp.createC();
		String q="delete from students where sid=?";
		PreparedStatement pstmt=con.prepareStatement(q);
		// set the values of parameter..
		
		pstmt.setInt(1,userId);
		
		
		// execute...
		
		pstmt.executeUpdate();
		
		f=true;
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return f;

	}

	public static void showAllStudents() {
		boolean f=false;
		//jdbc code is here...
		try {
		Connection con =cp.createC();
		String q="Select *from students;";
		
		Statement stmt =con.createStatement();
		
		ResultSet set=stmt.executeQuery(q);
		
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString(4);
			
			System.out.println("ID: "+ id);
			System.out.println("name: "+name);
			System.out.println("phone: "+phone);
			System.out.println("city: "+city);
			System.out.println("+++++++++++++++++++++++++++++++++++");
			
		}
		

		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		
	}
}
