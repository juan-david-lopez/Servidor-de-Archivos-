package src.Util;

public class HilosMontarSerRecibirData {

    public void MontarServidor( boolean Montar, String direccionIP, int puerto ){
        HiloMontarServidor hiloMontarServidor = new HiloMontarServidor(direccionIP, puerto);
       if(Montar) {
           hiloMontarServidor.run();
       }
    }

    public void RecibirInformacionCliente(boolean Montar, String direccionIP, int puerto ){
        HiloArchivo hiloArchivo = new HiloArchivo(direccionIP, puerto);
        if(Montar){
            hiloArchivo.run();
        }
    }

}
