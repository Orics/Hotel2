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
        return null;
    }
    
    public ArrayList<Reservation> GetAllReservations(){
        return null;
    }
    
    public ArrayList<Reservation> SearchReservationsById(String resID){
        return null;
    }
    
    public ArrayList<Reservation> SearchReservationsByCustomer(String cusID){
        return null;
    }
    
    public ArrayList<Reservation> SearchReservationsByRoom(String roomID){
        return null;
    }
    
    public ArrayList<ReservationDetail> GetReservationDetails(String resID){
        return null;
    }
     
    public boolean InsertData(Reservation res){
        return true;
    }
    
    public boolean UpdateData(Reservation res){
        return true;
    }
    
    public boolean DeleteData(String res){
        return true;
    }
}
