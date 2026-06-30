public class BibliotecaService {
  private LinkedBST<Libro> biblioteca;
  public BibliotecaService(){
    biblioteca = new LinkedBST<>();
  }
  public void registrarLibro (Libro libro) throws ItemDuplicated {
    biblioteca.insert(libro);
    System.out.println("Libro registrado correctamente")
  }
  public Libro buscarLibro(int codigo) throws ItemNotFound {
    Libro buscado = new Libro(codigo,"","","",0,"");
    return biblioteca.search(buscado);
  }

  public void buscarPorTitulo(String titulo) {
    String libros = biblioteca.getInOrder();

    if(libros.toLowerCase().contains(titulo.toLowerCase())) {
      System.out.println(libros);
    } else {
      System.out.println("No se encontraron libros con ese título");
    }
  }

  public void buscarPorAutor(String autor) {
    String libros = biblioteca.getInOrder();

    if(libros.toLowerCase().contains(autor.toLowerCase())) {
      System.out.println(libros);
    } else {
      System.out.println("No se encontraron libros con ese autor");
    }
  }

  public void buscarPorCategoria(String categoria) {
    String libros = biblioteca.getInOrder();

    if(libros.toLowerCase().contains(categoria.toLowerCase())) {
      System.out.println(libros);
    } else {
      System.out.println("No se encontraron libros con esa categoria");
    }
  }


  public void mostrarLibros(){
    System.out.println(biblioteca.getInOrder());
  }
  public void eliminarLibro(int codigo) throws ExceptionIsEmpty, ItemNotFound{
    Libro libro = buscarLibro(codigo);
    biblioteca.delete(libro);
    System.out.println("Libro eliminado correctamente");
  }
  public void cambiarEstado(int codigo, String estado) throws ItemNotFound{
    Libro libro = buscarLibro(codigo);
    libro.setEstado(estado);
  }
  public void mostrarDisponibles(){
    mostrarPorEstado("Disponible");
  }
    public void mostrarPrestados(){
    mostrarPorEstado("Prestado");
  }
  public void mostrarPorEstado(String estado){
    String libros = biblioteca.getInOrder();
    if (libros.contains(estado)){
      System.out.println(libros);
    } else{
      System.out.println("No existen libros con ese estado");
    }
  }

  public int contarPorEstado(String estado) {
    String libros = biblioteca.getInOrder();
    int contador = 0;

    String[] partes = libros.split("Codigo:");

    for(int i = 1; i < partes.length; i++) {
      if(partes[i].toLowerCase().contains(estado.toLowerCase())) {
        contador++;
      }
    }
    return contador;
  }
  
  public void reporte(int solicitudesPendientes) {
    int total = biblioteca.countAllNodes();
    int disponibles = contarPorEstado("Disponible");
    int prestados = contarPorEstado("Prestado");

    System.out.println("Reporte General");
    System.out.println("Total libros: " + total);
    System.out.println("Libros disponibles: " + disponibles);
    System.out.println("Libros prestados: " + prestados);
    System.out.println("Solicitudes pendientes: " + solicitudesPendientes);
  }

public void modificarLibro(int codigo, String titulo, String autor, String categoría, int anio, String estado) {
  try {
    Libro libro = buscarLibro(codigo);

    libro.setTitulo(titulo);
    libro.setAutor(autor);
    libro.setCategoria(categoria);
    libro.setAnio(anio);
    libro.setEstado(estado);

    System.out.println("Libro modificado correctamente");

  } catch(ItemNotFound e) {
    System.out.println("Libro no encontrado");
  }
}
  
}

