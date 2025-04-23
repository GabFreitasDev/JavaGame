package MecanicasJogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Erros.*;
import Feiticos.*;
import Cartas.*;
import GUI.TelaCombateGUI;
import GUI.TelaEscolhaDuelo;
import GUI.TelaFimDoDuelo;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JogoGUI {

        private Jogadores jogador;
	private int turno = 1;
	private boolean isJogador1 = true;
	private ArrayList<Carta> mao1;
	private ArrayList<Carta> mao2;
	private ArrayList<Carta> campoDeBatalha1;
	private ArrayList<Carta> campoDeBatalha2;
	private Random random = new Random();
	private Carta cartaJogador1;
	private Carta cartaJogador2;
	public int jogarDeNovo = 1;

	public JogoGUI() {
		mao1 = new ArrayList<Carta>();
		mao2 = new ArrayList<Carta>();
	}

	Cemiterio cemiterio = new Cemiterio();
	
	public void atacar(Jogadores jogadorAtaque, Jogadores jogadorDefesa) {

            if (jogadorDefesa.getCarta().getResistencia() < jogadorAtaque.getCarta().getPoder()) {

                int dano = jogadorAtaque.getCarta().getPoder() - jogadorDefesa.getCarta().getResistencia();
                int vidaAtual = jogadorDefesa.getVidaJogador() - dano;
                jogadorDefesa.getCarta().setVivo(false);
                jogadorDefesa.setVidaJogador(vidaAtual);
            } else {
                int vidaAtual = jogadorDefesa.getVidaJogador();
                jogadorDefesa.getCarta().setVivo(true);
                jogadorDefesa.setVidaJogador(vidaAtual);
                //System.out.println("Nova resistencia apos o ataque: " + resistenciaDefesa);
            }
            
            int novaResistencia = jogadorDefesa.getCarta().getResistencia() - jogadorAtaque.getCarta().getPoder();
            jogadorDefesa.getCarta().setResistencia(novaResistencia);
    }
	//Novo
	public void reiniciaPartida(Jogadores jogador1, Jogadores jogador2) {
		getListaCartas1().clear();
		getListaCartas2().clear();
		getCampoDeBatalha1().clear();
		getCampoDeBatalha2().clear();
		
		jogador1.setVidaJogador(20);
		jogador2.setVidaJogador(20);
		jogador1.setManaJogador(15);
		jogador2.setManaJogador(15);
		
		turno = 1;
	}

	public ArrayList<Carta> getListaCartas1() {
		return mao1;
	}

	public ArrayList<Carta> getListaCartas2() {
		return mao2;
	}

	public ArrayList<Carta> getCampoDeBatalha1() {
		return campoDeBatalha1;
	}

	public void setCampoDeBatalha1(ArrayList<Carta> campoDeBatalha1) {
		this.campoDeBatalha1 = campoDeBatalha1;
	}

	public ArrayList<Carta> getCampoDeBatalha2() {
		return campoDeBatalha2;
	}

	public void setCampoDeBatalha2(ArrayList<Carta> campoDeBatalha2) {
		this.campoDeBatalha2 = campoDeBatalha2;
	}

	public Jogadores getJogador() {
		return jogador;
	}

	public boolean getjogadorAtivo() {
		return isJogador1;
	}

	public int getJogarDeNovo() {
		return jogarDeNovo;
	}
	
	// public void cartasDisponiveis(Jogadores maoJogador1, Jogadores maoJogador2) {

	// ArrayList<Criatura> listaCriaturas1 = new ArrayList<Criatura>();
	// listaCriaturas1.add(maoJogador1.getCriatura().getNome());

	// ArrayList<Criatura> listaCriaturas2 = maoJogador2.getCriaturasLista();

	// }

}

