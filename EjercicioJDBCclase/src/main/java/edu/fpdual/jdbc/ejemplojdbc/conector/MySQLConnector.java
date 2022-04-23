package edu.fpdual.jdbc.ejemplojdbc.conector;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityManagerImpl;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Set;

/**
 * Class responsible for creation of MySQL DB connection.
 * @author jose.m.prieto.villar
 *
 */
public class MySQLConnector {

  @Setter
  @Getter
  Properties prop = new Properties();

  public MySQLConnector() {
    try {
      //Loads all the properties of file "config.properties".
      prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates the connection object for a MySQL DDBB
   * @return a {@link Connection}
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
   * Obtains the URL to connect to a MySQL DDBB.
   * @return an URL
   */
  private String getURL() {
    //jdbc:mysql://localhost:3306/world?user=sa&password=12345678&useSSL=false;
    return new StringBuilder().append(prop.getProperty(MySQLConstants.URL_PREFIX))
        .append(prop.getProperty(MySQLConstants.URL_HOST)).append(":")
        .append(prop.getProperty(MySQLConstants.URL_PORT)).append("/")
        .append(prop.getProperty(MySQLConstants.URL_SCHEMA)).append("?user=")
        .append(prop.getProperty(MySQLConstants.USER)).append("&password=")
        .append(prop.getProperty(MySQLConstants.PASSWD)).append("&useSSL=")
        .append(prop.getProperty(MySQLConstants.URL_SSL)).append(("&useJDBCCompliantTimezoneShift="))
        .append(prop.getProperty(MySQLConstants.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT)).append(("&useLegacyDatetimeCode="))
        .append(prop.getProperty(MySQLConstants.USE_LEGACY_DATE_TIME_CODE)).append(("&serverTimezone="))
        .append(prop.getProperty(MySQLConstants.SERVER_TIMEZONE)).toString();
  }

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    ejemploStatement();
    //ejemploPreparedStatement();
    //mostrarCiudades();
  }

  private static void ejemploStatement() throws SQLException, ClassNotFoundException {
    MySQLConnector connector = new MySQLConnector();

    try(Connection connection = connector.getMySQLConnection();
        Statement stm = connection.createStatement()) {
      ResultSet result = stm.executeQuery("SELECT Id, Name, District FROM world.city where CountryCode = 'ESP'");

      int counter = 0;
      result.beforeFirst();
      while (result.next()) {
        int id = result.getInt("Id");
        String name = result.getString("Name");
        String district = result.getString("District");
        System.out.println(id + " " + name + " " + district);
        counter++;
      }
      System.out.println("Total de elementos: " + counter);
    }
  }

  private static void ejemploPreparedStatement() throws SQLException, ClassNotFoundException {
    Connection connection = new MySQLConnector().getMySQLConnection();
    CityManagerImpl cityManager = new CityManagerImpl();
    Set<City> cities = cityManager.findCityByCountryCodeBetweenPopulation(connection, "ESP", 100000, 250000);
    for (City c: cities) {
      System.out.println(c);
    }

    System.out.println("Total de elementos: " + cities.size());
  }
/*
  private static void mostrarCiudades() throws SQLException, ClassNotFoundException {
    Connection connection = new MySQLConnector().getMySQLConnection();
    Statement s = connection.createStatement();
    ResultSet ciudades = s.executeQuery("SELECT * FROM world.city");


    for ( City c : ciudades) {
      System.out.println(ciudades.getString(c));
    }
    //System.out.println("Total de elementos: " + cities.size());
  }*/
}
