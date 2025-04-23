package ProjetoPOO;

import Erros.IndiceForaDoLimiteException;
import Erros.ManaInsuficienteException;
import Erros.NumeroForaDoLimite;
import MecanicasJogo.*;

public class JogoDeCartas {
	
    public static void main(String[] args) throws NumeroForaDoLimite, IndiceForaDoLimiteException, ManaInsuficienteException {
    	
    	Jogo jogo = new Jogo();
    	
    	Jogadores jogador1 = new Jogadores("Freitas", 20, 10, jogo.getListaCartas1(), jogo.getCampoDeBatalha1());
    	Jogadores jogador2 = new Jogadores("Leal", 20, 10, jogo.getListaCartas2(), jogo.getCampoDeBatalha2());
        
    	jogo.getJogarDeNovo();
    	
        while(jogo.getJogarDeNovo() == 1) {
        	
        	jogo.definirCartasDaMao(jogador1);
        	jogo.definirCartasDaMao(jogador2);
        	jogo.comecoJogo(jogador1);
                jogo.comecoJogo(jogador2);
            
        	while((jogador1.getVidaJogador() > 0 && jogador2.getVidaJogador() > 0) && (jogador1.getMao() != null && jogador2.getMao() != null)) {
        		  
            	jogo.executarTurno(jogador1, jogador2);
            	jogo.exibirStatus(jogador1, jogador2);
            }
        	
        	if(jogador1.getVidaJogador() <= 0) {
        		System.out.println(jogador2.getNomeJogador()+" venceu o duelo!");
        		jogador2.ganhaExperiencia();
        		jogador2.setExperiencia(jogador2.ganhaExperiencia());
        		jogador2.quantoFaltaNovoNivel(jogador2, jogador2.getNivelJogador());
        	}
        	
        	if(jogador2.getVidaJogador() <= 0) {
        		System.out.println(jogador1.getNomeJogador()+" venceu o duelo!");
        		jogador1.ganhaExperiencia();
        		jogador1.setExperiencia(jogador1.ganhaExperiencia());
        		jogador1.quantoFaltaNovoNivel(jogador1, jogador1.getNivelJogador());
        	}
        	
        	jogo.reiniciaPartida(jogador1, jogador2);
        	jogo.desejaJogarDeNovo();
        }
        System.out.println("Fim de Jogo!!!");
       
    }
    
   
}
