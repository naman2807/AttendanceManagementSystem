package database;

import alert.MyAlert;
import data.Candidate;
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

    public static void loginIntoSystem(Connection connection, String userId, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.loginQuery());
        preparedStatement.setString(1, userId);
    }

    public static void addCandidate(Connection connection, Candidate candidate) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.insertCandidateQuery());
        preparedStatement.setString(1, candidate.getName());
        preparedStatement.setString(2, candidate.getPhoneNumber());
        preparedStatement.setString(3, candidate.getId());
        preparedStatement.setString(4, candidate.getAddress());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            MyAlert.createAlert(Alert.AlertType.CONFIRMATION, "SUCCESS", "CANDIDATE ID: " +
                    candidate.getId(), "Candidate has been added to record.");
        }else {
            MyAlert.createAlert(Alert.AlertType.ERROR, "FAILED","CANDIDATE ID: " +
                     candidate.getId(), "Cannot add candidate to database.");
        }
    }

}
