package edu.fpdual.todo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import edu.fpdual.todo.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Connector connector = new Connector();
    ResultSetMetaData metaDatos = null;
    try (Connection connection = connector.getMySQLConnection()) {
      Statement stm = connection.createStatement();
      int columnas = metaDatos.getColumnCount();
      String [] nombreColumnas = new String[columnas];

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
