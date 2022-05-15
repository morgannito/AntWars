module com.example.antwars {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.antwars to javafx.fxml;
    exports com.antwars;
}