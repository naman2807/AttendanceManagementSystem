package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

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

    public void handleMouseReleased(){
        if(name.getText().isEmpty() || name.getText().trim().isEmpty() || phoneNumber.getText().isEmpty()
        || phoneNumber.getText().trim().isEmpty() || address.getText().isEmpty() || address.getText().trim().isEmpty()){

        }
    }
}
