package CriaturasDeck2;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Lobisomem extends Criatura{

    public Lobisomem() {

        super(6, 5, 3, 8, "Lobisomem", "Uma mistura de homem e lobo nas noites de lua cheia, espalhando terror com sua força descomunal e uivos sombrios.", new ImageIcon("src\\ImagensCartas\\cartaLobisomem.png").getImage());
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        int novoPoder = jogador1.getCarta().getPoder() + 2;
        jogador1.getCarta().setPoder(novoPoder);
        int novaResistencia = jogador1.getCarta().getResistencia() - 2;
        jogador1.getCarta().setResistencia(novaResistencia);
        
        JOptionPane.showMessageDialog(telaCombate,"Lobisomem agora possui o poder de " + jogador1.getCarta().getPoder() + " e a resistência de " + jogador1.getCarta().getResistencia());
	jogador1.gastaMana(3);
    }

    
}
