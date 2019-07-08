/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.Bill;
import hotel.BLL.BillDetail;
import hotel.BLL.Reservation;
import hotel.BLL.ReservationDetail;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class BillDTO {
    public Bill GetBill(String BillID){
        String sql = "select * from S_Bill where BillID = " + BillID;
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            Bill b = new Bill();
            b.setBillID(dt.getValue()[0][0]);
            b.setDatetime(dt.getValue()[0][1]);
            b.setEmployeeID(dt.getValue()[0][2]);
            b.setCustomerID(dt.getValue()[0][3]);
            b.setStatus(dt.getValue()[0][4]); 
            return b;
        }
        else
            return null;  
    }
    
    public ArrayList<Bill> GetAllBills(){
        String sql = "select * from S_Bill";
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Bill> list = new ArrayList<Bill>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Bill b = new Bill();
                b.setBillID(dt.getValue()[i][0]);
                b.setDatetime(dt.getValue()[i][1]);
                b.setEmployeeID(dt.getValue()[i][2]);
                b.setCustomerID(dt.getValue()[i][3]);
                b.setStatus(dt.getValue()[i][4]);
                list.add(b);
            }
            return list;
        }
        else
            return null;
    }
    
    public ArrayList<Bill> SearchBillsById(String billID){
        String sql = "select * from S_Bill where BillID like '@%'";
        sql = sql.replaceFirst("@", billID);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Bill> list = new ArrayList<Bill>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Bill b = new Bill();
                b.setBillID(dt.getValue()[i][0]);
                b.setDatetime(dt.getValue()[i][1]);
                b.setEmployeeID(dt.getValue()[i][2]);
                b.setCustomerID(dt.getValue()[i][3]);
                b.setStatus(dt.getValue()[i][4]);
                list.add(b);
            }
            return list;
        }
        else
            return null;
    }
    
    public ArrayList<Bill> SearchBillsByCustomer(String cusID){
        String sql = "select * from S_Bill where CustomerID like '@%'";
        sql = sql.replaceFirst("@", cusID);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Bill> list = new ArrayList<Bill>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Bill b = new Bill();
                b.setBillID(dt.getValue()[i][0]);
                b.setDatetime(dt.getValue()[i][1]);
                b.setEmployeeID(dt.getValue()[i][2]);
                b.setCustomerID(dt.getValue()[i][3]);
                b.setStatus(dt.getValue()[i][4]);
                list.add(b);
            }
            return list;
        }
        else
            return null;
    }
    
    public ArrayList<Bill> SearchBillByRoom(String roomID){
        String sql = "select BillID, Datetime, EmployeeID, CustomerID, Status from S_Bill, S_BillDetail where S_Bill.BillID = S_BillDetail.BillID and RoomID like '@%'";
        sql = sql.replaceFirst("@", roomID);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Bill> list = new ArrayList<Bill>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Bill b = new Bill();
                b.setBillID(dt.getValue()[i][0]);
                b.setDatetime(dt.getValue()[i][1]);
                b.setEmployeeID(dt.getValue()[i][2]);
                b.setCustomerID(dt.getValue()[i][3]);
                b.setStatus(dt.getValue()[i][4]);
                list.add(b);
            }
            return list;
        }
        else
            return null;
    }
    
    public ArrayList<BillDetail> GetBillDetails(String billID){
        String sql = "select BillDetailID, BillID, RoomID from S_Bill, S_BillDetail where S_Bill.BillID = S_BillDetail.BillID and BillID = '@'";
        sql = sql.replaceFirst("@", billID);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<BillDetail> list = new ArrayList<BillDetail>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                BillDetail bd = new BillDetail();
                bd.setBillDetailID(dt.getValue()[i][0]);
                bd.setBillDetailID(dt.getValue()[i][1]);
                bd.setBillDetailID(dt.getValue()[i][2]);
                list.add(bd);
            }
            return list;
        }
        else
            return null;
    }
        
    public boolean InsertData(Bill b){
        String sql = "insert into S_Bill values('@','@','@','@','@')";
        sql = sql.replaceFirst("@", b.getBillID());
        sql = sql.replaceFirst("@", b.getDatetime());
        sql = sql.replaceFirst("@", b.getEmployeeID());
        sql = sql.replaceFirst("@", b.getCustomerID());
        sql = sql.replaceFirst("@", b.getStatus());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    public boolean UpdateData(Bill b){
        String sql = "update S_Bill set Datetime = '@', EmployeeID = '@', CustomerID = '@', Status = '@' where BillID = '@'";
        sql = sql.replaceFirst("@", b.getBillID());
        sql = sql.replaceFirst("@", b.getDatetime());
        sql = sql.replaceFirst("@", b.getEmployeeID());
        sql = sql.replaceFirst("@", b.getCustomerID());
        sql = sql.replaceFirst("@", b.getStatus());
        sql = sql.replaceFirst("@", b.getBillID());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    public boolean DeleteData(String billID){
        String sql = "delete S_Bill where BillID = " + billID;
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
}
