package controller;


import java.util.List;


import modelo.Cliente;
import persistence.ClienteDAO;
import persistence.PersistenceException;

public class ClienteController {
    ClienteDAO cliente = new ClienteDAO();

    // -------------------------------------------------------------------------- //
    // Lista todos os carros
    // -------------------------------------------------------------------------- //

    public void listCLiente() throws PersistenceException {
        List<Cliente> clientes = cliente.listAll();

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Cpf: " + clientes.get(i).getCpf() + " ||  Telefone: " + clientes.get(i).getTelefone() +
                            "\nNumero Cliente: " + clientes.get(i).getN_cliente() + "  || Observações: "
                            + clientes.get(i).getObservacoes() + "\nPlaca: "
                            + clientes.get(i).getPlaca() + "\n");
        }
    }

    

    // -------------------------------------------------------------------------- //
    // Registra entrada e saida de carros não registrados
    // -------------------------------------------------------------------------- //


    public void delete(String cpf) throws PersistenceException {
        Cliente cli = cliente.findByCpf(cpf);

        cliente.delete(cli);

    }

    public void salvar(String cpf) throws PersistenceException {
        Cliente cli = cliente.findByCpf(cpf);

        cliente.save(cli);

    }

   

    // -------------------------------------------------------------------------- //
    // Registra entrada e saida de carros não registrados
    // -------------------------------------------------------------------------- //

    

}
