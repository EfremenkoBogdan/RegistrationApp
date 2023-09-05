package com.example.registrationapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HelloWorkingScene extends HelloController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView appleImage;

    @FXML
    private ImageView beachImage;

    @FXML
    private ImageView flowersImage;

    @FXML
    private Button homeButton;

    @FXML
    private ImageView nightImage;

    @FXML
    void initialize() {
        homeButton.setOnAction(actionEvent -> {
            homeButton.getScene().getWindow().hide();
            openNewScene("hello-view.fxml");

        });
    }

}
