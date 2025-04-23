package CriaturasDeck2;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Boitata extends Criatura{

    public Boitata() {

        super(7, 3, 1, 5, "Boitatá", "-", new ImageIcon("src\\ImagensCartas\\cartaBoitata.png").getImage());
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador2.setManaJogador(jogador2.getManaJogador() - 2);
        jogador1.gastaMana(1);
        
        JOptionPane.showMessageDialog(telaCombate,"Boitatá reduziu a mana de "+jogador2.getNomeJogador()+" em 2!");    
    }
}
