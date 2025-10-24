import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
    static List<Pelicula> catalogo = new ArrayList<>();
    private static final String ARCHIVO = "datos/peliculas.csv";

    public static void verMejorValoradas(){
        catalogo.sort((a, b) -> Integer.compare(b.Valoracion, a.Valoracion));

        catalogo.forEach(p -> System.out.println("Titulo: " + p.Titulo + " Valoración: " + p.Valoracion));
    }

}
