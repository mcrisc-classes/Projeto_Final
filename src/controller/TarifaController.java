package controller;

import java.util.List;

import modelo.Carros;
import modelo.Tarifa;
import persistence.PersistenceException;
import persistence.TarifaDAO;

public class TarifaController {
    private TarifaDAO t = new TarifaDAO();

    public void listarTarifas() throws PersistenceException {

        List<Tarifa> tarifas = t.listAll();

        for (int i = 0; i < tarifas.size(); i++) {

            System.out.println(
                    "Placa: " + tarifas.get(i).getPlaca() + "                | Preço do Bloco: "
                            + tarifas.get(i).getPreco_bloco() +
                            "\nData do pagamento: " + tarifas.get(i).getDt_pagamento() + " | Valor pago: "
                            + tarifas.get(i).getValor_pago() + "\n");
        }
    }

    public void update() throws PersistenceException {

        Tarifa tarifa = new Tarifa("ASD0000", 10, null, 100);

        t.update(tarifa);

    }

    public void insert(Carros carro) throws PersistenceException {

        // Calculo sobre a tarifa de acordo com a duração

    }

}
