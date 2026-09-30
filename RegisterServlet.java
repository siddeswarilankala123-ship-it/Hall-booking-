package com.functionhall.controller;
import com.functionhall.dao.UserDAO;
import com.functionhall.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        try{
            User u=new User(); u.setName(req.getParameter("name")); u.setEmail(req.getParameter("email"));
            u.setPhone(req.getParameter("phone")); u.setPassword(req.getParameter("password"));
            new UserDAO().register(u); resp.sendRedirect("login.jsp?registered=1");
        }catch(Exception e){ resp.sendRedirect("register.jsp?error=Registration+failed"); }
    }
}
