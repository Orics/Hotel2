/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.ReservationDetail;
import hotel.BLL.RoomType;

/**
 *
 * @author Orics
 */
public class ReservationDetailDTO {
    public ReservationDetail GetReservationDetail(String resDetailId){
        ReservationDetail rsdt= new ReservationDetail();
        String sql=" select ReservationDetailID, ReservationID,CustomerID \n"
                + "From S_ReservationDetail \n"
                + "Where ReservationDetailID='@ReservationDetailID'";
        sql=sql.replaceFirst("@ReservationDetailID", resDetailId);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            rsdt.setReservationDetailID(dt.getValue()[i][0]);
            rsdt.setReservationID(dt.getValue()[i][1]);
            rsdt.setCustomerID(dt.getValue()[i][2]);
             
            }
            return rsdt;
        }
        else
            return null;
        
        
        
    }
    
    public boolean InsertData (ReservationDetail resDetail){
        String sql = "insert into S_ReservationDetail values (S_Seq_ReservationDetail.nextval, '@','@')";
        sql = sql.replaceFirst("@",resDetail.getReservationID() );
        sql = sql.replaceFirst("@",resDetail.getCustomerID() );
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else
            return false;
        
        
    }
    
    public boolean UpdateData (ReservationDetail resDetail){
        if(resDetail != null){
            String sql = "Update S_ReservationDetail \n"
                    + "set \n"
                    + "ReservationID ='@ReservationID',\n"
                    + "CustomerID='@CustomerID',\n"
                    + "where ReservationDetailID='@ReservationDetailID'";
            
            
            sql = sql.replace("@ReservationID",resDetail.getReservationID() );
            sql = sql.replace("@CustomerID",resDetail.getCustomerID() );
            sql = sql.replace("@ReservationDetailID",resDetail.getReservationDetailID() );
           
            DataAccess dal = new DataAccess();
          if(dal.ExecuteNonQuery(sql)>0)
                     return true;
            else
                    return false;
        }
        
        return false;
    }
    
    public boolean DeleteData (String resDetailID){
        String sql ="Delete From S_ReservationDetail \n"
                    + "where ReservationDetailID='@ReservationDetailID'";
            sql = sql.replace("@ReservationDetailID", resDetailID);
            DataAccess dal = new DataAccess();
            if(dal.ExecuteNonQuery(sql)>0)
                     return true;
            else
                    return false;
    }
}
