package src.csvDao;

import src.domain.Cliente;

import java.io.Closeable;
import java.io.IOException;

public class clienteDao implements Closeable {
    private static final String FLUJO_DATOS_LECTURA_ESCRITURA = "ESCRITURA";
    private final String rutaArchivo;
    private final String formato;
    public static final String FLUJO_DATOS_LECTURA = "LECTURA";
    public clienteDao() {
        super();
        this.rutaArchivo = "C:/Users/lenovo/Documents/grupo_dia/publicadores.csv";
        this.formato = "%s,%s,%s%s";
    }
    public static void guardarClienteDao(Cliente cliente) {

    }
    @Override
    public void close() throws IOException {
        cerrarFlujoDeDatos(clienteDao.FLUJO_DATOS_LECTURA_ESCRITURA);
    }

    private void cerrarFlujoDeDatos(String flujoDatosLecturaEscritura) {
        try {
            close();
        } catch (IOException e) {
           System.err.println(" no se pudo cerrar el flujo de datos");
        }
    }
}
