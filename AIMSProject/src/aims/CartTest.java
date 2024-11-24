package aims;

import aims.cart.Cart;
import aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99);

        // Tạo giỏ hàng và thêm DVD
        Cart cart = new Cart();
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // In giỏ hàng
        cart.printCart();

        // Tìm kiếm theo ID
        System.out.println("\nSearch by ID:");
        cart.searchById(2); // Thay ID để kiểm tra

        // Tìm kiếm theo tiêu đề
        System.out.println("\nSearch by Title:");
        cart.searchByTitle("Star");
        cart.searchByTitle("Unknown");
    }
}