package controller;

import java.rmi.server.SocketSecurityException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;

import modelo.Carros;
import persistence.CarroDAO;
import persistence.PersistenceException;

public class CarroController {
    CarroDAO carro = new CarroDAO();

    // -------------------------------------------------------------------------- //
    // Lista todos os carros
    // -------------------------------------------------------------------------- //

    public void listarCarros() throws PersistenceException {
        List<Carros> carros = carro.listAll();

        for (int i = 0; i < carros.size(); i++) {
            System.out
                    .println("Placa: " + carros.get(i).getPlaca() + " ||  Descrição: " + carros.get(i).getDescricao() +
                            "\nBlocos: " + carros.get(i).getQuantidade_blocos() + "  || Duração: "
                            + carros.get(i).getDuracao() + "\nData entrada: "
                            + carros.get(i).getHora_entrada() +
                            "\nData saida: " + carros.get(i).getHora_saida() + "\n");
        }
    }

    // -------------------------------------------------------------------------- //
    // Registra entrada ou saida
    // -------------------------------------------------------------------------- //

    public int registrarEntradaOuSaida(String placa) throws PersistenceException, SQLException, ParseException {

        Carros car = carro.findByPlaca(placa);

        // Condições:
        if (car != null && car.getHora_saida() == null && car.getHora_entrada() == null) { // Se tiver registro de
                                                                                           // carro e ele não tiver
                                                                                           // registro de saida e nem
                                                                                           // de entrada;

            carro.save(car);

            return 0;
        } else if (car != null && car.getHora_saida() == null) { // Se tiver registro de carro e ele tiver registro de

            car = carro.saveSaida(car);
            car.setDuracao(duracao(car.getPlaca()));
            car.setQuantidade_blocos(calcularBloco(car.getPlaca()));
            car = carro.findByPlaca(placa);
            carro.update(car);

            return 1;
        } else { // Carro sem registro no bd chamar a outra função registrarEntradaOuSaida

            return 2;
        }

    }

    // -------------------------------------------------------------------------- //
    // Registra entrada e saida de carros não registrados
    // -------------------------------------------------------------------------- //

    public void registrarEntradaOuSaida(Carros car) throws PersistenceException, SQLException {

        carro.save(car);

    }

    // -------------------------------------------------------------------------- //
    // Duração que o carro ficou na vaga
    // -------------------------------------------------------------------------- //

    public int duracao(String placa) throws PersistenceException, ParseException {

        Carros car = carro.findByPlaca(placa);

        // ----------------------------
        // CONVERSÃO DE DATA:

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d1 = null, d2 = null;

        d1 = format.parse(car.getHora_entrada());
        d2 = format.parse(car.getHora_saida());

        long diff = d2.getTime() - d1.getTime();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        int m = (int) minutes;

        // ----------------------------
        return m;

    }

    // -------------------------------------------------------------------------- //
    // Calculo de bloco
    // -------------------------------------------------------------------------- //

    public int calcularBloco(String placa) throws PersistenceException, SQLException, ParseException {

        EstacionamenteController e = new EstacionamenteController();
        int m = duracao(placa);

        // Divindo blocos;
        if (e.tipoBloco().equals("meia")) {
            float f = (float) m;
            double d = f / 30;
            d = Math.ceil(d);
            m = (int) d;

            return m;

        } else {

            double d = m / 60;
            d = Math.round(d);

            m = (int) d;

            return m;
        }
    }

    public void delete(String placa) throws PersistenceException {
        Carros car = carro.findByPlaca(placa);

        carro.delete(car);

    }

}
