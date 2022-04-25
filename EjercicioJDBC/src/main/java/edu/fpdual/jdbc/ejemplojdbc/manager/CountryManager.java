package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Country DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Countries data.
 *
 * @author jose.m.prieto.villar
 * @author natalia castillo muñoz
 */
public interface CountryManager {

  /**
   * Finds all the countries in the DB based on a list of ids.
   *
   * @param con DB connection
   * @param ids Countries id set to search for.
   * @return a {@link List} of {@link Country}
   */
  public List<Country> findAllById(Connection con, Set<String> ids);

  /**
   * Find an al countries between a surface area from the DB
   *
   * @param con DB connection
   * @param startSurfaceArea the range start surface area
   * @param endSurfaceArea the range end surface area
   * @return a {@link List} of {@link Country}
   * @throws {@link SQLException}
   */
  public List<Country> findBySurfaceAreaBetween(Connection con, BigDecimal startSurfaceArea,
                                                BigDecimal endSurfaceArea) throws SQLException;

  /**
   * Finds all the countries in the DB
   *
   * @param con DB connection
   * @return a {@link List} of {@link City}
   */
  List<Country> findAll(Connection con);

  /**
   * Find an specific countries from the DB
   *
   * @param con DB connection
   * @param id the city id
   * @return a {@link List} of {@link City}
   */
  Country findByCode(Connection con, String code); //¿no devuelve una lista se debe cambiar el return?

  /**
   * Busca paises que contengan ciertas letras
   *
   * @param con DB connection
   * @param letras String que debe tener el nombre
   * @return a {@link List} of {@link City}
   */
  Set<Country> findLetterInName(Connection con, String letras);


  /**
   * Añadir una ciudad nueva
   *
   */
  void addPais(Connection con, String code, String name, String continente, String region, Double surfaceArea, Integer indepYear, int pop, Double lifeExp, Double gnp, Double gnpOld, String localName, String govern, String head, Integer capital, String code2);

  /**
   * Modificar nombre de una ciudad
   * @param con
   * @param code
   * @param Name
   */
  void editPais(Connection con, String code, String Name);

  /**
   * Borrar ciudad
   * @param con
   * @param code
   */
  void delPais(Connection con, String code);
}