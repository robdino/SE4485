package services.hs_services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.hs_entities.HS_ACCT;
import services.hs_services.HS_ACCT_Services;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_ACCT_Services_Impl implements HS_ACCT_Services {

	private Connection con;
	private String hs_db_name;

	public HS_ACCT_Services_Impl(Connection con) {
		super();

		hs_db_name=DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void create(HS_ACCT acct) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql for insert
			// there are 39 variables
			String sql = String.format("insert into %s.HS_ACCT "
					+ "(NUMBANK, TYPEACCT, NUMACCT, PRODCODE, NUMTAXID, ACTTITLE1, ACTTITLE2, ACTTITLE3, ACTTITLE4, NUMBRNCH, "
					+ "STATUS2, LASTDATE, DATEOPEN, DATECLSE, REASONCL, COMMENT1, COMMENT2, AMTCURBL, NUMSIGN, TAXIDTYP, "
					+ "ALIENNUM, FLGFORGN1, FLGFORGN2, STREET1A, STREET1B, STREET2A, STREET2B, "
					+ "CITY1, CITY2, STATE1, STATE2, ZIP1, ZIP2, DATEBEG, DATEEND, XML_BLOB, COMMENTDATE1, COMMENTDATE2, OPERID) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					hs_db_name);

			myStmt = con.prepareStatement(sql);

			// set the param values for the account
			myStmt.setString(1, acct.getNUMBANK());
			myStmt.setString(2, acct.getTYPEACCT());
			myStmt.setString(3, acct.getNUMACCT());
			myStmt.setString(4, acct.getPRODCODE());
			myStmt.setString(5, acct.getNUMTAXID());
			myStmt.setString(6, acct.getACTTITLE1());
			myStmt.setString(7, acct.getACTTITLE2());
			myStmt.setString(8, acct.getACTTITLE3());
			myStmt.setString(9, acct.getACTTITLE4());
			myStmt.setString(10, acct.getNUMBRNCH());
			myStmt.setString(11, acct.getSTATUS2());
			myStmt.setTimestamp(12, acct.getLASTDATE());
			myStmt.setTimestamp(13, acct.getDATEOPEN());
			myStmt.setTimestamp(14, acct.getDATECLSE());
			myStmt.setString(15, acct.getREASONCL());
			myStmt.setString(16, acct.getCOMMENT1());
			myStmt.setString(17, acct.getCOMMENT2());
			myStmt.setString(18, acct.getAMTCURBL());
			myStmt.setString(19, acct.getNUMSIGN());
			myStmt.setString(20, acct.getTAXIDTYP());
			myStmt.setString(21, acct.getALIENNUM());
			myStmt.setString(22, acct.getFLGFORGN1());
			myStmt.setString(23, acct.getFLGFORGN2());
			myStmt.setString(24, acct.getSTREET1A());
			myStmt.setString(25, acct.getSTREET1B());
			myStmt.setString(26, acct.getSTREET2A());
			myStmt.setString(27, acct.getSTREET2B());
			myStmt.setString(28, acct.getCITY1());
			myStmt.setString(29, acct.getCITY2());
			myStmt.setString(30, acct.getSTATE1());
			myStmt.setString(31, acct.getSTATE2());
			myStmt.setString(32, acct.getZIP1());
			myStmt.setString(33, acct.getZIP2());
			myStmt.setTimestamp(34, acct.getDATEBEG());
			myStmt.setTimestamp(35, acct.getDATEEND());
			myStmt.setString(36, acct.getXML_BLOB());
			myStmt.setTimestamp(37, acct.getCOMMENTDATE1());
			myStmt.setTimestamp(38, acct.getCOMMENTDATE2());
			myStmt.setString(39, acct.getOPERID());

			// execute sql insert
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(HS_ACCT acct) throws DAOException {
		try {

			delete(acct.getNUMBANK(), acct.getTYPEACCT(), acct.getNUMACCT());

			create(acct);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format("delete from %s.HS_ACCT where NUMBANK=? AND TYPEACCT=? AND NUMACCT =? ",
					hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, NUMBANK);
			myStmt.setString(2, TYPEACCT);
			myStmt.setString(3, NUMACCT);

			// execute sql statement
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}