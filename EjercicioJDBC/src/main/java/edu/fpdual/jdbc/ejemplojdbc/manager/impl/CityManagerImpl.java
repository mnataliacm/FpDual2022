package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.manager.CityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Cities data.
 *
 * @author jose.m.prieto.villar
 * @author maria.castillo.munoz
 *
 */
public class CityManagerImpl implements CityManager {

  public List<City> findAll(Connection con) {
    // Create general statement
    try (Statement stmt = con.createStatement()) {
      // Queries the DB
      ResultSet result = stmt.executeQuery("SELECT * FROM City;");
      // Set before first registry before going through it.
      result.beforeFirst();

      // Initializes variables
      List<City> cities = new ArrayList<>();
      HashMap countries = new HashMap();

      // Run through each result
      while (result.next()) {
        // Initializes a city per result
        cities.add(new City(result));
        // Groups the countried by city
        countries.put(result.getInt("ID"), result.getString("CountryCode"));
      }

      // Fill the country of each city
      fillCountries(con, countries, cities);

      return cities;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public City findById(Connection con, int id) {
    //prepare SQL statement
    String sql = "select * "
        + "from city a, Country b "
        + "where a.id = ? "
        + "and a.CountryCode = b.Code;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setInt(1, id);
      // Queries the DB
      ResultSet result = stmt.executeQuery();
      // Set before first registry before going through it.
      result.beforeFirst();

      // Initialize variable
      City city = null;

      // Run through each result
      while (result.next()) {
        // Initializes a city per result
        city = new City(result);
        Country country = new Country(result);
        city.setCountry(country);
      }

      return city;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Fills all the countries for each city.
   *
   * @param con       the Db connection
   * @param countries the map of cities and countries.
   * @param cities    the list of cities to update.
   */
  private void fillCountries(Connection con, Map<Integer, String> countries, List<City> cities) {
    // Obtains all the country codes to search
    Set<String> countryCodes = new HashSet<>(countries.values());

    // Looks for all countries and groups them by id.
    Map<String, Country> countriesMap = new CountryManagerImpl().findAllById(con, countryCodes).stream()
        .collect(Collectors.toMap(Country::getId, data -> data));

    // Associates the corresponding Country to each City
    cities.forEach(city -> {
      String countryCode = countries.get(city.getId());
      Country foundCountry = countriesMap.get(countryCode);
      city.setCountry(foundCountry);
    });
  }

  /**
   * Fills all the countries for each city.
   *
   * @param con    the Db connection
   * @param letras
   * @return
   */
  public Set<City> findLetterInName(Connection con, String letras) {
    //prepare SQL statement
    String sql = "select *"
        + " from city a, country b"
        + " where a.Name like ?"
        + " and a.CountryCode = b.Code;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, letras);
      // Queries the DB
      ResultSet result = stmt.executeQuery();
      // Set before first registry before going through it.
      result.beforeFirst();

      // Initialize variables
      City city = null;
      Set<City> citySet = new HashSet<>();
      // Run through each result
      while (result.next()) {
        // Initializes a city per result
        city = new City(result);
        citySet.add(city);
        Country country = new Country(result);
        city.setCountry(country);
      }
      return citySet;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void addCiudad(Connection con, int id, String Name, String CountryCode, String District, int Population) {
    //prepare SQL statement
    String sql = "insert into city values (?, ?, ?, ?, ?);";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setInt(1, id);
      stmt.setString(2, Name);
      stmt.setString(3, CountryCode);
      stmt.setString(4, District);
      stmt.setInt(5, Population);

      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Ciudad insertada correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void editCiudad(Connection con, int id, String Name) {

  }

  @Override
  public void delCiudad(Connection con, int id) {

  }


  public void editCiudad(Connection con, Integer id, String Name) {
    //prepare SQL statement
    String sql = "update city set Name = ? where ID = ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, Name);
      stmt.setInt(2, id);
      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Ciudad modificada correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public void delCiudad(Connection con, Integer id) {
    //prepare SQL statement
    String sql = "delete from city where ID = ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setInt(1, id);

      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Ciudad borrada correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  //Por que pide esto? o convertir en abstract??
  /*@Override
  public void editCiudad(Connection con, int id, String Name) {

  }

  @Override
  public void delCiudad(Connection con, int id) {

  }*/
}
