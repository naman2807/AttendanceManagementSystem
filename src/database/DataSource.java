package database;

import alert.MyAlert;
import data.Attendance;
import data.Candidate;
import gui.LoginWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: database
 * Project Name: AttendanceManagementSystem
 * Date: 08-06-2021
 */

public class DataSource {

    public static boolean loginIntoSystem(Connection connection, String userId, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.loginQuery());
        preparedStatement.setString(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.next()){
            MyAlert.createAlert(Alert.AlertType.WARNING, "FAILED", "CANNOT LOG IN!",
                    "Account with USERNAME: " + userId + " does not exist.");
            return false;
        }
        resultSet.previous();
        while (resultSet.next()){
            if(userId.equalsIgnoreCase(resultSet.getString(1)) && password.equalsIgnoreCase(resultSet.getString(2))){
                LoginWindow.getStage().close();
                return true;
            }else {
                MyAlert.createAlert(Alert.AlertType.WARNING, "FAILED", "CANNOT LOG IN!",
                        "Kindly check your  password.");
                return false;
            }
        }
        return false;
    }

    public static void addCandidate(Connection connection, Candidate candidate) throws SQLException {
        if(validateCandidate(connection, candidate)){
            MyAlert.createAlert(Alert.AlertType.ERROR,"ERROR","CANDIDATE ID: " +
                    candidate.getId(), "Candidate already exists. Cannot add to database.");
            return;
        }
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.insertCandidateQuery());
        preparedStatement.setString(1, candidate.getName());
        preparedStatement.setString(2, candidate.getPhoneNumber());
        preparedStatement.setString(3, candidate.getId());
        preparedStatement.setString(4, candidate.getAddress());
        int result = preparedStatement.executeUpdate();
        if(result == 1) {
            MyAlert.createAlert(Alert.AlertType.CONFIRMATION, "SUCCESS", "CANDIDATE ID: " +
                    candidate.getId(), "Candidate has been added to record.");
        } else {
            MyAlert.createAlert(Alert.AlertType.ERROR, "FAILED","CANDIDATE ID: " +
                     candidate.getId(), "Cannot add candidate to database.");
        }
    }

    private static boolean validateCandidate(Connection connection, Candidate candidate) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.searchCandidateQuery());
        preparedStatement.setString(1, candidate.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public static ObservableList<Candidate> getCandidatesList(Connection connection) throws SQLException {
        ObservableList<Candidate> candidates = FXCollections.observableArrayList();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.getCandidatesQuery());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString(1);
            String phone = resultSet.getString(2);
            String id = resultSet.getString(3);
            String address = resultSet.getString(4);
            candidates.add(new Candidate(id, name, ""));
        }
        return candidates;
    }

    public static void uploadAttendance(Connection connection, Attendance attendance) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.insertNewAttendanceQuery());
        preparedStatement.setString(1, attendance.getId());
        preparedStatement.setString(2, attendance.getDate());
        preparedStatement.setString(3, attendance.getStatus());
        preparedStatement.executeUpdate();
    }

    public static boolean validateDateForAttendance(Connection connection, String date) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.validateDateForAttendanceQuery());

    }

}
