package data;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: data
 * Project Name: AttendanceManagementSystem
 * Date: 08-06-2021
 */

public class Attendance{
    private SimpleStringProperty id = new SimpleStringProperty("");
    private SimpleStringProperty status = new SimpleStringProperty("");
    private SimpleStringProperty date = new SimpleStringProperty("");

    public Attendance() {
    }

    public Attendance(String id, String status, String date){
        this.id.set(id);
        this.status.set(status);
        this.date.set(date);
    }
}
