package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagement {
 private static final String url="jdbc:mysql://localhost:3306/hospital";
 private static final String username="root";
 private static final String password="abc123";
 
 public static void main(String args)
 {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch (ClassNotFoundException e){
		e.printStackTrace();
	}
	 Scanner scanner = new Scanner(System.in);
	 try {
		Connection connection= DriverManager.getConnection(url, username, password);
		Patient patient= new Patient(connection,scanner);
		Doctor doctor = new Doctor(connection);
		while(true){
			System.out.println("Hospital Management System");
			System.out.println("1.Add patient");
			System.out.println("2.View patient");
			System.out.println("3.View Doctor");
			System.out.println("4.Book Appointment");
			System.out.println("0.Exit");
		    System.out.println("Enter your Choice");
		    int choice= scanner.nextInt();
		    switch (choice) {
			case 1:
				patient.addPatient();
				break;
	         case 2:
				patient.viewPatient();
				break;
	          case 3:
				doctor.viewDoctor();
				break;
	            case 4:
				
				break;
	            case 0:
					return;
					
				
				
				

			default:
				break;
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
 }
}
