package edu.fpdual.todo.connect;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

  @Setter
  @Getter
  Properties prop = new Properties();

  public Connector() {
    try {
      //Carga todas las propiedades del archivo config.properties
      prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Crea el objeto de conexión a MySQL BBDD
   * @return a {@link Connection}
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    try {
      //Indica que driver se usará..
      Class.forName(prop.getProperty(Constants.DRIVER));

      //Crea la conexión obteniendo la URL.
      return  DriverManager.getConnection(getURL());

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Monta la URL de conexión a la BBDD
   * @return una URL
   */
  private String getURL() {
    //jdbc:mysql://localhost:3306/world?user=sa&password=12345678&useSSL=false;
    return new StringBuilder().append(prop.getProperty(Constants.URL_PREFIX))
        .append(prop.getProperty(Constants.URL_HOST)).append(":")
        .append(prop.getProperty(Constants.URL_PORT)).append("/")
        .append(prop.getProperty(Constants.URL_SCHEMA)).append("?user=")
        .append(prop.getProperty(Constants.USER)).append("&password=")
        .append(prop.getProperty(Constants.PASSWD)).append("&useSSL=")
        .append(prop.getProperty(Constants.URL_SSL)).append(("&useJDBCCompliantTimezoneShift="))
        .append(prop.getProperty(Constants.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT)).append(("&useLegacyDatetimeCode="))
        .append(prop.getProperty(Constants.USE_LEGACY_DATE_TIME_CODE)).append(("&serverTimezone="))
        .append(prop.getProperty(Constants.SERVER_TIMEZONE)).toString();
  }
}
