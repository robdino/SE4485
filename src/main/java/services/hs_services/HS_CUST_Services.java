package services.hs_services;

import entities.hs_entities.HS_CUST;
import utils.DAOException;

public interface HS_CUST_Services {

	
    void create(HS_CUST acct) throws DAOException;


    void update(HS_CUST acct) throws DAOException;

    void delete(String NUMBANK,  String TYPECUST,String CIF) throws DAOException;

 
}
