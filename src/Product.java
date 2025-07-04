public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    abstract String getName();
    double getPrice() {
        return this.price;
    }
    int getQuantity() {
        return this.quantity;
    }
    void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
