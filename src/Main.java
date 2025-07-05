import interfaces.ShippingService;
import models.*;
import services.Checkout;
import services.ProductShippingService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Omar", 20000);
            Cart cart = new Cart();
            Product cheese = new ExpirableShippableProduct("Cheese", 5.99, 10,
                    LocalDate.of(2025, 8, 9), 5);
            CartItem cheeseItem = new CartItem(cheese, 2);
            cart.add(cheeseItem);

            Product tv = new ShippableProduct("TV", 499.99, 5, 8000);
            CartItem tvItem = new CartItem(tv, 1);
            cart.add(tvItem);

            ShippingService shippingService = new ProductShippingService(cart.getItems());
            Checkout checkout = new Checkout(customer, shippingService);

            checkout.processOrder(cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}