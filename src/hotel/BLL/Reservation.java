/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.BLL;

/**
 *
 * @author Orics
 */
public class Reservation {
    private String ReservationID;
    private String Datetime;
    private String EmployeeID;
    private String RoomID;
    private String Status;

    public Reservation() {
    }

    public Reservation(String ReservationID, String Datetime, String EmployeeID, String RoomID, String Status) {
        this.ReservationID = ReservationID;
        this.Datetime = Datetime;
        this.EmployeeID = EmployeeID;
        this.RoomID = RoomID;
        this.Status = Status;
    }

    public String getReservationID() {
        return ReservationID;
    }

    public String getDatetime() {
        return Datetime;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public String getRoomID() {
        return RoomID;
    }

    public String getStatus() {
        return Status;
    }

    public void setReservationID(String ReservationID) {
        this.ReservationID = ReservationID;
    }

    public void setDatetime(String Datetime) {
        this.Datetime = Datetime;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
