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


    @FXML
    public void initialize() {
        searchInitialization();
        tableInitialization();

    }


    @FXML public void PersonViewClicked() throws IOException {
        Stage stage = (Stage) searchAnchorPane.getScene().getWindow();
        Parent personViewParent = FXMLLoader.load(getClass().getResource("PersonView.fxml"));
        Scene personViewScene = new Scene(personViewParent, 800, 600);
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

        resultsTable.setItems(getEntities());


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

        ObservableList<Entity> entities = FXCollections.observableArrayList();
        entities.add(frank);


        return entities;

    }

}
