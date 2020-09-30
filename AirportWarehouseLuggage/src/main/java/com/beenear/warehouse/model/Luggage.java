package com.beenear.warehouse.model;

public class Luggage {
    private int weight;
    private String size;
    private LuggageContentType type;

    public Luggage(int weight, String size, LuggageContentType type) {
        this.weight = weight;
        this.size = size;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LuggageContentType getType() {
        return type;
    }

    public void setType(LuggageContentType type) {
        this.type = type;
    }


}
