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

//    public void setCost(int cost) {
//        this.cost = cost;
//    }

    public Date getDateAndTime() throws ParseException {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int year = now.getYear();
        String date = day + "/" + month + "/" + year + " " + hour + ":" + minute;
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy HH:mm");
        Date parsedDate = format.parse(date);

        return parsedDate;
    }

    public String computeTimeDuration (Date d1, Date d2){
        long diff = d2.getTime() - d1.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        String totalTimeSpent = diffHours + " " + "hours" + " " + diffMinutes + " " + "minutes";

        return totalTimeSpent;
    }

    public void setCost(String totalTimeSpent){
        String[] hourAndMinute = totalTimeSpent.split(" ");
        if (Integer.parseInt(hourAndMinute[0]) < 1 && Integer.parseInt(hourAndMinute[2]) > 0){
            cost = 10;
        }
        else if (Integer.parseInt(hourAndMinute[0]) == 1 && Integer.parseInt(hourAndMinute[2]) == 0){
            cost = 10;
        }
        else if (Integer.parseInt(hourAndMinute[0]) == 1 && Integer.parseInt(hourAndMinute[2]) > 0){
            cost = 15;
        }
        else if (Integer.parseInt(hourAndMinute[0]) > 1 && Integer.parseInt(hourAndMinute[2]) == 0){
            cost = 10 + 5 * (Integer.parseInt(hourAndMinute[0]) - 1);
        }
        else{
            cost = 10 + 5 * (Integer.parseInt(hourAndMinute[0]));
        }
    }
}
