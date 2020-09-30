package com.beenear.warehouse.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LuggageSpotTest {

    @Test
    public void isAvailable() {
        LuggageSpot luggageSpot = new LuggageSpot(2);
        Luggage luggage = new Luggage(20, "10X15", LuggageContentType.DAILY);
        luggageSpot.setLuggage(luggage);
        Assert.assertFalse("false", luggageSpot.isAvailable());
    }

    @Test
    public void removeLuggage() {
        Luggage luggage = new Luggage(20, "10X15", LuggageContentType.DAILY);
        LuggageSpot luggageSpot = new LuggageSpot(3);
        luggageSpot.setLuggage(luggage);
        Assert.assertTrue("true", luggageSpot.removeLuggage().isPresent());
    }

}