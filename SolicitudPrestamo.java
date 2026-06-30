public class SolicitudPrestamo {
  private String codigoEstudiante;
  private String nombreEstudiante;
  private int codigoLibro;
  private String fechaSolicitud;

  public SolicitudPrestamo(String codigoEstudiante, String nombreEstudiante, int codigoLibro, String fechaSolicitud) {
    this.codigoEstudiante = codigoEstudiante;
    this.nombreEstudiante = nombreEstudiante;
    this.codigoLibro = codigoLibro;
    this.fechaSolicitud = fechaSolicitud;
  }

  public int getCodigoLibro() {
    return codigoLibro;
  }

  @Override
  public String toString(){
    return "Estudiante: " + codigoEstudiante +
            "Nombre: " + nombreEstudiante + 
            "Libro solicitado: " + codigoLibro +
            "Fecha: " + fechaSolicitud;
  }
}
