package com.example.registrationapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloRegistration extends HelloController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField countryField;

    @FXML
    private CheckBox femaleCheckBox;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private CheckBox maleCheckBox;

    @FXML
    private CheckBox otherCheckBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField userNameField;

    @FXML
    void initialize() {



        signUpButton.setOnAction(actionEvent -> {
            signUpNewUser();
            signUpButton.getScene().getWindow().hide();
            openNewScene("hello-view.fxml");


        });

    }

    private void signUpNewUser() {

        DatabaseHandler databaseHandler = new DatabaseHandler();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String userName = userNameField.getText();
        String password = passwordField.getText();
        String country = countryField.getText();
        String gender = "";

        if (femaleCheckBox.isSelected()) {
            gender = "Female";
        }
        else if (maleCheckBox.isSelected()) {
            gender = "Male";
        }
        else if (otherCheckBox.isSelected()) {
            gender = "Other";
        }

        Customer customer = new Customer (lastName, firstName, gender, country, userName, password);
        databaseHandler.signUpUser(customer);
    }

}
