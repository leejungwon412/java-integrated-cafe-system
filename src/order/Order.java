package order;

import java.util.ArrayList;

public class Order {
    private String id;
    private ArrayList<CartItem> items = new ArrayList<>();

    public Order() {

    }

    public Order(String id, CartItem cartItem) {
        this.id = id;
        items.add(cartItem);
    }
}
