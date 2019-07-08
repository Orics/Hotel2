/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.Reservation;
import hotel.BLL.ReservationDetail;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class ReservationDTO {
    public Reservation GetReservation(String resID){
        Reservation rs= new Reservation();
        String sql=" select ReservationID,DateTime,EmployeeID,RoomID,Status \n"
                + "From S_Reservation \n"
                + "Where ReservationID='@ReservationID'";
        sql=sql.replaceFirst("@ReservationID", resID);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            rs.setReservationID(dt.getValue()[i][0]);
            rs.setDatetime(dt.getValue()[i][1]);
            rs.setEmployeeID(dt.getValue()[i][2]);
            rs.setRoomID(dt.getValue()[i][3]);
            rs.setStatus(dt.getValue()[i][4]);
             
            }
            return rs;
        }
        else
        return null;
    }
    
    public ArrayList<Reservation> GetAllReservations(){
         String sql = "select * from S_Reservation ";
     
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        ArrayList<Reservation> list = new ArrayList<>();
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Reservation rs = new Reservation();
            rs.setReservationID(dt.getValue()[i][0]);
            rs.setDatetime(dt.getValue()[i][1]);
            rs.setEmployeeID(dt.getValue()[i][2]);
            rs.setRoomID(dt.getValue()[i][3]);
            rs.setStatus(dt.getValue()[i][4]);
            list.add(rs); 
            }
            return list;
        }
        else
        return null;
    }
    
    public ArrayList<Reservation> SearchReservationsById(String resID){
        ArrayList<Reservation> list= new ArrayList<>();
        DataAccess dal= new DataAccess();
        String sql= " Select * from S_Reservation where ReservationID like '%@%'";
        sql = sql.replaceFirst("@", resID);
        DataTable dt = dal.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Reservation rs = new Reservation();
            rs.setReservationID(dt.getValue()[i][0]);
            rs.setDatetime(dt.getValue()[i][1]);
            rs.setEmployeeID(dt.getValue()[i][2]);
            rs.setRoomID(dt.getValue()[i][3]);
            rs.setStatus(dt.getValue()[i][4]);
            list.add(rs); 
            }
            return list;
        }
        else
        return null;
    }
    
    public ArrayList<Reservation> SearchReservationsByCustomer(String cusID){
        ArrayList<Reservation> list= new ArrayList<>();
        DataAccess dal= new DataAccess();
        String sql= " Select * ReservationID,DateTime,EmployeeID,RoomID,Status\n"
                + "From S_Reservation rs,S_ReservationDetail rsdt \n"
                + "where rsdt.CustomerID like '%@%' and rsdt.ReservationID=rs.ReservationID";
        sql = sql.replaceFirst("@", cusID);
        DataTable dt = dal.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Reservation rs = new Reservation();
            rs.setReservationID(dt.getValue()[i][0]);
            rs.setDatetime(dt.getValue()[i][1]);
            rs.setEmployeeID(dt.getValue()[i][2]);
            rs.setRoomID(dt.getValue()[i][3]);
            rs.setStatus(dt.getValue()[i][4]);
            list.add(rs); 
            }
            return list;
        }
        else
        return null;
    }
    
    public ArrayList<Reservation> SearchReservationsByRoom(String roomID){
        ArrayList<Reservation> list= new ArrayList<>();
        DataAccess dal= new DataAccess();
        String sql="select * from S_Reservation \n"
                + "Where  RoomID like '%@%' ";
        sql = sql.replaceFirst("@", roomID);
        DataTable dt = dal.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Reservation rs = new Reservation();
            rs.setReservationID(dt.getValue()[i][0]);
            rs.setDatetime(dt.getValue()[i][1]);
            rs.setEmployeeID(dt.getValue()[i][2]);
            rs.setRoomID(dt.getValue()[i][3]);
            rs.setStatus(dt.getValue()[i][4]);
            list.add(rs); 
            }
            return list;
        }
        else
        return null;
    }
    
    public ArrayList<ReservationDetail> GetReservationDetails(String resID){
        ArrayList<ReservationDetail> list = new ArrayList<>();
        DataAccess dal= new DataAccess();
        String sql="select * from S_ReservationDetail \n"
                + "where ReservationID='@' ";
        sql = sql.replaceFirst("@", resID);
        DataTable dt = dal.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            ReservationDetail rsdt = new ReservationDetail();
            rsdt.setReservationDetailID(dt.getValue()[i][0]);
            rsdt.setReservationID(dt.getValue()[i][1]);
            rsdt.setCustomerID(dt.getValue()[i][2]);
            
            list.add(rsdt); 
            }
            return list;
        }
        else
        return null;
    }
     
    public boolean InsertData(Reservation res){       
       String sql = "insert into S_Reservation values ('@','@','@','@','@')";
        sql = sql.replaceFirst("@", res.getReservationID());
        sql = sql.replaceFirst("@", res.getDatetime());
        sql = sql.replaceFirst("@", res.getEmployeeID());
        sql = sql.replaceFirst("@", res.getRoomID());
        sql = sql.replaceFirst("@", res.getStatus());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else
            return false;
    }
    
    public boolean UpdateData(Reservation res){
        
        if(res != null){
            String sql = "Update S_Reservation \n"
                    + "set \n"   
                    + "DateTime ='@DateTime',\n"
                    + "EmployeeID='@EmployeeID',\n"
                    + "RoomID='@RoomID',\n"
                    + "Status ='@Status'\n"
                    + "where ReservationID='@ReservationID'";
            
            sql = sql.replace("@DateTime", res.getDatetime());
            sql = sql.replace("@EmployeeID", res.getEmployeeID());
            sql = sql.replace("@RoomID", res.getRoomID());
            sql = sql.replace("@Status",res.getStatus());
            sql = sql.replace("@ReservationID", res.getReservationID());
            DataAccess dal = new DataAccess();
            if(dal.ExecuteNonQuery(sql)>0)
                return true;
            else
                return false;
        }   
        return false   ;
    }
    
    public boolean DeleteData(String res){       
       if(res!=null){
            String sql ="Delete From S_Reservation \n"
                    + "where ReservationID='@ReservationID'";
            sql = sql.replace("@ReservationID", res);
            DataAccess dal = new DataAccess();
            if(dal.ExecuteNonQuery(sql)>0)
                return true;
            else
                return false;
       }
       return false;
    }
}
