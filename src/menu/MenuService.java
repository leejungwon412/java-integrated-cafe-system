package menu;

import java.io.*;
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

    public void saveMenu() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("menus.txt"));
        for (int i = 0; i < menus.size(); i++) {
            String line = menus.get(i).getName() + "," + menus.get(i).getPrice();
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    public void loadMenus() throws IOException {
        File file = new File("menus.txt");
        if (!file.exists()) {
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader("menus.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            Menu menu = new Menu(data[0], Integer.parseInt(data[1]));
            menus.add(menu);
        }
        br.close();
    }
}
