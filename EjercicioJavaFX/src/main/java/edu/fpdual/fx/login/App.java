package edu.fpdual.fx.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

  private static Scene scene;

  @Override
  public void start(Stage stage) throws Exception {
    System.out.println(getClass());
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/login_form.fxml"));
    stage.setTitle("Control de Acceso");
    stage.setScene(new Scene(root, 700, 500));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }


}
