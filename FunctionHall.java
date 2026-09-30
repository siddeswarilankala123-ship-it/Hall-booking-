package com.functionhall.model;

public class FunctionHall {
    private int hallId, capacity;
    private String hallName, location, description, facilities, image;
    private double pricePerDay;

    public int getHallId(){ return hallId; }
    public void setHallId(int v){ hallId=v; }
    public int getCapacity(){ return capacity; }
    public void setCapacity(int v){ capacity=v; }
    public String getHallName(){ return hallName; }
    public void setHallName(String v){ hallName=v; }
    public String getLocation(){ return location; }
    public void setLocation(String v){ location=v; }
    public String getDescription(){ return description; }
    public void setDescription(String v){ description=v; }
    public String getFacilities(){ return facilities; }
    public void setFacilities(String v){ facilities=v; }
    public String getImage(){ return image; }
    public void setImage(String v){ image=v; }
    public double getPricePerDay(){ return pricePerDay; }
    public void setPricePerDay(double v){ pricePerDay=v; }
}
