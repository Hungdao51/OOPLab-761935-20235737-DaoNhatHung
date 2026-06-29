package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        this(store, null);
    }

    public AddBookToStoreScreen(Store store, Runnable onItemAdded) {
        super(store, onItemAdded);
        setTitle("Add Book");
    }

    @Override
    protected void addMoreFields(JPanel form) {
        // Lab yêu cầu đơn giản, Book chỉ cần title, category, cost
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        Book book = new Book(title, category, cost);
        store.addMedia(book);
        notifyItemAdded();

        JOptionPane.showMessageDialog(this, "Book added successfully!");
        dispose();
    }
}
