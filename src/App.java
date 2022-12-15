
import java.util.ArrayList;
import java.util.List;

import controller.EstacionamenteController;
import controller.TarifaController;
import modelo.Cliente;
import persistence.ClienteDAO;
import persistence.EstacionamentoDAO;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        TarifaController t = new TarifaController();

        t.listarTarifas();
        t.update();
        t.listarTarifas();

    }

}
