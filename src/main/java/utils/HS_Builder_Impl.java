package utils;

import java.sql.Timestamp;

import entities.hs_entities.HS_ACCT;
import entities.hs_entities.HS_ACCT_HOLD;
import entities.hs_entities.HS_ACCT_NOTE;
import entities.hs_entities.HS_ACCT_STOP;
import entities.hs_entities.HS_CUAC;
import entities.hs_entities.HS_CUST;


//Singleton
public class HS_Builder_Impl implements HS_Builder {
	
	
	private static HS_Builder_Impl hs_builder;
	
	private HS_Builder_Impl() {} 
	  
	public static HS_Builder_Impl getInstance() 
    { 
        if (hs_builder==null) 
        	hs_builder = new HS_Builder_Impl(); 
        return hs_builder; 
    } 

	public HS_ACCT build_HS_ACCT(String nUMBANK, String tYPEACCT, String nUMACCT, String pRODCODE, String nUMTAXID,
			String aCTTITLE1, String aCTTITLE2, String aCTTITLE3, String aCTTITLE4, String nUMBRNCH, String sTATUS2,
			Timestamp lASTDATE, Timestamp dATEOPEN, Timestamp dATECLSE, String rEASONCL, String cOMMENT1,
			String cOMMENT2, String aMTCURBL, String nUMSIGN, String tAXIDTYP, String aLIENNUM, String fLGFORGN1,
			String fLGFORGN2, String sTREET1A, String sTREET1B, String sTREET2A, String sTREET2B, String cITY1,
			String cITY2, String sTATE1, String sTATE2, String zIP1, String zIP2, Timestamp dATEBEG, Timestamp dATEEND,
			String xML_BLOB, Timestamp cOMMENTDATE1, Timestamp cOMMENTDATE2, String oPERID) {
		
		HS_ACCT acct = new HS_ACCT();
	
		acct.setNUMBANK(nUMBANK);
		
		acct. setTYPEACCT( tYPEACCT);
		
		acct.setNUMACCT( nUMACCT); 
	
		acct.setPRODCODE(pRODCODE);
		
		acct. setNUMTAXID( nUMTAXID);
		
		acct.setACTTITLE1( aCTTITLE1);
		acct.setACTTITLE2( aCTTITLE2);
		acct.setACTTITLE3( aCTTITLE3);
		acct.setACTTITLE4( aCTTITLE4);
		acct.setNUMBRNCH( nUMBRNCH);
		
		acct.setSTATUS2( sTATUS2);
		acct.setLASTDATE( lASTDATE);
		
		acct.setDATEOPEN( dATEOPEN);
		
		acct.setDATECLSE( dATECLSE);
		
		acct.setREASONCL( rEASONCL);
		
		acct.setCOMMENT1( cOMMENT1);
		acct.setCOMMENT2( cOMMENT2);
		
		acct.setAMTCURBL( aMTCURBL);
		acct.setNUMSIGN( nUMSIGN);
		
		acct.setTAXIDTYP( tAXIDTYP);
		
		acct.setALIENNUM( aLIENNUM);
		
		acct.setFLGFORGN1( fLGFORGN1);
		
		acct.setFLGFORGN2( fLGFORGN2);
		
		acct.setSTREET1A( sTREET1A);
		
		acct.setSTREET1B( sTREET1B);
		
		acct.setSTREET2A( sTREET2A);
		
		acct.setSTREET2B( sTREET2B);
		
		acct.setCITY1( cITY1);
		
		acct.setCITY2( cITY2);
		acct. setSTATE1( sTATE1);
		
		acct.setSTATE2( sTATE2);
		acct.setZIP1( zIP1);
		
		acct.setZIP2( zIP2);
		acct.setDATEBEG( dATEBEG);
		
		acct.setDATEEND( dATEEND);
		
		acct.setXML_BLOB( xML_BLOB);
		
		acct.setCOMMENTDATE1( cOMMENTDATE1);
		
		acct.setCOMMENTDATE2( cOMMENTDATE2);
		
		acct.setOPERID( oPERID);
		
		return acct;
	}

	public HS_ACCT_STOP build_HS_ACCT_STOP(String nUMBANK, String tYPEACCT, String nUMACCT, String iDSTOP,
			String nUMBEG, String nUMEND, String aMTCHECK, Timestamp dATEEXPR, Timestamp dATECRTD, String oPERID,
			String nAMPAYTO, String sTOPREAS, String rEGIONID, Timestamp dATECHK, String oFFID) {
		
		
		  HS_ACCT_STOP acct_stop = new HS_ACCT_STOP();
	      
	      acct_stop.setNUMBANK(nUMBANK);
	      acct_stop.setTYPEACCT(tYPEACCT);
	      acct_stop.setNUMACCT(nUMACCT);
	      acct_stop.setIDSTOP(iDSTOP);
	      acct_stop.setNUMBEG(nUMBEG);
	      acct_stop.setNUMEND(nUMEND);
	      acct_stop.setAMTCHECK(aMTCHECK);
	      acct_stop.setDATEEXPR(dATEEXPR);
	      acct_stop.setDATECRTD(dATECRTD);
	      acct_stop.setOPERID(oPERID);
	      acct_stop.setNAMPAYTO(nAMPAYTO);
	      acct_stop.setSTOPREAS(sTOPREAS);
	      acct_stop.setREGIONID(rEGIONID);
	      acct_stop.setDATECHK(dATECHK);
	      acct_stop.setOFFID(oFFID);
          
	      return acct_stop;
		
	}

	public HS_ACCT_NOTE build_HS_ACCT_NOTE(String rEGIONID, String tYPEACCT, String nUMACCT, Timestamp dATECRTD,
			String aCTNOTE, String oPERID, String iDNOTE) {
		
		HS_ACCT_NOTE acNote= new HS_ACCT_NOTE();
		
		acNote.setREGIONID(rEGIONID);
		acNote.setTYPEACCT(tYPEACCT);
		acNote.setNUMACCT(nUMACCT);
		acNote.setDATECRTD(dATECRTD);
		acNote.setACTNOTE(aCTNOTE);
		acNote.setOPERID(oPERID);
		acNote.setIDNOTE(iDNOTE);
		
		return acNote;
	}

	public HS_ACCT_HOLD build_HS_ACCT_HOLD(String nUMBANK, String tYPEACCT, String nUMACCT, String iDHOLD, String oFFID,
			String hOLDTXT, String aMTHOLD, Timestamp dATEEXPR, Timestamp dATEADDED, String nUMBRNCH, String oPERID,
			String dESCCODE, String dATEDEP, String rSNHOLD) {


		 HS_ACCT_HOLD acct_hold = new HS_ACCT_HOLD();
         
         acct_hold.setNUMBANK(nUMBANK);
         acct_hold.setTYPEACCT(tYPEACCT);
         acct_hold.setNUMACCT(nUMACCT);
         acct_hold.setIDHOLD(iDHOLD);
         acct_hold.setOFFID(oFFID);
         acct_hold.setHOLDTXT(hOLDTXT);
         acct_hold.setAMTHOLD(aMTHOLD);
         acct_hold.setDATEEXPR(dATEEXPR);
         acct_hold.setDATEADDED(dATEADDED);
         acct_hold.setNUMBRNCH(nUMBRNCH);
         acct_hold.setOPERID(oPERID);
         acct_hold.setDESCCODE(dESCCODE);
         acct_hold.setDATEDEP(dATEDEP);
         acct_hold.setRSNHOLD(rSNHOLD);
         
         return acct_hold;
		
	}

	public HS_CUST build_HS_ACCT_CUST(String nUMBANK, String tYPECUST, String cIF, String nAMFULL, String nUMTAXID,
			String nUMBRNCH, Timestamp lASTDATE, Timestamp dATEOPEN, String pHONETYP1, String pHONETYP2,
			String pHONETYP3, String pHONETYP4, String pHONE1, String pHONE2, String pHONE3, String pHONE4,
			String pHONEEXT1, String pHONEEXT2, String pHONEEXT3, String pHONEEXT4, String oPERID, String aDDRTYP1,
			String aDDRTYP2, String aDDRTYP3, String aDDRTYP4, String fLGFORGN1, String fLGFORGN2, String fLGFORGN3,
			String fLGFORGN4, String sTREET1A, String sTREET1B, String sTREET1C, String sTREET1D, String sTREET2A,
			String sTREET2B, String sTREET2C, String sTREET2D, String cITY1, String cITY2, String cITY3, String cITY4,
			String sTATE1, String sTATE2, String sTATE3, String sTATE4, String zIP1, String zIP2, String zIP3,
			String zIP4, Timestamp dATEBEG1, Timestamp dATEBEG2, Timestamp dATEBEG3, Timestamp dATEBEG4,
			Timestamp dATEEND1, Timestamp dATEEND2, Timestamp dATEEND3, Timestamp dATEEND4, String xML_BLOB) {


		HS_CUST cust = new HS_CUST();
        
        cust.setNUMBANK(nUMBANK);
        cust.setTYPECUST(tYPECUST);
        cust.setCIF(cIF);
        cust.setNAMFULL(nAMFULL);
        cust.setNUMTAXID(nUMTAXID);
        cust.setNUMBRNCH(nUMBRNCH);
        cust.setLASTDATE(lASTDATE);
        cust.setDATEOPEN(dATEOPEN);
        cust.setPHONETYP1(pHONETYP1);
        cust.setPHONETYP2(pHONETYP2);
        cust.setPHONETYP3(pHONETYP3);
        cust.setPHONETYP4(pHONETYP4);
        cust.setPHONE1(pHONE1);
        cust.setPHONE2(pHONE2);
        cust.setPHONE3(pHONE3);
        cust.setPHONE4(pHONE4);
        cust.setPHONEEXT1(pHONEEXT1);
        cust.setPHONEEXT2(pHONEEXT2);
        cust.setPHONEEXT3(pHONEEXT3);
        cust.setPHONEEXT4(pHONEEXT4);
        cust.setOPERID(oPERID);
        cust.setADDRTYP1(aDDRTYP1);
        cust.setADDRTYP2(aDDRTYP2);
        cust.setADDRTYP3(aDDRTYP3);
        cust.setADDRTYP4(aDDRTYP4);
        cust.setFLGFORGN1(fLGFORGN1);
        cust.setFLGFORGN2(fLGFORGN2);
        cust.setFLGFORGN3(fLGFORGN3);
        cust.setFLGFORGN4(fLGFORGN4);
        cust.setSTREET1A(sTREET1A);
        cust.setSTREET1B(sTREET1B);
        cust.setSTREET1C(sTREET1C);
        cust.setSTREET1D(sTREET1D);
        cust.setSTREET2A(sTREET2A);
        cust.setSTREET2B(sTREET2B);
        cust.setSTREET2C(sTREET2C);
        cust.setSTREET2D(sTREET2D);
        cust.setCITY1(cITY1);
        cust.setCITY2(cITY2);
        cust.setCITY3(cITY3);
        cust.setCITY4(cITY4);
        cust.setSTATE1(sTATE1);
        cust.setSTATE2(sTATE2);
        cust.setSTATE3(sTATE3);
        cust.setSTATE4(sTATE4);
        cust.setZIP1(zIP1);
        cust.setZIP2(zIP2);
        cust.setZIP3(zIP3);
        cust.setZIP4(zIP4);
        cust.setDATEBEG1(dATEBEG1);
        cust.setDATEBEG2(dATEBEG2);
        cust.setDATEBEG3(dATEBEG3);
        cust.setDATEBEG4(dATEBEG4);
        cust.setDATEEND1(dATEEND1);
        cust.setDATEEND2(dATEEND2);
        cust.setDATEEND3(dATEEND3);
        cust.setDATEEND4(dATEEND4);
        cust.setXML_BLOB(xML_BLOB);
        
        return cust;
	}

	public HS_CUAC build_HS_ACCT_CUAC(String cUSTBANK, String tYPECUST, String cIF, String nUMBANK,
			String tYPEACCT, String nUMACCT, String rELATION, String cODEOWNR, String sTATE2, String rELATN4) {


		HS_CUAC cuac = new HS_CUAC();
        
        cuac.setCUSTBANK(cUSTBANK);
        cuac.setTYPECUST(tYPECUST);
        cuac.setCIF(cIF);
        cuac.setNUMBANK(nUMBANK);
        cuac.setTYPEACCT(tYPEACCT);
        cuac.setNUMACCT(nUMACCT);
        cuac.setRELATION(rELATION);
        cuac.setCODEOWNR(cODEOWNR);
        cuac.setSTATE2(sTATE2);
        cuac.setRELATN4(rELATN4);
        
        return cuac;
	}

}
