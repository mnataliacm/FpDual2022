package edu.fpdual.fx.controller.events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MyMouseEnteredEvent implements EventHandler<MouseEvent> {
  @Override
  public void handle(MouseEvent mouseEvent) {
    System.out.println("El Ratón Ha entrado");
  }
}
