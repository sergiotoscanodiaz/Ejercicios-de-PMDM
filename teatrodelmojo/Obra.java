package teatrodelmojo;

/**
 * @author Sergio Toscano Díaz 2ºDAM
 */

class Obra {
  
  private String titulo;
  private int duracion;  
  private String compania; 
  private String director;
  private float precio;
  private int edadMinima; 
  
  public Obra (String tit, int dur, String com, String dir, float pre, int edad) {
    
    this.titulo = tit;
    this.duracion = dur;
    this.compania = com;
    this.director = dir;
    this.precio = pre;
    this.edadMinima = edad;
  }
  public int getEdad() {
    
    return this.edadMinima;
  }
  public float getPrecio() {
    
    return this.precio;
  }
  
  public String toString() {
    
    return "Título: " + titulo + "\nDuración: " + duracion + "\nCompañía: " + compania+ "\nDirector: " + 
            director + "\nPrecio: " + precio + "\nEdad mínima: " + edadMinima;
  }
  
}
