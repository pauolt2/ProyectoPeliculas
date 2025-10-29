import java.util.ArrayList;
import java.util.List;

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





}
