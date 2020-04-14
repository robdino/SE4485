package services.hs_services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.hs_entities.HS_CUST;
import services.hs_services.HS_CUST_Services;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_CUST_Services_Impl implements HS_CUST_Services {

	private Connection con;
	private String hs_db_name;
	
	public HS_CUST_Services_Impl(Connection con) {
		super();
		hs_db_name=DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	// 58 variables
	public void create(HS_CUST acct) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql for insert

			String sql = String.format("insert into %s.HS_CUST "
					+ "(NUMBANK, TYPECUST, CIF, NAMFULL, NUMTAXID, NUMBRNCH, LASTDATE, DATEOPEN, PHONETYP1, PHONETYP2, PHONETYP3, PHONETYP4, "
					+ "PHONE1, PHONE2, PHONE3, PHONE4, PHONEEXT1, PHONEEXT2, PHONEEXT3, PHONEEXT4, "
					+ "OPERID, ADDRTYP1, ADDRTYP2, ADDRTYP3, ADDRTYP4, FLGFORGN1, FLGFORGN2, FLGFORGN3, FLGFORGN4, "
					+ "STREET1A, STREET1B, STREET1C, STREET1D, STREET2A, STREET2B, STREET2C, STREET2D, CITY1, CITY2, CITY3, CITY4, STATE1, STATE2, STATE3, STATE4, "
					+ "ZIP1, ZIP2, ZIP3, ZIP4, DATEBEG1, DATEBEG2, DATEBEG3, DATEBEG4, DATEEND1, DATEEND2, DATEEND3, DATEEND4, XML_BLOB) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					hs_db_name);

			myStmt = con.prepareStatement(sql);

			// set the param values for the account
			myStmt.setString(1, acct.getNUMBANK());
			myStmt.setString(2, acct.getTYPECUST());
			myStmt.setString(3, acct.getCIF());
			myStmt.setString(4, acct.getNAMFULL());
			myStmt.setString(5, acct.getNUMTAXID());
			myStmt.setString(6, acct.getNUMBRNCH());
			myStmt.setTimestamp(7, acct.getLASTDATE());
			myStmt.setTimestamp(8, acct.getDATEOPEN());
			myStmt.setString(9, acct.getPHONETYP1());
			myStmt.setString(10, acct.getPHONETYP2());
			myStmt.setString(11, acct.getPHONETYP3());
			myStmt.setString(12, acct.getPHONETYP4());
			myStmt.setString(13, acct.getPHONE1());
			myStmt.setString(14, acct.getPHONE2());
			myStmt.setString(15, acct.getPHONE3());
			myStmt.setString(16, acct.getPHONE4());
			myStmt.setString(17, acct.getPHONEEXT1());
			myStmt.setString(18, acct.getPHONEEXT2());
			myStmt.setString(19, acct.getPHONEEXT3());
			myStmt.setString(20, acct.getPHONEEXT4());
			myStmt.setString(21, acct.getOPERID());
			myStmt.setString(22, acct.getADDRTYP1());
			myStmt.setString(23, acct.getADDRTYP2());
			myStmt.setString(24, acct.getADDRTYP3());
			myStmt.setString(25, acct.getADDRTYP4());
			myStmt.setString(26, acct.getFLGFORGN1());
			myStmt.setString(27, acct.getFLGFORGN2());
			myStmt.setString(28, acct.getFLGFORGN3());
			myStmt.setString(29, acct.getFLGFORGN4());
			myStmt.setString(30, acct.getSTREET1A());
			myStmt.setString(31, acct.getSTREET1B());
			myStmt.setString(32, acct.getSTREET1C());
			myStmt.setString(33, acct.getSTREET1D());
			myStmt.setString(34, acct.getSTREET2A());
			myStmt.setString(35, acct.getSTREET2B());
			myStmt.setString(36, acct.getSTREET2C());
			myStmt.setString(37, acct.getSTREET2D());
			myStmt.setString(38, acct.getCITY1());
			myStmt.setString(39, acct.getCITY2());
			myStmt.setString(40, acct.getCITY3());
			myStmt.setString(41, acct.getCITY4());
			myStmt.setString(42, acct.getSTATE1());
			myStmt.setString(43, acct.getSTATE2());
			myStmt.setString(44, acct.getSTATE3());
			myStmt.setString(45, acct.getSTATE4());
			myStmt.setString(46, acct.getZIP1());
			myStmt.setString(47, acct.getZIP2());
			myStmt.setString(48, acct.getZIP3());
			myStmt.setString(49, acct.getZIP4());
			myStmt.setTimestamp(50, acct.getDATEBEG1());
			myStmt.setTimestamp(51, acct.getDATEBEG2());
			myStmt.setTimestamp(52, acct.getDATEBEG3());
			myStmt.setTimestamp(53, acct.getDATEBEG4());
			myStmt.setTimestamp(54, acct.getDATEEND1());
			myStmt.setTimestamp(55, acct.getDATEEND2());
			myStmt.setTimestamp(56, acct.getDATEEND3());
			myStmt.setTimestamp(57, acct.getDATEEND4());
			myStmt.setString(58, acct.getXML_BLOB());

			// execute sql insert
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// if CIF stays same but name changes, its good. but if name remains the same
	// and cif changes, it creates a new one
	public void update(HS_CUST acct) throws DAOException {
		try {
			delete(acct.getNUMBANK(), acct.getTYPECUST(), acct.getCIF());

			create(acct);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String NUMBANK, String TYPECUST, String CIF) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format("delete from %s.HS_CUST where NUMBANK=? AND TYPECUST=? AND CIF =? ", hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, NUMBANK);
			myStmt.setString(2, TYPECUST);
			myStmt.setString(3, CIF);

			// execute sql statement
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
