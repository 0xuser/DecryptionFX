package sample;

import javafx.scene.control.Alert;

public class Dialogs {

    private Dialogs() {
    }

    public static void informationAlert(String title, String header, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.show();
    }
}
