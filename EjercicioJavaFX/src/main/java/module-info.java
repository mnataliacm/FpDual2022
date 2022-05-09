module edu.fpdual.fx {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires lombok;


  opens edu.fpdual.fx to javafx.fxml;
  exports edu.fpdual.fx;
  exports edu.fpdual.fx.controller;
  opens edu.fpdual.fx.controller to javafx.fxml;
  exports edu.fpdual.fx.login;
  opens edu.fpdual.fx.login to javafx.fxml;

}