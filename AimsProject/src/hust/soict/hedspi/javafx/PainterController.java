package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    void initialize() {
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(drawingAreaPane.widthProperty());
        clip.heightProperty().bind(drawingAreaPane.heightProperty());
        drawingAreaPane.setClip(clip);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if (x < 0 || y < 0 || x > drawingAreaPane.getWidth() || y > drawingAreaPane.getHeight()) {
            return;
        }

        Circle newCircle = new Circle(x, y, 4);

        if (eraserRadioButton.isSelected()) {
            newCircle.setFill(Color.WHITE);
            newCircle.setRadius(8);
        } else {
            newCircle.setFill(Color.BLACK);
            newCircle.setRadius(4);
        }

        drawingAreaPane.getChildren().add(newCircle);
    }
}
