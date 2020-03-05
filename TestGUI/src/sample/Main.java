package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
    Label userSelectionMsgLbl = new Label("Your selection: ");
    Label userSelectionDataLbl = new Label("");
    Label itemChangeLbl = new Label("Item Changed: ");
    Label indexChangeLbl = new Label("Index Changed: ");

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ARGO Test Tool");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }




}

