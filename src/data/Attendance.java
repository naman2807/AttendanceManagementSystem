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

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
