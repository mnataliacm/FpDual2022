module edu.fpdual.fx {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires lombok;
  requires javafx.graphics;

  exports edu.fpdual.fx.login;
  opens edu.fpdual.fx.login to javafx.fxml;


}