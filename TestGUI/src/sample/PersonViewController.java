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


public class PersonViewController {
    @FXML private AnchorPane personAnchorPane;

    public TextField firstName = new TextField();
    public TextField lastName = new TextField();
    public ComboBox creditBureau = new ComboBox();

    public TextField dob = new TextField();
    public TextField ssn = new TextField();
    public TextField creditScore = new TextField();

    public ComboBox foreignIndicator = new ComboBox();
    public ComboBox pep = new ComboBox();
    public ComboBox onlineBanking = new ComboBox();

    public TextField telephone = new TextField();
    public TextField email = new TextField();
    public TextField address = new TextField();

    private String getFirstName() {
        return firstName.getText();
    }
    private String getLastName() {
        return lastName.getText();
    }
    private String getCreditBureau() {
        return creditBureau.getSelectionModel().getSelectedItem().toString();
    }

    private String getDOB() {
        return dob.getText();
    }
    private String getSSN() {
        return ssn.getText();
    }
    private String getCreditScore() { return creditScore.getText(); }

    private String getForeignIndicator() {
        return foreignIndicator.getSelectionModel().getSelectedItem().toString();
    }
    private String getPEP() {
        return pep.getSelectionModel().getSelectedItem().toString();
    }
    private String getOnlineBanking() {
        return onlineBanking.getSelectionModel().getSelectedItem().toString();
    }

    private String getTelephone() { return telephone.getText(); }
    private String getEmail() {
        return email.getText();
    }
    private String getAddress() {
        return address.getText();
    }

    Entity current = new Entity();

    private String errorMsg = "";

    @FXML
    public void initialize() {
        personViewInitialization();

    }

    public void getOutsideData(Entity entity) {
        current = entity;

        firstName.setText(current.getName());
        lastName.setText(current.getName());

        creditBureau.getSelectionModel().select(current.getCreditBureau());
        creditScore.setText(Integer.toString(current.getCreditScore()));




    }


    @FXML public void SearchViewClicked() throws IOException {
        Stage stage = (Stage) personAnchorPane.getScene().getWindow();
        Parent personViewParent = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene personViewScene = new Scene(personViewParent, 800, 600);
        Stage window = stage;

        window.setScene(personViewScene);
        window.show();
    }
    @FXML public void BusinessViewClicked() throws IOException {
        Stage stage = (Stage) personAnchorPane.getScene().getWindow();
        Parent businessViewParent = FXMLLoader.load(getClass().getResource("BusinessView.fxml"));
        Scene businessViewScene = new Scene(businessViewParent, 800, 600);
        Stage window = stage;

        window.setScene(businessViewScene);
        window.show();
    }

    public void UpdateButtonClicked() {
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Credit Bureau: " + getCreditBureau());

        System.out.println("DOB: " + getDOB());
        System.out.println("SSN: " + getSSN());
        System.out.println("Credit Score: " + getCreditScore());

        System.out.println("Foreign Indicator: " + getForeignIndicator());
        System.out.println("PEP: " + getPEP());
        System.out.println("Online Banking: " + getOnlineBanking());

        System.out.println("Telephone: " + getTelephone());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());

        inputValidate();
    }

    public void InsertButtonClicked() {
//        System.out.println("First Name: " + getFirstName());
//        System.out.println("Last Name: " + getLastName());
//        System.out.println("Credit Bureau: " + getCreditBureau());
//
//        System.out.println("DOB: " + getDOB());
//        System.out.println("SSN: " + getSSN());
//        System.out.println("Credit Score: " + getCreditScore());
//
//        System.out.println("Foreign Indicator: " + getForeignIndicator());
//        System.out.println("PEP: " + getPEP());
//        System.out.println("Online Banking: " + getOnlineBanking());
//
//        System.out.println("Telephone: " + getTelephone());
//        System.out.println("Email: " + getEmail());
//        System.out.println("Address: " + getAddress());

        System.out.println("Starting InsertButtonValidation");

        inputValidate();
    }

    public void personViewInitialization() {

        creditBureau.getItems().removeAll(creditBureau.getItems());
        creditBureau.getItems().addAll("Equifax", "Experian", "TransUnion", "Any");
        creditBureau.getSelectionModel().select("Any");

        foreignIndicator.getItems().removeAll(foreignIndicator.getItems());
        foreignIndicator.getItems().addAll("Foreign", "Domestic", "Any");
        foreignIndicator.getSelectionModel().select("Any");

        pep.getItems().removeAll(pep.getItems());
        pep.getItems().addAll("PEP", "None", "Any");
        pep.getSelectionModel().select("Any");

        onlineBanking.getItems().removeAll(onlineBanking.getItems());
        onlineBanking.getItems().addAll("Yes", "No", "Any");
        onlineBanking.getSelectionModel().select("Any");
    }

    private boolean inputValidate() {

        boolean firstnameResult = validateFirstName();
        boolean lastnameResult = validateLastName();
        boolean dobResult = validateDOB();
        boolean creditScoreResult = validateCreditScore();
        boolean ssnResult =  validateSSN();
        boolean emailResult = validateEmail();
        boolean phoneResult = validatePhoneNumber();

        if(firstnameResult && lastnameResult && dobResult && creditScoreResult &&
                ssnResult && emailResult && phoneResult) {
            System.out.println("Person Validation Correct");
            return true;
        }
        else {
            System.out.println("Person Validation Incorrect");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText(errorMsg);
            errorAlert.showAndWait();
            errorMsg = "";
            return false;
        }
    }

    //limit is char (20)
    private boolean validateFirstName() {
        if(getFirstName().length() > 20) {
            errorMsg += "First name cannot exceed 20 characters\n";
            return false;
        }

        return true;
    }

    //limit is char (20)
    private boolean validateLastName() {
        if(getLastName().length() > 20) {
            errorMsg += "Last name cannot exceed 20 characters\n";
            return false;
        }

        return true;
    }

    //as I understand it from screenshots, DOB = YYYY-MM-DD
    private boolean validateDOB() {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(getDOB().length() > 0) {
            matcher = pattern.matcher(getDOB());
            if(matcher.matches() == true) { /* we good, dob is valid */ }
            else {
                errorMsg += "DOB is not valid. Must be YYYY-MM-DD\n";
                return false;
            }
        }

        return true;
    }

    //length is nvarchar(9)
    private boolean validateSSN() {
        String regex = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(getSSN().length() > 0) {
            matcher = pattern.matcher(getSSN());
            if(matcher.matches() == true) { /* we good, ssn is valid */ }
            else {
                errorMsg += "SSN is not valid. Must be formatted as xxx-xx-xxxx\n";
                return false;
            }
        }

        return true;
    }

    //length is nvarchar(4)
    private boolean validateCreditScore() {
        if(getCreditScore().length() > 0 && getCreditScore().length() < 4) {
            try {
                Integer.parseInt(getCreditScore());
            } catch (Exception error) {
                errorMsg += "Credit Score is not a number\n";
                return false;
            }
        }
        else if (getCreditScore().length() >= 4){
            errorMsg += "Credit Score can only be 3 digits long.\n";
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
}
