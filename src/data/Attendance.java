package data;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: data
 * Project Name: AttendanceManagementSystem
 * Date: 08-06-2021
 */

public class Attendance{
    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");
    private final SimpleStringProperty date = new SimpleStringProperty("");

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(id, that.id) && Objects.equals(status, that.status) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, date);
    }
}
