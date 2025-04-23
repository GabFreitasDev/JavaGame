package MecanicasJogo;

public class SistemaExperiencia {

	private int experiencia;
	private int nivelJogador;
	private int experienciaNovoNivel;
	
	public int ganhaExperiencia() {
		return experiencia + 2;
	}
	
	public void quantoFaltaNovoNivel(Jogadores jogador, int nivel) {
		experienciaNovoNivel = nivel * 2;
		if(this.getExperiencia() != experienciaNovoNivel) {
			System.out.println(jogador.getNomeJogador() + ": XP("+this.getExperiencia()+"/"+this.getExperienciaNovoNivel()+")");
		}
		else {
			System.out.println(jogador.getNomeJogador() + " agora é nível "+subiuDeNivel());
		}
	}
	
	public int subiuDeNivel() {
		return nivelJogador + 1;
		
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivelJogador() {
		return nivelJogador;
	}

	public void setNivelJogador(int nivelJogador) {
		this.nivelJogador = nivelJogador;
	}

	public int getExperienciaNovoNivel() {
		return experienciaNovoNivel;
	}

	public void setExperienciaNovoNivel(int experienciaNovoNivel) {
		this.experienciaNovoNivel = experienciaNovoNivel;
	}
	
	
}
