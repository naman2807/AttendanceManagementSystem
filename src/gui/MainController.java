package gui;

import alert.MyAlert;
import database.DataBaseConnection;
import database.DataSource;
import formatter.DateFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
    private PasswordField password;
    @FXML
    private Pane addCandidate;
    @FXML
    private Pane markAttendancePane;

    @FXML
    public void handleKeyReleased(){
        if(!userID.getText().isEmpty() && !userID.getText().trim().isEmpty()){
            login.setDisable(password.getText().isEmpty() || password.getText().trim().isEmpty());
        }else {
            login.setDisable(true);
        }
    }

    @FXML
    public void handleMouseClick(MouseEvent event) throws SQLException, IOException {
        if(event.getSource() == addCandidate){
            addCandidateToRecord();
        }else if(event.getSource() == markAttendancePane){
            markAttendance();
        }
    }

    private void markAttendance() throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("markattendance.fxml"));
        Parent root = loader.load();
        MarkAttendanceController controller = loader.getController();
        controller.setCandidateTable();
        stage.setTitle("Mark Attendance");
        stage.setScene(new Scene(root, 845, 700));
        controller.setStage(stage);
        if(DataSource.validateDateForAttendance(DataBaseConnection.getConnection(), DateFormatter.getCurrentFormattedDate())){
            MyAlert.createAlert(Alert.AlertType.ERROR, "STOP!","DATE: " + DateFormatter.getCurrentFormattedDate(),
                    "Attendance Uploaded Already");
            stage.close();
            return;
        }
        stage.show();
    }

    private void validateDateForAttendance(){

    }

    private void addCandidateToRecord() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addcandidate.fxml"));
        stage.setTitle("Add Candidate");
        stage.setScene(new Scene(loader.load(), 845,519));
        stage.show();
    }

    public void login() throws SQLException, IOException {
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
        stage.setScene(new Scene(root, 845, 519));
        stage.show();
    }
}
