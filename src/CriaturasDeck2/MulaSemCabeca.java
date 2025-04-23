package CriaturasDeck2;

import Cartas.Criatura;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MulaSemCabeca extends Criatura{

	public MulaSemCabeca() {
		super(5, 3, 5, 4, "MulaSemCabeca", "Galopa na noite envolta em chamas, soltando relinchos assustadores enquanto amaldiçoa aqueles que cruzam seu caminho.", new ImageIcon("src\\ImagensCartas\\cartaMulaSemCabeca.png").getImage());
	}

    @Override
    public void usarHabilidade(Jogadores usuario, Jogadores jogador2, TelaCombateGUI telaCombate) {
        if(usuario == telaCombate.getJogador1()){
            
            if(telaCombate.getCarta1Campo2() != null){
                if(telaCombate.getCarta1Campo2().getPoder() <= 2){
                    telaCombate.getCarta1Campo2().setPoder(1);
                }
                else{
                    telaCombate.getCarta1Campo2().setPoder(telaCombate.getCarta1Campo2().getPoder() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Mula sem Cabeça reduziu em 2 o poder de "+telaCombate.getCarta1Campo2().getNome());
            }
            if(telaCombate.getCarta2Campo2() != null){
                if(telaCombate.getCarta2Campo2().getPoder() <= 2){
                    telaCombate.getCarta2Campo2().setPoder(1);
                }
                else{
                    telaCombate.getCarta2Campo2().setPoder(telaCombate.getCarta2Campo2().getPoder() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Mula sem Cabeça reduziu em 2 o poder de "+telaCombate.getCarta2Campo2().getNome());
            }
            if(telaCombate.getCarta3Campo2() != null){
                if(telaCombate.getCarta3Campo2().getPoder() <= 2){
                    telaCombate.getCarta3Campo2().setPoder(1);
                }
                else{
                    telaCombate.getCarta3Campo2().setPoder(telaCombate.getCarta3Campo2().getPoder() - 2);
                }
                JOptionPane.showMessageDialog(telaCombate,"Mula sem Cabeça reduziu em 2 o poder de "+telaCombate.getCarta3Campo2().getNome());
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
                    JOptionPane.showMessageDialog(telaCombate,"Mula sem Cabeça reduziu em 2 o poder de "+telaCombate.getCarta1Campo1().getNome());
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
                    JOptionPane.showMessageDialog(telaCombate,"Mula sem Cabeça reduziu em 2 o poder de "+telaCombate.getCarta2Campo1().getNome());
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
                    JOptionPane.showMessageDialog(telaCombate,"Mula sem Cabeça reduziu em 2 o poder de "+telaCombate.getCarta3Campo1().getNome());
                }
            }
        }
        
        usuario.gastaMana(5);
    }
}
