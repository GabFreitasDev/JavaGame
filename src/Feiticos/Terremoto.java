package Feiticos;

import Cartas.*;
import GUI.TelaCombateGUI;
import MecanicasJogo.Jogadores;

public class Terremoto extends Feitico {


    public Terremoto() {
        super(3, 5, 0, "Terremoto", "Um forte terremoto Ã© gerado e causa dano a um inimigo.", null);
    }

     public void usarFeitico(Criatura criatura){

            criatura.receberFeitico(this.poder);

        }

    @Override
    public void usarFeitico(Jogadores jogador1, Jogadores jogador2, TelaCombateGUI telaCombate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
