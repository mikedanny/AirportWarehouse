package com.beenear.warehouse;

import com.beenear.warehouse.model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LuggageWarehouseRunner {
    public static void main(String args[]) throws ParseException {
//        LocalDateTime now = LocalDateTime.now();
//        int hour = now.getHour();
//        int minute = now.getMinute();


//        LuggageWarehouse luggageWarehouse = new LuggageWarehouse(20);
//        luggageWarehouse.getFreeSpot();
//        int locker = luggageWarehouse.putLugagge();
//        Luggage l = luggageWarehouse.getLugagge(6);

        LuggageWarehouse luggageWarehouse = new LuggageWarehouse(20);
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the weight of your luggage");
        int weight = sc.nextInt();

        System.out.println("Please enter the size of your luggage in the length x width format");
        String size = sc.nextLine();

        System.out.println("Please specify whether your luggage contains something fragile or valuable. If not, please write daily instead");
        String type = sc.nextLine();
        LuggageContent luggageContent = LuggageContent.valueOf(type);

        Luggage luggage = new Luggage(weight, size, luggageContent);

        ArrayList<LuggageSpot> availableSpots = luggageWarehouse.getAvailableSpots();

        System.out.println("Our warehouse currently has a number of" + " " + availableSpots.size() + " " + "available spots.");

        Random rand = new Random();
        LuggageSpot reservedSpot = availableSpots.get(rand.nextInt(availableSpots.size()));
        int reservedIDCode = reservedSpot.getSpotNumber();

        reservedSpot = reservedSpot.fillSpot(luggage);

        System.out.println("Your luggage has received a warehouse spot. Your luggage identification code is" + " " + reservedIDCode);

//        LocalTime now = LocalTime.now();
//        int hour = now.getHour();
//        int minute = now.getMinute();
//        String dateStart = "11/03/14 09:29:58";
//        String dateStop = "11/03/14 09:33:43";

// Custom date format
//        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
//        Date d1 = format.parse(dateStart);
//        Date d2 = format.parse(dateStop);
//
//        long diff = d2.getTime() - d1.getTime();
//        long diffMinutes = diff / (60 * 1000);
//        long diffHours = diff / (60 * 60 * 1000);
//        System.out.println(diffHours + " " + diffMinutes);

    }

}
