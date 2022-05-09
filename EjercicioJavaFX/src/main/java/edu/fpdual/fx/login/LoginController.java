package edu.fpdual.fx.login;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class LoginController {

  @FXML
  private TextField emailIdField;

  @FXML
  private PasswordField passwordField;

  @FXML
  private Button submitButton;

  @FXML
  public void login(ActionEvent event) throws SQLException {

    Window owner = submitButton.getScene().getWindow();

    System.out.println(emailIdField.getText());
    System.out.println(passwordField.getText());

    if (emailIdField.getText().isEmpty()) {
      showAlert(Alert.AlertType.ERROR, owner, "Error!",
          "Por favor, introduce el nombre de usuario");
      return;
    }
    if (passwordField.getText().isEmpty()) {
      showAlert(Alert.AlertType.ERROR, owner, "Error!",
          "Por favor, introduce una contraseña");
      return;
    }

    String emailId = emailIdField.getText();
    String password = passwordField.getText();

    JdbcDao jdbcDao = new JdbcDao();
    boolean flag = jdbcDao.validate(emailId, password);

    if (!flag) {
      infoBox("Datos incorrectos, comprueba el nombre y la contraseña", null, "Error");
    } else {
      infoBox("BIENVENID@!", null, "Sesión Iniciada");
    }
  }

  public static void infoBox(String infoMessage, String headerText, String title) {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setContentText(infoMessage);
    alert.setTitle(title);
    alert.setHeaderText(headerText);
    alert.showAndWait();
  }

  private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
  }

}
