package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearchController {

    public ComboBox customerType = new ComboBox();
    public TextField age = new TextField();
    public ComboBox state = new ComboBox();

    public ComboBox creditBureau = new ComboBox();
    public ComboBox pep = new ComboBox();
    public TextField zipCode = new TextField();

    public ComboBox onlineBanking = new ComboBox();
    public ComboBox foreignIndicator = new ComboBox();
    public ComboBox specialUse = new ComboBox();

    public TextField name = new TextField();
    public TextField creditHigh = new TextField();
    public TextField creditLow = new TextField();
    public TextField city = new TextField();

    @FXML private TableView<Entity> resultsTable;
    //@FXML private TableColumn<Entity, Button> viewButtonColumn;
    @FXML private TableColumn<Entity, String> nameColumn;
    @FXML private TableColumn<Entity, Integer> ageColumn;
    @FXML private TableColumn<Entity, String> stateColumn;
    @FXML private TableColumn<Entity, Integer> zipCodeColumn;
    @FXML private TableColumn<Entity, Integer> creditScoreColumn;
    @FXML private TableColumn<Entity, String> bureauColumn;
    @FXML private TableColumn<Entity, String> specialUseColumn;

    private String getCustomerType() {
        return customerType.getSelectionModel().getSelectedItem().toString();
    }
    private String getAge() {
        return age.getText();
    }
    private String getState() {
        return state.getSelectionModel().getSelectedItem().toString();
    }

    private String getCreditBureau() {
        return creditBureau.getSelectionModel().getSelectedItem().toString();
    }
    private String getPep() {
        return pep.getSelectionModel().getSelectedItem().toString();
    }
    private String getZipCode() {
        return zipCode.getText();
    }

    private String getOnlineBanking() {
        return onlineBanking.getSelectionModel().getSelectedItem().toString();
    }
    private String getForeignIndicator() {
        return foreignIndicator.getSelectionModel().getSelectedItem().toString();
    }
    private String getSpecialUse() {
        return specialUse.getSelectionModel().getSelectedItem().toString();
    }

    private String getName() {
        return name.getText();
    }
    private String getCreditHigh() {
        return creditHigh.getText();
    }
    private String getCreditLow() {
        return creditLow.getText();
    }
    private String getCity() {
        return city.getText();
    }

    public AnchorPane searchAnchorPane;

    Entity current = new Entity();

    private String errorMsg = "";

    @FXML
    public void initialize() {
        searchInitialization();
        tableInitialization();

    }



    @FXML public void PersonViewClicked() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PersonView.fxml"));
        Parent personViewParent = loader.load();


        Stage stage = (Stage) searchAnchorPane.getScene().getWindow();
        //Parent personViewParent = FXMLLoader.load(getClass().getResource("PersonView.fxml"));
        Scene personViewScene = new Scene(personViewParent, 800, 600);

        PersonViewController controller = loader.getController();

        //controller.getOutsideData(current);


        Stage window = stage;

        window.setScene(personViewScene);
        window.show();
    }
    @FXML public void BusinessViewClicked() throws IOException {
        Stage stage = (Stage) searchAnchorPane.getScene().getWindow();
        Parent businessViewParent = FXMLLoader.load(getClass().getResource("BusinessView.fxml"));
        Scene businessViewScene = new Scene(businessViewParent, 800, 600);
        Stage window = stage;

        window.setScene(businessViewScene);
        window.show();
    }

    public void SearchButtonClicked() {
        System.out.println("Customer Type: " + getCustomerType());
        System.out.println("Age: " + getAge());
        System.out.println("State: " + getState());

        System.out.println("Credit Bureau: " + getCreditBureau());
        System.out.println("Pep: " + getPep());
        System.out.println("Zip Code: " + getZipCode());

        System.out.println("Online Banking: " + getOnlineBanking());
        System.out.println("Foreign Indicator: " + getForeignIndicator());
        System.out.println("Special Use: " + getSpecialUse());

        System.out.println("Name: " + getName());
        System.out.println("Credit High: " + getCreditHigh());
        System.out.println("Credit Low: " + getCreditLow());
        System.out.println("City: " + getCity());

        if(inputValidate()) {
            resultsTable.setItems(getEntities());
        }

    }

    private void searchInitialization() {

        customerType.getItems().removeAll(customerType.getItems());
        customerType.getItems().addAll("Person", "Business", "Any");
        customerType.getSelectionModel().select("Any");

        state.getItems().removeAll(state.getItems());
        state.getItems().addAll("Any", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        state.getSelectionModel().select("Any");

        creditBureau.getItems().removeAll(creditBureau.getItems());
        creditBureau.getItems().addAll("Equifax", "Experian", "TransUnion", "Any");
        creditBureau.getSelectionModel().select("Any");

        pep.getItems().removeAll(pep.getItems());
        pep.getItems().addAll("PEP", "None", "Any");
        pep.getSelectionModel().select("Any");

        onlineBanking.getItems().removeAll(onlineBanking.getItems());
        onlineBanking.getItems().addAll("Yes", "No", "Any");
        onlineBanking.getSelectionModel().select("Any");

        foreignIndicator.getItems().removeAll(foreignIndicator.getItems());
        foreignIndicator.getItems().addAll("Foreign", "Domestic", "Any");
        foreignIndicator.getSelectionModel().select("Any");

        specialUse.getItems().removeAll(specialUse.getItems());
        specialUse.getItems().addAll("Yes", "No", "Any");
        specialUse.getSelectionModel().select("Any");

    }

    public void ExpandSelectedButtonClicked() throws IOException {
        Entity selected = resultsTable.getSelectionModel().getSelectedItem();    //<-- How you get whatever was selected
        Stage stage = (Stage) searchAnchorPane.getScene().getWindow();
        Stage window = stage;

        if(resultsTable.getSelectionModel().getSelectedItem() == null) {
            System.out.println("ExpandSelectedButtonClicked(): Nothing selected");
        }
        else {
            if (selected.getCustType() == "BUS"){
                //expand to business view
                FXMLLoader BVloader = new FXMLLoader();
                BVloader.setLocation(getClass().getResource("BusinessView.fxml"));
                Parent businessViewParent = BVloader.load();

                Scene businessViewScene = new Scene(businessViewParent, 800, 600);

                BusinessViewController BVcontroller = BVloader.getController();

                BVcontroller.getOutsideData(selected);

                window.setScene(businessViewScene);
                window.show();

            }
            else if(selected.getCustType() == "PER") {
                //expand to person view
                FXMLLoader PVloader = new FXMLLoader();
                PVloader.setLocation(getClass().getResource("PersonView.fxml"));
                Parent personViewParent = PVloader.load();


                Scene personViewScene = new Scene(personViewParent, 800, 600);

                PersonViewController PVcontroller = PVloader.getController();

                PVcontroller.getOutsideData(selected);

                window.setScene(personViewScene);
                window.show();

            }
        }

    }

    private void tableInitialization() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Entity, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Entity, Integer>("age"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<Entity, String>("state"));
        zipCodeColumn.setCellValueFactory(new PropertyValueFactory<Entity, Integer>("zipCode"));
        creditScoreColumn.setCellValueFactory(new PropertyValueFactory<Entity, Integer>("creditScore"));
        bureauColumn.setCellValueFactory(new PropertyValueFactory<Entity, String>("creditBureau"));
        specialUseColumn.setCellValueFactory(new PropertyValueFactory<Entity, String>("specialUse"));
    }

    public ObservableList<Entity> getEntities() {
        Entity frank = new Entity();
        frank.setName("Frank");
        frank.setAge(50);
        frank.setState("Texas");
        frank.setZipCode(75082);
        frank.setCreditScore(720);
        frank.setCreditBureau("Equifax");
        frank.setSpecialUse("Pig");
        frank.setCustType("PER");

        Entity frankBurger = new Entity();
        frankBurger.setName("Frank's Burgers");
        frankBurger.setAge(50);
        frankBurger.setState("Texas");
        frankBurger.setZipCode(75082);
        frankBurger.setCreditScore(720);
        frankBurger.setCreditBureau("Equifax");
        frankBurger.setSpecialUse("Pig");
        frankBurger.setCustType("BUS");

        ObservableList<Entity> entities = FXCollections.observableArrayList();
        entities.addAll(frank, frankBurger, frank, frankBurger, frank, frankBurger, frank, frankBurger);
        //current = frank;


        return entities;

    }

    private boolean inputValidate() {

        boolean ageResult = validateAge();
        boolean zipcodeResult = validateZipcode();
        boolean creditLowResult = validateCreditLow();
        boolean creditHighResult = validateCreditHigh();

        if(ageResult && zipcodeResult && creditLowResult && creditHighResult)
            return true;
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText(errorMsg);
            errorAlert.showAndWait();
            errorMsg = "";
            return false;
        }
    }

    private boolean validateAge() {
        if(getAge().length() > 0 && getAge().length() < 4) {
            try {
                Integer.parseInt(getAge());
            } catch (Exception error) {
                errorMsg += "Age is not a number\n";
                return false;
            }
        }
        else if (getAge().length() >= 4){
            errorMsg += "Age can only be 3 digits long.\n";
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

    private boolean validateCreditLow() {
        if(getCreditLow().length() > 0 && getCreditLow().length() < 4) {
            try {
                Integer.parseInt(getCreditLow());
            } catch (Exception error) {
                errorMsg += "Credit Score (Low) is not a number\n";
                return false;
            }
        }
        else if (getCreditLow().length() >= 4){
            errorMsg += "Credit Score (Low) can only be 3 digits long.\n";
            return false;
        }

        return true;
    }

    private boolean validateCreditHigh() {
        if(getCreditHigh().length() > 0 && getCreditHigh().length() < 4) {
            try {
                Integer.parseInt(getCreditHigh());
            } catch (Exception error) {
                errorMsg += "Credit Score (High) is not a number\n";
                return false;
            }
        }
        else if (getCreditHigh().length() >= 4) {
            errorMsg += "Credit Score (High) can only be 3 digits long.\n";
            return false;
        }

        return true;
    }

}
