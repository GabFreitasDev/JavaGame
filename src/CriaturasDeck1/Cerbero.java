package CriaturasDeck1;
import Cartas.Carta;
import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cerbero extends Criatura{

    public Cerbero() {

	super(8, 5, 3, 5, "Cerbero", "O guardião do submundo, que não permite que ninguem escape do inferno!", new ImageIcon("src\\ImagensCartas\\cartaCerbero.png").getImage());
        this.setHabilidadeNoCampo(false);
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador2.perdeVida(2);
        jogador1.ganhaVida(2);
	jogador1.gastaMana(3); 
        JOptionPane.showMessageDialog(telaCombate,"Cerbero Drenou 2 de vida do oponente para "+jogador1.getNomeJogador());
    }
}
