package CriaturasDeck2;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cuca extends Criatura{

    public Cuca() {

	super(3, 2, 3, 5, "Cuca", "Com sua risada sinistra e magia poderosa, ela surge das sombras da floresta para punir os desobedientes", new ImageIcon("src\\ImagensCartas\\cartaCuca.png").getImage());
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador2.perdeVida(3);
        jogador1.ganhaVida(3);
	jogador1.gastaMana(3);
        
        JOptionPane.showMessageDialog(telaCombate,"Cuca Drenou 3 de vida do oponente para "+jogador1.getNomeJogador());
    }

    
}
