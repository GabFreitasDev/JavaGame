package CriaturasDeck2;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Saci extends Criatura{

	public Saci() {
		super(4, 1, 4, 1, "Saci", "Travesso ser do folclore brasileiro, com uma perna só,um cachimbo, que causa ventanias e prega peças nas florestas", new ImageIcon("src\\ImagensCartas\\cartaSaci.png").getImage());
	}

    @Override
    public void usarHabilidade(Jogadores usuario, Jogadores jogador2, TelaCombateGUI telaCombate) {
        if(usuario == telaCombate.getJogador1()){
            if(telaCombate.getCarta1Campo2() != null){
                if(telaCombate.getCarta1Campo2().getResistencia() <= 2){
                    telaCombate.getCarta1Campo2().setResistencia(0);
                }
                else{
                    telaCombate.getCarta1Campo2().setResistencia(telaCombate.getCarta1Campo2().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Saci reduziu em 2 a resistencia de "+telaCombate.getCarta1Campo2().getNome());
            }
            if(telaCombate.getCarta2Campo2() != null){
                if(telaCombate.getCarta2Campo2().getResistencia() <= 2){
                    telaCombate.getCarta2Campo2().setResistencia(0);
                }
                else{
                    telaCombate.getCarta2Campo2().setResistencia(telaCombate.getCarta2Campo2().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Saci reduziu em 2 a resistencia de "+telaCombate.getCarta2Campo2().getNome());
            }
            if(telaCombate.getCarta3Campo2() != null){
                if(telaCombate.getCarta3Campo2().getResistencia() <= 2){
                    telaCombate.getCarta3Campo2().setResistencia(0);
                }
                else{
                    telaCombate.getCarta3Campo2().setResistencia(telaCombate.getCarta3Campo2().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Saci reduziu em 2 a resistencia de "+telaCombate.getCarta3Campo2().getNome());
            }
            
            usuario.gastaMana(5);
        }
        
        else if(usuario == telaCombate.getJogador2()){
            
            if(telaCombate.getCarta1Campo1() != null){
                if(telaCombate.getCarta1Campo1().getResistencia() <= 2){
                    telaCombate.getCarta1Campo1().setResistencia(0);
                }
                else{
                    telaCombate.getCarta1Campo1().setResistencia(telaCombate.getCarta1Campo1().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Saci reduziu em 2 a resistencia de "+telaCombate.getCarta1Campo1().getNome());
            }
            if(telaCombate.getCarta2Campo1() != null){
                if(telaCombate.getCarta2Campo1().getResistencia() <= 2){
                    telaCombate.getCarta2Campo1().setResistencia(0);
                }
                else{
                    telaCombate.getCarta2Campo1().setResistencia(telaCombate.getCarta2Campo1().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Saci reduziu em 2 a resistencia de "+telaCombate.getCarta2Campo1().getNome());
            }
            if(telaCombate.getCarta3Campo1() != null){
                if(telaCombate.getCarta3Campo1().getResistencia() <= 2){
                    telaCombate.getCarta3Campo1().setResistencia(0);
                }
                else{
                    telaCombate.getCarta3Campo1().setResistencia(telaCombate.getCarta3Campo1().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Saci reduziu em 2 a resistencia de "+telaCombate.getCarta3Campo1().getNome());
            }
            
            usuario.gastaMana(4);
        }
    } 
}
