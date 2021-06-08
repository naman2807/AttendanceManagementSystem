package alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: alert
 * Project Name: AttendanceManagementSystem
 * Date: 08-06-2021
 */

public final class MyAlert {
    private MyAlert(){}

    public static void createAlert(Alert.AlertType alertType, String title, String headerText, String content){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            alert.close();
        }
    }
}
