/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CriaturasDeck2;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class CorpoSeco extends Criatura{
    
    public CorpoSeco() {

	super(1, 3, 3, 6, "CorpoSeco", "Uma criatura amaldiçoada que, mesmo em decomposição, jamais encontra descanso. Seu toque traz a morte, e seu retorno é inevitável.", new ImageIcon("src\\ImagensCartas\\cartaCorpoSeco.png").getImage());
    }
	

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador1.getCarta().setPoder(6);
        jogador1.getCarta().setResistencia(1);
        
        JOptionPane.showMessageDialog(telaCombate,"Corpo Seco inverteu seus status!");
	jogador1.gastaMana(3);
    }
}
