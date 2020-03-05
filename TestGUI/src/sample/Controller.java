package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.event.EventHandler.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Controller {
    public TextField SS_Number = new TextField();
    public TextField name = new TextField();
    public TextField credit_High = new TextField();
    public TextField credit_Low = new TextField();
    public TextField city = new TextField();
    public ComboBox state = new ComboBox();





//    public void setSS_Number(String SS_Number) {
//        this.SS_Number.setOnAction(Key);
//    }

    public String getSS_Number() {
        return SS_Number.getText();
    }

    public String getState() {
        return state.getSelectionModel().getSelectedItem().toString();
    }

    public String first;
    int cRangeLow, cRangeHigh;
    public void SearchButtonClicked(){
        System.out.println("SS Number: " + getSS_Number());
        System.out.println("State: " + getState());
       // System.out.println("State: " + getState());
    }

}
