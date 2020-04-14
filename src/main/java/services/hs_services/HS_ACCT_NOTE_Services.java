package services.hs_services;

import entities.hs_entities.HS_ACCT_NOTE;
import utils.DAOException;

public interface HS_ACCT_NOTE_Services {

	
	 	void create(HS_ACCT_NOTE acct) throws DAOException;

	    void update(HS_ACCT_NOTE acct) throws DAOException;

	    void delete(String REGIONID,  String TYPEACCT,String NUMACCT) throws DAOException;

}
