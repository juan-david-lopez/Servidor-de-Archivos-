package src.Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;

public class ArchivosServidor {
    public class ClienteArchivos {

        private Socket conector;
        private String direccionIP;
        private DataInputStream flujoEntrada;
        private DataOutputStream flujoSalida;
        private int puerto;

        public ClienteArchivos(String direccionIP, int puerto) {
            this.direccionIP = direccionIP;
            this.puerto = puerto;
        }

        /**
         * pone activo al servidor, es necesario para poder dar el tratamiento de datos
         * @return si se pudo realizar la conexion o no.
         */
        public boolean iniciarConexionConServidor() {
            try {
                this.conector 		= new Socket(this.direccionIP, this.puerto);
                this.flujoEntrada 	= new DataInputStream(this.conector.getInputStream());
                this.flujoSalida 	= new DataOutputStream(conector.getOutputStream());

                return true;
            } catch(Exception e) {
                return false;
            } finally {
                cerrarRecursos();
            }
        }

        public void cerrarRecursos() {
            try {
                this.flujoEntrada.close();
                this.flujoSalida.close();
                this.conector.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public DataInputStream getFlujoEntrada() {
            return flujoEntrada;
        }

        public void setFlujoEntrada(DataInputStream flujoEntrada) {
            this.flujoEntrada = flujoEntrada;
        }

        public DataOutputStream getFlujoSalida() {
            return flujoSalida;
        }

        public void setFlujoSalida(DataOutputStream flujoSalida) {
            this.flujoSalida = flujoSalida;
        }
    }

}
