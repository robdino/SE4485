package user_interface;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import utils.DB_Names_Holder;


//singleton
public class User_Interface {

	private static User_Interface ui;

	private User_Interface() {
	}

	public static User_Interface getInstance() {
		if (ui == null)
			ui = new User_Interface();
		return ui;
	}
	
	/*
	 * get the connection information for chosen HS databases to connect to it.  (URL, Username, Password)
	 */
	public void Initalize_DB_Names_Holder() {
		/*
		 * get all legal HS_database
		 */
		UI_DB_Interactor dumm = UI_DB_Interactor.getInstance();
		Map<Integer, String> databaseNames = dumm.get_All_HS_Databases();
		//dumm.close_connection();
		
		Scanner reader = new Scanner(System.in);
		
		int db_choice=-1;
		
		/*
		 * show it to the user
		 */
		for (int i = 0; i < databaseNames.size(); i++) {
			System.out.println(i + ") " + databaseNames.get(i));
		}

		/*
		 * get user selection
		 */
		db_choice = make_a_right_selection("Please select the HS database", 0,
				databaseNames.size() - 1, reader);
		
		/*
		 * initialize the database names holder class with the chosen hs database as well as the stored
		 * consumer info database name.
		 */
		DB_Names_Holder.setHs_db_name( databaseNames.get(db_choice) +"."+Schema_Name.schemaName);
		DB_Names_Holder.setCi_db_name(Consumer_Info_DB_Vars.db_name+"."+Schema_Name.schemaName);

	}

	
	/*
	 * makes sure that the user selection is within legal boundaries of the list of selections.
	 */
	private int make_a_right_selection(String question, int lowestValidVal, int highestValidVal, Scanner reader) {

		int user_choice = -1;
		while (true) {
			System.out.println(question);
			user_choice = readAnInt(reader);

			if (user_choice > highestValidVal || user_choice < lowestValidVal)
				System.out.println("wrong entry please enter a valid number.");
			else
				break;
		}

		return user_choice;
	}


	private int readAnInt(Scanner reader) {
		int x = -1; //flag

		while (true) {
			try {
				x = reader.nextInt();
				if (x != -1)
					break;
			} catch (InputMismatchException e) {
				System.out.println("Please input a number");
				reader.nextLine();
			} catch (Exception e) {
				e.toString();
				e.printStackTrace();
				System.out.println("Unhandled problem");
				System.exit(5);
			}
		}
		return x;
	}

}
