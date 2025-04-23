package CriaturasDeck1;

import Cartas.Criatura;
import MecanicasJogo.Jogadores;
import GUI.TelaCombateGUI;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Sereia extends Criatura{
    
    public Sereia() {
	super(3, 1, 6, 3, "Sereia", "Uma beleza encantadora que enfraquece os adversários com seu canto hipnótico.", new ImageIcon("src\\ImagensCartas\\cartaSereia.png").getImage());
        this.setHabilidadeNoCampo(true);
    }

    @Override
    public void usarHabilidade(Jogadores usuario, Jogadores receptor, TelaCombateGUI telaCombate) {
        if(usuario == telaCombate.getJogador1()){
            
            if(telaCombate.getCarta1Campo2() != null){
                if(telaCombate.getCarta1Campo2().getPoder() <= 2){
                    telaCombate.getCarta1Campo2().setPoder(1);
                }
                else{
                    telaCombate.getCarta1Campo2().setPoder(telaCombate.getCarta1Campo2().getPoder() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Sereia reduziu em 2 o poder de "+telaCombate.getCarta1Campo2().getNome());
            }
            if(telaCombate.getCarta2Campo2() != null){
                if(telaCombate.getCarta2Campo2().getPoder() <= 2){
                    telaCombate.getCarta2Campo2().setPoder(1);
                }
                else{
                    telaCombate.getCarta2Campo2().setPoder(telaCombate.getCarta2Campo2().getPoder() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Sereia reduziu em 2 o poder de "+telaCombate.getCarta2Campo2().getNome());
            }
            if(telaCombate.getCarta3Campo2() != null){
                if(telaCombate.getCarta3Campo2().getPoder() <= 2){
                    telaCombate.getCarta3Campo2().setPoder(1);
                }
                else{
                    telaCombate.getCarta3Campo2().setPoder(telaCombate.getCarta3Campo2().getPoder() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Sereia reduziu em 2 o poder de "+telaCombate.getCarta3Campo2().getNome());
            }
        }
        
        else if(usuario == telaCombate.getJogador2()){
            
            if(telaCombate.getCarta1Campo1() != null){
                if(telaCombate.getCarta1Campo1() != null){
                    if(telaCombate.getCarta1Campo1().getPoder() <= 2){
                        telaCombate.getCarta1Campo1().setPoder(1);
                    }
                    else{
                    telaCombate.getCarta1Campo1().setPoder(telaCombate.getCarta1Campo1().getPoder() - 2);
                    }
                    JOptionPane.showMessageDialog(telaCombate,"Sereia reduziu em 2 o poder de "+telaCombate.getCarta1Campo1().getNome());
                }
            }
            if(telaCombate.getCarta2Campo1() != null){
                if(telaCombate.getCarta2Campo1() != null){
                    if(telaCombate.getCarta2Campo1().getPoder() <= 2){
                        telaCombate.getCarta2Campo1().setPoder(1);
                    }
                    else{
                    telaCombate.getCarta2Campo1().setPoder(telaCombate.getCarta2Campo1().getPoder() - 2);
                    }
                    JOptionPane.showMessageDialog(telaCombate,"Sereia reduziu em 2 o poder de "+telaCombate.getCarta2Campo1().getNome());
                }
            }
            if(telaCombate.getCarta3Campo1() != null){
                if(telaCombate.getCarta3Campo1() != null){
                    if(telaCombate.getCarta3Campo1().getPoder() <= 2){
                        telaCombate.getCarta3Campo1().setPoder(1);
                    }
                    else{
                    telaCombate.getCarta3Campo1().setPoder(telaCombate.getCarta3Campo1().getPoder() - 2);
                    }
                    JOptionPane.showMessageDialog(telaCombate,"Sereia reduziu em 2 o poder de "+telaCombate.getCarta3Campo1().getNome());
                }
            }
        }
        
        usuario.gastaMana(6);
    }
}
