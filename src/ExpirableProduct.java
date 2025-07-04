import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable{
    LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    @Override
    public boolean isExpired() {
        return this.expiryDate.isBefore(LocalDate.now());
    }

    @Override
    String getName() {
        return this.name;
    }
}
