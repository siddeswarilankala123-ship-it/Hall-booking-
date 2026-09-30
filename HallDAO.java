package com.functionhall.dao;

import com.functionhall.model.FunctionHall;
import com.functionhall.util.DBConnection;
import java.sql.*;
import java.util.*;

public class HallDAO {
    public List<FunctionHall> findAll() throws SQLException {
        List<FunctionHall> list = new ArrayList<>();
        String sql="SELECT * FROM function_halls ORDER BY hall_id DESC";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql); ResultSet r=p.executeQuery()){
            while(r.next()){
                FunctionHall h=new FunctionHall();
                h.setHallId(r.getInt("hall_id")); h.setHallName(r.getString("hall_name"));
                h.setLocation(r.getString("location")); h.setDescription(r.getString("description"));
                h.setCapacity(r.getInt("capacity")); h.setPricePerDay(r.getDouble("price_per_day"));
                h.setFacilities(r.getString("facilities")); h.setImage(r.getString("image"));
                list.add(h);
            }
        }
        return list;
    }
    public FunctionHall findById(int id) throws SQLException {
        String sql="SELECT * FROM function_halls WHERE hall_id=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,id);
            try(ResultSet r=p.executeQuery()){
                if(r.next()){
                    FunctionHall h=new FunctionHall();
                    h.setHallId(r.getInt("hall_id")); h.setHallName(r.getString("hall_name"));
                    h.setLocation(r.getString("location")); h.setDescription(r.getString("description"));
                    h.setCapacity(r.getInt("capacity")); h.setPricePerDay(r.getDouble("price_per_day"));
                    h.setFacilities(r.getString("facilities")); h.setImage(r.getString("image"));
                    return h;
                }
            }
        }
        return null;
    }
}
