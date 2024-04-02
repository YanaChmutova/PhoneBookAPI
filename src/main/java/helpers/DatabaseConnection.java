package helpers;

import models.ContactModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    public void contactDatabaseRecorder(String id, ContactModel contactModel) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/phonebook";
        String username = "root";
        String password = "4121566";

        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println("Connection successful!!!");

        String insertQuery = "INSERT INTO contacts(id, name, lastName, email, phone, address, description)"+
                "VALUES (?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, contactModel.getName());
        preparedStatement.setString(3, contactModel.getLastName());
        preparedStatement.setString(4, contactModel.getEmail());
        preparedStatement.setString(5, contactModel.getPhone());
        preparedStatement.setString(6, contactModel.getAddress());
        preparedStatement.setString(7, contactModel.getDescription());
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {

            System.out.println("Insert successful!");
        }else {

            System.out.println("Not successful...");
        }
        preparedStatement.close();
        connection.close();
    }
}
