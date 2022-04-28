package edu.fpdual.todo.manager.implement;

import edu.fpdual.todo.dao.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class ActorManagerImpl {

  private final int id = 250;
  public static List<Actor> todos(Connection con) {
    try (Statement stmt = con.createStatement()){
      ResultSet result = stmt.executeQuery("SELECT * FROM Actor");
      result.beforeFirst();
      List<Actor> actores = new ArrayList<>();
      while (result.next()) {
        actores.add(new Actor(result));
      }
      return actores;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  public void insertarActor(Connection con, String nom, String ape) {
    //int id = todos(con).size() + 1;
    //int id = 250;
    //Convierte fecha a Timestamp para insertar en SQL
    java.util.Date fechaHora = new java.sql.Date (System.currentTimeMillis());
    Timestamp timestamp = new Timestamp(fechaHora.getTime());
    //prepare SQL statement
    String sql = "INSERT INTO actor VALUES (?, ?, ?, ?);";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setInt(1, id);
      stmt.setString(2, nom);
      stmt.setString(3, ape);
      stmt.setDate(4, (java.sql.Date) fechaHora);

      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Nuevo actor insertado correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
  public void cambiarActor(Connection con, int id, String nom, String ape) {
    //prepare SQL statement
    String sql = "UPDATE actor SET first_name LIKE 'Maria' WHERE actor_id = 250;";
    // TODO: 4/28/2022 error en query
    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      /*stmt.setInt(1, id);
      stmt.setString(2, nom);
      stmt.setString(3, ape);
      stmt.setInt(4, id);*/
      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Actor modificado correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public void borrarActor(Connection con, int id) {
    //prepare SQL statement
    String sql = "DELETE FROM Actor WHERE actor_id = ?";

    // Create general statement
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      //Add Parameters
      stmt.setInt(1, id);

      // Queries the DB
      stmt.executeUpdate();
      System.out.println("Actor borrado correctamente");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public Actor buscarID(Connection con, int id) {
    String sql = "SELECT * FROM actor WHERE actor_id = ?";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      stmt.setInt(1, id);
      //stmt.executeQuery();
      ResultSet result = stmt.executeQuery(sql);
      Actor actor = (Actor) result;
      return actor;
    } catch (SQLException e) {
      throw new RuntimeException(e);

    }
  }

}
