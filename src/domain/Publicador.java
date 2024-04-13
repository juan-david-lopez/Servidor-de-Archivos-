package src.domain;

import java.util.ArrayList;
import java.util.Objects;
public class Publicador {
    // Miembros tipo variable.

    /**
     * Identificador único del publicador.
     */
    private long idPublicador;

    /**
     * Abreviatura que sirve para identificar el Publicador.
     */
    private String abreviatura;

    /**
     * Colección de artículos publicados por el socio.
     */
    private ArrayList<Articulo> articulos;

    /**
     * Colección de fotos publicadas por el socio.
     */
    private ArrayList<Foto> fotos;

    /**
     * Nombre del publicador.
     */
    private String nombre;

    /**
     * Ruta de la carpeta en que se reciben los artículos del publicador.
     */
    private String rutaCarpetaArticulos;

    /**
     * Ruta de la carpeta en que se reciben las fotos del publicador.
     */
    private String rutaCarpetaFotos;

    /**
     * Url del sitio web del publicador.
     */
    private String urlDelSitioWeb;


    // Miembros tipo método (Constructor)

    /**
     * @param idPublicador
     * @param nombre
     * @param rutaCarpetaArticulos
     * @param rutaCarpetaFotos
     */
    public Publicador(long idPublicador, String nombre, String rutaCarpetaArticulos, String rutaCarpetaFotos) {
        super();
        this.idPublicador = idPublicador;
        this.nombre = nombre;
        this.rutaCarpetaArticulos = rutaCarpetaArticulos;
        this.rutaCarpetaFotos = rutaCarpetaFotos;
    }


    // Miembros tipo método (Accesores)

    /**
     * @return the idPublicador
     */
    public long getIdPublicador() {
        return idPublicador;
    }

    /**
     * @param idPublicador the idPublicador to set
     */
    public void setIdPublicador(long idPublicador) {
        this.idPublicador = idPublicador;
    }

    /**
     * @return the abreviatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * @param abreviatura the abreviatura to set
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * @return the articulos
     */
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    /**
     * @param articulos the articulos to set
     */
    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    /**
     * @return the fotos
     */
    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    /**
     * @param fotos the fotos to set
     */
    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the rutaCarpetaArticulos
     */
    public String getRutaCarpetaArticulos() {
        return rutaCarpetaArticulos;
    }

    /**
     * @param rutaCarpetaArticulos the rutaCarpetaArticulos to set
     */
    public void setRutaCarpetaArticulos(String rutaCarpetaArticulos) {
        this.rutaCarpetaArticulos = rutaCarpetaArticulos;
    }

    /**
     * @return the rutaCarpetaFotos
     */
    public String getRutaCarpetaFotos() {
        return rutaCarpetaFotos;
    }

    /**
     * @param rutaCarpetaFotos the rutaCarpetaFotos to set
     */
    public void setRutaCarpetaFotos(String rutaCarpetaFotos) {
        this.rutaCarpetaFotos = rutaCarpetaFotos;
    }

    /**
     * @return the urlDelSitioWeb
     */
    public String getUrlDelSitioWeb() {
        return urlDelSitioWeb;
    }

    /**
     * @param urlDelSitioWeb the urlDelSitioWeb to set
     */
    public void setUrlDelSitioWeb(String urlDelSitioWeb) {
        this.urlDelSitioWeb = urlDelSitioWeb;
    }


    // Miembros tipo método (hashcode e equals)
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Publicador other = (Publicador) obj;
        return Objects.equals(nombre, other.nombre);
    }
}
