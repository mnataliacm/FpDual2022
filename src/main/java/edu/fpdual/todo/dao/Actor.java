package edu.fpdual.todo.dao;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Actor {

  int id;
  String firstName;
  String lastName;

  public Actor(ResultSet result) {
    try {
      this.id = result.getInt("actor_id");
      this.firstName = result.getString("first_name");
      this.lastName = result.getString("last_name");
    }catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
