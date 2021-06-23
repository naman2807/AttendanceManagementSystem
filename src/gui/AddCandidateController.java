package gui;

import data.Candidate;
import database.DataBaseConnection;
import database.DataSource;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.Random;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: gui
 * Project Name: AttendanceManagementSystem
 * Date: 23-06-2021
 */

public class AddCandidateController {
    @FXML
    private TextField name;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField address;
    @FXML
    private Button addCandidate;

    public void handleKeyReleased(){
        addCandidate.setDisable(name.getText().isEmpty() || name.getText().trim().isEmpty() || phoneNumber.getText().isEmpty()
                || phoneNumber.getText().trim().isEmpty() || address.getText().isEmpty() || address.getText().trim().isEmpty());
    }

    public void addCandidate() throws SQLException {
        String cName = name.getText();
        String cPhone = phoneNumber.getText();
        String cAddress = address.getText();
        DataSource.addCandidate(DataBaseConnection.getConnection(), new Candidate(cName, cPhone,generateID(cName,
                        cPhone),cAddress));
    }

    private String generateID(String name, String number){
        char[] nameArray = name.toCharArray();
        char[] phoneArray = number.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        return String.valueOf(name.toCharArray()[0] + number.toCharArray()[0] +
                number.toCharArray()[1] + number.toCharArray()[2] + new Random().nextInt(100));
    }
}
