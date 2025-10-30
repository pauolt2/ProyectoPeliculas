import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class GestorPeliculas {
    static List<Pelicula> peliculas = new ArrayList<>();

    public static class Pelicula {
        String titulo, director, genero;
        int duracion;

        public Pelicula(String titulo, String director, String genero, int duracion) {
            this.titulo = titulo;
            this.director = director;
            this.genero = genero;
            this.duracion = duracion;
        }
    }

    static void modificarPeli(String d){
        Scanner sc = new Scanner(System.in);
        for (Pelicula superpeli : peliculas){

            if (superpeli.titulo.toLowerCase().contains(d.toLowerCase())){
                int eleccion = 0;
                System.out.println("¿Que quieres editar?");
                System.out.println("1. Titulo 2. Director 3. Genero 4. Duracion");
                switch (eleccion){

                    case 1: superpeli.titulo = sc.nextLine();
                    case 2: superpeli.director = sc.nextLine();
                    case 3: superpeli.genero = sc.nextLine();
                    case 4: superpeli.duracion = sc.nextInt();
                    }
                }
            }
        }
    }

