package gui;

import database.DataBaseConnection;
import database.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

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
    public void handleKeyReleased(){
        if(!userID.getText().isEmpty() && !userID.getText().trim().isEmpty()){
            login.setDisable(password.getText().isEmpty() || password.getText().trim().isEmpty());
        }else {
            login.setDisable(true);
        }
    }

    @FXML
    public void handleMouseClick(ActionEvent event) throws SQLException {
        if(event.getSource() == login){
            login();
        }
    }

    private void login() throws SQLException {
        String user = userID.getText();
        String pass = password.getText();
        DataSource.loginIntoSystem(DataBaseConnection.getConnection(), user, pass);
        showMainWindow();
    }


    private void showMainWindow(){

    }
}
