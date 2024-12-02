package com.keijisuzuki.sm;

import java.util.regex.*;

public abstract class Package {
    protected String trackingID;
    protected String destination;
    protected double weight;

    public Package(String trackingID, String destination, double weight) throws IllegalArgumentException {

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be a positive number.");
        }

        this.trackingID = trackingID;
        this.destination = destination;
        this.weight = weight;
    }

    public abstract double calculateShippingCost();

    public String getTrackingID() {
        return trackingID;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Tracking ID: %s | Destination: %s | Weight: %.2f | Cost: $%.2f",
                trackingID, destination, weight, calculateShippingCost());
    }
}
