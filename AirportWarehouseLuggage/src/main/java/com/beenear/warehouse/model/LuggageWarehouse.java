package com.beenear.warehouse.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LuggageWarehouse {
    private List<LuggageSpot> spots;
    private static final Random RANDOM = new Random();

    public LuggageWarehouse(int nrOfSpots) {
        spots = IntStream.range(0, nrOfSpots).boxed().map(LuggageSpot::new).collect(Collectors.toList());
    }

    public List<LuggageSpot> getAvailableSpots(){
        return spots.stream().filter(LuggageSpot::isAvailable).collect(Collectors.toList());
    }


    public CheckInDetails putLuggage(Luggage luggage) throws NoFreeSpotException {
        Optional<LuggageSpot> luggageSpot = getRandomFreeSpot(getAvailableSpots());
        if (luggageSpot.isPresent()) {
            luggageSpot.get().fillSpot(luggage);

            ReservationOperations reservationOperations = new ReservationOperations();
            LocalDateTime checkIn = LocalDateTime.now();
            luggageSpot.get().setIDCode(luggageSpot.get().getSpotNumber());
            return new CheckInDetails(checkIn, luggageSpot.get());
        } else {
            throw new NoFreeSpotException();
        }
    }

    public CheckOutDetails checkoutLuggage(LuggageSpot luggageSpot, LocalDateTime checkIn) {

        ReservationOperations reservationOperations = new ReservationOperations();

        Optional<Luggage> luggage = luggageSpot.removeLuggage();
        LocalDateTime checkOut = LocalDateTime.now();

        long cost =  reservationOperations.computeCost(checkIn, checkOut);

        return new CheckOutDetails(checkOut, luggage.get(), cost);
    }

    private Optional<LuggageSpot> getRandomFreeSpot(List<LuggageSpot> availableSpots){

        if (availableSpots.size() == 0) {
            return Optional.empty();
        }
        return Optional.ofNullable(availableSpots.get(RANDOM.nextInt(availableSpots.size())));
    }


}
