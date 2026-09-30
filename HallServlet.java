package com.functionhall.controller;
import com.functionhall.dao.HallDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/halls")
public class HallServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        try{
            req.setAttribute("halls",new HallDAO().findAll());
            req.getRequestDispatcher("halls.jsp").forward(req,resp);
        }catch(Exception e){throw new ServletException(e);}
    }
}
