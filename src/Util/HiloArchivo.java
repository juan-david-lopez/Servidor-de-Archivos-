package src.Util;

import src.Networking.ArchivosClientes;

public class HiloArchivo implements Runnable{
    private String direccionIP;
    private int puerto;
    public HiloArchivo(String direccionIP,int puerto){
        this.direccionIP=direccionIP;
        this.puerto=puerto;
    }
    @Override
    public void run() {
        ArchivosClientes archivosClientes = new ArchivosClientes(this.direccionIP,this.puerto);
        archivosClientes.iniciarConexionConServidor();
    }
}
