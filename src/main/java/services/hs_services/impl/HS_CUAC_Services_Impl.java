package services.hs_services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.hs_entities.HS_CUAC;
import services.hs_services.HS_CUAC_Services;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_CUAC_Services_Impl implements HS_CUAC_Services {

	private Connection con;
	private String hs_db_name;

	public HS_CUAC_Services_Impl(Connection con) {
		super();
		hs_db_name=DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void create(HS_CUAC acct) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql for insert

			String sql = String.format("insert into %s.HS_CUAC "
					+ "(CUSTBANK, TYPECUST, CIF, NUMBANK, TYPEACCT, NUMACCT, RELATION, CODEOWNR, STATE2, RELATN4) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", hs_db_name);

			myStmt = con.prepareStatement(sql);

			// set the param values for the account
			myStmt.setString(1, acct.getCUSTBANK());
			myStmt.setString(2, acct.getTYPECUST());
			myStmt.setString(3, acct.getCIF());
			myStmt.setString(4, acct.getNUMBANK());
			myStmt.setString(5, acct.getTYPEACCT());
			myStmt.setString(6, acct.getNUMACCT());
			myStmt.setString(7, acct.getRELATION());
			myStmt.setString(8, acct.getCODEOWNR());
			myStmt.setString(9, acct.getSTATE2());
			myStmt.setString(10, acct.getRELATN4());

			// execute sql insert

			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// if CIF stays same but name changes, its good. but if name remains the same
	// and cif changes, it creates a new one
	public void update(HS_CUAC acct) throws DAOException {
		try {

			delete(acct.getCUSTBANK(), acct.getTYPECUST(), acct.getCIF(), acct.getNUMBANK(), acct.getTYPEACCT(),
					acct.getNUMACCT());

			create(acct);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String CUSTBANK, String TYPECUST, String CIF, String NUMBANK, String TYPEACCT, String NUMACCT)
			throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format("delete from %s.HS_CUAC where CUSTBANK=? AND TYPECUST=? AND CIF=? AND "
					+ "NUMBANK=? AND TYPEACCT=? AND NUMACCT=? ", hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, CUSTBANK);
			myStmt.setString(2, TYPECUST);
			myStmt.setString(3, CIF);
			myStmt.setString(4, NUMBANK);
			myStmt.setString(5, TYPEACCT);
			myStmt.setString(6, NUMACCT);

			// execute sql statement
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
