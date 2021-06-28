package gui;

import data.Attendance;
import formatter.DateFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

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

    public void populateTable(){
        dateLabel.setText(DateFormatter.getCurrentFormattedDate());
    }
}
