package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    @FXML
    public void openAddClientForm() {
        loadPage("/addClient.fxml");
    }

    @FXML
    public void openAddCompteForm() {
        loadPage("/addCompte.fxml");
    }

    @FXML
    public void openAddTransactionForm() {
        loadPage("/addTransaction.fxml");
    }

    private void loadPage(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            AnchorPane page = loader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(page));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
