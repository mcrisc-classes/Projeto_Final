
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.DateTimeAtCompleted;

import controller.CarroController;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        CarroController c = new CarroController();

        c.calcularBloco(null);

    }

}
