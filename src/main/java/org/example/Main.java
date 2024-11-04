package org.example;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import org.example.Controller;


public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        Parent builtScene = FXMLLoader.load(getClass().getResource("/Page.fxml"));
        primaryStage.setScene(new Scene(builtScene));
        primaryStage.show();
    }
    public static void main(String[] args) throws SQLException {
        //initialation de des table
        Database db = new Database();
        Connection stml=db.connect();
        PreparedStatement pst=stml.prepareStatement("CREATE TABLE IF NOT EXISTS Compte (id int primary key AUTO_INCREMENT,nom varchar(100),dateCreation date,dateUpdate date,Devise int);");
        pst.execute();
        pst=stml.prepareStatement("CREATE TABLE IF NOT EXISTS Transactions (id int primary key AUTO_INCREMENT,letype varchar(100),Time_stamp timestamp,reference varchar(100));");
        pst.execute();
        pst=stml.prepareStatement("CREATE TABLE IF NOT EXISTS Clients (id int primary key AUTO_INCREMENT,nom varchar(100),prenom varchar(100),address varchar(100),phone varchar(100),email varchar(255));");
        pst.execute();
        pst=stml.prepareStatement("CREATE TABLE IF NOT EXISTS Banque (id int primary key AUTO_INCREMENT,pays varchar(255));");
        pst.execute();
        pst=stml.prepareStatement("CREATE TABLE IF NOT EXISTS compte_transaction (id int primary key AUTO_INCREMENT,compteid int,transactionid int);");
        pst.execute();
        pst=stml.prepareStatement("ALTER TABLE Compte\n" +
                "ADD FOREIGN KEY (id) REFERENCES Clients(id);");
        pst.execute();
        pst=stml.prepareStatement("ALTER TABLE Compte\n" +
                "ADD FOREIGN KEY (id) REFERENCES Banque(id);");
        pst.execute();
        // lancer l'interface visual
        launch(args);
    }
}
