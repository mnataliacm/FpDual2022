package edu.fpdual.jdbc.ejemplojdbc.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityRemove {

  public void delCiudad(Connection con, Integer id) {
    //prepare SQL statement
    String sql = "delete from city where ID = ?;";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setInt(1, id);

      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Ciudad borrada correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
}
