package Feiticos;

import Cartas.Criatura;
import Cartas.Feitico;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;

public class BolaDeFogo extends Feitico{
    
	public BolaDeFogo() {
        super(5, 5, 0, "BolaDeFogo", "Um Meteoro invade a Ã³rbita do planeta e atinge o campo de batalha.", new ImageIcon("src\\ImagensCartas\\cartaBolaDeFogo.png").getImage());
        this.setParaAtaque(true);
    }

    @Override
    public void usarFeitico(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        if (jogador2.getCarta().getResistencia() < jogador1.getCarta().getPoder()) {
            int dano = jogador1.getCarta().getPoder() - jogador2.getCarta().getResistencia();
            int vidaAtual = jogador2.getVidaJogador() - dano;
            jogador2.getCarta().setVivo(false);
            jogador2.setVidaJogador(vidaAtual);
        }
        else{
            int novaResistencia = jogador1.getCarta().getPoder() - jogador2.getCarta().getResistencia();
            jogador2.getCarta().setVivo(true);
            jogador2.getCarta().setResistencia(novaResistencia);
        }
    }

}

