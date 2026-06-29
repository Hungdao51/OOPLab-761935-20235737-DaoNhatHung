package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CartScreen extends JFrame {
    private Cart cart;
    private Runnable viewStoreAction;

    public CartScreen(Cart cart) {
        this(cart, null);
    }

    public CartScreen(Cart cart, Runnable viewStoreAction) {
        super();

        this.cart = cart;
        this.viewStoreAction = viewStoreAction;

        Platform.setImplicitExit(false);
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(findCartFxml());

                CartScreenController controller = new CartScreenController(cart, this::showStoreView);
                loader.setController(controller);
                loader.load();

                Parent root = loader.getRoot();
                fxPanel.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        this,
                        "Cannot open cart screen: " + e.getMessage(),
                        "Cart error",
                        JOptionPane.ERROR_MESSAGE));
            }
        });
    }

    private URL findCartFxml() throws IOException {
        Path[] candidates = {
                Paths.get("AimsProject", "src", "hust", "soict", "hedspi", "aims", "screen", "cart.fxml"),
                Paths.get("src", "hust", "soict", "hedspi", "aims", "screen", "cart.fxml")
        };

        for (Path candidate : candidates) {
            if (Files.exists(candidate)) {
                return candidate.toAbsolutePath().toUri().toURL();
            }
        }

        URL resource = getClass().getResource("cart.fxml");
        if (resource != null) {
            return resource;
        }

        throw new IOException("cart.fxml was not found on the classpath or in the source folder.");
    }

    private void showStoreView() {
        SwingUtilities.invokeLater(() -> {
            if (viewStoreAction != null) {
                viewStoreAction.run();
            }
            dispose();
        });
    }
}
