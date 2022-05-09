package edu.fpdual.fx.login;

import java.sql.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JdbcDao {

  private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
  private static final String DATABASE_USERNAME = "root";
  private static final String DATABASE_PASSWORD = "root";
  private static final String SELECT_QUERY = "SELECT * FROM actor WHERE first_name = ? and last_name = ?";

  public boolean validate(String fName, String sName) throws SQLException {

    // Step 1: Establishing a Connection and
    // try-with-resource statement will auto close the connection.
    try (Connection connection = DriverManager
        .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

         // Step 2:Create a statement using connection object
         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
      preparedStatement.setString(1, fName);
      preparedStatement.setString(2, sName);

      System.out.println(preparedStatement);

      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        return true;
      }


    } catch (SQLException e) {
      // print SQL exception information
      printSQLException(e);
    }
    return false;
  }

  public static void printSQLException(SQLException ex) {
    for (Throwable e: ex) {
      if (e instanceof SQLException) {
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + ((SQLException) e).getSQLState());
        System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
        System.err.println("Message: " + e.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
          System.out.println("Cause: " + t);
          t = t.getCause();
        }
      }
    }
  }

}
