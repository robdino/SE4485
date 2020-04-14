package services.retrieve.retrieve_by_ci;

public enum CI_FIELDS {

	  Customer_TYPE  (" CustomerType = ") 		//ConsumerInfo.[CustomerType]	String
	 	
	, AGE (" year(GETDATE()) - year(DOB) = ")	//ConsumerInfo.DOB				Date 		we calculate the age, then we search.
	, STATE (" STATE= ") 		   				//ConsumerInfo.[State]   		String
	
	, CREDIT_BUREAU (" Bureau= ")				//ConsumerInfo.Bureau			String
	, PEP (" PEP= ")							//ConsumerInfo.PEP				String
	, ZIP_CODE (" ZIPCode= ") 					//ConsumerInfo.[ZIPCode]		String
	
	, ONLINE_BANKING (" OnlineBanking = ")		//ConsumerInfo.OnlineBanking	String 
	, FOREIGN_IND (" ForeignInd= ")				//ConsumerInfo.ForeignInd		String 		
	, SPECIAL_USE (" SpecUse= ") 				//ConsumerInfo.SpecUse			String
	
	
	, NAME (" Name= ") 							//ConsumerInfo.[Name]			String
	, CREDIT_RANGE_L (" CreditScore >= ")		//ConsumerInfo.CreditScore		String		
	, CREDIT_RANGE_H (" CreditScore<= ")		//ConsumerInfo.CreditScore		String	
	, CITY (" City= ")							//ConsumerInfo.[City]			String
	;						

	private String val;
	
	private CI_FIELDS (String s) {
		val=s;
	}
	public String getVal() {
		return val;
	}
}