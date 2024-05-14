package src.Util;

import src.Networking.ArchivosServidor;

public class HiloMontarServidor implements Runnable{
  private final String direccionIP;
  private final int puerto;
    public HiloMontarServidor(String direccionIP,int puerto){
        this.direccionIP=direccionIP;
        this.puerto=puerto;
    }
    @Override
    public void run() {
        ArchivosServidor ArchivosServidor = new ArchivosServidor(direccionIP, puerto);
        ArchivosServidor.iniciarConexionConServidor();
    }
}
