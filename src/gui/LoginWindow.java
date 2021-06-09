package gui;

import database.DataBaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: gui
 * Project Name: AttendanceManagementSystem
 * Date: 09-06-2021
 */

public class LoginWindow extends Application {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
        DataBaseConnection.connectToDataBase();
    }

    public static Stage getStage(){

    }
}
