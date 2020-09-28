package com.beenear.warehouse.model;

public class Luggage {
    private int weight;
    private String size;
    private LuggageContent type;

    public Luggage(int weight, String size, LuggageContent type) {
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

    public LuggageContent getType() {
        return type;
    }

    public void setType(LuggageContent type) {
        this.type = type;
    }


}
