import java.util.Scanner;

public class Main {
    static void main() {

        Scanner scanner = new Scanner(System.in);
        GestorPeliculas.cargarCatalogo();

        mainloop : while (true){
            System.out.println("=====================================");
            System.out.println("CATÁLOGO DE PELÍCULAS Y SERIES");
            System.out.println("=====================================");
            System.out.println("1. Añadir película/serie");
            System.out.println("2. Ver catálogo completo");
            System.out.println("3. Buscar por título");
            System.out.println("4. Filtrar por género");
            System.out.println("5. Filtrar por director");
            System.out.println("6. Eliminar película/serie");
            System.out.println("7. Modificar película/serie");
            System.out.println("8. Ver mejor valoradas");
            System.out.println("0. Salir (guarda automáticamente)");
            System.out.print("Opcion: ");

            int op = scanner.nextInt();
            scanner.nextLine();

            String titulo;
            String director;
            int estreno;
            String genero;
            int valoracion;

            switch (op){
                case 1:
                    GestorPeliculas.añadirPelicula();
                    break;
                case 2:
                    GestorPeliculas.verCatalogo();
                    break;
                case 3:
                    System.out.print("Titulo de la pelicula: ");
                    titulo = scanner.nextLine();
                    GestorPeliculas.buscarPorTitulo(titulo);
                    break;
                case 4:
                    System.out.print("Genero a filtrar: ");
                    genero = scanner.nextLine();
                    GestorPeliculas.filtrarPeliculasGenero(genero);
                    break;
                case 5:
                    System.out.print("Director a filtrar: ");
                    director = scanner.nextLine();
                    GestorPeliculas.filtrarPeliculasDirector(director);
                    break;
                case 6:
                    System.out.print("Titulo de pelicula a eliminar: ");
                    titulo = scanner.nextLine();
                    GestorPeliculas.eliminarPelicula(titulo);
                    break;
                case 7:
                    System.out.println("Titulo de pelicula a modificar: ");
                    titulo = scanner.nextLine();
                    GestorPeliculas.modificarPeli(titulo);
                    break;
                case 8:
                    GestorPeliculas.verMejorValoradas();
                    break;
                case 0:
                    System.out.println("Guardando catálogo y saliendo...");
                    GestorPeliculas.guardarCatalogo();
                    break mainloop;
                default:
                    System.out.println("Opcion no valida.");

            }
            System.out.println("\nPresiona Enter para continuar...");
            scanner.nextLine();
        }

    }

}
