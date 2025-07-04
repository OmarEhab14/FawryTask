import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private final Customer customer;
    private final ShippingService shippingService;

    public Checkout(Customer customer, ShippingService shippingService) {
        this.customer = customer;
        this.shippingService = shippingService;
    }

    public void processOrder(Cart cart) {
        if (cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Empty cart");
        }

        validateExpiredItem(cart);

        double subtotal = calculateSubtotal(cart);

        double shippingFees = shippingService.calculateShippingFees();

        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Insufficient balance");
        }

        customer.pay(total);

        updateInventory(cart);

        shippingService.shipItems();

        printReceipt(cart, subtotal, shippingFees, total);


    }

    private void validateExpiredItem(Cart cart) {
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product instanceof Expirable expirable && expirable.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired");
            }
        }
    }

    private double calculateSubtotal(Cart cart) {
        double subtotal = 0;
        for (CartItem item : cart.getItems()) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    private void updateInventory(Cart cart) {
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
    }

    private void printReceipt(Cart cart, double subtotal, double shippingFees, double total) {
        System.out.println("** Checkout Receipt **");

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            System.out.println(item.getQuantity() + "x " + product.getName() + "\t" + product.getPrice() * item.getQuantity());
        }

        System.out.println("---");
        System.out.println("Subtotal\t" + String.format("%.2f", subtotal));
        System.out.println("Shipping\t" + String.format("%.2f", shippingFees));
        System.out.println("Total\t\t" + String.format("%.2f", total));
        System.out.println("Remaining Balance: " + String.format("%.2f", customer.getBalance()));
        System.out.println("END.");
    }
}