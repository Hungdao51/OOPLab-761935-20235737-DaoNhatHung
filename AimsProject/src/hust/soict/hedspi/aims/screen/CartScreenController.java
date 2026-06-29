package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CartScreenController {
    private Cart cart;
    private Runnable viewStoreAction;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    private ObservableList<Media> cartItems;
    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart) {
        this(cart, null);
    }

    public CartScreenController(Cart cart, Runnable viewStoreAction) {
        this.cart = cart;
        this.viewStoreAction = viewStoreAction;
    }

    @FXML
    private void initialize() {
        tblMedia.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colMediaTitle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
        colMediaCategory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
        colMediaCost.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getCost()).asObject());

        cartItems = FXCollections.observableArrayList(cart.getItemsOrdered());
        filteredList = new FilteredList<>(cartItems, p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateButtonBar(newValue);
                });

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia();
        });

        radioBtnFilterId.setOnAction(e -> showFilteredMedia());
        radioBtnFilterTitle.setOnAction(e -> showFilteredMedia());

        updateTotalCost();
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            return;
        }

        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            cartItems.remove(selectedMedia);
            updateTotalCost();
        }
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing");
                alert.setHeaderText(null);
                alert.setContentText("Playing: " + selectedMedia.getTitle());
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Order");
            alert.setHeaderText(null);
            alert.setContentText("Cart is empty!");
            alert.showAndWait();
            return;
        }

        cart.clear();
        cartItems.clear();
        updateTotalCost();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText(null);
        alert.setContentText("Order placed successfully!");
        alert.showAndWait();
    }

    @FXML
    private void btnViewStorePressed(ActionEvent event) {
        if (viewStoreAction != null) {
            viewStoreAction.run();
        }
    }

    private void showFilteredMedia() {
        String filter = tfFilter.getText();

        if (filter == null || filter.trim().isEmpty()) {
            filteredList.setPredicate(media -> true);
            return;
        }

        String lowerCaseFilter = filter.toLowerCase();

        filteredList.setPredicate(media -> {
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }

            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            }

            return true;
        });
    }

    private void updateTotalCost() {
        lblTotalCost.setText(cart.totalCost() + " $");
    }
}
