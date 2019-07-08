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
public class Bill {
    private String BillID;
    private String Datetime;
    private String EmployeeID;
    private String CustomerID;
    private String Status;

    public Bill() {
    }

    public Bill(String BillID, String Datetime, String EmployeeID, String CustomerID, String Status) {
        this.BillID = BillID;
        this.Datetime = Datetime;
        this.EmployeeID = EmployeeID;
        this.CustomerID = CustomerID;
        this.Status = Status;
    }

    public String getBillID() {
        return BillID;
    }

    public String getDatetime() {
        return Datetime;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getStatus() {
        return Status;
    }

    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public void setDatetime(String Datetime) {
        this.Datetime = Datetime;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
