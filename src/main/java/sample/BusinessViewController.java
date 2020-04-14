package sample;


import java.io.IOException;

import entities.entity_to_show.CI_View;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class BusinessViewController {

    CI_View current;

    public AnchorPane businessAnchorPane;

    public TextField companyName = new TextField();
    public TextField yearEstablished = new TextField();
    public TextField taxID = new TextField();

    public TextField telephone = new TextField();
    public TextField email = new TextField();
    public TextField address = new TextField();

    public TextField city = new TextField();
    public ComboBox state = new ComboBox();
    public TextField zipCode = new TextField();


    private String getCompanyName() {
        return companyName.getText();
    }
    private String getYearEstablished() { return yearEstablished.getText(); }
    private String getTaxID() { return taxID.getText(); }

    private String getTelephone() {
        return telephone.getText();
    }
    private String getEmail() { return email.getText(); }
    private String getAddress() { return address.getText(); }

    private String getCity() { return city.getText(); }
    private String getState() {
        return state.getSelectionModel().getSelectedItem().toString();
    }
    private String getZipCode() { return zipCode.getText(); }

    @FXML
    public void initialize() {
        //current = new Entity();
        businessViewInitialization();

    }

    @FXML public void SearchViewClicked() throws IOException {
        Stage stage = (Stage) businessAnchorPane.getScene().getWindow();
        Parent personViewParent = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene personViewScene = new Scene(personViewParent, 800, 600);
        Stage window = stage;

        window.setScene(personViewScene);
        window.show();
    }
    @FXML public void PersonViewClicked() throws IOException {
        Stage stage = (Stage) businessAnchorPane.getScene().getWindow();
        Parent personViewParent = FXMLLoader.load(getClass().getResource("PersonView.fxml"));
        Scene personViewScene = new Scene(personViewParent, 800, 600);
        Stage window = stage;

        window.setScene(personViewScene);
        window.show();
    }

    public void getOutsideData(CI_View entity) {
        current = entity;

        companyName.setText(current.getName());

        state.getSelectionModel().select(current.getState());





    }

    public void updateButtonClicked() {
        //String success = "";

        System.out.println("Company Name: " + getCompanyName());
        System.out.println("Year Established: " + getYearEstablished());
        System.out.println("Tax ID: " + getTaxID());

        System.out.println("Telephone: " + getTelephone());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());

        System.out.println("City: " + getCity());
        System.out.println("State: " + getState());
        System.out.println("Zip Code: " + getZipCode());


        //return success;
    }

    public String insertButtonClicked() {
        String success = "";

        System.out.println("Company Name: " + getCompanyName());
        System.out.println("Year Established: " + getYearEstablished());
        System.out.println("Tax ID: " + getTaxID());

        System.out.println("Telephone: " + getTelephone());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());

        System.out.println("City: " + getCity());
        System.out.println("State: " + getState());
        System.out.println("Zip Code: " + getZipCode());

        return success;
    }
    private void businessViewInitialization() {
        state.getItems().removeAll(state.getItems());
        state.getItems().addAll("", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        state.getSelectionModel().select("");

    }
    private void businessViewInitialization(CI_View entity) {
        state.getItems().removeAll(state.getItems());
        state.getItems().addAll("", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        state.getSelectionModel().select(entity.getState());

    }



}
