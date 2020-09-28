package com.beenear.warehouse.model;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.Scanner;

public class ReservationDetails {
    private Date checkIn;
    private Date checkOut;
    private int cost;

//    public ReservationDetails(Date checkIn, Date checkOut, int cost) {
//        this.checkIn = checkIn;
//        this.checkOut = checkOut;
//        this.cost = cost;
//    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getTime() throws ParseException {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int year = now.getYear();
        String date = day + "/" + month + "/" + year + " " + hour + ":" + minute;
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy HH:mm");
        Date d1 = format.parse(date);

        return d1;
    }
}
