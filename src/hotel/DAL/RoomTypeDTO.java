/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.DAL;

import hotel.BLL.CustomerType;
import hotel.BLL.RoomType;
import java.util.ArrayList;

/**
 *
 * @author Orics
 */
public class RoomTypeDTO {
    public ArrayList<RoomType> GetAllRoomTypes(){
        String sql = "select * from S_RoomType ";
        DataAccess da = new DataAccess();
        DataTable dt = da.ExecuteQuery(sql);
        ArrayList<RoomType> list = new ArrayList<>();
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            RoomType r = new RoomType();
            r.setRoomTypeID(dt.getValue()[i][0]);
            r.setRoomTypeName(dt.getValue()[i][1]);
            r.setNumberBeds(dt.getValue()[i][2]);
            r.setRoomRate(dt.getValue()[i][3]);
            list.add(r); 
            }
            return list;
        }
        else
            return null;
        
        
    }
    
    public RoomType GetRoomType(String typeID){
        DataAccess da = new DataAccess();
        RoomType rt= new RoomType();
        String sql="Select RoomTypeID,RoomTypeName,NumberBeds,RoomRate\n"
                + "From S_RoomType \n"
                + "Where RoomTypeID='@RoomTypeID'";
        sql=sql.replaceFirst("@RoomTypeID", typeID);
        DataTable dt = da.ExecuteQuery(sql);
        if(dt != null){
            for (int i = 0; i <dt.getRowCount(); i++) {
            RoomType r = new RoomType();
            r.setRoomTypeID(dt.getValue()[i][0]);
            r.setRoomTypeName(dt.getValue()[i][1]);
            r.setNumberBeds(dt.getValue()[i][2]);
            r.setRoomRate(dt.getValue()[i][3]);
             
            }
            return rt;
        }
        else
            return null;
        
        
    }
    
    public boolean InsertData(RoomType roomType){  
        String sql = "insert into S_RoomType values (S_Seq_RoomType.nextval, '@','@','@')";
        sql = sql.replaceFirst("@", roomType.getRoomTypeName());
        sql = sql.replaceFirst("@", roomType.getNumberBeds());
        sql = sql.replaceFirst("@", roomType.getRoomRate());
        DataAccess da = new DataAccess();
        if(da.ExecuteNonQuery(sql)>0)
            return true;
        else
            return false;
        
    }
    
    public boolean UpdateData(RoomType roomType){
        if(roomType != null){
            String sql = "Update S_RoomType \n"
                    + "set \n"
                    + "RoomTypeName ='@RoomTypeName',\n"
                    + "NumberBeds='@NumberBeds',\n"
                    + "RoomRate='@RoomRate',\n"
                    + "where RoomTypeID='@RoomTypeID'";
            
            
            sql = sql.replace("@RoomTypeName", roomType.getRoomTypeName());
            sql = sql.replace("@NumberBeds",roomType.getNumberBeds() );
            sql = sql.replace("@RoomRate", roomType.getRoomRate());
            sql = sql.replace("@RoomTypeID",roomType.getRoomTypeID() );
            DataAccess dal = new DataAccess();
          if(dal.ExecuteNonQuery(sql)>0)
                     return true;
            else
                    return false;
        }
        
        return false;
        
    }
    
    public boolean DeleteData(String typeID){
        
            String sql ="Delete From S_RoomType \n"
                    + "where RoomTypeID='@RoomTypeID'";
            sql = sql.replace("@RoomTypeID", typeID);
            DataAccess dal = new DataAccess();
            if(dal.ExecuteNonQuery(sql)>0)
                     return true;
            else
                    return false;
            
    }
    
    public String TypeId2TypeName(String typeID){
         String sql =" Select RoomTypeName from S_RoomType \n"
                + "where RoomTypeID='@RoomTypeID'";
         sql=sql.replaceFirst("@RoomTypeID", typeID);
        DataAccess da= new DataAccess();
        String RoomTypeName = da.ExecuteScalarQuery(sql);
        return RoomTypeName;
      
    }
    
    public String TypeName2TypeId(String typeName){
        String sql =" Select RoomTypeID from S_RoomType \n"
                + "where RoomTypeName='@RoomTypeName'";
         sql=sql.replaceFirst("@RoomTypeName", typeName);
        DataAccess da= new DataAccess();
        String RoomTypeID = da.ExecuteScalarQuery(sql);
        return RoomTypeID;
    }
}
