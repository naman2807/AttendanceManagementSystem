package gui;

import alert.MyAlert;
import data.Attendance;
import database.DataBaseConnection;
import database.DataSource;
import database.SQLQueries;
import formatter.DateFormatter;
import formatter.TimeFormatter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private Pane showAttendance;
    @FXML
    private Label totalStudents;
    @FXML
    private Label totalDays;
    @FXML
    private Label totalPresent;

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
        }else if(event.getSource() == showAttendance){
            showAttendancePane();
        }
    }

    private void showAttendancePane() throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showattendance.fxml"));
        Parent root = loader.load();
        stage.setTitle("Attendance Record");
        ShowAttendanceController controller = loader.getController();
        controller.populateTable();
        stage.setScene(new Scene(root, 845,700));
        stage.show();
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
        if(TimeFormatter.validateTime()){
            MyAlert.createAlert(Alert.AlertType.WARNING,"TIME PROBLEM","CURRENT TIME : " +
                    TimeFormatter.getCurrentTime(),"Cannot mark attendance at this time.");
            return;
        }
        if(DataSource.validateDateForAttendance(DataBaseConnection.getConnection(), DateFormatter.getCurrentFormattedDate())){
            MyAlert.createAlert(Alert.AlertType.ERROR, "STOP!","DATE: " + DateFormatter.getCurrentFormattedDate(),
                    "Attendance Uploaded Already");
            return;
        }
        controller.setStage(stage);
        stage.show();
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


    private void showMainWindow() throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainwindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Attendance Management Portal");
        MainController controller = loader.getController();
        controller.setLabels();
        stage.setScene(new Scene(root, 845, 519));
        stage.show();
    }

    private void setLabels() throws SQLException {
        totalStudents.setText(String.valueOf((long) DataSource.getCandidatesList(DataBaseConnection.getConnection()).size()));
        totalDays.setText(DataSource.getTotalWorkingDays(DataBaseConnection.getConnection()));
        totalPresent.setText(getPresentStudentCount());
    }

    private String getPresentStudentCount() throws SQLException {
        int count = 0;
        ObservableList<Attendance> attendances = DataSource.getAttendanceRecord(DataBaseConnection.getConnection(),DateFormatter.getCurrentFormattedDate());
        if(attendances == null){
            return String.valueOf(count);
        }
        count = (int) attendances.stream().filter(e -> e.getStatus().equalsIgnoreCase("present")).count();
        return String.valueOf(count);
    }
}
