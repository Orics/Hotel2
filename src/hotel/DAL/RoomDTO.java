/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.Room;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class RoomDTO {
    public ArrayList<Room> GetAllRooms(){
        return null;
    }
    
    public ArrayList<Room> SearchRoomsById(String roomID){
        return null;
    }
    
    public ArrayList<Room> SearchRoomsByRoomNumber(String roomNumber){
        return null;
    }
    
    public ArrayList<Room> SearchRoomsByCustomer(String cusID){
        return null;
    }
    
    public ArrayList<Room> SearchRoomsByType(String typeName){
        return null;
    }
    
    public boolean InsertData(Room room){
        return true;
    }
    
    public boolean UpdateData(Room room){
        return true;
    }
    
    public boolean DeleteData(Room room){
        return true;
    }
    
    public String RoomId2RoomNumber(String roomID){
        return null;
    }
    
    public String RoomNumber2RoomId(String roomNumber){
        return null;
    }
}


