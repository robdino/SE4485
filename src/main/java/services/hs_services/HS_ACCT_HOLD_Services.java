package services.hs_services;

import entities.hs_entities.HS_ACCT_HOLD;
import utils.DAOException;

public interface HS_ACCT_HOLD_Services {
	
	
    void create(HS_ACCT_HOLD acct) throws DAOException;

    void update(HS_ACCT_HOLD acct) throws DAOException;

    void delete(String NUMBANK,  String TYPEACCT,String NUMACCT, String IDHOLD) throws DAOException;
}
