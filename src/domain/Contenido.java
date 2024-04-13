package src.domain;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;
public class Contenido {
    protected long idContenido;

    /**
     * El título que identifica el contenido.
     */
    protected String title;

    /**
     * Fecha en que el contenido fue publicado. Este atributo es
     * de tipo String a fin de poderlo mostrar fácilmente como
     * cadena de texto o a fin de almacenarlo fácilmente.
     */
    protected String fechaPublicacion;

    /**
     * Fecha en que el contenido fue publicado. Este atributo es
     * de tipoi OffsetDateTime a fin de poder realizar la gestión
     * de Zona Horaria sin ID de zona sino con el desplazamiento
     * numérico.
     */
    protected OffsetDateTime fechaPublicacionOdt;

    /**
     * Fecha en que el contenido fue publicado. Este atributo
     * es de tipo ZoneDateTime a fin de poder realizar la gestión
     * de Zona Horaria cuando sea necesario.
     */
    protected ZonedDateTime fechaPublicacionZdt;


    // Miembros tipo método (Constructor)

    /**
     * Constructor
     *
     * @param idContenido Identificador único.
     * @param title Título que identifica el contenido.
     * @param fechaPublicacion Fecha en que se publicó.
     */
    public Contenido(long idContenido, String title, String fechaPublicacion) {
        super();
        this.idContenido = idContenido;
        this.title = title;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Constructor de zonaDateTime.
     * @param  idContenido numero de identificacion del conte
     * @param  title string del titulo del conte
     * @param  fechaPublicacionZdt datetime que corresponde a la fecha
     */
    public Contenido(long idContenido, String title,  ZonedDateTime fechaPublicacionZdt) {
        super();
        this.idContenido = idContenido;
        this.title = title;
        this.fechaPublicacionZdt = fechaPublicacionZdt;
    }

    /**
     * Constructor
     *
     * @param idContenido Identificador único.
     * @param title Título que identifica el contenido.
     * @param fechaPublicacionOdt Fecha en que se publicó.
     */
    public Contenido(long idContenido, String title, OffsetDateTime fechaPublicacionOdt) {
        super();
        this.idContenido = idContenido;
        this.title = title;
        this.fechaPublicacionOdt = fechaPublicacionOdt;
    }


    // Miembros tipo método (Accesores)

    /**
     * @return the idContenido
     */
    public long getIdContenido() {
        return idContenido;
    }

    /**
     * @param idContenido the idContenido to set
     */
    public void setIdContenido(long idContenido) {
        this.idContenido = idContenido;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the fechaPublicacion
     */
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the fechaPublicacionOdt
     */
    public OffsetDateTime getFechaPublicacionOdt() {
        return fechaPublicacionOdt;
    }

    /**
     * @param fechaPublicacionOdt the fechaPublicacionOdt to set
     */
    public void setFechaPublicacionOdt(OffsetDateTime fechaPublicacionOdt) {
        this.fechaPublicacionOdt = fechaPublicacionOdt;
    }

    /**
     * @return the fechaPublicacionZdt
     */
    public ZonedDateTime getFechaPublicacionZdt() {
        return fechaPublicacionZdt;
    }

    /**
     * @param fechaPublicacionZdt the fechaPublicacionZdt to set
     */
    public void setFechaPublicacionZdt(ZonedDateTime fechaPublicacionZdt) {
        this.fechaPublicacionZdt = fechaPublicacionZdt;
    }


    // Miembros tipo método (hashcode e equals)

    @Override
    public int hashCode() {
        return Objects.hash(fechaPublicacion, idContenido, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contenido other = (Contenido) obj;
        return Objects.equals(fechaPublicacion, other.fechaPublicacion) && idContenido == other.idContenido
                && Objects.equals(title, other.title);
    }
}
