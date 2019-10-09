package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextArea textarea1;
    @FXML
    private TextArea textarea2;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;

    @FXML
    private ChoiceBox choicebox1;

    List<String> algorithms = new ArrayList<String>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Loading view");

        algorithms.add("MD5 Hash");
        algorithms.add("ROT13");

        choicebox1.getItems().addAll(algorithms);
        choicebox1.getSelectionModel().selectFirst();

    }

    public void handleEncryptButtonClick(){
        String text = textarea1.getText();

        if(text.isEmpty()){
            Dialogs.informationAlert("Information", "Information Alert", "You should write text in the first field.");
        }else{

            try{
                if(choicebox1.getValue().equals("ROT13")){
                    textarea2.setText(CipherManager.rot13(text));
                }
                else if(choicebox1.getValue().equals("MD5 Hash")){
                    textarea2.setText(CipherManager.md5(text));
                }
            }catch(Exception ex){
                System.out.println(ex.fillInStackTrace());
            }

        }


    }
    public void handleDecryptButtonClick(){
        String text = textarea1.getText();

        if(text.isEmpty()){
            Dialogs.informationAlert("Information", "Information Alert","You should write text in the first field.");
        }else{
            try{
                if(choicebox1.getValue().equals("ROT13")){
                    textarea2.setText(CipherManager.rot13(text));
                }
                else if(choicebox1.getValue().equals("MD5 Hash")){
                    textarea2.setText(CipherManager.md5Decode(text));
                }
            }catch(Exception ex){
                System.out.println(ex.fillInStackTrace());
            }
        }


    }

    public void handleClearButtonClick(){
        textarea1.setText("");
        textarea2.setText("");
    }

    public void handleAbout(){
        Dialogs.informationAlert("About","Special thanks","Special thanks for md5decrypt.net for using their API.");
    }

}
