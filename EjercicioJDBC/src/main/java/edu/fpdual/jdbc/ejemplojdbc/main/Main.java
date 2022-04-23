package edu.fpdual.jdbc.ejemplojdbc.main;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner s = new Scanner(System.in);
        int menu;
        String letra;
        // Connects to the DB
        try (Connection con = new MySQLConnector().getMySQLConnection()){
            do {
                System.out.println("\n___MENU___");
                System.out.println("1) Todas las ciudades \n2) Buscar ciudad por id \n3) Que el nombre contenga ciertas letras " +
                    "\n4) Que empiece por \n5) Que termine por \n6) Añadir \n7) Modificar \n8) Borrar \n9) Salir");
                System.out.print("Elije opción de la lista: ");
                menu = s.nextInt();
                switch (menu) {
                    case 1:
                        System.out.println(new CityManagerImpl().findAll(con));
                        break;
                    case 2:
                        System.out.println("Introduce id a buscar:");
                        int id = s.nextInt();
                        System.out.println(new CityManagerImpl().findById(con, id));
                        break;
                    case 3:
                        letra = "%adri%";
                        System.out.println(new CityManagerImpl().findLetterInName(con, letra));
                        break;
                    case 4:
                        letra = "Grana%";
                        System.out.println(new CityManagerImpl().findLetterInName(con, letra));
                        break;
                    case 5:
                        letra = "%laga";
                        System.out.println(new CityManagerImpl().findLetterInName(con, letra));
                        break;
                    case 6:
                        id = 4100;
                        String nombre = "Campanillas";
                        String pais = "ESP";
                        String ciudad = "Málaga";
                        int poblacion = 18620;
                        new CityManagerImpl().addCiudad(con, id, nombre, pais, ciudad, poblacion);
                        break;
                    case 7:
                        System.out.println(new CityManagerImpl().findById(con, 15));
                        break;
                    case 8:
                        System.out.println(new CityManagerImpl().findById(con, 20));
                        break;
                    case 9:

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + menu);
                }
            } while (menu != 9);


/*
//			List<Country> countries = new CountryManager().findBySurfaceAreaBetween(con, BigDecimal.valueOf(100),
//					BigDecimal.valueOf(1000));
//			System.out.println(countries.size());
//			countries.forEach(country -> System.out.println(country));
//			new GeneralManager().findLanguajeDataWithPercentageGreaterThan(con, 0)
//					.forEach(data -> System.out.printf(
//							"Datos de la ciudad %s: lenguaje -> %s - Porcentaje de habla: %f - Pais: (%s) %s ",
//							data.getCityName(), data.getCityLanguage(), data.getLanguagePercentage(),
//							data.getCountryCode(), data.getCountryName() + "\n"));*/
        }
    }

}
