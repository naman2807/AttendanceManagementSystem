package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: gui
 * Project Name: AttendanceManagementSystem
 * Date: 09-06-2021
 */

public class MainController {
    @FXML
    private Button login;
    @FXML
    private TextField userID;
    @FXML
    private TextField password;

    public void initialize(){
        login.setDisable(true);
    }

    @FXML
    public void handleMouseClick(ActionEvent event){
        if(event.getSource() == login){
            login();
        }
    }

    private void login(){

    }
}
