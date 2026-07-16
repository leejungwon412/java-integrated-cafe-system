package order;

import member.User;
import menu.MenuService;

import java.io.*;
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
                System.out.println("메뉴 이름 : " + cartItems.get(i).getMenu().getName() + ", 개수 : " + cartItems.get(i).getCount() + ", 가격 : " + cartItems.get(i).getCount() * cartItems.get(i).getMenu().getPrice());
            }
            System.out.println("총 가격 : " + getTotalPrice());
        }
    }

    public void viewOrderItem() {
        if (orders.isEmpty()) {
            System.out.println("주문 내역이 없습니다.");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("메뉴 이름 : " + orders.get(i).getMenu().getName() + ", 개수 : " + orders.get(i).getCount() + ", 가격 : " + orders.get(i).getCount() * orders.get(i).getMenu().getPrice());
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

    public void saveOrders() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("orders.txt"));
        for (int i = 0; i < orders.size(); i++) {
            String line = orders.get(i).getMenu().getName() + "," + orders.get(i).getCount();
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    public void loadOrders(MenuService menuService) throws IOException {
        File file = new File("orders.txt");
        if (!file.exists()) {
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader("orders.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            CartItem cartItem = new CartItem(menuService.getMenuByName(data[0]), Integer.parseInt(data[1]));
            orders.add(cartItem);
        }
        br.close();
    }
}
