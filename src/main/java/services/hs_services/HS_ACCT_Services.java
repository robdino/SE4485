package services.hs_services;


import entities.hs_entities.HS_ACCT;
import utils.DAOException;


public interface HS_ACCT_Services {
	
	    void create(HS_ACCT acct) throws DAOException;


	    void update(HS_ACCT acct) throws DAOException;

	    void delete(String NUMBANK,  String TYPEACCT,String NUMACCT) throws DAOException;
}
