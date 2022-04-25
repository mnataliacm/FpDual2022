package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.manager.CountryManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Country DTO Manager.
 * <p>
 * Contains all the queries used to consult and manipulate Countries data.
 *
 * @author jose.m.prieto.villar
 */
public class CountryManagerImpl implements CountryManager {

   /*public List<Country> findAllById(Connection con, Set<String> ids) {
        // Creates the SQL command
        String sql = String.format("SELECT * FROM Country WHERE Code IN (%s)",
                ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));
        // "ESP","FR","DEU","UK","PR"
        // SELECT * FROM Country WHERE Code in ("ESP","FR","DEU","UK","PR"

        // Create a prepared statement
        try (Statement stmt = con.createStatement()) {

            // Executes sql command
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<Country> countries = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a country per result
                countries.add(new Country(result));
            }

            return countries;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/

    /*public List<Country> findBySurfaceAreaBetween(Connection con, BigDecimal startSurfaceArea,
                                                  BigDecimal endSurfaceArea) throws SQLException {

        try (PreparedStatement prepStmt = con
                .prepareStatement("SELECT * FROM Country where SurfaceArea between ? and ?")) {
            prepStmt.setBigDecimal(1, startSurfaceArea);
            prepStmt.setBigDecimal(2, endSurfaceArea);

           // return prepareReturn(prepStmt.executeQuery());
        }

    }
/*
    /**
     * Prepare the return of a result set
     * @param result the result set to prepate
     * @return a {@link List} of {@link Country}
     * @throws {@link SQLException}
     */
    /*private List<Country> prepareReturn(ResultSet result) throws SQLException {

        List<Country> countries = new ArrayList<>();

        while (result.next()) {
            countries.add(new Country(result));
        }

        return countries;
    }*/


  @Override
  public List<Country> findAllById(Connection con, Set<String> ids) {
    return null;
  }

  @Override
  public List<Country> findBySurfaceAreaBetween(Connection con, BigDecimal startSurfaceArea, BigDecimal endSurfaceArea) throws SQLException {
    return null;
  }

  //añado
  public List<Country> findAll(Connection con) {
    // Create general statement
    try (Statement stmt = con.createStatement()) {
      // Queries the DB
      ResultSet result = stmt.executeQuery("SELECT * FROM Country;");
      // Set before first registry before going through it.
      result.beforeFirst();

      // Initializes variables
      List<Country> countries = new ArrayList<>();

      // Run through each result
      while (result.next()) {
        // Initializes a Country per result
        countries.add(new Country(result));
        // Groups the countried by Country
      }

      return countries;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Country findByCode(Connection con, String id) {
    //prepare SQL statement
    String sql = "select * "
        + "from Country"
        + " where code like ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, id);
      // Queries the DB
      ResultSet result = stmt.executeQuery();
      // Set before first registry before going through it.
      //result.beforeFirst();

      // Initialize variable
      Country country = null;

      // Run through each result
      while (result.next()) {
        // Initializes a Country per result
        country = new Country(result);
      }
      return country;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
/*
    /**
     * Fills all the countries for each Country.
     *
     * @param con       the Db connection
     * @param countries the map of countries and countries.
     * @param countries    the list of countries to update.
     */
  // TODO: 24/04/2022 al cambiar variables de ciudad lo he roto revisar
    /*private void fillCountries(Connection con, Map<Integer, String> countries, List<Country> countries) {
        // Obtains all the country codes to search
        Set<String> countryCodes = new HashSet<>(countries.values());

        // Looks for all countries and groups them by id.
        Map<String, Country> countriesMap = new CountryManagerImpl().findAllById(con, countryCodes).stream()
            .collect(Collectors.toMap(Country::getId, data -> data));

        // Associates the corresponding Country to each Country
        countries.forEach(Country -> {
            String countryCode = countries.get(Country.getId());
            Country foundCountry = countriesMap.get(countryCode);
            Country.setCountry(foundCountry);
        });
    }*/

  /**
   * Fills all the countries for each Country.
   *
   * @param con    the Db connection
   * @param letras
   * @return
   */
  public Set<Country> findLetterInName(Connection con, String letras) {
    //prepare SQL statement
    String sql = "select *"
        + " from Country"
        + " where name like ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, letras);
      // Queries the DB
      ResultSet result = stmt.executeQuery();
      // Set before first registry before going through it.
      result.beforeFirst();

      // Initialize variables
      Country Country = null;
      Set<Country> CountrySet = new HashSet<>();
      // Run through each result
      while (result.next()) {
        // Initializes a Country per result
        Country = new Country(result);
        CountrySet.add(Country);
      }
      return CountrySet;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void addPais(Connection con, String code, String name, String continente, String region, Double surfaceArea, Integer indepYear, int pop, Double lifeExp, Double gnp, Double gnpOld, String localName, String govern, String head, Integer capital, String code2) {
    //prepare SQL statement
    String sql = "insert into country values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, code);
      stmt.setString(2, name);
      stmt.setString(3, continente);
      stmt.setString(4, region);
      stmt.setDouble(5, surfaceArea);
      stmt.setInt(6, indepYear);
      stmt.setInt(7, pop);
      stmt.setDouble(8, lifeExp);
      stmt.setDouble(9, gnp);
      stmt.setDouble(10, gnpOld);
      stmt.setString(11, localName);
      stmt.setString(12, govern);
      stmt.setString(13, head);
      stmt.setInt(14, capital);
      stmt.setString(15, code2);

      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Pais añadido correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public void editPais(Connection con, String code, String name) {
    //prepare SQL statement
    // TODO: 23/04/2022  falla no actualiza
    String sql = "update country set Name = ? where Code = ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, name);
      stmt.setString(2, code);
      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Pais modificado correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public void delPais(Connection con, String code) {
    //prepare SQL statement
    String sql = "delete from country where Code = ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, code);

      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Pais borrado correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

}
