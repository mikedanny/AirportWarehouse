package com.beenear.warehouse.model;

import java.util.Optional;

public class LuggageSpot {
    private int spotNumber;
    private int IDCode;
    private Luggage luggage;
    private ReservationOperations reservationDetails;

    public LuggageSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Optional<Luggage> getLuggage() {
        return Optional.ofNullable(luggage);
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public int getIDCode() { return IDCode; }

    public void setIDCode(int IDCode) { this.IDCode = IDCode; }

    public boolean isAvailable(){
        return luggage == null;
    }

    public void fillSpot(Luggage luggage) throws NoFreeSpotException {
        if (!isAvailable()) {
            throw new NoFreeSpotException();
        } else {
            setLuggage(luggage);
        }
    }

    public Optional<Luggage> removeLuggage(){
        Luggage previousLuggage = luggage;
        luggage = null;

        return Optional.ofNullable(previousLuggage);
    }
}
