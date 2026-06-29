package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        this(store, null);
    }

    public AddCompactDiscToStoreScreen(Store store, Runnable onItemAdded) {
        super(store, onItemAdded);
        setTitle("Add CD");
    }

    @Override
    protected void addMoreFields(JPanel form) {
        tfDirector = new JTextField();
        tfLength = new JTextField();
        tfArtist = new JTextField();

        form.add(new JLabel("Director:"));
        form.add(tfDirector);

        form.add(new JLabel("Length:"));
        form.add(tfLength);

        form.add(new JLabel("Artist:"));
        form.add(tfArtist);
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        String artist = tfArtist.getText();

        CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
        store.addMedia(cd);
        notifyItemAdded();

        JOptionPane.showMessageDialog(this, "CD added successfully!");
        dispose();
    }
}
