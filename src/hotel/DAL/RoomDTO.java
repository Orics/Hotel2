/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;
import hotel.BLL.Reservation;
import hotel.BLL.ReservationDetail;
import hotel.BLL.Room;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class RoomDTO {
    public ArrayList<Room> GetAllRooms(){
        String sql = "select * from S_Room ";
     
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        ArrayList<Room> list = new ArrayList<Room>();
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Room r = new Room();
            r.setRoomID(dt.getValue()[i][0]);
            r.setRoomNumber(dt.getValue()[i][1]);
            r.setFlow(dt.getValue()[i][2]);
            r.setRoomTypeID(dt.getValue()[i][3]);
            r.setStatus(dt.getValue()[i][4]);
            list.add(r); 
            }
            return list;
        }
        else
            return null;
    }
    
    public ArrayList<Room> SearchRoomsById(String roomID){
        ArrayList<Room> list= new ArrayList<>();
        DataAccess dal= new DataAccess();
        String sql= " Select * from S_Room where RoomID like '%@%'";
        sql = sql.replaceFirst("@", roomID);
        DataTable dt = dal.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Room r = new Room();
            r.setRoomID(dt.getValue()[i][0]);
            r.setRoomNumber(dt.getValue()[i][1]);
            r.setFlow(dt.getValue()[i][2]);
            r.setRoomTypeID(dt.getValue()[i][3]);
            r.setStatus(dt.getValue()[i][4]);
            list.add(r); 
            }
            return list;
        }
        else
            return null;
      
    }
    
    public ArrayList<Room> SearchRoomsByRoomNumber(String roomNumber){
        ArrayList<Room> list= new ArrayList<>();
        DataAccess dal= new DataAccess();
        String sql= " Select * from S_Room where RoomNumber like '%@%'";
        sql = sql.replaceFirst("@", roomNumber);
        DataTable dt = dal.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Room r = new Room();
            r.setRoomID(dt.getValue()[i][0]);
            r.setRoomNumber(dt.getValue()[i][1]);
            r.setFlow(dt.getValue()[i][2]);
            r.setRoomTypeID(dt.getValue()[i][3]);
            r.setStatus(dt.getValue()[i][4]);
            list.add(r); 
            }
            return list;
        }
        else
            return null;
        
        
        
    }
    
    public ArrayList<Room> SearchRoomsByCustomer(String cusID){
        ArrayList<Room> list = new ArrayList<>();
        DataAccess da = new DataAccess();
        String sql="Select RoomID,RoomNumber,Floor,RoomTypeID,Status\n"
                + " From S_ReservationDetail rd,S_Reservation r,S_Room room \n"
                + " where CustomerID like '%@%'\n "
                + "and rd.ReservationID = r.ReservationID \n "
                + "and room.RoomID =r.RoomID";
        sql= sql.replaceFirst("@", cusID);
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Room r = new Room();
            r.setRoomID(dt.getValue()[i][0]);
            r.setRoomNumber(dt.getValue()[i][1]);
            r.setFlow(dt.getValue()[i][2]);
            r.setRoomTypeID(dt.getValue()[i][3]);
            r.setStatus(dt.getValue()[i][4]);
            list.add(r); 
            }
            return list;
        }
        else
            return null;
        
    }
    
    public ArrayList<Room> SearchRoomsByType(String typeName){
        ArrayList<Room> list = new ArrayList<>();
        DataAccess da = new DataAccess();
        String sql= " Select RoomID,RoomNumber,Floor,RoomTypeID,Status \n"
                + "From S_Room r, S_RoomType rt \n"
                + "Where rt.RoomTypeName like '%@%' and rt.RoomTypeID=r.RoomTypeID";
        sql= sql.replaceFirst("@", typeName);
        DataTable dt = da.ExecuteQuery(sql);
        
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            Room r = new Room();
            r.setRoomID(dt.getValue()[i][0]);
            r.setRoomNumber(dt.getValue()[i][1]);
            r.setFlow(dt.getValue()[i][2]);
            r.setRoomTypeID(dt.getValue()[i][3]);
            r.setStatus(dt.getValue()[i][4]);
            list.add(r); 
            }
            return list;
        }
        else
            return null;
        
    }
    
    public boolean InsertData(Room room){
        String sql = "insert into S_Room values (S_Seq_Room.nextval, '@','@','@','@')";
        sql = sql.replaceFirst("@", room.getRoomNumber());
        sql = sql.replaceFirst("@", room.getFloor());
        sql = sql.replaceFirst("@", room.getRoomTypeID());
        sql = sql.replaceFirst("@", room.getStatus());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else
            return false;
        
    }
    
    public boolean UpdateData(Room room){
        if(room != null){
            String sql = "Update S_room \n"
                    + "set \n" 
                    + "RoomNumber ='@RoomNumber',\n"
                    + "Floor='@Floor',\n"
                    + "RoomType='@RoomTypeID',\n"
                    + " Status='@RoomStatusID'\n"
                    + "where RoomID='@RoomID'";
            
            
            sql = sql.replace("@RoomNumber", room.getRoomNumber());
            sql = sql.replace("@Floor", room.getFloor());
            sql = sql.replace("@RoomTypeID", room.getRoomTypeID());
            sql = sql.replace("@RoomStatusID",room.getStatus());
            sql = sql.replace("@RoomID", room.getRoomID());
            DataAccess dal = new DataAccess();
          if(dal.ExecuteNonQuery(sql)>0)
                     return true;
            else
                    return false;
        }
        
        return false;
    }
    
    public boolean DeleteData(Room room){
        if(room!=null){
            String sql ="Delete From S_Room \n"
                    + "where RoomID='@RoomID'";
            sql = sql.replace("@RoomID", room.getRoomID());
            DataAccess dal = new DataAccess();
            if(dal.ExecuteNonQuery(sql)>0)
                     return true;
            else
                    return false;
            
        }
        
        return false;
    }
    
    public String RoomId2RoomNumber(String roomID){
        String sql =" Select RoomNumber from S_Room r\n"
                + "where r.RoomID='@'";
        sql=sql.replaceFirst("@", roomID);
        DataAccess da= new DataAccess();
        String RoomNumber = da.ExecuteScalarQuery(sql);
        return RoomNumber;
    }
    
    public String RoomNumber2RoomId(String roomNumber){
        String sql =" Select RoomID from S_Room r\n"
                + "where r.RoomNumber='@'";
        sql=sql.replaceFirst("@", roomNumber);
        DataAccess da= new DataAccess();
        String RoomID = da.ExecuteScalarQuery(sql);
        return RoomID;
    }
}


