/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.CustomerType;
import hotel.BLL.Room;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class RoomTypeDTO {
    public ArrayList<Room> GetAllRoomTypes(){
        return null;
    }
    
    public CustomerType GetRoomType(String typeID){
        return null;
    }
    
    public boolean InsertData(CustomerType roomType){
        return true;
    }
    
    public boolean UpdateData(CustomerType roomType){
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
