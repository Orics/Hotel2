/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.Bill;
import hotel.BLL.Customer;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class CustomerDTO {
    
    public Customer GetCustomer(String cusID){
        String sql = "select * from S_Customer where CustomerID = " + cusID;
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            Customer cus = new Customer();
            cus.setCustomerID(dt.getValue()[0][0]);
            cus.setCustomerTypeID(dt.getValue()[0][1]);
            cus.setFullName(dt.getValue()[0][2]);
            cus.setGender(dt.getValue()[0][3]);
            cus.setIDCardNumber(dt.getValue()[0][4]);
            cus.setAddress(dt.getValue()[0][5]);
            cus.setPoint(dt.getValue()[0][6]);
            cus.setStatus(dt.getValue()[0][7]);
            return cus;
        }
        else
            return null;  
    }
    
    public ArrayList<Customer> GetAllCustomers(){
        String sql = "select * from S_Customer";
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Customer> list = new ArrayList<Customer>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Customer cus = new Customer();
                cus.setCustomerID(dt.getValue()[i][0]);
                cus.setCustomerTypeID(dt.getValue()[i][1]);
                cus.setFullName(dt.getValue()[i][2]);
                cus.setGender(dt.getValue()[i][3]);
                cus.setIDCardNumber(dt.getValue()[i][4]);
                cus.setAddress(dt.getValue()[i][5]);
                cus.setPoint(dt.getValue()[i][6]);
                cus.setStatus(dt.getValue()[i][7]);
                list.add(cus);
            }
            return list;
        }
        else
            return null;
    }
    
    
    public ArrayList<Customer> SearchCustomersById(String id ){
        String sql = "select * from S_Customer where CustomerID like '@%'";
        sql = sql.replaceFirst("@", id);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Customer> list = new ArrayList<Customer>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Customer cus = new Customer();
                cus.setCustomerID(dt.getValue()[i][0]);
                cus.setCustomerTypeID(dt.getValue()[i][1]);
                cus.setFullName(dt.getValue()[i][2]);
                cus.setGender(dt.getValue()[i][3]);
                cus.setIDCardNumber(dt.getValue()[i][4]);
                cus.setAddress(dt.getValue()[i][5]);
                cus.setPoint(dt.getValue()[i][6]);
                cus.setStatus(dt.getValue()[i][7]);
                list.add(cus);
            }
            return list;
        }
        else
            return null;
    }
    
    public ArrayList<Customer> SearchCustomersByIdCard(String idCard ){
        String sql = "select * from S_Customer where IDCardNumber like '@%'";
        sql = sql.replaceFirst("@", idCard);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Customer> list = new ArrayList<Customer>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Customer cus = new Customer();
                cus.setCustomerID(dt.getValue()[i][0]);
                cus.setCustomerTypeID(dt.getValue()[i][1]);
                cus.setFullName(dt.getValue()[i][2]);
                cus.setGender(dt.getValue()[i][3]);
                cus.setIDCardNumber(dt.getValue()[i][4]);
                cus.setAddress(dt.getValue()[i][5]);
                cus.setPoint(dt.getValue()[i][6]);
                cus.setStatus(dt.getValue()[i][7]);
                list.add(cus);
            }
            return list;
        }
        else
            return null;
    }
    
    public ArrayList<Customer> SearchCustomersByPhoneNumber(String phoneNumber){
        String sql = "select * from S_Customer where PhoneNumber like '@%'";
        sql = sql.replaceFirst("@", phoneNumber);
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<Customer> list = new ArrayList<Customer>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                Customer cus = new Customer();
                cus.setCustomerID(dt.getValue()[i][0]);
                cus.setCustomerTypeID(dt.getValue()[i][1]);
                cus.setFullName(dt.getValue()[i][2]);
                cus.setGender(dt.getValue()[i][3]);
                cus.setIDCardNumber(dt.getValue()[i][4]);
                cus.setAddress(dt.getValue()[i][5]);
                cus.setPoint(dt.getValue()[i][6]);
                cus.setStatus(dt.getValue()[i][7]);
                list.add(cus);
            }
            return list;
        }
        else
            return null;
    }
    
    public boolean InsertData(Customer cus){
        String sql = "insert into S_Customer values(S_Seq_Customer.nextval,'@','@','@','@','@','@','@')";
        sql = sql.replaceFirst("@", cus.getCustomerTypeID());
        sql = sql.replaceFirst("@", cus.getFullName());
        sql = sql.replaceFirst("@", cus.getGender());
        sql = sql.replaceFirst("@", cus.getIDCardNumber());
        sql = sql.replaceFirst("@", cus.getAddress());
        sql = sql.replaceFirst("@", cus.getPoint());
        sql = sql.replaceFirst("@", cus.getStatus());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    public boolean UpdateData(Customer cus){
        String sql = "update S_Customer set CustomerTypeID = '@', " +
                                            "FullName = '@', " +
                                            "Gender = '@', " +
                                            "IDCardNumber = '@', " +
                                            "Address = '@', " +
                                            "Point = '@', " +
                                            "Status = '@'";
        sql = sql.replaceFirst("@", cus.getCustomerTypeID());
        sql = sql.replaceFirst("@", cus.getFullName());
        sql = sql.replaceFirst("@", cus.getGender());
        sql = sql.replaceFirst("@", cus.getIDCardNumber());
        sql = sql.replaceFirst("@", cus.getAddress());
        sql = sql.replaceFirst("@", cus.getPoint());
        sql = sql.replaceFirst("@", cus.getStatus());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    public boolean DaleteData(String cusID){
        String sql = "delete S_Customer where CustomerID = " + cusID;
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    
    
}
