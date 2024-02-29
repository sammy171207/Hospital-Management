package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Patient {
	private  Connection connection;
	private Scanner scanner;
	 public Patient (Connection connection,Scanner scanner){
		 this.connection=connection;
		 this.scanner=scanner;
		 
	 }
	 public void addPatient() {
		 System.out.print("Enter Patient Name");
		 String name=scanner.next();
		 System.out.println("Enter Patient Age");
		 int age=scanner.nextInt();
		 System.out.println("Enter Patient Gender");
		 String gender=scanner.next();
		 try {
			 String query="INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
			 PreparedStatement preparestatement = connection.prepareStatement(query);
			 preparestatement.setString(1, name);
			 preparestatement.setInt(2, age);
			 preparestatement.setString(3, gender);
			 int affectedRows=preparestatement.executeUpdate();
			 if(affectedRows>0)
			 {
				 System.out.println("Data insert Successfully");
				 
			 }
			 else{
				 System.out.println("Data not inserted");
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	public void viewPatient() {
		String query= "select* from patients";
		try {
			PreparedStatement preparestatement =connection.prepareStatement(query);
			ResultSet resultSet =preparestatement.executeQuery();
			System.out.println("+--------------------------------------------------+");
			System.out.println("+--------PatientId-----PatientName--Age---Gender");
			System.out.println("---------------------------------------------");
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String name= resultSet.getString("name");
				int age=resultSet.getInt("age");
				String gender=resultSet.getString("gender");
				System.out.printf("-------------------------------------------------",id,name,age,gender);
			}
			
		} catch ( SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	public boolean getPatientById(int id) {
		String query="SELECT * FROM patients where id=?";
		try {
			PreparedStatement preparestatement=connection.prepareStatement(query);
			preparestatement.setInt(1, id);
			ResultSet resultSet= preparestatement.executeQuery();
			if(resultSet.next()){
				return true;
				
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub

	}

}
