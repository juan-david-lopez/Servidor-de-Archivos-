package src.domain;

public class Articulo extends Contenido{
    private String cuerpo;

    /**
     *
     * @param idContenido
     * @param title
     * @param fechaPublicacion
     * @param cuerpo
     */
    public Articulo(long idContenido, String title, String fechaPublicacion, String cuerpo) {
        super(idContenido, title, fechaPublicacion);
        this.cuerpo = cuerpo;
    }
    public Articulo(long idContenido, String title, String fechaPublicacion) {
        super(idContenido, title, fechaPublicacion);
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
