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
public class Customer {
    private String CustomerID;
    private String CustomerTypeID;
    private String FullName;
    private String Gender;
    private String IDCardNumber;
    private String Address;
    private String Point;
    private String Status;

    public Customer() {
    }

    public Customer(String CustomerID, String CustomerTypeID, String FullName, String Gender, String Address, String Point, String Status) {
        this.CustomerID = CustomerID;
        this.CustomerTypeID = CustomerTypeID;
        this.FullName = FullName;
        this.Gender = Gender;
        this.Address = Address;
        this.Point = Point;
        this.Status = Status;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getCustomerTypeID() {
        return CustomerTypeID;
    }

    public String getFullName() {
        return FullName;
    }

    public String getGender() {
        return Gender;
    }

    public String getIDCardNumber() {
        return IDCardNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getPoint() {
        return Point;
    }

    public String getStatus() {
        return Status;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCustomerTypeID(String CustomerTypeID) {
        this.CustomerTypeID = CustomerTypeID;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setIDCardNumber(String IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPoint(String Point) {
        this.Point = Point;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
