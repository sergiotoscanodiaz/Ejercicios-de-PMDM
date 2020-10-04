package teatrodelmojo;

// @author Sergio Toscano Díaz 2ºDAM
import java.util.ArrayList;
import java.util.Scanner;

public class TeatroDelMojo {

  public static void main(String[] args) {

    System.out.println("Teatro del Mojo, ¡Bienvenido!");
     System.out.println("---------------------------------------------------");

    Scanner s = new Scanner(System.in);
    ArrayList<Espectador> espectadores = new ArrayList<Espectador>();
    Espectador[][] asientos = new Espectador[10][9];
    System.out.println("Rellena la información sobre la obra que desea ver.");
    Obra funcion = obraInfo();
    System.out.println("Número de espectadores: ");
    int numeroEspectadores = Integer.parseInt(s.nextLine());
    //Espectadores aleatorios a generar
    for (int i = 0; i < numeroEspectadores; i++) {

      System.out.println("Espere mientras se genera los espectadores: " + i);
      espectadores.add(Espectador.espectadorAleatorio(i));
    }
    asignaAsiento(asientos, espectadores, funcion);
    muestraAsientos(asientos);

    String peticionUsuario = "";
    do {
      System.out.println("Teclea el asiento del espectador que quieras identificar.");
      System.out.println("Teclea muestra para ver los espectadores que se encuentran en la sala, teclea funcion para ver información de la obra, teclea salir para irse.");
      peticionUsuario = s.nextLine();
      if (peticionUsuario.equalsIgnoreCase("muestra")) {
        muestraAsientos(asientos);
      } else if (peticionUsuario.equalsIgnoreCase("salir")) {
        System.out.println("Ha sido un placer. ¡Nos vemos!");
      } else if (peticionUsuario.equalsIgnoreCase("funcion")) {
        System.out.println(funcion);
      } else {

        peticionUsuario = peticionUsuario.toUpperCase();
        // Convierte las letras de los asientos en posiciones en el array
        int i = peticionUsuario.charAt(0) - 65;
        int j = Character.getNumericValue(peticionUsuario.charAt(1));
        System.out.println("\n" + asientos[j][i]);
      }
    } while (!peticionUsuario.equalsIgnoreCase("salir"));
    s.close();

  }

  /**
   * Función que asigna a los espectadores en un asiento según la información de
   * la función
   *
   * @param asientos
   * @param espectadores
   * @param funcion
   */
  public static void asignaAsiento(Espectador[][] asientos, ArrayList<Espectador> espectadores, Obra funcion) {

    int numeroAsignado = 0;
    for (int s = 0; s < espectadores.size() && numeroAsignado < 90;) {

      //Randomize position
      int i = (int) (Math.random() * 10);
      int j = (int) (Math.random() * 9);
      if (asientos[i][j] == null) {

        if (espectadores.get(s).asientoEspectador(i, j, funcion)) {

          asientos[i][j] = espectadores.get(s);
          numeroAsignado++;
        }
        s++;
      }
    }
  }

  /**
   * Función de la información de la obra o función.
   */
  public static Obra obraInfo() {

    Scanner s = new Scanner(System.in);
    System.out.print("Título: ");
    String titulo = s.nextLine();
    System.out.print("Duración: ");
    int duracion = Integer.parseInt(s.nextLine());
    System.out.print("Compañía: ");
    String compania = s.nextLine();
    System.out.print("Director: ");
    String director = s.nextLine();
    System.out.print("Precio de la entrada: ");
    float precioEntrada = Float.parseFloat(s.nextLine());
    System.out.print("Edad mínima: ");
    int edadMinima = Integer.parseInt(s.nextLine());
    System.out.println();
    return new Obra(titulo, duracion, compania, director, precioEntrada, edadMinima);
  }

  /**
   * Función que muestra como las personas están sentadas en sus asientos
   *
   * @param asientos
   */
  public static void muestraAsientos(Espectador[][] asientos) {

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 10; j++) {
        if (asientos[j][i] != null) {
          System.out.print("   " + asientos[j][i].getAsiento());
        } else {
          System.out.print("  X0");
        }
      }
      System.out.println();
    }

  }
}
