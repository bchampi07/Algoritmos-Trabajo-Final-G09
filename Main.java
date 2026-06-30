import java.util.Scanner;

public class Main {
  public static void main(String [] args) {
      Scanner sc = new Scanner(System.in);

      BibliotecaService biblioteca = new BibliotecaService();
      PrestamoService prestamos = new PrestamoService(biblioteca);
      
      cargarLibrosIniciales(biblioteca);
      
      int opcion;

      do {
        System.out.println("1. Registrar libro");
        System.out.println("2. Mostrar libros");
        System.out.println("3. Buscar libro por codigo");
        System.out.println("4. Buscar libros por titulo");
        System.out.println("5. Buscar libros por autor");
        System.out.println("6. Buscar libros por categoria");
        System.out.println("7. Modificar libro");
        System.out.println("8. Eliminar libro");
        System.out.println("9. Registrar solicitud");
        System.out.println("10. Mostrar solicitudes");
        System.out.println("11. Consultar siguiente solicitud");
        System.out.println("12. Atender solicitud");
        System.out.println("13. Registrar devolucion");
        System.out.println("14. Mostrar reporte");
        System.out.println("15. Salir");

        System.out.print("Seleccione una opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion) {
          case 1: {
            try {

                System.out.print("Codigo: ");
                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.print("Título: ");
                String titulo = sc.nextLine();

                System.out.print("Autor: ");
                String autor = sc.nextLine();

                System.out.print("Categoria: ");
                String categoria = sc.nextLine();

                System.out.print("Anio: ");
                int anio = sc.nextInt();
                sc.nextLine();

                Libro libro = new Libro(codigo,titulo,autor,categoria,anio,"Disponible");

                biblioteca.registrarLibro(libro);
            } catch(Exception e) {
                System.out.println("No se pudo registrar");
            }

            break;
            }

          case 2:{

              biblioteca.mostrarLibros();
              break;
            }
            
          case 3:{
              try {
                System.out.print("Codigo: ");

                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.println(biblioteca.buscarLibro(codigo));
                
              }catch(Exception e) {
                System.out.println("Libro no encontrado");
                
              }

              break;
            }

            case 4: {
              System.out.print("Titulo: ");
              String titulo = sc.nextLine();
              biblioteca.buscarPorTitulo(titulo);
              break;
            }
            
            case 5: {
              System.out.print("Autor: ");
              String autor = sc.nextLine();
              biblioteca.buscarPorAutor(autor);
              break;
            }
            
            case 6: {
              System.out.print("Categoria: ");
              String categoria = sc.nextLine();
              biblioteca.buscarPorCategoria(categoria);
              break;
            }

            case 7: {
              System.out.print("Codigo del libro: ");
              int codigo = sc.nextInt();
              sc.nextLine();
              
              System.out.print("Nuevo titulo: ");
              String titulo = sc.nextLine();
              
              System.out.print("Nuevo autor: ");
              String autor = sc.nextLine();
              
              System.out.print("Nueva categoria: ");
              String categoriaNueva = sc.nextLine();
              
              System.out.print("Nuevo anio: ");
              int anio = sc.nextInt();
              sc.nextLine();
              
              System.out.print("Estado: ");
              String estado = sc.nextLine();
              
              biblioteca.modificarLibro(codigo, titulo, autor, categoriaNueva, anio, estado);
              break;
            }
          
          case 8: {
            try {
              System.out.print("Codigo del libro: ");
              int codigo = sc.nextInt();
              sc.nextLine();
              
              biblioteca.eliminarLibro(codigo);
            } catch(Exception e) {
              System.out.println("No se pudo eliminar");
            }
            break;
          }
          
          case 9: {
            System.out.print("Codigo estudiante: ");
            String codigoEstudiante = sc.nextLine();
            
            System.out.print("Nombre estudiante: ");
            String nombre = sc.nextLine();
            
            System.out.print("Codigo libro: ");
            int codigoLibroSolicitud = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Fecha: ");
            String fecha = sc.nextLine();
            
            SolicitudPrestamo solicitud =
              new SolicitudPrestamo(codigoEstudiante, nombre, codigoLibroSolicitud, fecha);
            
            prestamos.registrarSolicitud(solicitud);
            break;
          }
          
          case 10: {
            prestamos.mostrarSolicitudes();
            break;
          }
          
          case 11: {
            prestamos.siguienteSolicitud();
            break;
          }
          
          case 12: {
            prestamos.atenderSolicitud();
            break;
          }
          
          case 13: {
            System.out.print("Codigo del libro: ");
            int codigoLibro = sc.nextInt();
            sc.nextLine();
            
            prestamos.devolverLibro(codigoLibro);
            break;
          
          }
          
          case 14: {
            biblioteca.reporte(prestamos.solicitudesPendientes());
            break;
          }
          
          case 15: {
            System.out.println("Hasta luego.");
            break;
          }

          default:
            System.out.println("Opcion invalida.");
        }
            
      } while(opcion != 15);

      sc.close();
  }
  public static void cargarLibroIniciales(BibliotecaService biblioteca){
    try{
       biblioteca.registrarLibro(new Libro(101, "Programacion en Java", "Herbert Schildt", "Programacion", 2022, "Disponible"));
       biblioteca.registrarLibro(new Libro(102, "Estructura de Datos", "Mark Allen Weiss", "Computacion", 2021, "Disponible"));
       biblioteca.registrarLibro(new Libro(103, "Introduccion a Algoritmos", "Thomas Cormen", "Algoritmos", 2022, "Prestado"));
       biblioteca.registrarLibro(new Libro(104, "Java Como Programar", "Deitel", "Programacion", 2020, "Disponible"));
       biblioteca.registrarLibro(new Libro(105, "Clean Code", "Robert Martin", "Programacion", 2008, "Disponible"));
       biblioteca.registrarLibro(new Libro(106, "Sistemas Operativos", "Silberschatz", "Computacion", 2019, "Disponible"));
       biblioteca.registrarLibro(new Libro(107, "Redes de computadoras", "Tanenbaum", "Redes", 2021, "Prestado"));
       biblioteca.registrarLibro(new Libro(108, "Bases de Datos", "Elmasri", "Base de Datos", 2020, "Disponible"));
       biblioteca.registrarLibro(new Libro(109, "Ingenieria de Software", "Sommerville", "Software", 2018, "Disponible"));
       biblioteca.registrarLibro(new Libro(110, "Patrones de Diseno", "Gamma", "Software", 1994, "Disponible"));

       biblioteca.registrarLibro(new Libro(111, "Python Crash Course", "Eric Matthes", "Programacion", 2023, "Disponible"));
       biblioteca.registrarLibro(new Libro(112, "Inteligencia Artificial", "Stuart Russell", "IA", 2021, "Prestado"));
       biblioteca.registrarLibro(new Libro(113, "Machine Learning", "Tom Mitchell", "IA", 1997, "Disponible"));
       biblioteca.registrarLibro(new Libro(114, "Mineria de Datos", "Jiawei Han", "Datos", 2012, "Disponible"));
       biblioteca.registrarLibro(new Libro(115, "Analisis y Diseno de Sistema", "Kendall", "Sistemas", 2019, "Disponible"));
       biblioteca.registrarLibro(new Libro(116, "Arquitectura de Computadoras", "Patterson", "Computacion", 2020, "Disponible"));
       biblioteca.registrarLibro(new Libro(117, "Compiladores", "Aho", "Computacion", 2007, "Prestado"));
       biblioteca.registrarLibro(new Libro(118, "Calculo I", "James Stewart", "Matematica", 2018, "Disponible"));
       biblioteca.registrarLibro(new Libro(119, "Algebra Lineal", "Gilbert Strang", "Matematica", 2016, "Disponible"));
       biblioteca.registrarLibro(new Libro(120, "Estadistica", "Walpole", "Matematica", 2015, "Disponible"));

       biblioteca.registrarLibro(new Libro(121, "Cisco CCNA", "Wendell Odom", "Redes", 2020, "Disponible"));
       biblioteca.registrarLibro(new Libro(122, "Seguridad Informatica", "Willian Stallings", "Seguridad", 2017, "Prestado"));
       biblioteca.registrarLibro(new Libro(123, "Criptografia", "Bruce Schneier", "Seguridad", 2015, "Disponible"));
       biblioteca.registrarLibro(new Libro(124, "Cloud Computing", "Rajkumar Buyya", "Cloud", 2013, "Disponible"));
       biblioteca.registrarLibro(new Libro(125, "Internet de las Cosas", "Samuel Greengard", "IoT", 2021, "Disponible"));
       biblioteca.registrarLibro(new Libro(126, "Desarrollo Web", "Jon Duckett", "Programacion", 2014, "Disponible"));
       biblioteca.registrarLibro(new Libro(127, "HTML y XP", "Jon Duckett", "Programacion", 2011, "Disponible"));
       biblioteca.registrarLibro(new Libro(128, "JavaScript Moderno", "Kyle Simpson", "Programacion", 2020, "Prestado"));
       biblioteca.registrarLibro(new Libro(129, "Scrum y XP", "Henrik Kniberg", "Software", 2015, "Disponible"));
       biblioteca.registrarLibro(new Libro(130, "UML Gota a Gota", "Marting Fowler", "Software", 2004, "Disponible"));
      }
  }
}
