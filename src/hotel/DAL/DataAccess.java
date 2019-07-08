/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Orics
 */
public class DataAccess {
    private static String ConnectString ;
    private static String Username;
    private static String Password;

    public DataAccess (){
        ConnectString = "jdbc:oracle:thin:@localhost:1521:orcl";
        Username = "system";
        Password = "1011f337";
    }
    
    public DataAccess (String ConnectString, String Username, String Password ){
        this.ConnectString = ConnectString;
        this.Username = Username;
        this.Password = Password;
    }
    
    public String getConnectString() {
        return ConnectString;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setConnectString(String ConnectString) {
        this.ConnectString = ConnectString;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean TestConnect(){
        try {
            Connection con = DriverManager.getConnection(ConnectString,Username, Password);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    } 
  
    public String ExecuteScalarQuery(String sql){
        PreparedStatement pSt = null;
        try { 
            Connection conn = DriverManager.getConnection(ConnectString, Username, Password);
            pSt = conn.prepareStatement(sql);
            ResultSet rs = pSt.executeQuery(sql);
            rs.next();
            String str = rs.getString(1);
            pSt.close();
            return str;
        } catch (SQLException ex) {
            System.out.println("Exe scalar query fail");
        } 
        return null;
    }
    
    public DataTable ExecuteQuery(String sql){  
        PreparedStatement pSt = null;
        DataTable dt = null;
        try { 
            Connection conn = DriverManager.getConnection(ConnectString, Username, Password);
            pSt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = pSt.executeQuery(sql);
            
            rs.last();
            int col = rs.getMetaData().getColumnCount();
            int row = rs.getRow();
            rs.beforeFirst();
            
            dt = new DataTable(row, col);
            int i=0,j;
            for(i = 0; rs.next(); i++){
                for(j = 0; j<col; j++){
                     dt.getValue()[i][j] = rs.getString(j+1);
                }     
            }
            pSt.close();
            return dt;
            
        } catch (SQLException ex) {
             System.out.println("Exe query fail");
        } 
        return dt;
    }
    
    public int ExecuteNonQuery(String sql){
        System.out.println("exe exe non sql DAL");
        PreparedStatement pSt = null;
        int nRow = 0;
        try { 
            Connection conn = DriverManager.getConnection(ConnectString, Username, Password);
            pSt = conn.prepareStatement(sql);
            nRow = pSt.executeUpdate(sql);  
            pSt.close();
            return nRow; 
        } catch (SQLException ex) {
            System.out.println(" exe non sql DAL fail");
        } 
        return 0;
    }
    
    public String ExecuteFunction(String sql){
        try {
            Connection conn = DriverManager.getConnection(ConnectString, Username, Password);
            CallableStatement statement = conn.prepareCall(sql);
            statement.registerOutParameter(1, java.sql.Types.INTEGER);
            statement.execute();
            return Integer.toString(statement.getInt(1));
        } catch (SQLException ex) {
             System.out.println("Exe func fail");
        }
        return null;
    }
  
    public void ExecuteProcedure(String sql){
        System.out.println("exe proce DAL");
        try {
            Connection conn = DriverManager.getConnection(ConnectString, Username, Password);
            CallableStatement statement = conn.prepareCall(sql);
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Exec Procedure fail");
        }
    }
}
