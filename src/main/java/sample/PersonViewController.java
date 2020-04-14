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

    CI_View current = new CI_View();

    @FXML
    public void initialize() {
        personViewInitialization();

    }

    public void getOutsideData(CI_View entity) {
        current = entity;

        firstName.setText(current.getName());
        lastName.setText(current.getName());

        creditBureau.getSelectionModel().select(current.getCreditBureau());
        creditScore.setText(current.getCreditScore());




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

    }

    public void InsertButtonClicked() {
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

}
