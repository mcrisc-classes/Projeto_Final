package interfaceUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import com.mysql.cj.xdevapi.Client;

import controller.UseCaseController;
import modelo.Carros;
import modelo.Cliente;
import persistence.CarroDAO;
import persistence.ClienteDAO;
import persistence.PersistenceException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GerenciamentoVeiculos extends UseCaseController {

    private JPanel panel;
    private JLabel placa;
    private JLabel descrição;
    private JTextField txtplaca;
    private JLabel cpf;
    private JTextField txtcpf;
    private JTextField txtdescricao;
    private JTextField txtnome;
    private JTextField txtCelular;
    private JTextField txtSaldo;
    private JTextField txtBlocos;
    private Connection conn;

    /**
     * @throws PersistenceException
     */

    // Função responsavel por procurar clientes cadastrados por meio do cpf

    public void procurar() throws PersistenceException {


        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws SQLException {
                String telefone = null;
                String nome = null;
                String saldo = null;
                String blocos = null;

                String cpf = txtcpf.getText();

                try (PreparedStatement ps = conn.prepareStatement(
                        "SELECT * FROM cliente WHERE cpf = ?;")) {

                    ps.setString(1, cpf);

                    try (ResultSet rs = ps.executeQuery();) {
                        if (rs.next()) {
                            telefone = rs.getString("telefone");
                            nome = rs.getString("nome");
                            saldo = rs.getString("saldo");
                            blocos = rs.getString("quantidade_blocos");
                        }
                    }
                }

                return telefone;
            }

            @Override
            protected void done() {
                txtCelular.setEditable(true);
                txtSaldo.setEditable(true);
                txtBlocos.setEditable(true);

                try {
                    String telefone = get();
                    String saldo = get();
                    String blocos = get();

                    if (cpf != null) {
                        txtCelular.setText(telefone);
                        txtSaldo.setText(saldo);
                        txtBlocos.setText(blocos);

                    } else {
                        txtCelular.setText("Cliente Não Encontrado");
                        txtSaldo.setText("Cliente Não Encontrado");
                        txtBlocos.setText("Cliente Não encontrado");
                    }

                } catch (InterruptedException | ExecutionException e) {
                    System.err.println("Error!");
                }

                txtCelular.setEditable(false);
                txtSaldo.setEditable(false);
                txtBlocos.setEditable(false);
            }

        };

        worker.execute();

    }

    // função responsavel por cadastra veiculo

    public void cadastrarVeiculo() throws PersistenceException {

        Carros c = new Carros();
        CarroDAO cl = new CarroDAO();

        c.setPlaca(txtplaca.getText());
        c.setDescricao(txtdescricao.getText());

        cl.save(c);

    }

    // função responsavel por construir o painel e aplicar as dms funções

    public void PanelGerenciaVeiculos() throws PersistenceException {

        panel = new JPanel();

        JLabel placa = new JLabel("Placa: ");
        JLabel descricao = new JLabel("Descrição: ");
        JTextField txtplaca = new JTextField(15);
        JLabel cpf = new JLabel("Cpf: ");
        JTextField txtcpf = new JTextField(15);
        JTextField txtdescricao = new JTextField(15);
        // JTextField txtnome = new JTextField(15);
        JTextField txtCelular = new JTextField(15);
        // JTextField txtSaldo = new JTextField(15);
        // JTextField txtBlocos = new JTextField(15);

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;

        add(cpf, gc);

        gc.gridx++;

        add(txtcpf, gc);

        procurar();

        gc.gridy--;

        add(txtCelular, gc);

        gc.gridy--;

        add(placa, gc);

        gc.gridx++;

        add(txtplaca);

        gc.gridy--;
        gc.gridx--;

        add(descricao, gc);

        gc.gridx++;

        add(txtdescricao, gc);

        cadastrarVeiculo();

    }

    @Override
    public JPanel buildUI() {
        // TODO Auto-generated method stub
        return null;
    }

}
