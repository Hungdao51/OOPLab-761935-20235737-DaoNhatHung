package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    private Runnable onItemAdded;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store) {
        this(store, null);
    }

    public AddItemToStoreScreen(Store store, Runnable onItemAdded) {
        this.store = store;
        this.onItemAdded = onItemAdded;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createHeader(), BorderLayout.NORTH);
        cp.add(createForm(), BorderLayout.CENTER);

        setTitle("Add Item To Store");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected JPanel createHeader() {
        JPanel header = new JPanel();
        JLabel title = new JLabel("Add Item To Store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        header.add(title);
        return header;
    }

    protected JPanel createForm() {
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();

        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Cost:"));
        form.add(tfCost);

        addMoreFields(form);

        JButton btnAdd = new JButton("Add");
        form.add(new JLabel(""));
        form.add(btnAdd);

        btnAdd.addActionListener(e -> addItem());

        return form;
    }

    protected abstract void addMoreFields(JPanel form);

    protected abstract void addItem();

    protected void notifyItemAdded() {
        if (onItemAdded != null) {
            onItemAdded.run();
        }
    }
}
