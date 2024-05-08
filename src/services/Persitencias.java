package src.services;

import src.csvDao.PublicadorDao;
import src.csvDao.clienteDao;
import src.domain.Cliente;
import src.domain.Publicador;
import src.exceptions.Exceptions;

import java.io.IOException;

public class Persitencias {
    private PublicadorDao publicadorDao;
    private clienteDao clienteDao;
    public long GuardarPublicador(Publicador publica) throws IOException {
        long idpublicador;
        try {
            idpublicador = publicadorDao.guardarPublicador(publica);
        } catch (Exceptions.PublicadorDuplicadoException | Exceptions.CsvDePublicadorMalFormado e) {
            throw new RuntimeException(e);
        }
        return idpublicador;
    }
    public long GuardarCliente(Cliente cliente) throws IOException{
        long idcliente;
        try {
            idcliente = clienteDao.guardarClienteDao(cliente);
        } catch (Exceptions.CsvDePublicadorMalFormado e) {
            throw new RuntimeException(e);
        }
        return idcliente;
    }

}
