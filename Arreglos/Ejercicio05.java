package edu.fpdual.Ejercicios.Arreglos;

public class Ejercicio05 {
  public static void main(String[] args) {

    String[] varios = {"maria", "campanillas123", "tengo45", "antonio", "garbanzos33"};

    for (int i = 0; i < varios.length; i++) {
      System.out.println(varios[i] + "  ¿Contiene números?  " + buscaNumeros(varios[i]));
      if (buscaNumeros(varios[i]).equals("")) {
        System.out.println("No");
      } else {
        buscaNumeros(varios[i]);
      }
    }
  }

  public static StringBuilder buscaNumeros(String v) {

      char[] ch = v.toCharArray();
      StringBuilder str = new StringBuilder();
      for (char c : ch) {
        if(Character.isDigit(c)) {
          str.append(c);
        }
      }
      if (str.isEmpty()) {
        return new StringBuilder("No.");
      } else {
        return new StringBuilder("Si, " + str + ".");
      }

  }
}
