package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BusinessViewController {

    Entity current;

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

    String errorMsg = "";

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

    public void getOutsideData(Entity entity) {
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

        inputValidate();

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

        inputValidate();

        return success;
    }
    public void viewAccountsClicked() throws IOException{
        // Query HS_ACCTS and return list of entities.


        Stage stage = (Stage) businessAnchorPane.getScene().getWindow();
        FXMLLoader AVloader = new FXMLLoader();
        AVloader.setLocation(getClass().getResource("AcctResults.fxml"));
        Parent acctResultsViewParent = AVloader.load();


        Scene acctResultsViewScene = new Scene(acctResultsViewParent, 800, 600);

        AcctResultController AVcontroller = AVloader.getController();

        AVcontroller.getOutsideData(current);

        Stage window = stage;

        window.setScene(acctResultsViewScene);
        window.show();



        // Launch acctsView and fill table with entities
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
    private void businessViewInitialization(Entity entity) {
        state.getItems().removeAll(state.getItems());
        state.getItems().addAll("", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        state.getSelectionModel().select(entity.getState());

    }

    private boolean inputValidate() {

        boolean yearEstResult = validateYearEst();
        boolean phoneResult = validatePhoneNumber();
        boolean emailResult = validateEmail();
        boolean zipcodeResult = validateZipcode();

        if(yearEstResult && phoneResult && emailResult && zipcodeResult && emailResult && phoneResult) {
            System.out.println("Business Validation Correct");
            return true;
        }
        else {
            System.out.println("Business Validation Incorrect");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText(errorMsg);
            errorAlert.showAndWait();
            errorMsg = "";
            return false;
        }
    }

    private boolean validateYearEst() {
        if(getYearEstablished().length() == 4) {
            try {
                Integer.parseInt(getYearEstablished());
            } catch (Exception error) {
                errorMsg += "Year is not a number\n";
                return false;
            }
        }
        else if (getYearEstablished().length() != 0){
            errorMsg += "Year must be 4 digits long.\n";
            return false;
        }

        return true;
    }

    //length is nvarchar(10)
    private boolean validatePhoneNumber() {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(getTelephone().length() > 0 /*&& getTelephone().length() <= 10*/) {
            matcher = pattern.matcher(getTelephone());
            if(matcher.matches() == true) { /* we good, phone is valid */ }
            else {
                errorMsg += "Phone number is not valid.\n";
                return false;
            }
        }
        /* else if (getTelephone().length() > 10) {
            errorMsg += "Phone number is greater than 10 characters.\n";
        } */

        return true;
    }

    //length is nvarchar(40)
    private boolean validateEmail() {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(getEmail().length() > 0 && getEmail().length() <= 40) {
            matcher = pattern.matcher(getEmail());
            if(matcher.matches() == true) { /* we good, email is valid */ }
            else {
                errorMsg += "Email is not valid.\n";
                return false;
            }
        }
        else if (getEmail().length() > 40){
            errorMsg += "Email is greater than 10 characters\n";
            return false;
        }

        return true;
    }

    // Reference: https://howtodoinjava.com/regex/us-postal-zip-code-validation/
    private boolean validateZipcode() {
        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(getZipCode().length() > 0) {
            matcher = pattern.matcher(getZipCode());
            if(matcher.matches() == true) { /* we good, zip code is valid */ }
            else {
                errorMsg += "Zip Code is not a valid zip code\n";
                return false;
            }
        }

        return true;
    }
}
