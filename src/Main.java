class Pelicula {
    String Titulo;
    String Director;
    int Estreno;
    String Genero;
    int Valoracion;

    public Pelicula(String titulo, String director, int estreno, String genero, int valoracion) {
        Titulo = titulo;
        Director = director;
        Estreno = estreno;
        Genero = genero;
        Valoracion = valoracion;

    }
}

public class Main {
    static void main() {

        System.out.println("=====================================");
        System.out.println("CATÁLOGO DE PELÍCULAS Y SERIES");
        System.out.println("=====================================");
        System.out.println("1. Añadir película/serie");
        System.out.println("2. Ver catálogo completo");
        System.out.println("3. Buscar por título");
        System.out.println("4. Filtrar por género");
        System.out.println("5. Filtrar por director");
        System.out.println("6. Eliminar película/serie");
        System.out.println("7. Modificar película/serie");
        System.out.println("8. Ver mejor valoradas");
        System.out.println("0. Salir (guarda automáticamente)");


    }

}
