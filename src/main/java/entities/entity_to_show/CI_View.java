package entities.entity_to_show;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CI_View implements Viewable{

	private String 	custType, name, city, state, creditBureau, PEP, foreignIndicator, specialUse;
    private String 	age, zipCode;
    private String	creditHigh, creditLow, creditScore;
    private String 	onlineBanking;
    private Date 	dob;
    
    
	public CI_View(){}


	public String getCustType() {
		return custType;
	}


	public void setCustType(String custType) {
		this.custType = custType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCreditBureau() {
		return creditBureau;
	}


	public void setCreditBureau(String creditBureau) {
		this.creditBureau = creditBureau;
	}


	public String getPEP() {
		return PEP;
	}


	public void setPEP(String pEP) {
		PEP = pEP;
	}


	public String getForeignIndicator() {
		return foreignIndicator;
	}


	public void setForeignIndicator(String foreignIndicator) {
		this.foreignIndicator = foreignIndicator;
	}


	public String getSpecialUse() {
		return specialUse;
	}


	public void setSpecialUse(String specialUse) {
		this.specialUse = specialUse;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getOnlineBanking() {
		return onlineBanking;
	}


	public void setOnlineBanking(String onlineBanking) {
		this.onlineBanking = onlineBanking;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getCreditLow() {
		return creditLow;
	}


	public void setCreditLow(String creditLow) {
		this.creditLow = creditLow;
	}


	public String getCreditHigh() {
		return creditHigh;
	}


	public void setCreditHigh(String creditHigh) {
		this.creditHigh = creditHigh;
	}


	public String getCreditScore() {
		return creditScore;
	}


	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	
	public static CI_View extractFromResultSet(ResultSet rs) {
		
		CI_View record = null;
		try {
			
			record=new CI_View();
			record.setCustType(rs.getString("CustomerType"));
			record.setAge(rs.getString("Age"));
			record.setState(rs.getString("State"));
			record.setCreditBureau(rs.getString("Bureau"));
			record.setPEP(rs.getString("PEP"));
			record.setZipCode(rs.getString("ZIPCode"));
			record.setOnlineBanking(rs.getString("OnlineBanking"));
			record.setForeignIndicator(rs.getString("ForeignInd"));
			record.setSpecialUse(rs.getString("SpecUse"));
			record.setName(rs.getString("Name"));
			record.setCreditScore(rs.getString("CreditScore"));
			record.setCity(rs.getString("City"));
				
				//entities_to_return.add(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return record;
	}
	
	
	
	
	
	
	
}
