package edu.fpdual.jdbc.ejemplojdbc.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CountryRemove {

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
