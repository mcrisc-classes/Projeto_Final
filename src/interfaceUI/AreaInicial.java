package interfaceUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.UseCaseController;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class AreaInicial extends UseCaseController {

    private JLabel estacionamento;
    private JButton EntradaSaida;
    private JButton Mensalista;

    public void AreaInicial() {

        setLayout(new GridBagLayout());

        Font fonte = new Font("Arial", Font.ITALIC, 40);
        estacionamento = new JLabel("ParkSys");
        EntradaSaida = new JButton("Entrada/Saida");
        Mensalista = new JButton("Mensalista");

        estacionamento.setFont(fonte);

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 10;
        gc.gridy = 0;
        gc.weightx = 0.2;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;

        add(estacionamento, gc);

        gc.gridx = 0;
        gc.gridy++;

        Dimension d = getPreferredSize();
        d.width = 200;
        setPreferredSize(d);

        EntradaSaida.setSize(d);

        add(EntradaSaida, gc);

        gc.gridx = 20;

        Mensalista.setSize(d);

        add(Mensalista, gc);
        

    }

    @Override
    public JPanel buildUI() {
        // TODO Auto-generated method stub
        return null;
    }
}
