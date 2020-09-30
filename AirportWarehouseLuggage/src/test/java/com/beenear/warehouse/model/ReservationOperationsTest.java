package com.beenear.warehouse.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ReservationOperationsTest {

    @Test
    public void computeCost() {
        LocalDateTime d1 = LocalDateTime.of(2020, 9, 29, 18, 30);
        LocalDateTime d2 = LocalDateTime.of(2020, 9, 29, 19, 35);

        ReservationOperations reservationOperations = new ReservationOperations();

        Assert.assertEquals(15, reservationOperations.computeCost(d1, d2));

    }
}