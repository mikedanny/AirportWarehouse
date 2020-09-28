package com.beenear.warehouse.model;

import java.util.Optional;

public class LuggageSpot {
    private int spotNumber;
    private int IDCode;
    private Optional<Luggage> luggage;
    private Optional<ReservationDetails> reservationDetails;

    public LuggageSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.luggage = Optional.empty();
        this.reservationDetails = Optional.empty();
    }

    public Optional<Luggage> getLuggage() {
        return luggage;
    }

    public void setLuggage(Optional<Luggage> luggage) {
        this.luggage = luggage;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isAvailable(){
        return luggage.isEmpty();
    }

    public LuggageSpot fillSpot(Luggage luggage) {
        if (!isAvailable())
        {
            System.out.println("Spot is filled");
        }
        else
        {
            setLuggage(Optional.of(luggage));
            IDCode = spotNumber;
        }
        return this;
    }

    public Optional<Luggage> removeLuggage(int userCode){
        Optional<Luggage> luggageData = luggage;
        if (userCode == IDCode){
            luggage = Optional.empty();
        }
        return luggageData;
    }
}
