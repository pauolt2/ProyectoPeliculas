import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {
    static List<Pelicula> catalogo = new ArrayList<>();
    private static final String ARCHIVO = "datos/peliculas.csv";

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
//
        try {
            Path ruta = Paths.get(ARCHIVO);
            Files.createDirectories(ruta.getParent());
            Files.write(ruta, lineas);
            System.out.println(" Catálogo guardado correctamente en " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("⚠ Error al guardar el catálogo: " + e.getMessage());
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
            System.out.println(" Catálogo cargado correctamente (" + catalogo.size() + " películas)");
        } catch (IOException e) {
            System.out.println("⚠ Error al cargar el catálogo: " + e.getMessage());
        }
    }
}
