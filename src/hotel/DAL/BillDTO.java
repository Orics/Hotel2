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
    public Bill GetBill(){
        return null;
    }
    
    public ArrayList<Bill> GetAllBills(){
        return null;
    }
    
    public ArrayList<Bill> SearchBillsById(String billID){
        return null;
    }
    
    public ArrayList<Bill> SearchBillsByCustomer(String cusID){
        return null;
    }
    
    public ArrayList<Bill> SearchBillByRoom(String roomID){
        return null;
    }
    
    public ArrayList<BillDetail> GetBillDetails(String billID){
        return null;
    }
     
    public boolean InsertData(Reservation rbill){
        return true;
    }
    
    public boolean UpdateData(Reservation bill){
        return true;
    }
    
    public boolean DeleteData(String billID){
        return true;
    }
}
