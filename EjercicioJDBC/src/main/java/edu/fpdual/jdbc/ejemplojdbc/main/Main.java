package edu.fpdual.jdbc.ejemplojdbc.main;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.manager.*;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityManagerImpl;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CountryManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Scanner s = new Scanner(System.in);
    int menu = 0;
    String letra;
    Boolean salir = false;
    // Connects to the DB
    try (Connection con = new MySQLConnector().getMySQLConnection()){

      do {
        System.out.println("\n___MENU PRINCIPAL___");
        System.out.println("1) Tabla City \n2) Tabla Country \n3) Tabla CountryLanguage \n4) Salir");
        System.out.print("Elige tabla para trabajar: ");
        switch (s.nextInt()) {
          case 1:
            System.out.println("___Menu Tabla City___");
            System.out.println("1) Todas las ciudades \n2) Buscar ciudad por id \n3) Que el nombre contenga ciertas letras " +
                "\n4) Que empiece por \n5) Que termine por \n6) Añadir ciudad \n7) Modificar ciudad \n8) Borrar ciudad \n9) Salir");
            System.out.print("Elige opción de la lista: ");
            switch (s.nextInt()) {
              case 1:
                System.out.println(new CityManagerImpl().findAll(con));
                break;
              case 2:
                System.out.print("Introduce id a buscar: ");
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
                String tabla = "city";
                new CityManagerImpl().addCiudad(con, id, nombre, pais, ciudad, poblacion);
                break;
              case 7:
                id = 4100;
                nombre = "campa";
                new CityManagerImpl().editCiudad(con, id, nombre);
                break;
              case 8:
                id = 4100;
                new CityManagerImpl().delCiudad(con, id);
                break;
              case 9:
                salir = true;
                break;
              default:
                throw new IllegalStateException("Unexpected value: " + menu);
            }
            break;
          case 2:
            System.out.println("___Menu Tabla Country___");
            System.out.println("1) Todos las paises \n2) Buscar pais por id \n3) Que el nombre contenga ciertas letras " +
                "\n4) Que empiece por \n5) Que termine por \n6) Añadir país \n7) Modificar país \n8) Borrar país \n9) Salir");
            System.out.print("Elige opción de la lista: ");
            switch (s.nextInt()) {
              case 1:
                System.out.println(new CountryManagerImpl().findAll(con));
                break;
              case 2:
                System.out.print("Introduce id a buscar: ");
                String code = s.nextLine();
                System.out.println(new CountryManagerImpl().findByCode(con, code));
                break;
              case 3:
                letra = "%spa%";
                System.out.println(new CountryManagerImpl().findLetterInName(con, letra));
                break;
              case 4:
                letra = "Sp%";
                System.out.println(new CountryManagerImpl().findLetterInName(con, letra));
                break;
              case 5:
                letra = "%in";
                System.out.println(new CountryManagerImpl().findLetterInName(con, letra));
                break;
              case 6:
                code = "NCM";
                String name = "Querty";
                String continente = "Antártida";
                String region = "Polo Sur";
                Double surfaceArea = 186.20;
                Integer indepYear = 1000;
                Integer pop = 1000500;
                Double lifeExpec = 95.2;
                Double gnp = 500.0;
                Double gnpOld = 1000.0;
                String localName = "Querty";
                String govern = null;
                String headOfState = "Liliana";
                Integer capital = 4200;
                String code2 = "QY";
                new CountryManagerImpl().addPais(con, code, name, continente, region, surfaceArea, indepYear, pop, lifeExpec, gnp, gnpOld, localName, govern, headOfState, capital, code2);
                break;
              case 7:
                code = "NCM";
                name = "campa";
                new CountryManagerImpl().editPais(con, code, name);
                break;
              case 8:
                code = "NCM";
                new CountryManagerImpl().delPais(con, code);
                break;
              case 9:
                salir = true;
                break;
              default:
                throw new IllegalStateException("Unexpected value: " + menu);
            }
            break;
          case 3:
            System.out.println("Pendiente");
            break;
          case 4:
            salir = true;
            break;
        }
      } while (!salir);


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
