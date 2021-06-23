package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

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
        if(name.getText().isEmpty() || name.getText().trim().isEmpty() || phoneNumber.getText().isEmpty()
        || phoneNumber.getText().trim().isEmpty() || address.getText().isEmpty() || address.getText().trim().isEmpty()){
            addCandidate.setDisable(true);
        }else {
            addCandidate.setDisable(false);
        }
    }

    public void addCandidate(){
        String cName = name.getText();
        String cPhone = phoneNumber.getText();
        String cAddress = address.getText();
    }

    private String generateID(String name, String number){
        return String.valueOf(name.toCharArray()[0] + number.toCharArray()[0] +
                number.toCharArray()[1] + number.toCharArray()[2] + new Random().nextInt(100));
    }
}
