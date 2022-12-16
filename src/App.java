
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.DateTimeAtCompleted;

import controller.CarroController;
import modelo.Carros;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        CarroController c = new CarroController();

        Carros cari = new Carros();

        cari.setPlaca("BBB");
        cari.setDescricao("Penis murcho");

        // c.registrarEntradaOuSaida("BBB");
        c.delete("F4ust0");

    }

}
