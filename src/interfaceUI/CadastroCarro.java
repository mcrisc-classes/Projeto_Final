package interfaceUI;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.UseCaseController;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import javax.swing.JButton;

public class CadastroCarro extends UseCaseController {
    
    private JPanel penel;
    private JLabel placa;
    private JTextField txtplaca;
    private JButton pesquisar;
    private JLabel entrada;
    private JLabel saida;
    private JLabel permanencia;
    private JLabel blocos;
    private JLabel preco;
    private JLabel total;
    private JTextField txtBloco;
    private JTextField txtPreco;
    private JTextField txtTotal;
    private JTextField txtentrada;
    private JTextField txtSaida;
    private JTextField txtPermanencia;
    private JTextField txtDescricao;
    private JButton entradaCarro;
    private JButton cadastrarSaida;
    private JButton cadastrarCarro;
    private JButton cancelar;

    /* Criação da Janela responsavel por pesquisar carros */

    public void PesquisarCarro() {

        placa = new JLabel("Placa: ");
        txtplaca = new JTextField(15);
        pesquisar = new JButton("Pesquisar");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;

        add(placa, gc);

        gc.gridx++;

        add(txtplaca, gc);

        gc.gridx++;

        add(pesquisar, gc);

    }

    @Override
    public JPanel buildUI() {
        // TODO Auto-generated method stub
        return null;
    }

    /* Criação da tabela responsavel pela entrade de veiculos cadastrado */

    /*public void EntradaVeiculo(ActionEvent e) {

        pesquisar.setEnabled(false);
        pesquisar.setVisible(false);

        entrada = new JLabel("Entrada: ");
        permanencia = new JLabel("Permanencia: ");
        txtPermanencia = new JTextField(15);
        txtentrada = new JTextField(15);
        txtDescricao = new JTextField(15);
        blocos = new JLabel("Blocos: ");
        preco = new JLabel("Preço: ");
        total = new JLabel("Total: ");
        txtBloco = new JTextField(15);
        txtPreco = new JTextField(15);
        txtTotal = new JTextField(15);
        entradaCarro = new JButton("Entrada Carro");
        cancelar = new JButton("Cancelar");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;

        add(entrada, gc);

        gc.gridx++;

        add(txtentrada, gc);

        gc.gridx--;
        gc.gridy--;

        add(permanencia, gc);

        gc.gridx++;

        add(txtPermanencia, gc);

        gc.gridx--;
        gc.gridy--;

        add(blocos, gc);

        gc.gridx++;

        add(txtBloco, gc);

        gc.gridx--;
        gc.gridy--;

        add(preco, gc);

        gc.gridx++;

        add(txtPreco, gc);

        gc.gridx--;
        gc.gridy--;

        add(total, gc);

        gc.gridx++;

        add(txtTotal, gc);

        gc.gridx--;
        gc.gridy--;

        add(txtDescricao, gc);

        gc.gridy--;

        add(entradaCarro, gc);

        gc.gridx++;

        add(cancelar, gc);

    }*/

    /* Criação da Janela responsavel pela saida de veiculos */

   /* public void SaidaVeiculo(ActionEvent e) {

        pesquisar.setEnabled(false);
        pesquisar.setVisible(false);

        saida = new JLabel("Saida: ");
        txtSaida = new JTextField(15);
        entradaCarro = new JButton("Saida Carro");
        cancelar = new JButton("Cancelar");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;

        add(saida, gc);

        gc.gridx++;

        add(txtSaida);

        gc.gridy--;
        gc.gridx--;

        add(entradaCarro, gc);

        gc.gridx++;

        add(cancelar, gc);

    }*/

    /* Crianção de janelas que cadastra veiculos não inclusos no banco */

    /*public void CadastrarCarro(ActionEvent e) {

        pesquisar.setEnabled(false);
        pesquisar.setVisible(false);

        placa = new JLabel("Placa: ");
        txtplaca = new JTextField(15);
        permanencia = new JLabel("Permanencia: ");
        txtPermanencia = new JTextField(15);
        txtSaida = new JTextField(15);
        txtentrada = new JTextField(15);
        txtDescricao = new JTextField(15);
        blocos = new JLabel("Blocos: ");
        preco = new JLabel("Preço: ");
        total = new JLabel("Total: ");
        txtBloco = new JTextField(15);
        txtPreco = new JTextField(15);
        txtTotal = new JTextField(15);
        entradaCarro = new JButton("Cadastrar Carro");
        cancelar = new JButton("Cancelar");
        entradaCarro = new JButton("Entrada Carro");
        cancelar = new JButton("Cancelar");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;

        add(entrada, gc);

        gc.gridx++;

        add(txtentrada, gc);

        gc.gridx--;
        gc.gridy--;

        add(permanencia, gc);

        gc.gridx++;

        add(txtPermanencia, gc);

        gc.gridx--;
        gc.gridy--;

        add(blocos, gc);

        gc.gridx++;

        add(txtBloco, gc);

        gc.gridx--;
        gc.gridy--;

        add(preco, gc);

        gc.gridx++;

        add(txtPreco, gc);

        gc.gridx--;
        gc.gridy--;

        add(total, gc);

        gc.gridx++;

        add(txtTotal, gc);

        gc.gridx--;
        gc.gridy--;

        add(txtDescricao, gc);

        gc.gridy--;

        add(entradaCarro, gc);

        gc.gridx++;

        add(cancelar, gc);
    }*/

}
