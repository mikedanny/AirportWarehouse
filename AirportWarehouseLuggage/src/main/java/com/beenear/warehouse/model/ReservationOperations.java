package com.beenear.warehouse.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ReservationOperations {

    public long computeCost(LocalDateTime d1, LocalDateTime d2){
        long minutes = Duration.between(d1, d2).toMinutes();
        long cost = 0L;
        if (minutes > 0L) {
            cost = 10L + 5L * (minutes / 60L - 1L);
            if (minutes % 60L > 0L) {
                cost += 5;
            }
        }
        return cost;
    }
}
