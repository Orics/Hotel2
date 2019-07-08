/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.CustomerType;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class CustomerTypeDTO {
    public ArrayList<CustomerType> GetAllCustomerTypes(){
        return null;
    }
    
    public CustomerType GetCustomerType(String typeID){
        return null;
    }
    
    public boolean InsertData(CustomerType cusType){
        return true;
    }
    
    public boolean UpdateData(CustomerType cusType){
        return true;
    }
    
    public boolean DeleteData(String typeID){
        return true;
    }
    
    public String TypeId2TypeName(String typeID){
        return null;
    }
    
    public String TypeName2TypeId(String typeName){
        return null;
    }
}
