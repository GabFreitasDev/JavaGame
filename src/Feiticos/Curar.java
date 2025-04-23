package Feiticos;

import Cartas.*;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import javax.swing.ImageIcon;

public class Curar extends Feitico {

    public Curar() {
	super(3, 4, 0, "Curar", "Uma forçaa divina surgiu e lhe concedeu 2 de vida", new ImageIcon("src\\ImagensCartas\\cartaCurar.png").getImage());
        this.setParaAtaque(false);
    }

    @Override
    public void usarFeitico(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        int novaVida = jogador1.getVidaJogador() + this.getPoder();
        jogador1.setVidaJogador(novaVida);
    }

}
