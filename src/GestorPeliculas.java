import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPeliculas {
    static List<Pelicula> catalogo = new ArrayList<>();
    private static final String ARCHIVO = "datos/peliculas.csv";

    public static void buscarPorTitulo(String tituloBuscado) {
        boolean encontrado = false;
        for (Pelicula p : catalogo) {
            if (p.getTitulo().toLowerCase().contains(tituloBuscado.toLowerCase())) {
                System.out.println("----------------------------------");
                System.out.println("Título: " + p.getTitulo());
                System.out.println("Director: " + p.getDirector());
                System.out.println("Año: " + p.getEstreno());
                System.out.println("Género: " + p.getGenero());
                System.out.println("Valoración: " + p.getValoracion() + "/5");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron películas con ese título.");
        }
    }

    public static boolean añadirPelicula(Pelicula pelicula) {
        return catalogo.add(pelicula);
    }

    public static void modificarPeli(String tituloBuscado) {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;

        for (Pelicula p : catalogo) {
            if (p.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                encontrado = true;
                System.out.println("¿Qué quieres editar?");
                System.out.println("1. Título");
                System.out.println("2. Director");
                System.out.println("3. Género");
                System.out.println("4. Año de estreno");
                System.out.println("5. Valoración");
                System.out.print("Elige una opción: ");

                int eleccion = sc.nextInt();
                sc.nextLine();

                switch (eleccion) {
                    case 1:
                        System.out.print("Nuevo título: ");
                        p.setTitulo(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nuevo director: ");
                        p.setDirector(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nuevo género: ");
                        p.setGenero(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nuevo año de estreno: ");
                        p.setEstreno(sc.nextInt());
                        break;
                    case 5:
                        System.out.print("Nueva valoración (1-5): ");
                        p.setValoracion(sc.nextInt());
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                System.out.println("Película modificada correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ninguna película con ese título.");
        }
    }

    public static void verCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("Catálogo de películas:");
            for (Pelicula p : catalogo) {
                System.out.println("----------------------------------");
                System.out.println("Título: " + p.getTitulo());
                System.out.println("Director: " + p.getDirector());
                System.out.println("Año: " + p.getEstreno());
                System.out.println("Género: " + p.getGenero());
                System.out.println("Valoración: " + p.getValoracion() + "/5");
            }
        }
    }

    public static void verMejorValoradas() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        catalogo.sort((a, b) -> Integer.compare(b.getValoracion(), a.getValoracion()));

        System.out.println("Películas mejor valoradas:");
        for (Pelicula p : catalogo) {
            System.out.println("Título: " + p.getTitulo() + " | Valoración: " + p.getValoracion() + "/5");
        }
    }

    public static void filtrarPeliculasGenero(String generoBuscado) {
        boolean encontrado = false;
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getGenero().toLowerCase().contains(generoBuscado.toLowerCase())) {
                System.out.println(pelicula);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron películas del género especificado.");
        }
    }

    public static boolean eliminarPelicula(String titulo) {
        boolean eliminado = catalogo.removeIf(
                p -> p.getTitulo().equalsIgnoreCase(titulo)
        );
        if (eliminado)
            System.out.println("Película eliminada correctamente.");
        else
            System.out.println("No se encontró ninguna película con ese título.");
        return eliminado;
    }

    public static void guardarCatalogo() {
        List<String> lineas = new ArrayList<>();
        for (Pelicula p : catalogo) {
            String linea = String.join(";",
                    p.getTitulo(),
                    p.getDirector(),
                    String.valueOf(p.getEstreno()),
                    p.getGenero(),
                    String.valueOf(p.getValoracion())
            );
            lineas.add(linea);
        }

        try {
            Path ruta = Paths.get(ARCHIVO);
            Files.createDirectories(ruta.getParent());
            Files.write(ruta, lineas);
            System.out.println("Catálogo guardado correctamente en " + ARCHIVO + ".");
        } catch (IOException e) {
            System.out.println("Error al guardar el catálogo: " + e.getMessage());
        }
    }

    public static void cargarCatalogo() {
        Path ruta = Paths.get(ARCHIVO);
        if (!Files.exists(ruta)) {
            System.out.println("No se encontró el archivo de datos. Se creará uno nuevo.");
            return;
        }

        try {
            List<String> lineas = Files.readAllLines(ruta);
            catalogo.clear();

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(";");
                if (datos.length == 5) {
                    String titulo = datos[0];
                    String director = datos[1];
                    int estreno = Integer.parseInt(datos[2]);
                    String genero = datos[3];
                    int valoracion = Integer.parseInt(datos[4]);
                    catalogo.add(new Pelicula(titulo, director, estreno, genero, valoracion));
                }
            }
            System.out.println("Catálogo cargado correctamente (" + catalogo.size() + " películas).");
        } catch (IOException e) {
            System.out.println("Error al cargar el catálogo: " + e.getMessage());
        }
    }
}
