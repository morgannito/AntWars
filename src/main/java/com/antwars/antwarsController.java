package com.antwars;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class antwarsController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}