package interfaceUI;

import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.UseCaseController;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;;

public class CadastroCliente extends UseCaseController {

    private JLabel telefone;
    private JLabel nome;
    private JLabel cpf;
    private JLabel observacoes;
    private JTextField textTelefone;
    private JTextField textNome;
    private JTextField textCpf;
    private JTextField Observacoes;
    private JButton cadastrar;
    private JButton botaoGravar;
    private JLabel Saldo;
    private JTextField txtSaldo;
    private Connection conn;

    /* Criação da tabela para Cadastrar Cliente */

    public CadastroCliente() {

        JLabel telefone = new JLabel("Telefone: ");
        JLabel nome = new JLabel("Nome: ");
        JLabel cpf = new JLabel("CPF: ");
        JLabel observacoes = new JLabel("Observações: ");
        JLabel Saldo = new JLabel("Saldo: ");
        JTextField textTelefone = new JTextField(15);
        JTextField textNome = new JTextField(15);
        JTextField textCpf = new JTextField(15);
        JTextField textobservacoes = new JTextField(15);
        JTextField txtSaldo = new JTextField(15);
        JButton botaoGravar = new JButton("Gravar");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;

        add(cpf, gc);

        gc.gridx++;

        add(textCpf, gc);

        gc.gridx--;
        gc.gridy--;

        add(telefone, gc);

        gc.gridx++;

        add(textTelefone, gc);

        gc.gridx--;
        gc.gridy--;

        add(nome, gc);

        gc.gridx++;

        add(textNome, gc);

        gc.gridx--;
        gc.gridy--;

        add(observacoes, gc);

        gc.gridx++;

        add(textobservacoes, gc);

        gc.gridx--;
        gc.gridy--;

        add(Saldo, gc);

        gc.gridx++;

        add(txtSaldo, gc);

        gc.gridx--;
        gc.gridy--;

        add(botaoGravar, gc);

    }

    public JTextField getTextTelefone() {
        return textTelefone;
    }

    public void setTextTelefone(JTextField textTelefone) {
        this.textTelefone = textTelefone;
    }

    public JTextField getTextNome() {
        return textNome;
    }

    public void setTextNome(JTextField textNome) {
        this.textNome = textNome;
    }

    public JTextField getTextCpf() {
        return textCpf;
    }

    public void setTextCpf(JTextField textCpf) {
        this.textCpf = textCpf;
    }

    public JTextField getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(JTextField observacoes) {
        Observacoes = observacoes;
    }

    public JTextField getTxtSaldo() {
        return txtSaldo;
    }

    public void setTxtSaldo(JTextField txtSaldo) {
        this.txtSaldo = txtSaldo;
    }

    @Override
    public JPanel buildUI() {
        // TODO Auto-generated method stub
        return null;
    }

}
