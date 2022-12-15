package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import modelo.Carros;
import persistence.CarroDAO;
import persistence.PersistenceException;

public class CarroController {
    CarroDAO carro = new CarroDAO();

    public void listarCarros() throws PersistenceException {
        List<Carros> carros = carro.listAll();

        for (int i = 0; i < carros.size(); i++) {
            System.out.println("Placa: " + carros.get(i).getPlaca() + " |  Descrição: " + carros.get(i).getPlaca()
                    + carros.get(i).getHora_entrada());
        }
    }

    public int registrarEntradaOuSaida(String placa) throws PersistenceException {

        Carros car = carro.findByPlaca(placa);

        // Condições:
        if (car != null && car.getHora_saida() == null && car.getHora_entrada() == null) { // Se tiver registro de
                                                                                           // carro e ele não tiver
                                                                                           // registro de saida e nem
                                                                                           // de entrada;
            carro.save(car);
            return 0;
        } else if (car != null && car.getHora_saida() == null) { // Se tiver registro de carro e ele tiver registro de
                                                                 // saida;
            carro.save(car);
            return 1;
        } else { // Carro sem registro no bd chamar a outra função registrarEntradaOuSaida
            return 2;
        }

    }

    public void registrarEntradaOuSaida(Carros car) throws PersistenceException {

        carro.save(car);

    }

    public void calcularBloco(String placa) throws PersistenceException, ParseException {

        Carros car = carro.findByPlaca("EEE0000");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d1 = null, d2 = null;

        d1 = format.parse(car.getHora_entrada());
        d2 = format.parse(car.getHora_saida());

        long diff = d2.getTime() - d1.getTime();// as given
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

        System.out.println(minutes);

    }

}
