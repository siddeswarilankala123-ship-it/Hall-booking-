package com.functionhall.model;

import java.sql.Date;

public class Booking {
    private int bookingId, userId, hallId, numberOfGuests;
    private Date bookingDate;
    private double totalAmount;
    private String status, hallName;

    public int getBookingId(){return bookingId;} public void setBookingId(int v){bookingId=v;}
    public int getUserId(){return userId;} public void setUserId(int v){userId=v;}
    public int getHallId(){return hallId;} public void setHallId(int v){hallId=v;}
    public int getNumberOfGuests(){return numberOfGuests;} public void setNumberOfGuests(int v){numberOfGuests=v;}
    public Date getBookingDate(){return bookingDate;} public void setBookingDate(Date v){bookingDate=v;}
    public double getTotalAmount(){return totalAmount;} public void setTotalAmount(double v){totalAmount=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getHallName(){return hallName;} public void setHallName(String v){hallName=v;}
}
