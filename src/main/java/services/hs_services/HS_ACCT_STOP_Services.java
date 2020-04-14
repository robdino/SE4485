package services.hs_services;

import entities.hs_entities.HS_ACCT_STOP;
import utils.DAOException;

public interface HS_ACCT_STOP_Services {

	
 	void create(HS_ACCT_STOP acct) throws DAOException;

    void update(HS_ACCT_STOP acct) throws DAOException;

    void delete(String NUMBANK,  String TYPEACCT,String NUMACCT, 
    		String IDSTOP) throws DAOException;
    
	
}
