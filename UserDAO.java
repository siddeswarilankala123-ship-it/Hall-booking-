package com.functionhall.dao;

import com.functionhall.model.User;
import com.functionhall.util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class UserDAO {
    public boolean register(User u) throws SQLException {
        String sql="INSERT INTO users(name,email,phone,password,role) VALUES(?,?,?,?, 'CUSTOMER')";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,u.getName()); p.setString(2,u.getEmail()); p.setString(3,u.getPhone());
            p.setString(4, BCrypt.hashpw(u.getPassword(), BCrypt.gensalt(10)));
            return p.executeUpdate()==1;
        }
    }
    public User login(String email,String password) throws SQLException {
        String sql="SELECT * FROM users WHERE email=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,email);
            try(ResultSet r=p.executeQuery()){
                if(r.next() && BCrypt.checkpw(password,r.getString("password"))){
                    User u=new User(); u.setUserId(r.getInt("user_id")); u.setName(r.getString("name"));
                    u.setEmail(r.getString("email")); u.setRole(r.getString("role")); return u;
                }
            }
        }
        return null;
    }
}
