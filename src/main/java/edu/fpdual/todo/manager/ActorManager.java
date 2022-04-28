package edu.fpdual.todo.manager;

import edu.fpdual.todo.dao.Actor;

import java.sql.Connection;
import java.util.List;

public interface ActorManager {

  /**
   * Buscar todos los actores
   *
   *  * @param con conexión a BD
   * @return a {@link List} of {@link Actor}
   */
  List<Actor> todos(Connection con);

  /**
   * Busca por nombre
   *
   * @param con conexión a BD
   * @param id del actor
   * @return a {@link List} of {@link Actor}
   */
  Actor buscaNombre(Connection con, int id);

  /**
   * Añade un actor
   *
   * @param con conexión a BD
   * @param id del actor
   * @param nom nombre del actor
   * @param ape apellido del actor
   */
  void insertarActor(Connection con, int id, String nom, String ape);

  /**
   * Modificar un actor existente
   *
   * @param con conexión a BD
   * @param id del actor
   * @param nom nombre del actor
   * @param ape apellido del actor
   */
  void cambiarActor(Connection con, int id, String nom, String ape);

  /**
   * Borrar Actor
   *
   * @param con conexión a BD
   * @param id del actor
   */
  void borrarActor(Connection con, int id);

}
