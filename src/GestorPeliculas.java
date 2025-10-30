import java.util.ArrayList;
import java.util.List;

public  class GestorPeliculas {
    static List<pelicula> peliculas = new ArrayList<>();

    public record pelicula(String titulo, String director, String genero, int duracion){

    }

    static void modificarPeli(String d){
        for (pelicula pelito : peliculas){

            if (pelito.titulo.toLowerCase().contains(d.toLowerCase())){
                int eleccion = 0;
                System.out.println("¿Que quieres editar?");
                System.out.println("1. Titulo 2. Director 3. Genero 4. Duracion");
                switch (eleccion){

                    case 1: pelito.titulo = sc.nextLine();
                    case 2: pelito.director = sc.nextLine();
                    case 3: pelito.genero = sc.nextLine();
                    case 4: pelito.duracion = sc.nextInt();

                    }
                }
            }
        }
    }
}

