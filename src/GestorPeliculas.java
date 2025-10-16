import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
    private static List<Pelicula> catalogo = new ArrayList<>();
    private static final String ARCHIVO = "datos/peliculas.csv";


    public static boolean añadirPelicula(Pelicula pelicula){
        return catalogo.add(pelicula);
    }


}
