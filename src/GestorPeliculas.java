import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
    static List<Pelicula> catalogo = new ArrayList<>();
    private static final String ARCHIVO = "datos/peliculas.csv";

    public static boolean añadirPelicula(Pelicula pelicula){
        return catalogo.add(pelicula);
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
