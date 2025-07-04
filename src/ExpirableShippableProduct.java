import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Expirable, Shippable{
    LocalDate expiryDate;
    double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
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
