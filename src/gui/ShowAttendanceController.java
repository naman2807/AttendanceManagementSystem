package gui;

import data.Attendance;
import database.DataBaseConnection;
import database.DataSource;
import formatter.DateFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @FXML
    private PieChart attendancePie;
    @FXML
    private Label name;
    @FXML
    private Label id;

    public void invokePieChart(){
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount() == 1){
                try {
                    loadWindow();
                } catch (IOException | SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        });
    }

    private void loadWindow() throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showattendancepiechart.fxml"));
        Parent root = loader.load();
        stage.setTitle("Attendance Graph");
        ShowAttendanceController controller = loader.getController();
        controller.showPieChart(tableView);
        stage.setScene(new Scene(root, 845,700));
        stage.show();
    }

    private void showPieChart(TableView<Attendance> tableView1) throws SQLException, IOException {
        if(tableView1.getSelectionModel().getSelectedItem() != null){
            double present = 0;
            double absent = 0;
            Attendance attendance = tableView1.getSelectionModel().getSelectedItem();
            setLabels(attendance);
            ObservableList<Attendance> attendances = DataSource.getAttendanceOfStudent(DataBaseConnection.getConnection(), attendance.getId());
            if(attendances == null){
                return;
            }
            present = (double) attendances.stream().filter(attendance1 -> attendance1.getStatus().equalsIgnoreCase("present")).count();
            absent = (double) attendances.stream().filter(attendance1 -> attendance1.getStatus().equalsIgnoreCase("absent")).count();
            loadChart(present, absent);
        }
    }

    private void setLabels(Attendance attendance){

    }

    private void loadChart(double present, double absent) throws IOException, SQLException {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("PRESENT", present),
                new PieChart.Data("ABSENT", absent)
        );
        attendancePie.setData(list);
    }


    public void populateTable() throws SQLException {
        dateLabel.setText(DateFormatter.getCurrentFormattedDate());
        ObservableList<Attendance> attendances = DataSource.getAttendanceRecord(DataBaseConnection.getConnection(), DateFormatter.getCurrentFormattedDate());
        if(attendances == null){
            return;
        }
        tableView.setItems(attendances);
        invokePieChart();
    }
}
