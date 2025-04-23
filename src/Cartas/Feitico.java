package Cartas;

import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;
import java.awt.Image;

public abstract class Feitico extends Carta{
	
    private boolean paraAtaque;
    
    public Feitico(int poder, int mana, int resistencia, String nome, String descricao, Image imagem) {
        super(poder, mana, resistencia, nome, descricao, imagem);
    }
    
    public abstract void usarFeitico(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate);
    
    public boolean getParaAtaque(){
        return paraAtaque;
    }
    
    public void setParaAtaque(boolean paraAtaque){
        this.paraAtaque = paraAtaque;
    }
}
