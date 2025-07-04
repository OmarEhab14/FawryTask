import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("John", 20000);
            Cart cart = new Cart();
            cart.add(new CartItem(new ExpirableShippableProduct("Cheese", 5.99, 10,
                    LocalDate.of(2025, 8, 9), 5),2));
            cart.add(new CartItem(new ShippableProduct("TV", 499.99, 5, 30), 1));

            ShippingService shippingService = new ProductShippingService(cart.getItems());
            Checkout checkout = new Checkout(customer, shippingService);

            checkout.processOrder(cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}