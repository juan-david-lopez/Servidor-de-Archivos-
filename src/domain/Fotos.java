package src.domain;

public class Fotos extends Contenido{
    private byte[] cuerpo;

    /**
     * constructor de fotos donde recibe los siguientes parametros
     * @param idContenido long
     * @param title String
     * @param fechaPublicacion String
     * @param cuerpo byte[]
     */
    public Fotos(long idContenido, String title, String fechaPublicacion, byte[] cuerpo) {
        super(idContenido, title, fechaPublicacion);
        this.cuerpo=cuerpo;
    }
    public Fotos(long idContenido, String title, String fechaPublicacion) {
        super(idContenido, title, fechaPublicacion);
    }

    /**
     *
     * @return el cuerpo de la foto en un arreglo de byte
     */
    public byte[] getCuerpo() {
        return cuerpo;
    }

    /**
     * se setea el cuerpo de la foto en caso de modificacion
     * @param cuerpo
     */
    public void setCuerpo(byte[] cuerpo) {
        this.cuerpo = cuerpo;
    }
}
