import java.util.Scanner;

public class Main {
  public static void main(String [] args) {
      Scanner sc = new Scanner(System.in);

      BibliotecaService biblioteca = new BibliotecaService();
      PrestamoService prestamos = new PrestamoService(biblioteca);

      int opcion;

      do {
        System.out.println("\n==== QUICKLIBRARY ====");
        System.out.println("1. Registrar libro");
        System.out.println("2. Mostrar libros");
        System.out.println("3. Buscar libro por codigo");
        System.out.println("4. Buscar libros por categoria");
        System.out.println("5. Modificar libro");
        System.out.println("6. Eliminar libro");
        System.out.println("7. Registrar solicitud");
        System.out.println("8. Mostrar solicitudes");
        System.out.println("9. Atender solicitud");
        System.out.println("10. Registrar devolucion");
        System.out.println("11. Mostrar reporte");
        System.out.println("12. Salir");

        System.out.print("Seleccione una opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion) {
          case 1:
            try {

                System.out.print("Codigo: );
                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.print("Título: ");
                String titulo = sc.nextLine();

                System.out.print("Autor: ");
                String autor = sc.nextLine();

                System.out.print("Categoria: ");
                String categoria = sc.nextLine();

                System.out.print("Anio: ");
                String anio = sc.nextLine();
                sc.nextLine();

                Libro libro = new Libro(codigo,titulo,autor,categoria,anio,"Disponible");

                biblioteca.registrarLibro(libro);
            } catch(Exception e) {
                System.out.println("No se pudo registrar");
            }

            break;

          case 2:

              biblioteca.mostrarLibros();
              break;
          case 3:
              try {
                System.out.print("Codigo: ");

                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.println(biblioteca.buscarLibro(codigo));
                
              }catch(Exception e) {
                System.out.println("Libro no encontrado");
                
              }

              break;
            case 4:
              System.out.print("Categoria: ");
              String categoria = sc.nextLine();

              biblioteca.buscarPorCategoria(categoria);
              break;
            case 5:
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

              biblioteca.modificarLibro(codigo,titulo,autor,categoriaNueva,anio,estado);
              break;
            case 6:
              try {
                System.out.print("Codigo del libro");

                int codigo = sc.nextInt();
                sc.nextLine();
                
                biblioteca.eliminarLibro(codigo);
                
              }catch(Exceptin e ){
                System.out.println("No se pudo eliminar");
              }
              break;
        }

        
      }
      
  }
}
