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
public class OncaPintada extends Criatura{
    
    public OncaPintada() {

	super(3, 1, 2, 2, "OncaPintada", "Ágil e implacável, a onça-pintada domina seu território com precisão mortal.", new ImageIcon("src\\ImagensCartas\\cartaOncaPintada.png").getImage());
    }
	

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        jogador1.getCarta().setResistencia(jogador1.getCarta().getResistencia() + 3);
        jogador1.gastaMana(2);
        
        JOptionPane.showMessageDialog(telaCombate,"Hidra agora possui a resistência de "+ jogador1.getCarta().getResistencia());
    }
}
