package src.domain;

import java.util.*;


public class Rol {
    private long idRol;
    /**
     *  el nombre corresponde a la clave del treeMap debido a que el nombre
     *  nos permite conocer si tiene acceso(true) o sino la tiene (false)
     */
    private String nombre;

    private TreeMap<String,Boolean> PermisoAccesos;

    public Rol(long idRol, String nombre, TreeMap<String,Boolean> permisoAccesos){
        super();
        this.idRol=idRol;
        this.nombre=nombre;
        this.PermisoAccesos=permisoAccesos;
    }
    public Rol(long idRol, String nombre){
        this.idRol=idRol;
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TreeMap<String, Boolean> getPermisoAccesos() {
        return PermisoAccesos;
    }

    public void setPermisoAccesos(TreeMap<String, Boolean> permisoAccesos) {
        PermisoAccesos = permisoAccesos;
    }

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }
    @Override
    public int hashCode() {
        return Objects.hash(idRol);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rol other = (Rol) obj;
        return idRol == other.idRol;
    }
}
