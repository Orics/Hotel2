/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.Customer;
import hotel.BLL.Employee;

/**
 *
 * @author Orics
 */
public class EmployeeDTO {
    public String GetPassword(String empID){
        String sql = "select Password from S_Employee where EmployeeID = " + empID;
        DataAccess da = new DataAccess();
        String rs = da.ExecuteScalarQuery(sql);
        return rs;
    }
    
    public Employee GetEmployee(String empID){
        String sql = "select * from S_Employee where EmployeeID = " + empID;
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            Employee emp = new  Employee();
            emp.setEmployeeID(dt.getValue()[0][0]);
            emp.setRole(dt.getValue()[0][1]);
            emp.setPassword(dt.getValue()[0][2]);
            emp.setFullName(dt.getValue()[0][3]);
            emp.setGender(dt.getValue()[0][4]);
            emp.setPhoneNumber(dt.getValue()[0][5]);
            emp.setAddress(dt.getValue()[0][6]);
            emp.setStatus(dt.getValue()[0][7]);  
            return emp;
        }
        else
            return null;  
    }
    
    public boolean InsertData(Employee emp){
        String sql = "insert into S_Employee values('@','@','@','@','@','@','@')";
        sql = sql.replaceFirst("@", emp.getRole());
        sql = sql.replaceFirst("@", emp.getPassword());
        sql = sql.replaceFirst("@", emp.getFullName());
        sql = sql.replaceFirst("@", emp.getGender());
        sql = sql.replaceFirst("@", emp.getPhoneNumber());
        sql = sql.replaceFirst("@", emp.getAddress());
        sql = sql.replaceFirst("@", emp.getStatus());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql) > 0)
            return true;
        else
            return false;
    }
    
    public boolean UpdateData(Employee emp){
        String sql = "update S_Employee set Role = '@', Password = '@', FullName = '@', Gender = '@', PhoneNumber = '@', Address = '@', Status = '@' where = '@'";

        sql = sql.replaceFirst("@", emp.getRole());
        sql = sql.replaceFirst("@", emp.getPassword());
        sql = sql.replaceFirst("@", emp.getFullName());
        sql = sql.replaceFirst("@", emp.getGender());
        sql = sql.replaceFirst("@", emp.getPhoneNumber());
        sql = sql.replaceFirst("@", emp.getAddress());
        sql = sql.replaceFirst("@", emp.getStatus());
        
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql) > 0)
            return true;
        else
            return false;
    }
    
    public boolean DeleteData(String empID){
        String sql = "delete S_Employee where EmployeeID = " + empID;
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql) > 0)
            return true;
        else
            return false;
    }
    
}
