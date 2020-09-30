package com.beenear.warehouse.model;

public class NoFreeSpotException extends Exception {

    public NoFreeSpotException() {
        super("Spot is not available!");
    }
}
