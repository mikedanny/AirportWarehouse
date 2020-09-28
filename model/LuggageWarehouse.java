package com.beenear.warehouse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LuggageWarehouse {
    private List<LuggageSpot> spots;

    public LuggageWarehouse(int nrOfSpots) {
        spots = new ArrayList<>(nrOfSpots);
        spots = IntStream.range(0, nrOfSpots).boxed().map(LuggageSpot::new).collect(Collectors.toList());
    }

    public ArrayList<LuggageSpot> getAvailableSpots(){
        ArrayList<LuggageSpot> availableSpots = new ArrayList<LuggageSpot>();
        spots.forEach(spot -> {
            if (spot.isAvailable()){
                availableSpots.add(spot);
            }
        });
        return availableSpots;
    }
}
