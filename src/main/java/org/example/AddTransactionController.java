package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AddTransactionController {

    @FXML
    private TextField referenceField;
    @FXML
    private TextField timestampField;
    @FXML
    private TextField comptesField;

    @FXML
    public void handleSubmitTransaction() {
        String reference = referenceField.getText();
        Timestamp timestamp = Timestamp.valueOf(timestampField.getText()); // Ensure this is in the correct format
        String[] compteNames = comptesField.getText().split(","); // Assume user enters comma-separated names
        List<Compte> comptes = new ArrayList<>();

        // Here you would typically retrieve the Compte objects from a database or a list
        // For now, we will assume that we can create them directly for demonstration purposes
        for (String compteName : compteNames) {
            Compte compte = new Compte(compteName.trim(), new Date(1), new Date(1), 0); // Dummy values
            comptes.add(compte);
        }

        // Create the Transaction object
        Transaction transaction = new Transaction(timestamp, reference, comptes);
        // Here you can add logic to store the transaction object

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Transaction Added");
        alert.setHeaderText(null);
        alert.setContentText("Transaction with reference " + reference + " added successfully!");
        alert.showAndWait();
    }

    @FXML
    public void handleCancel() {
        // Logic to go back to the dashboard
    }
}