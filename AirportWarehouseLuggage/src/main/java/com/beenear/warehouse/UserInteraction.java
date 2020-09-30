package com.beenear.warehouse;

import com.beenear.warehouse.model.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class UserInteraction {
    public static void main(String args[]) throws ParseException {

        int nrOfSpots = 3;
        LuggageWarehouse luggageWarehouse = new LuggageWarehouse(nrOfSpots);
        HashMap<Integer, CheckInDetails> ckin = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        String userOptions = "Please enter a choice:\n" +
                "1 - to get the number of available spots in the warehouse.\n" +
                "2 - to add a luggage in the warehouse\n" +
                "3 - to remove a luggage\n" +
                "4 - to exit";
        System.out.println(userOptions);

        int input = sc.nextInt();

        Optional<CheckInDetails> cki = Optional.empty();
        while (input != 4) {
            if (input == 1) {
                System.out.println(String.format("There are a total of %d available spots", luggageWarehouse.getAvailableSpots().size()));

            } else if (input == 2) {
                cki = getCheckInDetails(luggageWarehouse, sc, cki);
                if (cki.isEmpty()){
                    System.out.println(userOptions);
                    input = sc.nextInt();
                    continue;
                }
                else{
                    ckin.put(cki.get().getLuggageSpot().getIDCode(), cki.get());
                }

            } else if (input == 3) {
                getCheckOutDetails(luggageWarehouse, sc, ckin);
                System.out.println(userOptions);
                input = sc.nextInt();
                continue;

            } else {
                sc.close();
            }
            System.out.println(userOptions);
            input = sc.nextInt();
        }
    }

    private static String getCheckOutDetails(LuggageWarehouse luggageWarehouse, Scanner sc, HashMap<Integer, CheckInDetails> ckin) {
        String returnString = "";
        if (ckin.isEmpty()) {
            System.out.println("There is no existing luggage");
            returnString = "There is no existing luggage";
        } else {
            System.out.println("Please fill in below the identification number that you received, " +
                    "which corresponds to your package:");
            final int code = sc.nextInt();
            if (ckin.containsKey(code)) {
                CheckOutDetails cko = luggageWarehouse.checkoutLuggage(ckin.get(code).getLuggageSpot(),
                        ckin.get(code).getCheckIn());
                System.out.println("Luggage with the IDCode" + " " + ckin.get(code).getLuggageSpot().getIDCode() +
                        "," + "with weight=" + cko.getLuggage().get().getWeight() + " " + "kg" + "," + " " +
                        "size=" + cko.getLuggage().get().getSize() + " " + "cm" + " " + "and type=" +
                        cko.getLuggage().get().getType() + " " + "has been reserved from" + " " + ckin.get(code).getCheckIn() + " " +
                        "until" + " " + cko.getCheckOut() + "." + "The total cost is" + " " +
                        cko.getCost() + " " + "Ron." + "\n");

                returnString = "Luggage with the IDCode" + " " + ckin.get(code).getLuggageSpot().getIDCode() +
                        "," + "with weight=" + cko.getLuggage().get().getWeight() + " " + "kg" + "," + " " +
                        "size=" + cko.getLuggage().get().getSize() + " " + "cm" + " " + "and type=" +
                        cko.getLuggage().get().getType() + " " + "has been reserved from" + " " + ckin.get(code).getCheckIn() + " " +
                        "until" + " " + cko.getCheckOut() + "." + "The total cost is" + " " +
                        cko.getCost() + " " + "Ron." + "\n";

            } else {
                System.out.println("Error: incorrect code");
                returnString = "Error: incorrect code";
            }
        }
        return returnString;
    }

    private static Optional<CheckInDetails> getCheckInDetails(LuggageWarehouse luggageWarehouse, Scanner sc, Optional<CheckInDetails> cki) {
        System.out.println("Please provide the weight of the luggage");
        int weight = sc.nextInt();

        System.out.println("Please provide the size of the luggage in the lengthXwidth format");
        String size = sc.next();
        if (size.contains("X")) {
            String splitByX[] = size.split("X");
            try {
                Integer.parseInt(splitByX[0]);
                Integer.parseInt(splitByX[1]);

            } catch (NumberFormatException e) {
                System.out.println("Erroneous format");
                return Optional.empty();
            }
        } else {
            System.out.println("Erroneous format");
            return Optional.empty();
        }


        System.out.println("Please specify whether the content of your luggage is fragile or valuable." +
                " If not, just specify that it's daily content");
        String type = sc.next();
        LuggageContentType luggageContentType = LuggageContentType.valueOf(type.toUpperCase());

        Luggage luggage = new Luggage(weight, size, luggageContentType);

        try {
            cki = Optional.ofNullable(luggageWarehouse.putLuggage(luggage));
        } catch (NoFreeSpotException e) {
            System.out.println("There are no more free spots!!");
            return Optional.empty();
        }

        if (cki.isPresent()) {
            System.out.println("Spot number" + " " + cki.get().getLuggageSpot().getSpotNumber()
                    + " " + "with the identification code" + " " + cki.get().getLuggageSpot().getIDCode() + " "
                    + "at date" + " " + cki.get().getCheckIn() + " " + "has been reserved for your luggage." + "\n");
        } else {
            return Optional.empty();
        }
        return cki;
    }

}
