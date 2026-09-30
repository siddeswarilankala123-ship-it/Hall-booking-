package com.functionhall.dao;

import com.functionhall.model.Booking;
import com.functionhall.util.DBConnection;
import java.sql.*;
import java.util.*;

public class BookingDAO {
    public boolean isAvailable(int hallId, Date date) throws SQLException {
        String sql="SELECT COUNT(*) FROM bookings WHERE hall_id=? AND booking_date=? AND status IN ('PENDING','CONFIRMED')";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,hallId); p.setDate(2,date);
            try(ResultSet r=p.executeQuery()){ r.next(); return r.getInt(1)==0; }
        }
    }

    public int create(Booking b) throws SQLException {
        if(!isAvailable(b.getHallId(), b.getBookingDate())) return -1;
        String sql="INSERT INTO bookings(user_id,hall_id,booking_date,number_of_guests,total_amount,status) VALUES(?,?,?,?,?,'PENDING')";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            p.setInt(1,b.getUserId()); p.setInt(2,b.getHallId()); p.setDate(3,b.getBookingDate());
            p.setInt(4,b.getNumberOfGuests()); p.setDouble(5,b.getTotalAmount()); p.executeUpdate();
            try(ResultSet r=p.getGeneratedKeys()){ if(r.next()) return r.getInt(1); }
        }
        return -1;
    }

    public List<Booking> findByUser(int userId) throws SQLException {
        List<Booking> list=new ArrayList<>();
        String sql="SELECT b.*,h.hall_name FROM bookings b JOIN function_halls h ON b.hall_id=h.hall_id WHERE b.user_id=? ORDER BY b.created_at DESC";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,userId);
            try(ResultSet r=p.executeQuery()){
                while(r.next()){
                    Booking b=new Booking(); b.setBookingId(r.getInt("booking_id")); b.setHallId(r.getInt("hall_id"));
                    b.setHallName(r.getString("hall_name")); b.setBookingDate(r.getDate("booking_date"));
                    b.setNumberOfGuests(r.getInt("number_of_guests")); b.setTotalAmount(r.getDouble("total_amount"));
                    b.setStatus(r.getString("status")); list.add(b);
                }
            }
        }
        return list;
    }
}
