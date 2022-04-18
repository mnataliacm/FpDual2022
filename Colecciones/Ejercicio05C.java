package edu.fpdual.Ejercicios.Colecciones;

import java.util.ArrayList;

public class Ejercicio05C {
  public static void main(String[] args) {

    ArrayList<String> varios = new ArrayList<>();
    varios.add(new String("maria"));
    varios.add(new String("campanillas123"));
    varios.add(new String("tengo45"));
    varios.add(new String("antonio"));
    varios.add(new String("garbanzos33"));

    for (int i = 0; i < varios.size(); i++) {
      String x = varios.get(i);
      System.out.println(varios.get(i) + "  ¿Contiene números? " + buscaNumeros(x));
    }
  }

  public static StringBuilder buscaNumeros(String v) {
    boolean esta = false;
    for (int i = 0; i < v.length(); i++) {
      char[] ch = v.toCharArray();
      StringBuilder str = new StringBuilder();
      for (char c : ch) {
        if(Character.isDigit(c)) {
          str.append(c);
        } else {
        }
      }
      return str;
    }
    return null;
  }
}
