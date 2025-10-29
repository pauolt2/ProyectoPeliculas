import java.io.IOException;
import java.nio.file.*;
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
            System.out.println("Catálogo guardado correctamente en " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar el catálogo: " + e.getMessage());
        }
    }

    public static void cargarCatalogo() {
        Path ruta = Paths.get(ARCHIVO);
        if (!Files.exists(ruta)) {
            System.out.println("No se encontró el archivo de datos, se creará uno nuevo.");
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
            System.out.println(" Catalogo cargado correctamente (" + catalogo.size() + " películas)");
        } catch (IOException e) {
            System.out.println(" Error al cargar el catálogo: " + e.getMessage());
        }

    }


}