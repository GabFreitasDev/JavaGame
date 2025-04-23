/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Feiticos;

import Cartas.Feitico;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class ExplosaoArcana extends Feitico{
    
    public ExplosaoArcana() {
        super(3, 1, 0, "ExplosaoArcana", "Galáxias se colidem e gera uma explosão arcana catastrófica!", new ImageIcon("src\\ImagensCartas\\cartaCurar.png").getImage());
        this.setParaAtaque(false);
    } 

    @Override
    public void usarFeitico(Jogadores usuario, Jogadores jogador2, TelaCombateGUI telaCombate) {
        if(usuario == telaCombate.getJogador1()){
            
            if(telaCombate.getCarta1Campo2() != null){
                telaCombate.getCarta1Campo2().setResistencia(telaCombate.getCarta1Campo2().getResistencia() - 3);
                
                
                if(telaCombate.getCarta1Campo2().getResistencia() < 0){
                    telaCombate.getCarta1Campo2().setResistencia(0);
                } 
                JOptionPane.showMessageDialog(telaCombate," Explosão Arcana reduziu em 3 a resistência de "+telaCombate.getCarta1Campo2().getNome());
            }
    
        
            if(telaCombate.getCarta2Campo2() != null){
                telaCombate.getCarta2Campo2().setResistencia(telaCombate.getCarta2Campo2().getResistencia() - 3);
                
                
                if(telaCombate.getCarta2Campo2().getResistencia() < 0){
                    telaCombate.getCarta2Campo2().setResistencia(0);
                } 
                JOptionPane.showMessageDialog(telaCombate," Explosão Arcana reduziu em 3 a resistência de "+telaCombate.getCarta2Campo2().getNome());
            }
         
          if(telaCombate.getCarta3Campo2() != null){
                telaCombate.getCarta3Campo2().setResistencia(telaCombate.getCarta3Campo2().getResistencia() - 3);
                
                
                if(telaCombate.getCarta3Campo2().getResistencia() < 0){
                    telaCombate.getCarta3Campo2().setResistencia(0);
                } 
                JOptionPane.showMessageDialog(telaCombate," Explosão Arcana reduziu em 3 a resistência de "+telaCombate.getCarta3Campo2().getNome());
            }
        }else if(usuario == telaCombate.getJogador2()){
        
            if(telaCombate.getCarta1Campo1() != null){
                telaCombate.getCarta1Campo1().setResistencia(telaCombate.getCarta1Campo1().getResistencia() - 3);
                
                if(telaCombate.getCarta1Campo1().getResistencia() < 0){
                    telaCombate.getCarta1Campo1().setResistencia(0);
                }
                JOptionPane.showMessageDialog(telaCombate," Explosão Arcana reduziu em 3 o poder de "+telaCombate.getCarta1Campo1().getNome());
            }
            
            if(telaCombate.getCarta2Campo1() != null){
                telaCombate.getCarta2Campo1().setResistencia(telaCombate.getCarta2Campo1().getResistencia() - 3);
                
                if(telaCombate.getCarta2Campo1().getResistencia() < 0){
                    telaCombate.getCarta2Campo1().setResistencia(0);
                } 
                JOptionPane.showMessageDialog(telaCombate," Explosão Arcana reduziu em 3 o poder de "+telaCombate.getCarta2Campo1().getNome());
            }
            
            if(telaCombate.getCarta3Campo1() != null){
                telaCombate.getCarta3Campo1().setResistencia(telaCombate.getCarta3Campo1().getResistencia() - 3);
                
                if(telaCombate.getCarta3Campo1().getResistencia() < 0){
                    telaCombate.getCarta3Campo1().setResistencia(0);
                } 
                JOptionPane.showMessageDialog(telaCombate," Explosão Arcana reduziu em 3 o poder de "+telaCombate.getCarta3Campo1().getNome());
            }
        
        }
    }
}
    