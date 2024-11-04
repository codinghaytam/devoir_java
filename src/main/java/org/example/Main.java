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
        launch(args);
        Database db = new Database();
        Connection stml=db.connect();
        PreparedStatement pst=stml.prepareStatement("CREATE TABLE IF NOT EXISTS Man (id int,nom varchar(100));");
        pst.execute();
    }
}
