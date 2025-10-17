import java.util.ArrayList;
import java.util.List;

public  class GestorPeliculas {
    static List<pelicula> peliculas = new ArrayList<>();

    public record pelicula(String titulo, String director, String genero, int duracion){

    }

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



    static void main() {
        pelicula peli = new pelicula("Pasta","Jaume","Horror",120);
        peliculas.add(peli);
        filtrarPeliculasGenero("Horror");
        filtrarPeliculasDirector("Jaume");
    }
}

