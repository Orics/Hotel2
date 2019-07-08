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
public class RoomType {
    private String RoomTypeID;
    private String RoomTypeName;
    private String NumberBeds;
    private String RoomRate;

    public RoomType() {
    }

    public RoomType(String RoomTypeID, String RoomTypeName, String NumberBeds, String RoomRate) {
        this.RoomTypeID = RoomTypeID;
        this.RoomTypeName = RoomTypeName;
        this.NumberBeds = NumberBeds;
        this.RoomRate = RoomRate;
    }

    public String getRoomTypeID() {
        return RoomTypeID;
    }

    public String getRoomTypeName() {
        return RoomTypeName;
    }

    public String getNumberBeds() {
        return NumberBeds;
    }

    public String getRoomRate() {
        return RoomRate;
    }

    public void setRoomTypeID(String RoomTypeID) {
        this.RoomTypeID = RoomTypeID;
    }

    public void setRoomTypeName(String RoomTypeName) {
        this.RoomTypeName = RoomTypeName;
    }

    public void setNumberBeds(String NumberBeds) {
        this.NumberBeds = NumberBeds;
    }

    public void setRoomRate(String RoomRate) {
        this.RoomRate = RoomRate;
    }
    
}
