
import java.util.ArrayList;
import java.util.List;

import controller.EstacionamenteController;
import modelo.Cliente;
import persistence.ClienteDAO;
import persistence.EstacionamentoDAO;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        EstacionamenteController e = new EstacionamenteController();

        e.dadosEstacionamentos();

        e.alterarBloco("Robertinho");

        e.dadosEstacionamentos();

    }

}
