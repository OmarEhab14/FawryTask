public class BasicProduct extends Product{
    public BasicProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    String getName() {
        return name;
    }
}
