package edu.fpdual.fx.controller;

import edu.fpdual.fx.controller.events.MyMouseEnteredEvent;
import edu.fpdual.fx.controller.events.MyMouseExitedEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

  @FXML
  private Button primaryButton;

  @FXML
  private ImageView boxImage;

  @FXML
  private void switchToSecondary() throws IOException {
    App.setRoot("secondary");
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    primaryButton.setText("Boton Inicial");

    boxImage.setOnMouseEntered(new MyMouseEnteredEvent());
    boxImage.setOnMouseExited(new MyMouseExitedEvent());
    boxImage.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Clicked!!!!"));

    Rectangle clip = new Rectangle(
        boxImage.getFitWidth(), boxImage.getFitHeight()
    );
    clip.setArcWidth(20);
    clip.setArcHeight(20);
    boxImage.setClip(clip);

    // snapshot the rounded image.
    SnapshotParameters parameters = new SnapshotParameters();
    parameters.setFill(Color.TRANSPARENT);
    WritableImage image = boxImage.snapshot(parameters, null);

    // remove the rounding clip so that our effect can show through.
    boxImage.setClip(null);

    // apply a shadow effect.
    boxImage.setEffect(new DropShadow(20, Color.BLACK));

    // store the rounded image in the imageView.
    boxImage.setImage(image);
  }
}
