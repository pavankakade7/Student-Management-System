package studentManagementApp;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class start {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		System.out.println("welcome to student Management application");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to DELETE student info");
			System.out.println("Press 3 to DISPLAY student info");
			System.out.println("Press 4 to EXIT APP");
			// c is nothing  but choice
			int c=Integer.parseInt(br.readLine());
			
			
			if(c==1) {
				// add students...
				System.out.println("Enter the student name:");
				String name= br.readLine();
				
				System.out.println("Enter the student phone:");
				String phone= br.readLine();
				
				System.out.println("Enter the student city:");
				String city= br.readLine();
				
				
				// create student object to store the student information...
				student st = new student(name, phone, city);
				boolean ans=studentDao.insertStudentToDB(st);
				if(ans) {
					System.out.println("student is  added successfully...");
				}
				else {
					System.out.println("something went wrong try again...");
				}
				System.out.println(st);
				
			}else if(c==2) {
				
				//delete student...
				System.out.println("enter student id for delete");
				int userId=Integer.parseInt(br.readLine());
				boolean f=studentDao.deleteStudent(userId);
				if(f) {
					System.out.println("deleted successfully...");
					
				}else {
					System.out.println("something wents wrong...");
				}
			}else if(c==3) {
				// display student...
				studentDao.showAllStudents();
			}else if(c==4) {
				//exit app...
				break;
			}else {
				System.out.println("user has entred wrong choices...");
				System.out.println("please enter the following choices...");
				
			}
			
			
		}
		System.out.println("Thank you for using my application...");
		System.out.println("See you soon... Bye Bye...");
	}

}
