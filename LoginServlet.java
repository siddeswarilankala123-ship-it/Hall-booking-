package com.functionhall.controller;
import com.functionhall.dao.UserDAO;
import com.functionhall.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        try{
            User u=new UserDAO().login(req.getParameter("email"),req.getParameter("password"));
            if(u!=null){ req.getSession().setAttribute("user",u); resp.sendRedirect("index.jsp"); }
            else { resp.sendRedirect("login.jsp?error=Invalid+email+or+password"); }
        }catch(Exception e){ throw new ServletException(e); }
    }
}
