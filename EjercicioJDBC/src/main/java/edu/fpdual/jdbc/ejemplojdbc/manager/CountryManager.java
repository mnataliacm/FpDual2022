package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.dao.Country;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Countries data.
 *
 * @author jose.m.prieto.villar
 *
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

}