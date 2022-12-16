
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.DateTimeAtCompleted;

import controller.CarroController;
import controller.TarifaController;
import modelo.Carros;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        CarroController c = new CarroController();

        Carros cari = new Carros();

        System.out.println("TARIFA : " + c.precoTarifa("APXKM"));
        System.out.println("TARIFA : " + c.precoTarifa("R0N41D0"));

        TarifaController t = new TarifaController();

        t.insert("W3D1-000");

    }

}
