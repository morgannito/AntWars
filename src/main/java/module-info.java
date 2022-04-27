module com.example.antwars {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.antwars to javafx.fxml;
    exports com.example.antwars;
}