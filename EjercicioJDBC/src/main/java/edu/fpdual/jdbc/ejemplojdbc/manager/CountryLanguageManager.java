package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.dao.CountryLanguage;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

/**
 * CountryLanguage DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Countries language data.
 *
 * @author natalia castillo muñoz
 */
public interface CountryLanguageManager {

  /**
   * Finds all the language in the DB based on a list of ids.
   *
   * @param con DB connection
   * @param ids Countries id set to search for.
   * @return a {@link List} of {@link Country}
   */
  public List<CountryLanguage> findAllById(Connection con, Set<String> ids);


}
