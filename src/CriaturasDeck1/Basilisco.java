package CriaturasDeck1;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Basilisco extends Criatura{

    public Basilisco() {

        super(2, 2, 3, 7, "Basilisco", "Com olhos brilhantes e mortais, escamas reluzentes e presas afiadas prontas para atacar.", new ImageIcon("src\\ImagensCartas\\cartaBasilisco.png").getImage());
        this.setHabilidadeNoCampo(false);
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador1.getCarta().setPoder(7);
        jogador1.getCarta().setResistencia(2);
        
        JOptionPane.showMessageDialog(telaCombate,"Basislisco inverteu seus status!");
	jogador1.gastaMana(3);
    }
}
