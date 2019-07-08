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
public class Employee {
    private String EmployeeID;
    private String Role;
    private String Password;
    private String FullName;
    private String Gender;
    private String PhoneNumber;
    private String Address;
    private String Status;

    public Employee() {
    }

    public Employee(String EmployeeID, String Role, String Password, String FullName, String Gender, String PhoneNumber, String Address, String Status) {
        this.EmployeeID = EmployeeID;
        this.Role = Role;
        this.Password = Password;
        this.FullName = FullName;
        this.Gender = Gender;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Status = Status;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public String getRole() {
        return Role;
    }

    public String getPassword() {
        return Password;
    }

    public String getFullName() {
        return FullName;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getStatus() {
        return Status;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
}
