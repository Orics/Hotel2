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
public class CustomerType {
    private String CustomerTypeID;
    private String CustomerTypeName;
    private String DiscountRate;
    private String Point;

    public CustomerType() {
    }

    public String getCustomerTypeID() {
        return CustomerTypeID;
    }

    public String getCustomerTypeName() {
        return CustomerTypeName;
    }

    public String getDiscountRate() {
        return DiscountRate;
    }

    public String getPoint() {
        return Point;
    }

    public void setCustomerTypeID(String CustomerTypeID) {
        this.CustomerTypeID = CustomerTypeID;
    }

    public void setCustomerTypeName(String CustomerTypeName) {
        this.CustomerTypeName = CustomerTypeName;
    }

    public void setDiscountRate(String DiscountRate) {
        this.DiscountRate = DiscountRate;
    }

    public void setPoint(String Point) {
        this.Point = Point;
    }
    
    
}
