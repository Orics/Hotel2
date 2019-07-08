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
public class Room {
    private String RoomID;
    private String RoomNumber;
    private String Flow;
    private String RoomTypeID;
    private String Status;

    public Room() {
    }

    public Room(String RoomID, String RoomNumber, String Flow, String RoomTypeID, String Status) {
        this.RoomID = RoomID;
        this.RoomNumber = RoomNumber;
        this.Flow = Flow;
        this.RoomTypeID = RoomTypeID;
        this.Status = Status;
    }

    public String getRoomID() {
        return RoomID;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public String getFlow() {
        return Flow;
    }

    public String getRoomTypeID() {
        return RoomTypeID;
    }

    public String getStatus() {
        return Status;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public void setFlow(String Flow) {
        this.Flow = Flow;
    }

    public void setRoomTypeID(String RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
