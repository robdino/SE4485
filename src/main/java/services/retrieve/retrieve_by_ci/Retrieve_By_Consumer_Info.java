package services.retrieve.retrieve_by_ci;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.entity_to_show.CI_View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.retrieve.Retrieve;
import utils.DB_Names_Holder;

public class Retrieve_By_Consumer_Info extends Retrieve {
	
	public Retrieve_By_Consumer_Info(Connection con) {
		super(con);
	}
	
	public ObservableList<CI_View> getEntities(CI_View user_input) {
		
		List<String> conditions=getConditions(user_input);

		return retrieve(conditions);
			
	}
	
	
	// check if something got selected or not.
	
	private List<String> getConditions(CI_View user_input) {
		
		List<String> conditionsList= new ArrayList<>();
		
		if (!user_input.getCustType().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.Customer_TYPE, user_input.getCustType()));
			
		if (user_input.getAge()!=null && !user_input.getAge().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.AGE, user_input.getAge()));
			
		if (!user_input.getState().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.STATE, user_input.getState()));
		
		if (!user_input.getCreditBureau().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.CREDIT_BUREAU, user_input.getCreditBureau()));
		
		if (!user_input.getPEP().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.PEP, user_input.getPEP()));

		if (user_input.getZipCode()!=null && !user_input.getZipCode().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.ZIP_CODE, user_input.getZipCode()));

		if (!user_input.getOnlineBanking().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.ONLINE_BANKING, user_input.getOnlineBanking()));

		if (!user_input.getForeignIndicator().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.FOREIGN_IND, user_input.getForeignIndicator()));

		if (!user_input.getSpecialUse().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.SPECIAL_USE, user_input.getSpecialUse()));

		if (user_input.getName()!=null && !user_input.getName().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.NAME, user_input.getName()));
		
		if (user_input.getCreditHigh()!=null && !user_input.getCreditHigh().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.CREDIT_RANGE_H, user_input.getCreditHigh()));
		
		if (user_input.getCreditLow()!=null && !user_input.getCreditLow().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.CREDIT_RANGE_L, user_input.getCreditLow()));
		
		if (user_input.getCity()!=null && !user_input.getCity().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(CI_FIELDS.CITY, user_input.getCity()));
		
		return conditionsList;
		
	}

	
	
	public ObservableList<CI_View> retrieve (List<String> conditions_list) {
		
		String query= String.format("select ci.[CustomerType], year (GETDATE()) - year(ci.[DOB]) As Age " /*age*/
				+ ", ci.[State], ci.[Bureau], ci.[PEP], ci.[ZIPCode], ci.[OnlineBanking], ci.[ForeignInd]"
				+ ", ci.[SpecUse], ci.[Name], ci.[CreditScore], ci.[CITY] "
				+ "from %s.ConsumerInfo AS ci ", DB_Names_Holder.getCi_db_name());
		ResultSet rs=null;
		
		ObservableList<CI_View> entities_to_return= FXCollections.observableArrayList();
		
		if (!conditions_list.isEmpty()) {
			StringBuilder str_builder= new StringBuilder(query);
			
			str_builder.append(" WHERE ");
			
		  for (int i=0; i< conditions_list.size();i++)
			  str_builder.append(conditions_list.get(i) +  " AND ");
		  
		  query=str_builder.toString();
		
		  query=query.substring(0,query.lastIndexOf("AND"));
		 
		}
		
		try (PreparedStatement ps= con.prepareStatement(query)){
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
			entities_to_return.add(CI_View.extractFromResultSet(rs));
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return entities_to_return;
	}
	
	
	
	
	
	
	
}
