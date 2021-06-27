package gui;

import data.Attendance;
import data.Candidate;
import database.DataBaseConnection;
import database.DataSource;
import formatter.DateFormatter;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: gui
 * Project Name: AttendanceManagementSystem
 * Date: 24-06-2021
 */

public class MarkAttendanceController {
    @FXML
    private TableView<Candidate> candidateTableView;


    public void setCandidateTable() throws SQLException {
        ObservableList<Candidate> candidates = DataSource.getCandidatesList(DataBaseConnection.getConnection());
        candidateTableView.setItems(candidates);
    }

    public void markAttendance(Stage stage){
        candidateTableView.getItems().forEach(MarkAttendanceController::accept);
    }

    private static void accept(Candidate candidate) {
        if (candidate.getStatus().isSelected()) {
            try {
                DataSource.uploadAttendance(DataBaseConnection.getConnection(), new Attendance(candidate.getId(),
                        "PRESENT", DateFormatter.getCurrentFormattedDate()));
            } catch (SQLException throwables) {
                System.err.println("Cannot upload attendance");
            }
        } else {
            try {
                DataSource.uploadAttendance(DataBaseConnection.getConnection(), new Attendance(candidate.getId(),
                        "ABSENT", DateFormatter.getCurrentFormattedDate()));
            } catch (SQLException throwables) {
                System.err.println("Cannot upload attendance");
            }
        }
    }

}
