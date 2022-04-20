package edu.fpdual.jdbc.ejemplojdbc.conector;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class responsible for creation of MySQL DB connection
 *
 * @author natalia.castillo.munoz
 */
public class MySQLConnector {

  @Getter
  @Setter
  //propiedad que almacena las propiedades de conexion
  Properties prop = new Properties();

  public MySQLConnector() {
    try {
      //Carga todas las propiedades del archivo config.properties
      prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
    } catch  (IOException e){
      e.printStackTrace();
    }
  }

  /**
   * Creates the connection object for a MySQL DDBB
   * @return a {@Link Connection}
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
    try {

      //Indicates which driver is going to be used.
      Class.forName(prop.getProperty(MySQLConstants.DRIVER));
      //Creates the connection based on the obtained URL.
      return  DriverManager.getConnection(getURL());
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Obtains the URL to connect to MySQL DDBB
   * @return an URL
   */
  private String getURL() {
    return new StringBuilder(). append(prop.getProperty(MySQLConstants.URL_PREFIX))
        .append(prop.getProperty(MySQLConstants.URL_HOST)).append(":")
        .append(prop.getProperty(MySQLConstants.URL_PORT)).append("/")
        .append(prop.getProperty(MySQLConstants.URL_SCHEMA)).append("?user=")
        .append(prop.getProperty(MySQLConstants.USER)).append("&password=")
        .append(prop.getProperty(MySQLConstants.PASSWD)).append("&useSSL")
        .append(prop.getProperty(MySQLConstants.URL_SSL)).append(("&useJDBCCompliantTimezoneShift="))
        .append(prop.getProperty(MySQLConstants.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT)).append(("&useLegacyDatetimeCode="))
        .append(prop.getProperty(MySQLConstants.USE_LEGACY_DATE_TIME_CODE)).append(("&serverTimezone="))
        .append(prop.getProperty(MySQLConstants.SERVER_TIMEZONE)).toString();
  }

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    MySQLConnector connector = new MySQLConnector();
    Connection connection = connector.getMySQLConnection();
    System.out.println(connection.getCatalog());
  }

}
