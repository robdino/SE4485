package driver_pac;

import java.sql.Connection;
import java.sql.SQLException;

import data_source_mgr_pac.Data_Src_Mgr;
import sample.Main;
import sample.SearchController;
import services.retrieve.retrieve_by_ci.Retrieve_By_Consumer_Info;
import user_interface.User_Interface;




public class driver {
	
	public static void main(String[] args) {

		 Connection con= null;
		
		 //HS_Builder_Impl builder= HS_Builder_Impl.getInstance();
		 User_Interface ui= User_Interface.getInstance();
		 
		 ui.Initalize_DB_Names_Holder();
		 
		 try
	        {
			 con= Data_Src_Mgr.get_Serv_Con();

//			 HS_CUST_Services_Impl cus_serv=new HS_CUST_Services_Impl (con, hs_db_name, ci_db_name);
//			 
//			 cus_serv.retrieve_with_join(hs_db_name, ci_db_name);
//			 cus_serv.retrieve_with_no_join(hs_db_name);
			 
			 
			 
			 
			 Retrieve_By_Consumer_Info rm= new Retrieve_By_Consumer_Info(con);
			 
			 SearchController.setRm(rm);
			 //rgs.retrieve_no_join(hs_db_name, ci_db_name);
//			 HS_CUST rec= new HS_CUST();
//			 
//			 rec.setCIF("boris__555");
//			 rec.setNAMFULL("bojo_bojo");
//			 rec.setTYPECUST("WTF");
//			 rec.setNUMBANK("005");
//			 
//			 //cus_serv.create(rec, hs_db_name );
//			 
//			 //cus_serv.delete("005", "WTF", "boris__555", hs_db_name);
//			 
//			 HS_CUST rec_up= new HS_CUST();
//			 
//			 rec_up.setCIF("boris__555");
//			 
//			 rec_up.setNAMFULL("bono_bono");  //the one that does is not part of the primary key.
//			 
//			 rec_up.setTYPECUST("WTF");
//			 rec_up.setNUMBANK("005");
//			 
//			 cus_serv.update(rec_up, hs_db_name );
			 
			 Main.LAUNCH(args);
	        
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	        }
	        finally
	        {
	            try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	        }
	}
	
	
	
	
	
	
	
}
