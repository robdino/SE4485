package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {
    public TextField SS_Number = new TextField();

//    public void setSS_Number(String SS_Number) {
//        this.SS_Number.setOnAction(Key);
//    }

    public String getSS_Number() {
        return SS_Number.getText();
    }

    public String first;
    int cRangeLow, cRangeHigh;
    public void SearchButtonClicked(){
        System.out.println("SS Number: " + getSS_Number());

    }


}
