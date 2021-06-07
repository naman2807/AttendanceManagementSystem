package data;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public long getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleLongProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber.set(phoneNumber);
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

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(name, candidate.name) && Objects.equals(phoneNumber, candidate.phoneNumber) && Objects.equals(id, candidate.id) && Objects.equals(address, candidate.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, id, address);
    }
}
