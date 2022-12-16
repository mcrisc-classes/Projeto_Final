package controller;

import java.util.List;

import modelo.Carros;
import modelo.Tarifa;
import persistence.CarroDAO;
import persistence.PersistenceException;
import persistence.TarifaDAO;

public class TarifaController {
    private TarifaDAO t = new TarifaDAO();
    final double preco = 3.5; // PREÇO BLOCO

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

    public void update(Tarifa tarifa) throws PersistenceException {

        t.update(tarifa);

    }

    public void insert(String placa) throws PersistenceException {
        CarroDAO carro = new CarroDAO();
        Carros car = carro.findByPlaca(placa);
        Tarifa tarifa = new Tarifa(car.getPlaca(), (float) preco, car.getHora_saida(), precoTarifa(car));

        t.insert(tarifa);

    }

    public float precoTarifa(Carros carro) {

        float total = (float) (carro.getQuantidade_blocos() * preco);

        return total;
    }

}
