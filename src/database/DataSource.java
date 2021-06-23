package database;

import alert.MyAlert;
import data.Candidate;
import gui.LoginWindow;
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

    private boolean validateCandidate(Candidate candidate){
        return false;
    }

}
