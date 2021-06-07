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
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleLongProperty phoneNumber = new SimpleLongProperty();
    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty address = new SimpleStringProperty("");

    public Candidate() {
    }

    public Candidate(String name, long phoneNumber, String id, String address){
        this.name.set(name);
        this.phoneNumber.set(phoneNumber);
        this.id.set(id);
        this.address.set(address);
    }
}
