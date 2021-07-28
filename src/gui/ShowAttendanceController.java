package gui;

import data.Attendance;
import database.DataBaseConnection;
import database.DataSource;
import formatter.DateFormatter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.event.MouseEvent;
import java.io.IOException;
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

    public void initialize(){
        tableView.setOnMouseClicked(e -> {
            try {
                showPieChart();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void showPieChart() throws SQLException {
        if(tableView.getSelectionModel().getSelectedItem() != null){
            int present = 0;
            int absent = 0;
            Attendance attendance = tableView.getSelectionModel().getSelectedItem();
            ObservableList<Attendance> attendances = DataSource.getAttendanceOfStudent(DataBaseConnection.getConnection(), attendance.getId());
        }
    }

    public void populateTable() throws SQLException {
        dateLabel.setText(DateFormatter.getCurrentFormattedDate());
        ObservableList<Attendance> attendances = DataSource.getAttendanceRecord(DataBaseConnection.getConnection(), DateFormatter.getCurrentFormattedDate());
        if(attendances == null){
            return;
        }
        tableView.setItems(attendances);


    }
}
