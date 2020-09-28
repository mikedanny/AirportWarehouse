package com.beenear.warehouse;

import com.beenear.warehouse.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class LuggageWarehouseRunner {
    public static void main(String args[]) throws ParseException {
//        LuggageWarehouse luggageWarehouse = new LuggageWarehouse(20);
//        luggageWarehouse.getFreeSpot();
//        int locker = luggageWarehouse.putLugagge();
//        Luggage l = luggageWarehouse.getLugagge(6);

        LuggageWarehouse luggageWarehouse = new LuggageWarehouse(20);
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the weight of your luggage");
        int weight = sc.nextInt();

        System.out.println("Please enter the size of your luggage in the length x width format");
        String size = sc.next();

        System.out.println("Please specify whether your luggage contains something fragile or valuable. If not, please write daily instead.");
        String type = sc.next();
        LuggageContent luggageContent = LuggageContent.valueOf(type.toUpperCase());

        Luggage luggage = new Luggage(weight, size, luggageContent);

        ArrayList<LuggageSpot> availableSpots = luggageWarehouse.getAvailableSpots();

        System.out.println("Our warehouse currently has a number of" + " " + availableSpots.size() + " " + "available spots.");

        Random rand = new Random();
        LuggageSpot randomSpot = availableSpots.get(rand.nextInt(availableSpots.size()));
        int reservedIDCode = randomSpot.getSpotNumber();

        LuggageSpot reservedSpot = randomSpot.fillSpot(luggage);
        ReservationDetails reservationDetails = new ReservationDetails();
        Date checkIn = reservationDetails.getDateAndTime();

        System.out.println("Your luggage has received a warehouse spot on the following date:" + " " + checkIn + "."
                + "Your luggage identification code is" + " " + reservedIDCode + "." + "Please press 1 when you wish to recover your luggage");

        if (sc.nextInt() == 1){
            Optional<Luggage> freedLuggage = reservedSpot.removeLuggage(reservedIDCode);
            ReservationDetails releaseDetails = new ReservationDetails();
            Date checkOut = releaseDetails.getDateAndTime();
            String totalTimeSpent = releaseDetails.computeTimeDuration(checkIn, checkOut);

            releaseDetails.setCost(totalTimeSpent);
            int cost = releaseDetails.getCost();

            System.out.println("Luggage with the IDCode" + " " + reservedIDCode + "," + "with weight=" + freedLuggage.get().getWeight() + " " + "kg" + "," + " " +
                    "size=" + freedLuggage.get().getSize() + " " + "cm" + " " + "and type=" + freedLuggage.get().getType() + " " + "has been reserved from" + " " + checkIn + " " +
                    "until" + " " + checkOut + "," + " " + "for a total time of" + " " + totalTimeSpent + "." + " " + "The total cost is" + " " +
                    cost + " " + "lei.");

//            System.out.println("Luggage specifications:" + " " + freedLuggage + "\n" + "Total time spent:" + " " + totalTimeSpent + "\n" +
//                    "Total cost:" + " " + cost);
        }
        sc.close();

    }

}
