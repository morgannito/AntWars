module com.example.antwars {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.antwars to javafx.fxml;
    exports com.example.antwars;
}