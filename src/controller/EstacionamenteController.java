package controller;

import modelo.Estacionamento;
import persistence.EstacionamentoDAO;
import persistence.PersistenceException;

public class EstacionamenteController {

    EstacionamentoDAO estacionamento = new EstacionamentoDAO();

    public void dadosEstacionamentos() throws PersistenceException {

        Estacionamento e = estacionamento.consultarEstacionamento();

        System.out.println("ID: " + e.getId() + "\nVagas totais: " + e.getVagas_totais() +
                "\nVagas livres : " + e.getVagas_livres() + "\nVAgas ocupadas: " + e.getVagas_ocupadas() +
                "\nTipo bloco: " + e.getTipo_bloco());

    }

    public void LiberarVaga() throws PersistenceException {

        estacionamento.liberarVaga();
    }

    public void OcuparVaga() throws PersistenceException {

        estacionamento.ocuparVaga();
    }

    public void alterarBloco(String bloco) throws PersistenceException {

        estacionamento.alterarBloco(bloco);
    }

}
