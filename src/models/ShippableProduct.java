package models;

import interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable {
    double weight;
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
