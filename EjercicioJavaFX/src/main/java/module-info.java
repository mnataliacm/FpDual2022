module edu.fpdual.fx.ejerciciojavafx {
  requires javafx.controls;
  requires javafx.fxml;


  opens edu.fpdual.fx.ejerciciojavafx to javafx.fxml;
  exports edu.fpdual.fx.ejerciciojavafx;
}