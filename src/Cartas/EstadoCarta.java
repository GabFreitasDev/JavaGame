package Cartas;

import Erros.ManaInsuficienteException;
import Erros.NaoAtacavelException;
import MecanicasJogo.Jogadores;

public interface EstadoCarta {

    public boolean atacavel(Carta carta, int espacoCampo) throws NaoAtacavelException;
    public boolean jogavel(Jogadores jogador) throws ManaInsuficienteException;
}
