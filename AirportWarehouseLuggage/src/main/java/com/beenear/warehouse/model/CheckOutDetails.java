package com.beenear.warehouse.model;

import java.time.LocalDateTime;
import java.util.Optional;

public class CheckOutDetails {
    private LocalDateTime checkOut;
    private Luggage luggage;
    private long cost;

    public CheckOutDetails(LocalDateTime checkOut, Luggage luggage, long cost) {
        this.checkOut = checkOut;
        this.luggage = luggage;
        this.cost = cost;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public Optional<Luggage> getLuggage() {
        return Optional.ofNullable(luggage);
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
