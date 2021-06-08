package database;

import data.Candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: database
 * Project Name: AttendanceManagementSystem
 * Date: 08-06-2021
 */

public class DataSource {
    public static void addCandidate(Connection connection, Candidate candidate) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.insertCandidateQuery());
        preparedStatement.setString(1, candidate.getName());
        preparedStatement.setString(2, candidate.getPhoneNumber());
        preparedStatement.setString(3, candidate.getId());
    }

}
