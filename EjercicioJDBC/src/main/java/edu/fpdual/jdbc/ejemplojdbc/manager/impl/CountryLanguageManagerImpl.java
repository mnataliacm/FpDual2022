package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.dao.CountryLanguage;
import edu.fpdual.jdbc.ejemplojdbc.manager.CountryLanguageManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CountryLanguageManagerImpl implements CountryLanguageManager {

  /*public List<CountryLanguage> findAll(Connection con) {
    // Create general statement
    try (Statement stmt = con.createStatement()) {
      // Queries the DB
      ResultSet result = stmt.executeQuery("SELECT * FROM countrylanguage;");
      // Set before first registry before going through it.
      result.beforeFirst();

      // Initializes variables
      List<CountryLanguage> languages = new ArrayList<>();
      HashMap language = new HashMap();

      // Run through each result
      while (result.next()) {
        // Initializes a city per result
        cities.add(new City(result));
        // Groups the countried by city
        countries.put(result.getInt("ID"), result.getString("CountryCode"));
      }

      // Fills the country of each city
      fillCountries(con, countries, cities);

      return cities;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }*/

}
