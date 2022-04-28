package edu.fpdual.todo;

import java.util.Date;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import edu.fpdual.todo.connect.Connector;
import edu.fpdual.todo.dao.Actor;
import edu.fpdual.todo.manager.ActorManager;
import edu.fpdual.todo.manager.implement.ActorManagerImpl;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Main {

  public static void main(String[] args) {
    Date objDate = new Date();
    String fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(objDate);
    Connector connector = new Connector();

    try(Connection con = new Connector().getConnection()) {
      System.out.println("\nConectado a BBDD: " + con.getCatalog());
      System.out.println("Fecha y hora: " + fecha);
      System.out.println("Otra fecha: " + objDate);
      System.out.println("Numero total de actores: " + ActorManagerImpl.todos(con).size());
      System.out.println("Lista de actores");
      System.out.println(new ActorManagerImpl().todos(con));
      System.out.println("Insertar un actor");
      new ActorManagerImpl().insertarActor(con, "Paco", "Leon");

      System.out.println(new ActorManagerImpl().todos(con));
      //System.out.println(new ActorManagerImpl().buscarID(con, 250));

      //System.out.println("Modificar un actor");
      //new ActorManagerImpl().cambiarActor(con, 250, "Maria", "Leon");

      System.out.println("Borrar un actor");
      new ActorManagerImpl().borrarActor(con, 250);

      System.out.println(new ActorManagerImpl().todos(con));

    } catch (SQLException e) {

    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }


  }
}
