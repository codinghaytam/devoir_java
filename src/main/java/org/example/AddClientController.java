package org.example;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.List;

public class AddClientController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;

    // List to store clients (you may want to use a more permanent storage in a real application)
    private List<Client> clients = new ArrayList<>();

    @FXML
    public void handleSubmitClient() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        // Validate inputs (basic validation)
        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            showAlert("Input Error", "All fields must be filled out!");
            return;
        }

        // Create the Client object
        Client client = new Client(nom, prenom, adresse, phone, email);
        clients.add(client); // Store the client (in memory for now)

        // Show success message
        showAlert("Client Added", "Client " + nom + " " + prenom + " added successfully!");

        // Clear fields after submission
        clearFields();
    }

    @FXML
    public void handleCancel() {
        // Logic to go back to the dashboard
        // This can be implemented by loading the main dashboard view again
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        nomField.clear();
        prenomField.clear();
        adresseField.clear();
        phoneField.clear();
        emailField.clear();
    }
}