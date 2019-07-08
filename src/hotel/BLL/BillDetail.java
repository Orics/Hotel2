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
public class BillDetail {
    private String BillDetailID;
    private String BillID;
    private String RoomID;

    public BillDetail() {
    }

    public String getBillDetailID() {
        return BillDetailID;
    }

    public String getBillID() {
        return BillID;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setBillDetailID(String BillDetailID) {
        this.BillDetailID = BillDetailID;
    }

    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }
    
}
