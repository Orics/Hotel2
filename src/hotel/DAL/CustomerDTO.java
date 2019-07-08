/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.Customer;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class CustomerDTO {
    
    public Customer GetCustomer(String CusID){
        return null;
    }
    
    public ArrayList<Customer> GetAllCustomers(){
        return null;
    }
    
    public ArrayList<Customer> SearchCustomersById(String id ){
        return null;
    }
    
    public ArrayList<Customer> SearchCustomersByIdCard(String idCard ){
        return null;
    }
    
    public ArrayList<Customer> SearchCustomersByPhoneNumber(String phoneNumber){
        return null;
    }
    
    public boolean InsertData(Customer cus){
        return true;
    }
    
    public boolean UpdateData(Customer cus){
        return true;
    }
    
    public boolean DaleteData(String cusID){
        return true;
    }
    
    
    
}
