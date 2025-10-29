import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
    static List<Pelicula> catalogo = new ArrayList<>();
    private static final String ARCHIVO = "datos/peliculas.csv";


    public static boolean añadirPelicula(Pelicula pelicula){
        return catalogo.add(pelicula);
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
                System.out.println("Año de estreno: " + p.getEstreno());
                System.out.println("Género: " + p.getGenero());
                System.out.println("Valoración: " + p.getValoracion() + "/5");
            }
            System.out.println("----------------------------------");
        }
    }

    public static void verMejorValoradas(){
        catalogo.sort((a, b) -> Integer.compare(b.Valoracion, a.Valoracion));

        catalogo.forEach(p -> System.out.println("Titulo: " + p.Titulo + " Valoración: " + p.Valoracion));
    }

    public static void filtrarPeliculasGenero(String g){
        for (Pelicula pelito : catalogo) {
            if (pelito.getGenero().toLowerCase().contains(g.toLowerCase())) {
                System.out.println(pelito);
            }
        }
    }

    public static void filtrarPeliculasDirector(String d){
        for (Pelicula pelito : catalogo) {
            if (pelito.getDirector().toLowerCase().contains(d.toLowerCase())) {
                System.out.println(pelito);
            }
        }
    }



}
