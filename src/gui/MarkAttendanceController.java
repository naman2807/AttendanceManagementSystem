package gui;

import data.Candidate;
import database.DataBaseConnection;
import database.DataSource;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

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

    public void markAttendance(){

    }
}
