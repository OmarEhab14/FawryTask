package models;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public abstract String getName();
    public double getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
