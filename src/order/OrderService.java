package order;

import member.User;

import java.util.ArrayList;

public class OrderService {
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    private ArrayList<CartItem> orders = new ArrayList<>();

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            totalPrice += cartItems.get(i).getMenu().getPrice() * cartItems.get(i).getCount();
        }
        return totalPrice;
    }

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void clearCartItem() {
        cartItems.clear();
    }

    public void viewCartItem() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니에 담은 상품이 없습니다.");
        } else {
            for (int i = 0; i < cartItems.size(); i++) {
                System.out.println("메뉴 이름 : " + cartItems.get(i).getMenu().getName() + ", 개수 : " + cartItems.get(i).getCount());
            }
            System.out.println("총 가격 : " + getTotalPrice());
        }
    }

    public void viewOrderItem() {
        if (orders.isEmpty()) {
            System.out.println("주문 내역이 없습니다.");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("메뉴 이름 : " + orders.get(i).getMenu().getName() + ", 개수 : " + orders.get(i).getCount());
            }
        }
    }

    public void payment(User user) {
        for (int i = 0; i < cartItems.size(); i++) {
            orders.add(cartItems.get(i));
        }
        user.setBalance(getTotalPrice());
        clearCartItem();
    }

    public boolean getOrderByName(String name) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getMenu().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void deleteOrder(String name) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getMenu().getName().equals(name)) {
                cartItems.remove(i);
            }
        }
    }
}
