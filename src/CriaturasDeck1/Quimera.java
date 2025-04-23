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

/**
 *
 * @author gabri
 */
public class Quimera extends Criatura{
    
    public Quimera() {
	super(2, 3, 5, 6, "Quimera", "Feroz com corpo de leão, cabeça de cabra e cauda de serpente, emoldurada por símbolos da mitologia grega.", new ImageIcon("src\\ImagensCartas\\cartaQuimera.png").getImage());
        this.setHabilidadeNoCampo(true);
    }

    @Override
    public void usarHabilidade(Jogadores usuario, Jogadores receptor, TelaCombateGUI telaCombate) {
        if(usuario == telaCombate.getJogador1()){
            if(telaCombate.getCarta1Campo2() != null){
                if(telaCombate.getCarta1Campo2().getResistencia() <= 2){
                    telaCombate.getCarta1Campo2().setResistencia(0);
                }
                else{
                    telaCombate.getCarta1Campo2().setResistencia(telaCombate.getCarta1Campo2().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Quimera reduziu em 2 a resistencia de "+telaCombate.getCarta1Campo2().getNome());
            }
            if(telaCombate.getCarta2Campo2() != null){
                if(telaCombate.getCarta2Campo2().getResistencia() <= 2){
                    telaCombate.getCarta2Campo2().setResistencia(0);
                }
                else{
                    telaCombate.getCarta2Campo2().setResistencia(telaCombate.getCarta2Campo2().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Quimera reduziu em 2 a resistencia de "+telaCombate.getCarta2Campo2().getNome());
            }
            if(telaCombate.getCarta3Campo2() != null){
                if(telaCombate.getCarta3Campo2().getResistencia() <= 2){
                    telaCombate.getCarta3Campo2().setResistencia(0);
                }
                else{
                    telaCombate.getCarta3Campo2().setResistencia(telaCombate.getCarta3Campo2().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Quimera reduziu em 2 a resistencia de "+telaCombate.getCarta3Campo2().getNome());
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
                JOptionPane.showMessageDialog(telaCombate,"Quimera reduziu em 2 a resistencia de "+telaCombate.getCarta1Campo1().getNome());
            }
            if(telaCombate.getCarta2Campo1() != null){
                if(telaCombate.getCarta2Campo1().getResistencia() <= 2){
                    telaCombate.getCarta2Campo1().setResistencia(0);
                }
                else{
                    telaCombate.getCarta2Campo1().setResistencia(telaCombate.getCarta2Campo1().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Quimera reduziu em 2 a resistencia de "+telaCombate.getCarta2Campo1().getNome());
            }
            if(telaCombate.getCarta3Campo1() != null){
                if(telaCombate.getCarta3Campo1().getResistencia() <= 2){
                    telaCombate.getCarta3Campo1().setResistencia(0);
                }
                else{
                    telaCombate.getCarta3Campo1().setResistencia(telaCombate.getCarta3Campo1().getResistencia() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Quimera reduziu em 2 a resistencia de "+telaCombate.getCarta3Campo1().getNome());
            }
            
            usuario.gastaMana(5);
        }
    }  
}
