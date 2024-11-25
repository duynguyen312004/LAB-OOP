package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
    // Thuộc tính: danh sách DVD trong cửa hàng
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("DVD \"" + dvd.getTitle() + "\" da duoc them vao cua hang.");
    }

    // Phương thức xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("DVD \"" + dvd.getTitle() + "\" đã được xóa khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy DVD \"" + dvd.getTitle() + "\" trong cửa hàng.");
        }
    }

    // Phương thức hiển thị danh sách DVD trong cửa hàng
    public void displayStoreItems() {
        System.out.println("\n*********************** CỬA HÀNG ***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Không có DVD nào trong cửa hàng.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                DigitalVideoDisc dvd = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + dvd.getTitle() + " - " + dvd.getCategory() +
                        " - " + dvd.getDirector() + " - " + dvd.getLength() + " phút - $" + dvd.getCost());
            }
        }
        System.out.println("********************************************************");
    }
}
