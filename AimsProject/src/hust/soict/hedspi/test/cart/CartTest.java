package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Thêm DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        dvd1.setId(1);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        dvd2.setId(2);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f, 0, "");
        dvd3.setId(3);
        cart.addMedia(dvd3);

        // Test in Cart
        cart.print();

        // Test tìm kiếm
        System.out.println("\n--- Testing Search ---");
        cart.filterMediaByID(1);
        cart.filterMediaByID(99);

        cart.filterMediaByTitle("Star Wars");
        cart.filterMediaByTitle("Avatar");
    }
}
