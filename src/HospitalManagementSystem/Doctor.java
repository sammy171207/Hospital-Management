package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    private Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;
    }

    public void viewDoctor() {
        String query = "SELECT * FROM doctor";
        try {
            PreparedStatement preparestatement = connection.prepareStatement(query);
            ResultSet resultSet = preparestatement.executeQuery();
            System.out.println("+--------------------------------------------------+");
            System.out.println("| DoctorId | DoctorName         | Specialization   |");
            System.out.println("+--------------------------------------------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("| %-8d| %-20s| %-16s|%n", id, name, specialization);
            }
            System.out.println("+--------------------------------------------------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getDoctorById(int id) {
        String query = "SELECT * FROM doctor WHERE id=?";
        try {
            PreparedStatement preparestatement = connection.prepareStatement(query);
            preparestatement.setInt(1, id);
            ResultSet resultSet = preparestatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
