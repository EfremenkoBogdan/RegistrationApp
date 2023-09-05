module com.example.registrationapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.registrationapp to javafx.fxml;
    exports com.example.registrationapp;
}