public class Pelicula {
    private String titulo;
    private String director;
    private int estreno;
    private String genero;
    private int valoracion;

    public Pelicula(String titulo, String director, int estreno, String genero, int valoracion) {
        this.titulo = titulo;
        this.director = director;
        this.estreno = Math.max(estreno, 0); // evita años negativos
        this.genero = genero;
        if (valoracion >= 1 && valoracion <= 5) {
            this.valoracion = valoracion;
        } else {
            System.out.println("La valoración debe ser del 1 al 5. Se establecerá en 1 por defecto.");
            this.valoracion = 1;
        }
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public int getEstreno() {
        return estreno;
    }
    public void setEstreno(int estreno) {
        if (estreno < 0)
            System.out.println("El año de estreno no puede ser negativo.");
        else
            this.estreno = estreno;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getValoracion() {
        return valoracion;
    }
    public void setValoracion(int valoracion) {
        if (valoracion >= 1 && valoracion <= 5)
            this.valoracion = valoracion;
        else
            System.out.println("La valoración debe ser del 1 al 5.");
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nDirector: " + director +
                "\nAño: " + estreno +
                "\nGénero: " + genero +
                "\nValoración: " + valoracion + "/5";
    }
}
