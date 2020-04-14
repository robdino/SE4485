package services.hs_services;

import entities.hs_entities.HS_CUAC;
import utils.DAOException;

public interface HS_CUAC_Services {

 	void create(HS_CUAC acct) throws DAOException;
  

    void update(HS_CUAC acct) throws DAOException;

    void delete(String CUSTBANK,  String TYPECUST,String CIF, 
    		String NUMBANK, String TYPEACCT, String NUMACCT) throws DAOException;
	
	
	
}
