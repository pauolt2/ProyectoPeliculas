public class Pelicula {
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


    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDirector() {
        return Director;
    }
    public void setDirector(String director) {
        Director = director;
    }

    public int getEstreno() {
        return Estreno;
    }
    public void setEstreno(int estreno) {
        if (estreno < 0) System.out.println("El año de estreno no puede ser negativo.");
        else Estreno = estreno;
    }

    public String getGenero() {
        return Genero;
    }
    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getValoracion() {
        return Valoracion;
    }
    public void setValoracion(int valoracion) {
        if (valoracion <= 5 && valoracion > 0) Valoracion = valoracion;
        else System.out.println("La valoracion debe ser del 1 al 5.");

    }
}
