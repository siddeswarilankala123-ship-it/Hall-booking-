package com.functionhall.controller;
import com.functionhall.dao.BookingDAO;
import com.functionhall.dao.HallDAO;
import com.functionhall.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/book")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        User u=(User)req.getSession().getAttribute("user");
        if(u==null){resp.sendRedirect("login.jsp");return;}
        try{
            int hallId=Integer.parseInt(req.getParameter("hallId"));
            Date date=Date.valueOf(req.getParameter("bookingDate"));
            int guests=Integer.parseInt(req.getParameter("guests"));
            FunctionHall h=new HallDAO().findById(hallId);
            Booking b=new Booking(); b.setUserId(u.getUserId()); b.setHallId(hallId);
            b.setBookingDate(date); b.setNumberOfGuests(guests); b.setTotalAmount(h.getPricePerDay());
            int id=new BookingDAO().create(b);
            if(id>0) resp.sendRedirect("my-bookings.jsp?success=1");
            else resp.sendRedirect("booking.jsp?hallId="+hallId+"&error=Date+already+booked");
        }catch(Exception e){throw new ServletException(e);}
    }
}
