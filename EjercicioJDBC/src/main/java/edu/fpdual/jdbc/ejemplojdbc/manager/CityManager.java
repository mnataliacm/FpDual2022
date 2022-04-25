package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Cities data.
 *
 * @author jose.m.prieto.villar
 *
 */
public interface CityManager {

  /**
   * Finds all the cities in the DB
   *
   * @param con DB connection
   * @return a {@link List} of {@link City}
   */
  List<City> findAll(Connection con);

  /**
   * Find an specific cities from the DB
   *
   * @param con DB connection
   * @param id the city id
   * @return a {@link List} of {@link City}
   */
  City findById(Connection con, int id); //¿no devuelve una lista se debe cambiar el return?

  /**
   * Busca ciudades que contengan ciertas letras
   *
   * @param con DB connection
   * @param letras String que debe tener el nombre
   * @return a {@link List} of {@link City}
   */
  Set<City> findLetterInName(Connection con, String letras);

  /**
   * Añadir una ciudad nueva
   * @param con
   * @param id
   * @param Name
   * @param CountryCode
   * @param District
   * @param Population
   */
  void addCiudad(Connection con, int id, String Name, String CountryCode, String District, int Population);

  /**
   * Modificar nombre de una ciudad
   * @param con
   * @param id
   * @param Name
   */
  void editCiudad(Connection con, int id, String Name);

  /**
   * Borrar ciudad
   * @param con
   * @param id
   */
  void delCiudad(Connection con, int id);
}