package com.example.pamo_s24261.model;

public class ShoppingItem {

    private final String name;
    private boolean bought;

    public ShoppingItem(String name) {
        this.name = name;
        this.bought = false;
    }

    public String getName() {
        return name;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
