package com.example.registrationapp;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButtom;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameField;

    @FXML
    void initialize() {
        signInButtom.setOnAction(actionEvent -> {
            String loginText = usernameField.getText().trim();
            String passwordText = passwordField.getText().trim();

            if (!loginText.equals("") && !passwordText.equals("")){
                loginUser(loginText,passwordText);

            }else if (loginText.equals("") && passwordText.equals("")) {
                System.out.println("Password and Username is empty!");
            } else if(loginText.equals("")){
                System.out.println("Username is empty!");
            }else if (passwordText.equals("")) {
                System.out.println("Password is empty!");
            }
        });
        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();
            openNewScene ("SignUpWindow.fxml");
        });
    }

    private void loginUser(String loginText, String passwordText) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Customer customer = new Customer();
        customer.setUsername(loginText);
        customer.setPassword(passwordText);
        ResultSet resultSet = databaseHandler.getCustomer(customer);



        try {
            if (resultSet.next()){
                System.out.println("Success");
                signInButtom.getScene().getWindow().hide();
                openNewScene ("WorkingScene.fxml");
            } else {
                Shake customerLoginAnimation = new Shake(usernameField);
                Shake customerPasswordAnimation = new Shake(passwordField);
                customerLoginAnimation.playAnim();
                customerPasswordAnimation.playAnim();
                System.out.println("False");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

     public void openNewScene (String window) {

         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource(window));

         try {
             loader.load();
         } catch ( IOException e) {
             e.printStackTrace();
         }
         Parent root = loader.getRoot();
         Stage stage = new Stage();
         stage.setScene(new Scene(root));
         stage.show();
    }

}
