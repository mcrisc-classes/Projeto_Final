package controller;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaceUI.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MainController extends JFrame {

    private AreaInicial ai;
    private CadastroCliente CadastroCliente;
    private CadastroCarro CadastroCarro;
    private GerenciamentoVeiculos gv;

    public MainController() {

        super("Estacionamento ");
        super.setSize(600, 300);
        super.setVisible(true);

        ai = new AreaInicial();
        CadastroCliente = new CadastroCliente();
        CadastroCarro = new CadastroCarro();
        gv = new GerenciamentoVeiculos();

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.BOTH;

        add(ai, gc);

        gc.gridy--;

        add(CadastroCliente, gc);

        gc.gridy--;

        add(CadastroCarro,gc);

        gc.gridy--;

        add(gv,gc);

        ai.setVisible(false);

        CadastroCliente.setVisible(false);

        CadastroCarro.setVisible(false);

        gv.setVisible(true);

        super.setJMenuBar(criaMenu());

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JMenuBar criaMenu() {
        JMenuBar barraDeMenu = new JMenuBar();

        JMenu arquivo = new JMenu("Arquivo");
        JMenuItem pagarMensalidade = new JMenuItem("Pagar Mensalidade");
        JMenuItem GerenciarVeiculo = new JMenuItem("Gerenciar Veiculo");
        JMenuItem sair = new JMenuItem("Sair");

        arquivo.add(sair);
        arquivo.add(pagarMensalidade);
        arquivo.add(GerenciarVeiculo);
        barraDeMenu.add(arquivo);

        return barraDeMenu;

    }
}
