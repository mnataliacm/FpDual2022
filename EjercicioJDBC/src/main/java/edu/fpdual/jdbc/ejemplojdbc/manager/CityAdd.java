package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.manager.CityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityAdd {

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

}
