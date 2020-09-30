package com.beenear.warehouse.model;

import java.time.LocalDateTime;

public class CheckInDetails {
    private LocalDateTime checkIn;
    private LuggageSpot luggageSpot;

    public CheckInDetails(LocalDateTime checkIn, LuggageSpot luggageSpot) {
        this.checkIn = checkIn;
        this.luggageSpot = luggageSpot;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LuggageSpot getLuggageSpot() {
        return luggageSpot;
    }

    public void setLuggageSpot(LuggageSpot luggageSpot) {
        this.luggageSpot = luggageSpot;
    }
}
