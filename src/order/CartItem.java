package order;

import menu.Menu;

public class CartItem {
    private Menu menu;
    private int count;

    public CartItem() {

    }

    public CartItem(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
