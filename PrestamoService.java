public class PrestamoService{
  private Queue<SolicitudPrestamo> colaSolicitudes;
  private BibliotecaService biblioteca;
  public PrestamoService(BibliotecaService biblioteca){
    this.biblioteca = biblioteca;
    colaSolicitudes = new Queue<>();
  }
  public void registrarSolicitud(SolicitudPrestamo solicitud){
    colaSolicitudes.enqueue(solicitud);
    System.out.println("Solicitud registrada");
  }
  public void mostrarSolicitudes(){
    colaSolicitudes.mostrar();
  }
  public void siguienteSolicitud(){
    SolicitudPrestamo solicitud = colaSolicitudes.peek();
    if(solicitud == null) {
      System.out.println("No hay solicitudes pendientes");
    } else {
      System.out.println(solicitud);
    }

  }

  public void atenderSolicitud(){
    SolicitudPrestamo solicitud = colaSolicitudes.dequeue();
    if (solicitud==null){
      return;
    } 
    try {
      Libro libro = biblioteca.buscarLibro(solicitud.getCodigoLibro());
      if(libro.estaDisponible()){
        libro.setEstado("Prestado");
        System.out.println("Prestamo realizado correctamente");
        } else {
        System.out.println("El libro no esta disponible");
      }
    } catch(ItemNotFound e){
      System.out.println("Libro no encontrado");
    }
  }
  public void devolverLibro(int codigo){
    try{ 
      Libro libro = biblioteca.buscarLibro(codigo);

      if(libro.estaDisponible()) {
        System.out.println("El libro ya esta disponible");
      } else{
        libro.setEstado("Disponible");
        System.out.println("Devolucion realizada correctamente");
      }

    } catch(ItemNotFound e){
      System.out.println("Libro no encontrado");
    }
  }

  public int solicitudesPendientes(){
    return colaSolicitudes.size();
  }
}
  
