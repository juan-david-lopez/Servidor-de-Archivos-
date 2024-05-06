package src.csvDao;

import javafx.beans.binding.Bindings;
import src.domain.Cliente;
import src.exceptions.Exceptions;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class clienteDao implements Closeable {
    public static final String FLUJO_DATOS_ESCRITURA = "ESCRITURA";
    public static final String CSV_SEPARADOR = ";";
    private static final String FLUJO_DATOS_LECTURA_ESCRITURA = "ESCRITURA";
    private final String rutaArchivo;
    private final String formato;
    public static final String FLUJO_DATOS_LECTURA = "LECTURA";
    private Formatter formateador;
    private BufferedReader lectorBufereado;
    private String idcliente;
    private FileWriter escritor;

    public clienteDao() {
        super();
        this.rutaArchivo = "C:/Users/lenovo/Documents/grupo_dia/publicadores.csv";
        this.formato = "%s,%s,%s%s";
    }

    public long  guardarClienteDao(Cliente cliente) throws Exceptions.CsvDePublicadorMalFormado, IOException, Exceptions.CsvDePublicadorMalFormado {

        long idcliente;
        try {
            // Se abre el flujo de datos con el archivo csv.
            abrirFlujoDeDatos(PublicadorDao.FLUJO_DATOS_LECTURA_ESCRITURA);

            // Se verifica si ya existe un publicador registrado con el mismo nombre.
            if (existecliente(cliente.getNombre())) {
                Exceptions.PublicadorDuplicadoException pde = new Exceptions().new PublicadorDuplicadoException();
                pde.setSistemaDePersistencia(PublicadorDao.SISTEMA_DE_PERSISTENCIA);
                pde.setNombreDelPublicador(cliente.getNombre());
                throw pde;
            }

            // Se genera el identificador del publicador a registrar.
            idcliente = generarId();

            // Se guarda el publicador en el archivo csv
            Bindings.format(
                    this.formato, this.idcliente, cliente.getNombre());
        } catch (Exceptions.PublicadorDuplicadoException e) {
            throw new RuntimeException(e);
        }
        return idcliente;
    }

    private long generarId() throws Exceptions.CsvDePublicadorMalFormado, IOException {
        long id = consultarIdMaximo();
        return ++id;
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

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public Formatter getFormateador() {
        return formateador;
    }

    private void abrirFlujoDeDatos(String tipo) throws IOException {
        if (clienteDao.FLUJO_DATOS_ESCRITURA == tipo || clienteDao.FLUJO_DATOS_LECTURA_ESCRITURA == tipo) {    // Se abre el flujo de datos de escritura.
            this.escritor = new FileWriter(
                    this.rutaArchivo, // Ruta del archivo csv.
                    true              // Indicación para añadir el texto al final del archivo.
            );
            this.formateador = new Formatter(this.escritor);
        }
    }

    private boolean existecliente(String nombre) throws Exceptions.CsvDePublicadorMalFormado, IOException {

        String linea;
        String nombreRegistroActual;
        while ((linea = this.lectorBufereado.readLine()) !=null  ){
            String[] datos = linea.split(clienteDao.CSV_SEPARADOR);
            if (datos.length >= 2) {
                nombreRegistroActual = datos[1];
                if (nombre == nombreRegistroActual) {
                    return true;
                }
            } else {
                throw new Exceptions().new CsvDePublicadorMalFormado();
            }
        }
        return false;
    }
    private long consultarIdMaximo() throws IOException, Exceptions.CsvDePublicadorMalFormado {
        long idActual;
        long idMax = 0;
        String linea;
        while( (linea = lectorBufereado.readLine()) != null ) {
            String[] datos = linea.split(clienteDao.CSV_SEPARADOR);
            if(datos.length >= 1) {
                idActual = Long.parseLong(datos[0]); // Se espera que el Id esté en la posición 0.
                if(idActual > idMax) {
                    idMax = idActual;
                }
            } else {
                throw new Exceptions().new CsvDePublicadorMalFormado();
            }
        }
        return idMax;
    }
}