package services;

import interfaces.Shippable;
import interfaces.ShippingService;
import models.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ProductShippingService implements ShippingService {
    List<CartItem> cartItems;
    private final double BASE_SHIPPING_FEE = 2;
    public ProductShippingService(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public void shipItems() {
        System.out.println("** Shipment Notice **");
        double totalWeight = 0;
        for (CartItem item : getShippableItems()) {
            if (item.getProduct() instanceof Shippable) {
                totalWeight += ((Shippable) item.getProduct()).getWeight() * item.getQuantity();
                System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "\t" + ((Shippable) item.getProduct()).getWeight() * item.getQuantity() + "g");
            }
        }
        if ((int)totalWeight > 0) {
            double weightInKg = totalWeight / 1000;
            System.out.println("Total package weight " + weightInKg + "Kg");
        } else {
            System.out.println("No shipment required");
        }
    }

    @Override
    public double calculateShippingFees() {
        double shippingFees = 0;
        for (CartItem item : getShippableItems()) {
            shippingFees += BASE_SHIPPING_FEE * item.getQuantity();
        }
        return shippingFees;
    }

    private List<CartItem> getShippableItems() {
        List<CartItem> shippableItems = new ArrayList<>();
        for (CartItem item : cartItems) {
            if (item.getProduct() instanceof Shippable) {
                shippableItems.add(item);
            }
        }
        return shippableItems;
    }

}
