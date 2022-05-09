package edu.fpdual.streams;

import edu.fpdual.streams.world.countries.City;

import java.sql.*;

public class MainMovies {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root", "root");
    Statement s = con.createStatement();
    ResultSet listado = s.executeQuery("SELECT ID, Name, Population, CountryCode FROM world.city");
    listado.next();
    City[] cities = new City[5];

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
    cities[2] = City.builder().id(3).name("Mexico").population(109481).countryCode("PHL").build();
    cities[3] = City.builder().id(4).name("Sydney").population(3276207).countryCode("AUS").build();
    cities[4] = City.builder().id(5).name("Carrefour").population(290204).countryCode("HTI").build();





  }

}
