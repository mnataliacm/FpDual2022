package edu.fpdual.jdbc.ejemplojdbc.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CountryAdd {
//code, name, continente, region, surfaceArea, indepYear, population, lifeExpec, gnp, localName, govern, headOfState, capital, code2 14
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
}
