package com.example.registrationapp;
import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connection = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connection, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(Customer customer) {

        String insertSQL = "INSERT INTO " + Constant.CUSTOMER_TABLE + "(" +
                Constant.CUSTOMER_LASTNAME + "," + Constant.CUSTOMER_FIRSTNAME + "," +
                Constant.CUSTOMER_GENDER + "," + Constant.CUSTOMER_COUNTRY + "," +
                Constant.CUSTOMER_USERNAME + "," + Constant.CUSTOMER_PASSWORD + ")" +
                "VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertSQL);
            preparedStatement.setString(1, customer.getLastName());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getCountry());
            preparedStatement.setString(5, customer.getUsername());
            preparedStatement.setString(6, customer.getPassword());

            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getCustomer(Customer customer) {
        ResultSet resultSet = null;

        String select ="SELECT * FROM " + Constant.CUSTOMER_TABLE +
                " WHERE " + Constant.CUSTOMER_USERNAME + "=? AND " + Constant.CUSTOMER_PASSWORD + "=?";
        try {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getPassword());

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
