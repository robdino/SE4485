package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;



public class AcctResultController {

    Entity current;

    public AnchorPane acctResultsAnchorPane;
    public TitledPane acctResultsTitle = new TitledPane();


    @FXML private TableView<Entity> acctResultsTable;
    @FXML private TableColumn<Entity, String> bankNum;
    @FXML private TableColumn<Entity, String> branchNum;
    @FXML private TableColumn<Entity, String> acctType;
    @FXML private TableColumn<Entity, String> acctNum;
    @FXML private TableColumn<Entity, String> prodCode;
    @FXML private TableColumn<Entity, String> amtCurBal;


    String errorMsg = "";

    @FXML
    public void initialize() {

    }

    @FXML public void viewThisAcct() throws IOException {
        /*Entity selected = acctResultsTable.getSelectionModel().getSelectedItem();    //<-- How you get whatever was selected
        Stage stage = (Stage) acctResultsAnchorPane.getScene().getWindow();
        Stage window = stage;

        if(acctResultsTable.getSelectionModel().getSelectedItem() == null) {
            System.out.println("ExpandSelectedButtonClicked(): Nothing selected");
        }
        else {

            //expand to Account view
            FXMLLoader AVloader = new FXMLLoader();
            AVloader.setLocation(getClass().getResource("AccountView.fxml"));
            Parent accountViewParent = AVloader.load();

            Scene businessViewScene = new Scene(accountViewParent, 800, 600);

            AccountViewController AVcontroller = AVloader.getController();

            AVcontroller.getOutsideData(selected);

            window.setScene(businessViewScene);
            window.show();



        }*/

        Alert notification = new Alert(Alert.AlertType.ERROR);
        notification.setHeaderText("Expand Account Selected");
        notification.setContentText("Need GUI Layout");
        notification.showAndWait();
    }
    @FXML public void backButtonClicked() throws IOException {
        Stage stage = (Stage) acctResultsAnchorPane.getScene().getWindow();
        Stage window = stage;

        if (current.getCustType() == "PER"){
            //expand to person view
            FXMLLoader PVloader = new FXMLLoader();
            PVloader.setLocation(getClass().getResource("PersonView.fxml"));
            Parent personViewParent = PVloader.load();


            Scene personViewScene = new Scene(personViewParent, 800, 600);

            PersonViewController PVcontroller = PVloader.getController();

            PVcontroller.getOutsideData(current);

            window.setScene(personViewScene);
            window.show();
        }
        else if (current.getCustType() == "BUS"){
            //expand to business view
            FXMLLoader BVloader = new FXMLLoader();
            BVloader.setLocation(getClass().getResource("BusinessView.fxml"));
            Parent businessViewParent = BVloader.load();

            Scene businessViewScene = new Scene(businessViewParent, 800, 600);

            BusinessViewController BVcontroller = BVloader.getController();

            BVcontroller.getOutsideData(current);

            window.setScene(businessViewScene);
            window.show();

        }


    }

    public void getOutsideData(Entity entity) {
        current = entity;
        acctResultsTitle.setText("Accounts of " + current.getName());

    }
    @FXML public void SearchViewClicked() throws IOException {
        Stage stage = (Stage) acctResultsAnchorPane.getScene().getWindow();
        Parent personViewParent = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene personViewScene = new Scene(personViewParent, 800, 600);
        Stage window = stage;

        window.setScene(personViewScene);
        window.show();
    }












}


