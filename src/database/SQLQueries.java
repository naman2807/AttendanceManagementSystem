package database;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: database
 * Project Name: AttendanceManagementSystem
 * Date: 07-06-2021
 */

public class SQLQueries {
    private static final String CANDIDATE_TABLE = "candidate_tbl";
    private static final String ID = "id";
    private static final String ATTENDANCE_TABLE = "attendance";
    private static final String STATUS = "status";

    public static String insertCandidateQuery(){
        return "INSERT INTO " + CANDIDATE_TABLE + " VALUES(?, ?, ?, ?)";
    }

    public static String insertNewAttendanceCandidateQuery(){
    }
}
