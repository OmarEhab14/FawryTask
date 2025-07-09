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
            Product cheese = new ExpirableShippableProduct("Cheese", 6.0, 10,
                    LocalDate.of(2025, 8, 9), 250);
            CartItem cheeseItem = new CartItem(cheese, 2);
            cart.add(cheeseItem);

            Product tv = new ShippableProduct("TV", 500.0, 5, 8000);
            CartItem tvItem = new CartItem(tv, 1);
            cart.add(tvItem);

            Product scratchCard = new BasicProduct("ScratchCard", 10.0, 20);
            CartItem scratchCardItem = new CartItem(scratchCard, 1);
            cart.add(scratchCardItem);

            Product biscuits = new ExpirableShippableProduct("Biscuits", 3.0, 15,
                    LocalDate.of(2025, 7, 20), 150);
            CartItem biscuitsItem = new CartItem(biscuits, 1);
            cart.add(biscuitsItem);

            ShippingService shippingService = new ProductShippingService(cart.getItems());
            Checkout checkout = new Checkout(customer, shippingService);

            checkout.processOrder(cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}