package edu.fpdual.streams.world.countries;

import jdk.jshell.Snippet;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class City {

  private int id;
  private String name;
  private int population;
  private String countryCode;
  public City(ResultSet result) throws SQLException {
    setId(result.getInt("ID"));
    setName(result.getString("Name"));
    setPopulation(result.getInt("Population"));
    setCountryCode(result.getString("CountryCode"));
  }


  /*public List ListCities() {
    List<City>[] cities = new List<>[];

    while (listado.next()) {
      cities = new City[listado.getRow()];
    }
    return cities;
  }*/


}
