package CriaturasDeck1;

import java.util.Scanner;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Grifo extends Criatura {

    public Grifo() {
	super(5, 1, 2, 2, "Grifo", "Poderosa criatura alada que peregrina por toda Arcadia!", new ImageIcon("src\\ImagensCartas\\cartaGrifo.png").getImage());
        this.setHabilidadeNoCampo(false);
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador2.setManaJogador(jogador2.getManaJogador() - 3);
        jogador1.gastaMana(2);
        
        JOptionPane.showMessageDialog(telaCombate,"Grifo reduziu a mana de "+jogador2.getNomeJogador()+" em 3!");

    }
}
