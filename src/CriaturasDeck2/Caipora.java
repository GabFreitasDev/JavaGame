package CriaturasDeck2;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Caipora extends Criatura{

    public Caipora() {

	super(6, 2, 4, 2, "Caipora", "-", new ImageIcon("src\\ImagensCartas\\cartaCaipora.png").getImage());
    }
	

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        int novoPoder = jogador1.getCarta().getPoder() - 3;
        jogador1.getCarta().setPoder(novoPoder);
        int novaResistencia = jogador1.getCarta().getResistencia() + 5;
        jogador1.getCarta().setResistencia(novaResistencia);
        
        JOptionPane.showMessageDialog(telaCombate,"Caipora agora possui o poder de " + jogador1.getCarta().getPoder() + " e a resistência de " + jogador1.getCarta().getResistencia());
	jogador1.gastaMana(4);
    }

    
}
