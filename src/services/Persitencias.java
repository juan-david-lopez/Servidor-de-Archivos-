package src.services;

import src.csvDao.PublicadorDao;
import src.csvDao.clienteDao;
import src.domain.Cliente;
import src.domain.Publicador;
import src.exceptions.GduqExceptions;

import java.io.IOException;

public class Persitencias {
    private PublicadorDao publicadorDao;
    private clienteDao clienteDa;
    public void GuardarPublicador(Publicador publica) throws IOException {
        try {
            publicadorDao.guardarPublicador(publica);
        } catch (GduqExceptions.PublicadorDuplicadoException | GduqExceptions.CsvDePublicadorMalFormado e) {
            throw new RuntimeException(e);
        }
    }
    public void GuardarCliente(Cliente cliente) throws IOException{
        try {
            clienteDao.guardarClienteDao(cliente);
        } catch (GduqExceptions.PublicadorDuplicadoException | GduqExceptions.CsvDePublicadorMalFormado e) {
        throw new RuntimeException(e);
    }


    }

}
