package data;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: data
 * Project Name: AttendanceManagementSystem
 * Date: 07-06-2021
 */

public class Candidate {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleLongProperty phoneNumber = new SimpleLongProperty();
    private SimpleStringProperty id = new SimpleStringProperty("");
    private SimpleStringProperty address = new SimpleStringProperty("");

    public Candidate() {
    }
}
