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
    private static final String DATE = "date";
    private static final String USERNAME_PASSWORD_TABLE = "username_password";
    private static final String USERNAME = "userid";

    public static String loginQuery(){
        return "SELECT * FROM " + USERNAME_PASSWORD_TABLE + " WHERE " + USERNAME + " = ?";
    }

    public static String searchCandidateQuery(){
        return "SELECT * FROM " + CANDIDATE_TABLE + " WHERE " + ID + " = ?";
    }

    public static String getCandidatesQuery(){
        return "SELECT * FROM " + CANDIDATE_TABLE;
    }

    public static String insertCandidateQuery(){
        return "INSERT INTO " + CANDIDATE_TABLE + " VALUES(?, ?, ?, ?)";
    }

    public static String insertNewAttendanceQuery(){
        return "INSERT INTO " + ATTENDANCE_TABLE + " VALUES (?, ?, ?)";
    }

    public static String validateDateForAttendanceQuery(){
        return "SELECT * FROM " + ATTENDANCE_TABLE + " WHERE " + DATE + " = ?";
    }

    public static String getAttendanceRecordQuery(){
        return "SELECT * FROM " + ATTENDANCE_TABLE + " WHERE " + DATE + "= ?";
    }

    public static  String getStudentAttendanceQuery(){
        return "SELECT * FROM " + ATTENDANCE_TABLE + " WHERE " + ID + "= ?";
    }

    public static String getDatesFromAttendance(){
        return "SELECT DISTINCT "  + DATE + " FROM " + ATTENDANCE_TABLE;
    }
}
