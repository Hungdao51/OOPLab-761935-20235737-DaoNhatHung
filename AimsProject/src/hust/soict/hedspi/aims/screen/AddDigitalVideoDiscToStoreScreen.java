package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        this(store, null);
    }

    public AddDigitalVideoDiscToStoreScreen(Store store, Runnable onItemAdded) {
        super(store, onItemAdded);
        setTitle("Add DVD");
    }

    @Override
    protected void addMoreFields(JPanel form) {
        tfDirector = new JTextField();
        tfLength = new JTextField();

        form.add(new JLabel("Director:"));
        form.add(tfDirector);

        form.add(new JLabel("Length:"));
        form.add(tfLength);
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
        store.addMedia(dvd);
        notifyItemAdded();

        JOptionPane.showMessageDialog(this, "DVD added successfully!");
        dispose();
    }
}
