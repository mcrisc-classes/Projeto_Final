
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import persistence.ClienteDAO;
import persistence.EstacionamentoDAO;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        EstacionamentoDAO e = new EstacionamentoDAO();

        int a = e.consultarVagasLivres(1);

        System.out.println("RONAAAAAALDINHO: " + a);

        ClienteDAO c = new ClienteDAO();

        Cliente cl = new Cliente();

        cl = c.findByCpf("450454234-02");

        System.out.println("CPF: " + cl.getCpf() + "\nNum_cliente: " + cl.getN_cliente() + "\nObs: "
                + cl.getObservacoes() + "\nPlaca: " + cl.getPlaca() + cl.getTelefone());

        List<Cliente> clientes = new ArrayList<>();

        clientes = c.listAll();

        Cliente c2 = new Cliente();
        c2 = clientes.get(2);

        System.out.println("CPF: " + c2.getCpf() + "\nNum_cliente: " + c2.getN_cliente() + "\nObs: "
                + c2.getObservacoes() + "\nPlaca: " + c2.getPlaca() + c2.getTelefone());

        System.out.println(clientes.size());

    }

}
