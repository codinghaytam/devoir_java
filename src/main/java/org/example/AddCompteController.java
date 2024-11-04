package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Date;

public class AddCompteController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField dateCreationField;
    @FXML
    private TextField dateUpdateField;
    @FXML
    private TextField deviseField;

    @FXML
    public void handleSubmitCompte() {
        String nom = nomField.getText();
        Date dateCreation = new Date(); // You might want to parse this from the input
        Date dateUpdate = new Date(); // You might want to parse this from the input
        int devise = Integer.parseInt(deviseField.getText());

        Compte compte = new Compte(nom, dateCreation, dateUpdate, devise);
        // Here you can add logic to store the compte object

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Compte Added");
        alert.setHeaderText(null);
        alert.setContentText("Compte " + nom + " added successfully!");
        alert.showAndWait();
    }

    @FXML
    public void handleCancel() {
        // Logic to go back to the dashboard
    }
}
