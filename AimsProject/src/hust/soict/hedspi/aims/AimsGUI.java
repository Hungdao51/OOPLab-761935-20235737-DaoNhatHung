package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.SwingUtilities;

public class AimsGUI {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                19.95f,
                120,
                "Hnam");

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                24.95f,
                234,
                "DavidThomson");

        CompactDisc cd1 = new CompactDisc(
                "Thien Ly Oi",
                "Pop",
                15.5f,
                50,
                "Kcm",
                "Jack");

        CompactDisc cd2 = new CompactDisc(
                "That Girl",
                "Pop",
                12.0f,
                60,
                "Eds",
                "Ed Sheeran");

        Book book1 = new Book(
                "The Lord of the Rings",
                "Fantasy",
                29.99f);
        book1.addAuthor("J.R.R. Tolkien");

        cd1.addTrack(new Track(5, "Track 1"));
        cd1.addTrack(new Track(4, "Track 2"));

        store.addMedia(dvd1, dvd2, cd1, cd2, book1);

        SwingUtilities.invokeLater(() -> {
            new StoreScreen(store, cart);
        });
    }
}
