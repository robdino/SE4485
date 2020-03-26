package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    //Scene search, personView, personExtendedView, businessView;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        Parent search = FXMLLoader.load(getClass().getResource("search.fxml"));
        window.setTitle("ARGO Test Tool");
        window.setScene(new Scene(search, 800, 600));
        window.show();











    }


    public static void main(String[] args) {
        launch(args);
    }




}

