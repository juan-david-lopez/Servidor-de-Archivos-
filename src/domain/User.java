package src.domain;

import java.util.ArrayList;

public class User extends Persona{
    public final String TipoAliadoCliente = "cliente";
    public final String TipoAliadoPublicador = "publicador";
    private long idCliente;
    private long idPublicador;
    private ArrayList<String> emails;
    private long idUsuario;

    private String loginEmail;

    private String tipoAliado;
    private Rol rol;
    public User(long idPersona, String documento, ArrayList<String> emails,
                   String nombreCompleto, String[] telefonos, String tipoDocumento,
                   long idCliente, long idPublicador, long idUsuario, String loginEmail, Rol rol) {
        super(idPersona, documento, emails, nombreCompleto, telefonos, tipoDocumento);
        this.idCliente = idCliente;
        this.idPublicador = idPublicador;
        this.idUsuario = idUsuario;
        this.loginEmail = loginEmail;
        this.rol = rol;
    }
    public User(String documento, String nombreCompleto) {
        super(documento, nombreCompleto);
    }
    public User(long idPersona, String documento, String nombreCompleto, String loginEmail, Rol rol) {
        super(idPersona, documento, nombreCompleto);
        this.loginEmail = loginEmail;
        this.rol = rol;
    }
    public User(String documento, String nombreCompleto, String loginEmail, Rol rol) {
        super(documento, nombreCompleto);
        this.loginEmail = loginEmail;
        this.rol = rol;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdPublicador() {
        return idPublicador;
    }

    public void setIdPublicador(long idPublicador) {
        this.idPublicador = idPublicador;
    }

    @Override
    public ArrayList<String> getEmails() {
        return emails;
    }

    @Override
    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
