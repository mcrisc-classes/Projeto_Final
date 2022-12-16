import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.DateTimeAtCompleted;

import controller.CarroController;
import controller.EstacionamenteController;
import modelo.Carros;
import modelo.Estacionamento;
import persistence.CarroDAO;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        CarroController c = new CarroController();

        Carros car = new Carros();

        car.setDescricao("FUSCAO PRETO UIUIUI");
        car.setPlaca("C4V4L0");

        c.registrarEntradaOuSaida(car);

        c.listarCarros();

    }

}
