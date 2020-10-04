package teatrodelmojo;

/**
 * @author Sergio Toscano Díaz 2ºDAM
 */

class Espectador {

  private String nombre;
  private String dni;
  private int edad;
  private float dinero;
  private String asiento = "Aún no tiene uno asignado"; 

  public String getAsiento() {

    return asiento;
  }

  public Espectador(String nombre, String dni, int edad, float dinero) {

    this.nombre = nombre;
    this.dni = dni;
    this.edad = edad;
    this.dinero = dinero;
  }

  public String toString() {

    return "Nombre: " + this.nombre + "\nDNI: " + this.dni + "\nEdad: " + this.edad + "\nDinero: " + this.dinero + "\nAsiento: " + this.asiento;
  }

  /**
   * Función que asigna un asiento al espectador según si tiene dinero y es lo suficientemente mayor para ver la función
   * @param i
   * @param j
   * @param funcion
   * @return 
   */
   
  public boolean asientoEspectador(int i, int j, Obra funcion) {

    String seatNumber = "";

    if (this.edad >= funcion.getEdad() && this.dinero >= funcion.getPrecio()) {

      seatNumber += ((char) (65 + j));
      seatNumber += "" + i;
      this.asiento = seatNumber;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Función que genera la información de un espectador de forma aleatoria
   * 
   * @param i
   * @return 
   */

  public static Espectador espectadorAleatorio(int i) {

    String nombre = "Espectador" + i;
    String dni = "" + i + ((char) (65 + (i / 10000000)));
    int dniTamano = dni.length();
    for (int j = 0; j < (9 - dniTamano); j++) { 
      dni = "0" + dni;
    }
    int edad = (int) (Math.random() * 100);
    float dinero = (float) (Math.random() * 100);
    return new Espectador(nombre, dni, edad, dinero);
  }

}
