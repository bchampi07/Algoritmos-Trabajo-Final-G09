public class Libro implements Comparable<Libro> {
  private int codigo;
  private String titulo;
  private String autor;
  private String categoria;
  private int anio;
  private String estado;

  public Libro(int codigo, String titulo, String autor, String categoria, int anio, String estado){
    this.codigo = codigo;
    this.titulo = titulo;
    this.autor = autor;
    this.categoria = categoria;
    this.anio = anio;
    this.estado = estado;
  }

  public int getCodigo(){
    return codigo;
  }
  public String getTitulo(){
    return titulo;
  }
  public String getAutor(){
    return autor;
  }
  public String getCategoria(){
    return categoria;
  }
  public String getEstado(){
    return estado;
  }
  
  public void setTitulo(String titulo){
    this.titulo = titulo;
  }
  public void setAutor(String autor){
    this.autor = autor;
  }
  public void setCategoria(String categoria){
    this.categoria = categoria;
  }

  public void setAnio(int anio){
    this.anio = anio;
  }
  public void setEstado(String estado){
    this.estado = estado;
  }
  public boolean estaDisponible(){
    return estado.equalsIgnoreCase("Disponible");
  }

  @override
  public String toString(){
    return "Codigo: " + codigo +
            " | Título: "+ titulo +
            " Autor: " + autor +
            " Categoría: " + categoria +
            " Año: " + anio + 
            " Estado: " + estado;
  }
  
}
