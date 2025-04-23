package CriaturasDeck1;
import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Hidra extends Criatura {

    public Hidra() {

	super(4, 1, 2, 3,"Hidra", "Seu veneno esmagador avaba com seu inimigos apenas com o hálito!", new ImageIcon("src\\ImagensCartas\\cartaHidra.png").getImage());
        this.setHabilidadeNoCampo(false);
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador1.getCarta().setResistencia(jogador1.getCarta().getResistencia() + 3);
        jogador1.gastaMana(2);
        
        JOptionPane.showMessageDialog(telaCombate,"Hidra agora possui a resistência de "+ jogador1.getCarta().getResistencia());

    }
}
