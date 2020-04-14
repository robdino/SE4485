package services.retrieve.retrieve_by_acct;

public enum HS_ACCT_FIELDS{
	
	NUMBANK 	(" [NUMBANK]  = ")
  ,	TYPEACCT 	(" [TYPEACCT] = ")
  ,	NUMACCT 	(" [NUMACCT]  =  ")
  ,	PRODCODE 	(" [PRODCODE] = ")
  ,	NUMBRNCH 	(" [NUMBRNCH] = ")
  ,	AMTCURBL 	(" [AMTCURBL] = ")
  ;
  
  	
  private String val;	
  
  private HS_ACCT_FIELDS(String str) {
		val=str;
	}
  
  public String getVal() {
	  return val;
  }
	
}
