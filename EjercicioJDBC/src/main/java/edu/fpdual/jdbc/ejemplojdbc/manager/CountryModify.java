package edu.fpdual.jdbc.ejemplojdbc.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CountryModify {

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
}
