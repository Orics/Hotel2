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
public class ReservationDetail {
    private String ReservationDetailID;
    private String ReservationID;
    private String CustomerID;

    public ReservationDetail() {
    }

    public ReservationDetail(String ReservationDetailID, String ReservationID, String CustomerID) {
        this.ReservationDetailID = ReservationDetailID;
        this.ReservationID = ReservationID;
        this.CustomerID = CustomerID;
    }

    public String getReservationDetailID() {
        return ReservationDetailID;
    }

    public String getReservationID() {
        return ReservationID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setReservationDetailID(String ReservationDetailID) {
        this.ReservationDetailID = ReservationDetailID;
    }

    public void setReservationID(String ReservationID) {
        this.ReservationID = ReservationID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }
    
    
}
