package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");

        // Test add
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        // Test remove
        store.removeMedia(dvd1);
        store.removeMedia(dvd1); // Lần 2 sẽ báo không tìm thấy
    }
}
