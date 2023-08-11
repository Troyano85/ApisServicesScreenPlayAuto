module com.example.restassured {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restassured to javafx.fxml;
    exports com.example.restassured;
}