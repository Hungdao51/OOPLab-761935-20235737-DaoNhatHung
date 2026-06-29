package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);

        btnAddToCart.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(this, "Added to cart: " + media.getTitle());
        });

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);

            btnPlay.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JOptionPane.showMessageDialog(this, "Playing: " + media.getTitle());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Play error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.add(Box.createVerticalGlue());

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}