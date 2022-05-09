package edu.fpdual.streams.world.countries;

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
public class Country {

  private String code;
  private String name;
  private String continent;
  private double surfaceArea;
  private int population;
  private double gnp;
  private int capital;
  private List<City> cities;

  public Country(ResultSet result) throws SQLException {
    setCode(result.getString("Code"));
    setName(result.getString("Name"));
    setPopulation(result.getInt("Continent"));
    setSurfaceArea(result.getDouble("SurfaceArea"));
    setPopulation(result.getInt("Population"));
    setGnp(result.getDouble("GNP"));
    setCapital(result.getInt("Capital"));
    //setCities(result.getObject(new City()));

  }

}
