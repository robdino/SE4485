package sample;

import java.io.IOException;

import entities.entity_to_show.CI_View;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.retrieve.retrieve_by_ci.Retrieve_By_Consumer_Info;

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

	@FXML
	private TableView<CI_View> resultsTable;
	@FXML
	private TableColumn<CI_View, String> nameColumn;
	@FXML
	private TableColumn<CI_View, Integer> ageColumn;
	@FXML
	private TableColumn<CI_View, String> stateColumn;
	@FXML
	private TableColumn<CI_View, Integer> zipCodeColumn;
	@FXML
	private TableColumn<CI_View, Integer> creditScoreColumn;
	@FXML
	private TableColumn<CI_View, String> bureauColumn;
	@FXML
	private TableColumn<CI_View, String> specialUseColumn;
	
	
	
	private static Retrieve_By_Consumer_Info rm;
	
	public static void setRm(Retrieve_By_Consumer_Info rm) {
		SearchController.rm = rm;
	}


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

	CI_View current = new CI_View();

	@FXML
	public void initialize() {
		searchInitialization();
		tableInitialization();
	}

	@FXML
	public void PersonViewClicked() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("PersonView.fxml"));
		Parent personViewParent = loader.load();

		Stage stage = (Stage) searchAnchorPane.getScene().getWindow();
		Scene personViewScene = new Scene(personViewParent, 800, 600);

		Stage window = stage;

		window.setScene(personViewScene);
		window.show();
	}

	@FXML
	public void BusinessViewClicked() throws IOException {
		Stage stage = (Stage) searchAnchorPane.getScene().getWindow();
		Parent businessViewParent = FXMLLoader.load(getClass().getResource("BusinessView.fxml"));
		Scene businessViewScene = new Scene(businessViewParent, 800, 600);
		Stage window = stage;

		window.setScene(businessViewScene);
		window.show();
	}

	// after the user clicks seach, this below is what will run.
	public void SearchButtonClicked() {
		/*
		 * send values to retrieve_fun, then display with set items.
		 */

		CI_View user_input = new CI_View();

		user_input.setCustType(getCustomerType());
		user_input.setAge(getAge());
		user_input.setState(getState());
		user_input.setCreditBureau(getCreditBureau());
		user_input.setPEP(getPep());
		user_input.setZipCode(getZipCode());
		user_input.setOnlineBanking(getOnlineBanking());
		user_input.setForeignIndicator(getForeignIndicator());
		user_input.setSpecialUse(getSpecialUse());
		user_input.setName(getName());
		user_input.setCreditHigh(getCreditHigh());
		user_input.setCreditLow(getCreditLow());
		user_input.setCity(getCity());


		ObservableList<CI_View> theList = rm.getEntities(user_input);

		resultsTable.setItems(theList);

	}

	private void searchInitialization() {

		customerType.getItems().removeAll(customerType.getItems());
		customerType.getItems().addAll("PER", "BUS", "Any");
		customerType.getSelectionModel().select("Any");

		state.getItems().removeAll(state.getItems());
		state.getItems().addAll("Any", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "ID",
				"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
				"NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA",
				"WA", "WV", "WI", "WY");
		state.getSelectionModel().select("Any");

		creditBureau.getItems().removeAll(creditBureau.getItems());
		creditBureau.getItems().addAll("Equifax", "Experian", "TransUnion", "Canada", "Mexico", "Business", "ITIN",
				"Any");
		creditBureau.getSelectionModel().select("Any");

		pep.getItems().removeAll(pep.getItems());
		pep.getItems().addAll("Y", "N", "Any");
		pep.getSelectionModel().select("Any");

		onlineBanking.getItems().removeAll(onlineBanking.getItems());
		onlineBanking.getItems().addAll("Y", "N", "Any");
		onlineBanking.getSelectionModel().select("Any");

		foreignIndicator.getItems().removeAll(foreignIndicator.getItems());
		foreignIndicator.getItems().addAll("Y", "N", "Any");
		foreignIndicator.getSelectionModel().select("Any");

		specialUse.getItems().removeAll(specialUse.getItems());
		specialUse.getItems().addAll("MLA", "OFAC", "SnS", "Identity Scan", "No Online Banking", "Frozen", "Deceased",
				"ITIN", "Any");
		specialUse.getSelectionModel().select("Any");

	}

	public void ExpandSelectedButtonClicked() throws IOException {
		CI_View selected = resultsTable.getSelectionModel().getSelectedItem(); // <-- How you get whatever was selected
		Stage stage = (Stage) searchAnchorPane.getScene().getWindow();
		Stage window = stage;

		if (resultsTable.getSelectionModel().getSelectedItem() == null) {
			System.out.println("ExpandSelectedButtonClicked(): Nothing selected");
		} else {
			if (selected.getCustType() == "BUS") {
				// expand to business view
				FXMLLoader BVloader = new FXMLLoader();
				BVloader.setLocation(getClass().getResource("BusinessView.fxml"));
				Parent businessViewParent = BVloader.load();

				Scene businessViewScene = new Scene(businessViewParent, 800, 600);

				BusinessViewController BVcontroller = BVloader.getController();

				BVcontroller.getOutsideData(selected);

				window.setScene(businessViewScene);
				window.show();

			} else if (selected.getCustType() == "PER") {
				// expand to person view
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
		nameColumn.setCellValueFactory(new PropertyValueFactory<CI_View, String>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<CI_View, Integer>("age"));
		stateColumn.setCellValueFactory(new PropertyValueFactory<CI_View, String>("state"));
		zipCodeColumn.setCellValueFactory(new PropertyValueFactory<CI_View, Integer>("zipCode"));
		creditScoreColumn.setCellValueFactory(new PropertyValueFactory<CI_View, Integer>("creditScore"));
		bureauColumn.setCellValueFactory(new PropertyValueFactory<CI_View, String>("creditBureau"));
		specialUseColumn.setCellValueFactory(new PropertyValueFactory<CI_View, String>("specialUse"));
	}

}
