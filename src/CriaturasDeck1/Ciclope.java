/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CriaturasDeck1;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Ciclope extends Criatura{

    public Ciclope() {

	super(6, 4, 3, 6, "Ciclope", "Um imponente ciclope de um olho só, com músculos protuberantes e um olhar ameaçador.", new ImageIcon("src\\ImagensCartas\\cartaCiclope.png").getImage());
        this.setHabilidadeNoCampo(false);
    }

    @Override
    public void usarHabilidade(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        int novoPoder = jogador1.getCarta().getPoder() - 2;
        jogador1.getCarta().setPoder(novoPoder);
        int novaResistencia = jogador1.getCarta().getResistencia() + 3;
        jogador1.getCarta().setResistencia(novaResistencia);
        
        JOptionPane.showMessageDialog(telaCombate,"Ciclope agora possui o poder de " + jogador1.getCarta().getPoder() + " e a resistência de " + jogador1.getCarta().getResistencia());
	jogador1.gastaMana(3);
    }
}
