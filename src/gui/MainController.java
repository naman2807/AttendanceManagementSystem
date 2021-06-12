package gui;

import database.DataBaseConnection;
import database.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: gui
 * Project Name: AttendanceManagementSystem
 * Date: 09-06-2021
 */

public class MainController {
    @FXML
    private Button login;
    @FXML
    private TextField userID;
    @FXML
    private TextField password;

    @FXML
    public void handleKeyReleased(){
        if(!userID.getText().isEmpty() && !userID.getText().trim().isEmpty()){
            login.setDisable(password.getText().isEmpty() || password.getText().trim().isEmpty());
        }else {
            login.setDisable(true);
        }
    }

    @FXML
    public void handleMouseClick(ActionEvent event) throws SQLException, IOException {
        if(event.getSource() == login){
            login();
        }
    }

    private void login() throws SQLException, IOException {
        String user = userID.getText();
        String pass = password.getText();
        if(DataSource.loginIntoSystem(DataBaseConnection.getConnection(), user, pass)){
            showMainWindow();
        }
    }


    private void showMainWindow() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainwindow.fxml")));
        stage.setTitle("Attendance Management Portal");
        stage.setScene(new Scene(root, 800, 700));
        stage.show();
    }
}
