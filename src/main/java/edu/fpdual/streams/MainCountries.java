package edu.fpdual.streams;

import edu.fpdual.streams.world.countries.City;
import edu.fpdual.streams.world.countries.Country;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

public class MainCountries {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root", "root");
    Statement s = con.createStatement();
    ResultSet listado = s.executeQuery("SELECT ID, Name, Population, CountryCode FROM world.city");
    listado.next();
    City[] cities = new City[5];
    Country[] countries = new Country[5];

    /*while (listado.next()) {
     cities = (List<City>[]) listado.getObject(listado.toString());
      for (List c: cities) {
        System.out.println(c);
      }
    }
    cities[0] = City.builder().id(listado.getInt("ID").name(listado.getString("Name")
        .population(listado.getInt("Population").countryCode(listado.getString("CountryCode").build();
*/
    cities[0] = City.builder().id(1).name("Madrid").population(2879052).countryCode("ESP").build();
    cities[1] = City.builder().id(2).name("London").population(7285000).countryCode("GBR").build();
    cities[2] = City.builder().id(3).name("Mexico").population(9209944).countryCode("PHL").build();
    cities[3] = City.builder().id(4).name("Sydney").population(3276207).countryCode("AUS").build();
    cities[4] = City.builder().id(5).name("Puerto Principe").population(290204).countryCode("HTI").build();

    countries[0] = Country.builder().code("ESP").name("España").continent("Europa")
        .surfaceArea(505992.00).population(39441700).gnp(553233.00).capital(1).build();
    countries[1] = Country.builder().code("GBR").name("Reino Unido").continent("Europa")
        .surfaceArea(242900.00).population(59623400).gnp(1378330.00).capital(2).build();
    countries[2] = Country.builder().code("MEX").name("Mexico").continent("America")
        .surfaceArea(1958201.00).population(98881000).gnp(414972.00).capital(3).build();
    countries[3] = Country.builder().code("AUS").name("Australia").continent("Oceania")
        .surfaceArea(7741220.00).population(18886000).gnp(211860.00).capital(3).build();
    countries[4] = Country.builder().code("HTI").name("Haiti").continent("North America")
        .surfaceArea(27750.00).population(8222000).gnp(3459.00).capital(5).build();

    //Encuentra la ciudad con mayor población de cada país.
    private static void CiudadMayorPoblacionPais(City[] cities) {
      List<City> citiesList = Array.asList(cities);
      List<String> nameList = citiesList.stream().map(City::getPopulation).max(citiesList.stream().max(listado.getInt("population")));

    }

    //Busca la ciudad con mayor población de cada continente.





  }

}

/*
• Encuentra la ciudad con mayor población de cada país.
• Busca la ciudad con mayor población de cada continente.
• Encuentra la capital con mayor población.
• Encuentra la capital con mayor población de cada continente.
• Ordena los países por el numero de ciudades de forma descendente.
• Ordena los países por su densidad poblacional de forma descendente e ignorando los países con población 0
 */