package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.manager.CityManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CityManagerImpl implements CityManager {

  @Override
  public Set<City> findCityByCountryCodeBetweenPopulation(Connection con, String countryCode, int startLimit, int endLimit) throws SQLException {
    try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM world.city "
        + "where CountryCode = ? AND Population BETWEEN ? AND ?")) {

      prepstm.setString(1, countryCode);
      prepstm.setInt(2, startLimit);
      prepstm.setInt(3, endLimit);

      ResultSet result = prepstm.executeQuery();

      Set<City> citySet = new HashSet<>();
      result.beforeFirst();
      while (result.next()) {
        City city = new City(result);
        citySet.add(city);
      }
      return citySet;
    }

  }
}

