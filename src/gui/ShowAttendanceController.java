package gui;

import data.Attendance;
import database.DataBaseConnection;
import database.DataSource;
import formatter.DateFormatter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: gui
 * Project Name: AttendanceManagementSystem
 * Date: 27-06-2021
 */

public class ShowAttendanceController {
    @FXML
    private TableView<Attendance> tableView;
    @FXML
    private Label dateLabel;

    public void populateTable() throws SQLException {
        dateLabel.setText(DateFormatter.getCurrentFormattedDate());
        ObservableList<Attendance> attendances = DataSource.getAttendanceRecord(DataBaseConnection.getConnection(), DateFormatter.getCurrentFormattedDate());
        if(attendances == null){
            return;
        }
        tableView.setItems(attendances);
    }
}
