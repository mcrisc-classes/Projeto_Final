package controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import com.mysql.cj.result.LocalDateTimeValueFactory;

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

}
