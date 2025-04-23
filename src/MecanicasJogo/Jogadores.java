package MecanicasJogo;

import CriaturasDeck1.Cerbero;
import CriaturasDeck1.Hidra;
import CriaturasDeck1.Grifo;
import CriaturasDeck1.Minotauro;
import java.util.Random;
import java.util.ArrayList;
import CriaturasDeck2.*;
import Erros.ManaInsuficienteException;
import Feiticos.*;
import Cartas.Carta;
import Cartas.Criatura;
import Cartas.Encantamento;
import Cartas.Feitico;

public class Jogadores {

	private String nomeJogador;
	private int vidaJogador;
	private int manaJogador;
	private Carta carta;
	private ArrayList<Carta> mao;
	private ArrayList<Carta> campoDeBatalha;
	private Random random = new Random();
	private Criatura criatura;
	private Feitico feitico;
	private Encantamento encantamento;
	// Novo
	private int experiencia = 0;
	private int nivelJogador = 1;
	private int experienciaNovoNivel;

	public Jogadores(String nome, int vida, int mana, ArrayList<Carta> mao, ArrayList<Carta> campoDeBatalha) {

		this.nomeJogador = nome;
		this.vidaJogador = vida;
		this.manaJogador = mana;
		this.mao = mao;
		// Novo
		this.campoDeBatalha = campoDeBatalha = new ArrayList<>();
	}

	public void gastaMana(int manaGasta) {
		manaJogador = manaJogador - manaGasta;
	}

	public void perdeVida(int dano) {
		vidaJogador = vidaJogador - dano;
	}

	public void ganhaVida(int cura) {
		vidaJogador = vidaJogador + cura;
	}

	public int getVidaJogador() {
		return vidaJogador;
	}

	public int getManaJogador() {
		return manaJogador;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public void setVidaJogador(int vidaJogador) {
		this.vidaJogador = vidaJogador;
	}

	public void setManaJogador(int manaJogador) {
		this.manaJogador = manaJogador;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public Carta getCarta() {
		
		return carta;
	}

	public void setCarta(Carta criatura) {
		this.carta = criatura;
	}

	public ArrayList<Carta> getMao() {
		return mao;
	}
	
	public Criatura getCriatura() {
		return criatura;
	}
	
	public Feitico getFeitico() {
		
		return feitico;
	}
	

	//Novo
	public void setMaoAleatoriaDeck1(ArrayList<Carta> mao, Deck deck) {
		
		int randomNum = random.nextInt(deck.getDeck1().size());
		Carta carta = deck.getDeck1().get(randomNum);
		
		if (carta != null) {
			mao.add(carta);
			deck.getDeck1().remove(carta);

		}
	}

	public void setMaoAleatoriaDeck2(ArrayList<Carta> mao, Deck deck) {
		
		int randomNum = random.nextInt(deck.getDeck2().size());
		Carta carta = deck.getDeck2().get(randomNum);
		
		if (carta != null) {
			mao.add(carta);
			deck.getDeck2().remove(carta);

		}
	}
	
	//Novo
	public void cartaProCemiterio1(Carta carta, Cemiterio cemiterio) {
		cemiterio.getCemiterio1().add(carta);
	}
	
	public void cartaProCemiterio2(Carta carta, Cemiterio cemiterio) {
		cemiterio.getCemiterio2().add(carta);
	}

	public void setMaoAleatoriaGUI(ArrayList<Carta> mao, int numeroCarta) {
		Carta carta;
		switch (numeroCarta) {
		case 1:
			carta = new Cerbero();
			break;
		case 2:
			carta = new Minotauro();
			break;
		case 3:
			carta = new Hidra();
			break;
		case 4:
			carta = new Grifo();
			break;
		default:
			carta = null; // Não deve ocorrer, mas é uma precaução
		}
		if (carta != null) {
			mao.add(carta); // Adiciona a carta gerada à lista
		}
	}

	public boolean isEmpty() {
		return mao == null || mao.isEmpty();
	}

	// Novo
	public ArrayList<Carta> getCampoDeBatalha() {
		return campoDeBatalha;
	}

	public void setCampoDeBatalha(ArrayList<Carta> campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	public void aumentarVida(int quantidade) {

		this.vidaJogador += quantidade;

	}

	// Novo
	public int ganhaExperiencia() {
		return experiencia + 2;
	}

	public void quantoFaltaNovoNivel(Jogadores jogador, int nivelAtual) {
		int experienciaNecessaria = nivelAtual * (2 * nivelAtual);

		while (jogador.getExperiencia() >= experienciaNecessaria) {
			jogador.setNivelJogador(jogador.getNivelJogador() + 1);
			nivelAtual = jogador.getNivelJogador();
			experienciaNecessaria = nivelAtual * (2 * nivelAtual);
			System.out.println(jogador.getNomeJogador() + " subiu para o nível " + nivelAtual + "!");
		}

		int falta = experienciaNecessaria - jogador.getExperiencia();
		System.out.println(jogador.getNomeJogador() + " precisa de mais " + falta + " XP para o próximo nível.");
	}

	public int subiuDeNivel() {
		return nivelJogador + 1;
	}

	public int getExperienciaNovoNivel() {
		return experienciaNovoNivel;
	}

	public void setNivelJogador(int nivelJogador) {
		this.nivelJogador = nivelJogador;
	}

	public void setExperienciaNovoNivel(int experienciaNovoNivel) {
		this.experienciaNovoNivel = experienciaNovoNivel;
	}

	public int getNivelJogador() {
		return nivelJogador;
	}
	
	public boolean jogavel(Carta carta) throws ManaInsuficienteException {
        if (this.getManaJogador() >= carta.getMana()) {
            return true;
        } else {
            throw new ManaInsuficienteException();
         
        }
    }

}