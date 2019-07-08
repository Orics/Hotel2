/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.Customer;
import hotel.BLL.CustomerType;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class CustomerTypeDTO {
    public ArrayList<CustomerType> GetAllCustomerTypes(){
        String sql = "select * from S_CustomerType";
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            ArrayList<CustomerType> list = new ArrayList<CustomerType>();
            for (int i = 0; i < dt.getRowCount(); i++) {
                CustomerType ct = new CustomerType();
                ct.setCustomerTypeID(dt.getValue()[i][0]);
                ct.setCustomerTypeName(dt.getValue()[i][1]);
                ct.setDiscountRate(dt.getValue()[i][2]);
                ct.setPoint(dt.getValue()[i][3]);
                list.add(ct);
            }
            return list;
        }
        else
            return null;
    }
    
    public CustomerType GetCustomerType(String typeID){
        String sql = "select * from S_CustomerType where CustomerTypeID = " + typeID;
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            CustomerType ct = new CustomerType();
            ct.setCustomerTypeID(dt.getValue()[0][0]);
            ct.setCustomerTypeName(dt.getValue()[0][1]);
            ct.setDiscountRate(dt.getValue()[0][2]);
            ct.setPoint(dt.getValue()[0][3]);
            return ct;
        }
        else
            return null;
    }
    
    public boolean InsertData(CustomerType cusType){
        String sql = "insert into S_CustomerType values(S_Seq_CustomerType.nextval,'@','@','@')";
        sql = sql.replaceFirst("@", cusType.getCustomerTypeName());
        sql = sql.replaceFirst("@", cusType.getDiscountRate());
        sql = sql.replaceFirst("@", cusType.getPoint()); 
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    public boolean UpdateData(CustomerType cusType){
        String sql = "update S_CustomerType set CustomerTypeName = '@', DiscountRate = '@', Point = '@'  where CustomerID = '@'";
        sql = sql.replaceFirst("@", cusType.getCustomerTypeName());
        sql = sql.replaceFirst("@", cusType.getDiscountRate());
        sql = sql.replaceFirst("@", cusType.getPoint()); 
        sql = sql.replaceFirst("@", cusType.getCustomerTypeID()); 
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    public boolean DeleteData(String typeID){
        String sql = "delete S_CustomerType  where CustomerID = " + typeID;
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else 
            return false;
    }
    
    public String TypeId2TypeName(String typeID){
        String sql = "select CustomerTypeName from S_CustomerType where CustomerTypeId = "+ typeID;
        DataAccess da = new DataAccess();
        String rs = da.ExecuteScalarQuery(sql);
        return rs;
    }
    
    public String TypeName2TypeId(String typeName){
        String sql = "select CustomerTypeID from S_CustomerType where CustomerTypeName = "+ typeName;
        DataAccess da = new DataAccess();
        String rs = da.ExecuteScalarQuery(sql);
        return rs;
    }
}
