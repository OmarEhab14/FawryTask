import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items;
    public Cart() {
        this.items = new ArrayList<>();
    }
    public void add(CartItem item) {
        if (item.getQuantity() > item.getProduct().getQuantity()) {
            throw new IllegalArgumentException("No enough stock for product " + item.getProduct().getName());
        }
        this.items.add(item);
    }
    public List<CartItem> getItems() {
        return items;
    }
    public void clearCart() {
        this.items.clear();;
    }
}
