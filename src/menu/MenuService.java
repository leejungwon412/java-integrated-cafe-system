package menu;

import java.util.ArrayList;

public class MenuService {
    ArrayList<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void modifyMenu(String name, String setName) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getName().equals(name)) {
                menus.get(i).setName(setName);
            }
        }
    }

    public void modifyMenu(String name, int setPrice) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getName().equals(name)) {
                menus.get(i).setPrice(setPrice);
            }
        }
    }

    public void deleteMenu(String name) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getName().equals(name)) {
                menus.remove(i);
            }
        }
    }

    public void getMenu() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println("상품명 : " + menus.get(i).getName() + ", 가격 : " + menus.get(i).getPrice());
        }
    }

    public boolean findName(String name) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Menu getMenuByName(String name) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getName().equals(name)) {
                return menus.get(i);
            }
        }
        return null;
    }
}
