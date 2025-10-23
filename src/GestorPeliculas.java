import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
    private List<Pelicula> catalogo = new ArrayList<>();
    private static final String ARCHIVO = "datos/peliculas.csv";
  
  
    static void filtrarPeliculasGenero(String g){
        for (pelicula pelito : peliculas) {

            if (pelito.genero.toLowerCase().contains(g.toLowerCase())) {

                System.out.println(pelito);
            }
        }
    }
    static void filtrarPeliculasDirector(String d){
        for (pelicula pelito : peliculas) {

            if (pelito.director.toLowerCase().contains(d.toLowerCase())) {

                System.out.println(pelito);
            }
        }
    }
}

