/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.BillDetail;

/**
 *
 * @author Orics
 */
public class BillDetailDTO {
    public BillDetail GetBillDetail(String billDetailId){
        String sql = "select * from S_BillDetail where BillDetailID = "+ billDetailId;
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            BillDetail bd = new BillDetail();
            bd.setBillDetailID(dt.getValue()[0][0]);
            bd.setBillID(dt.getValue()[0][1]);
            bd.setRoomID(dt.getValue()[0][2]);
            return bd;
        }
        else
            return null; 
    }
    
    public boolean InsertData (BillDetail billDetail){
        String sql = "insert into S_BillDetail values(S_Seq_BillDetail.nextval,'@','@')";
        sql = sql.replaceFirst("@", billDetail.getBillID());
        sql = sql.replaceFirst("@", billDetail.getRoomID());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)> 0)
            return true;
        else
            return false; 
    }
    
    public boolean UpdateData (BillDetail billDetail){
        String sql = "update S_BillDetail set BillID = '@', RoomID = '@' where BillDetailID = '@'";
        sql = sql.replaceFirst("@", billDetail.getBillID());
        sql = sql.replaceFirst("@", billDetail.getRoomID());
        sql = sql.replaceFirst("@", billDetail.getBillDetailID());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)> 0)
            return true;
        else
            return false; 
    }
    
    public boolean DeleteData (String billDetailID){
        String sql = "delete S_BillDetail where BillDetailID = " + billDetailID;
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)> 0)
            return true;
        else
            return false; 
    }
}