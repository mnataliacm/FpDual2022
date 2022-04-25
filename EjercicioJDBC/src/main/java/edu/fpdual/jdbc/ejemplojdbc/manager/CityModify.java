package edu.fpdual.jdbc.ejemplojdbc.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityModify {

  public void editCiudad(Connection con, Integer id, String Name) {
    //prepare SQL statement
    // TODO: 23/04/2022  falla no actualiza
    String sql = "update city set Name = ? where ID = ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setString(1, Name);
      stmt.setInt(2, id);
      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Ciudad modificada correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
}
